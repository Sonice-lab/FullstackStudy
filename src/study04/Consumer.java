package study04;

// [사고의 흐름 12] 소비자 역할을 수행할 스레드를 설계하기
public class Consumer extends Thread {
    // 공유 자원인 창고
    private Warehouse warehouse;

    // 생성자를 통해 외부(Main)에서 생성된 공유 창고 객체를 전달받음
    public Consumer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        // [사고의 흐름 13] 소비자도 계속해서 물건을 구매해야하므로 무한 루프를 돌린다.
        while(true) {
            // 창고에서 물건 소비 시도
            warehouse.consume();

            try {
                //[조건 2] 0.8초마다 한 번씩 창고에 접근
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
