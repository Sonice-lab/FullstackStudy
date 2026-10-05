package study04;

// [사고의 흐름 10] 생산자 역할을 수행할 스레드 설계
public class Producer extends Thread {
    // 공유자원인 창고
    private Warehouse warehouse;

    //생성자를 통해 외부(Main)에서 생성된 공유 창고 객체 전달받기
    public  Producer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    // 스레드가 실제로 실행할 코드를 담아두는 자바 시스템과 약속된 메서드 이름
    @Override
    public void run() {
        // [사고의 흐름 11] 생산자는 계속해서 뭏건을 만들어야 하므로 무한 루프를 돌린다.
        while(true) {
            // 창고에 물건 추가 시도
            warehouse.produce();
            try{
                // [조건 1] 0.5초마다 한 번씩 창고에 접근
                Thread.sleep(500);
            }catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
