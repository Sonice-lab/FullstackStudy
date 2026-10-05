package study04;

// [사고의 흐름 1]
// 생산자와 소비자가 공유할 창고(Warehouser) 클래스를 먼저 설계
public class Warehouse {
    // 1-1. 창고의 현재 상태를 나타내는 변수들 선언
    // 가. 현재 창고에 있는 제품의 개수
    private int itemCount = 0;
    // [조건 1] 창고의 제품 최대 수용량은 5개(상수 활용)
    private final int MAX_CAPACITY = 5;

    // [사고의 흐름 2] 생산자가 창고에 제품을 채워 넣는 메서드 만들기
// 여러 스레드가 동시에 접근해서 itemCount가 꼬이는 것을 막기 위해 반드기 동기화 처리하기
    public synchronized void produce() {

        try {
            // [사고의 흐름 3] 물건을 넣기 전, 창고가 가득 찼는지 먼저 확인하기
            // [조건 4] if 문 대신 while문을 사용하여, 스레드가 깨어난 후에도 다시 조건을 꼼꼼히 체크하게 함.
            while (itemCount >= MAX_CAPACITY) {
                System.out.println("[생산 대기] 창고가 가득 찼습니다. 생산자가 대기합니다. (현재 수량" + itemCount + " / 5)");
                // [조건 2-1] 창고가 가득 찼다면 빈자리가 생길때까지 현재 스레드(생산자)를 대기(wait) 상태로 만들기
                wait();

            }
            // [사고의 흐름 4] while문을 무사히 통과했다는 것은 창고에 빈자리가 있다는 것을 의미함
            // 제품을 추가함
            itemCount++;
            System.out.println("[생산 완료] 생산자가 제품을 만들었습니다. (현재수량: " + itemCount + " / 5");

            // [사고의 흐름 5] 물건이 추가되었으니, 창고가 비어서 대기하고 있을지도 모를 소비자들을 모두 깨워준다.
            // [조건 2-2] 대기 중인 소비자 스레드를 깨움
            notifyAll();

        } catch (InterruptedException e) {
            // wait() 메서드는 InterruptedException을 발생시킬 수 있으므로 예외 처리가 필요함
            // e.printStackTrace(); 에러의 발생 원인과 에러가 발생하기까지의 전체 코드 호출 경로를 콘솔에 상세히 출력해주는 메서드
            e.printStackTrace();
        }

        // 수량이 0보다 작아지거나 5를 초과하면 강제로 프로그램을 종료시킴
        if (itemCount < 0 || itemCount > 5) {
            System.err.println("🚨 치명적 버그 발생! 수량 오류: " + itemCount);
            System.exit(0);
        }

    } // end of produce

    // [사고의 흐름 6] 소비자가 창고에서 제품을 가져가는 메서드를 만들기(동기화 필수)
    public synchronized void consume() {

        try {
            // [사고의 흐름 7] 물건을 꺼내기 전, 창고가 비어있는지 먼저 확인하기
            // [조건 4] 여기서도 if 대신 while문을 사용함
            while (itemCount <= 0) {
                System.out.println("[소비대기] 창고가 비어있습니다. 소비자가 대기합니다. (현재 수량: " + itemCount + " / 5");
                // [조건 3-1] 창고가 비어있다면 재 세품이 추가될 때까지 현재 스레드(소비자)를 대기 (wait) 상태로 만들기
                wait();
            }
            // [사고의 흐름 8] while문을 통과했다는 것은 창고에 물건이 최소 1개 이상 있다는 의미. 제품을 꺼낸다.
            itemCount--;
            System.out.println("[소비 완료] 소비자가 제품을 구매했습니다.(현재수량: " + itemCount + " / 5");

            // [사고의 흐름 9] 물건을 꺼내서 창고에 빈자리가 생겼으니, 꽉차서 대기중이던 생산자를 깨워줌.
            // [조건 3-2] 대기 중인 생산자 스레드를 깨움
            notifyAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 수량이 0보다 작아지거나 5를 초과하면 강제로 프로그램을 종료시킴
        if (itemCount < 0 || itemCount > 5) {
            System.err.println("🚨 치명적 버그 발생! 수량 오류: " + itemCount);
            System.exit(0);
        }

    }// end of consume
} // end of warehouse class
