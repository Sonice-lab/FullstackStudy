package study04;

public class Main {

    public static void main(String[] args) {
        System.out.println("---생산자-소비자 시뮬레이션을 시작합니다.---");

        // 1. 단 하나의 공유 창고 객체를 생성합니다.
        Warehouse sharedWarehouse = new Warehouse();

        // 2. 생산자와 소비자 스레드를 생성할 때, 방금 만든 '동일한 창고(sharedWarehouse)'를 넘겨줌.
        // 두 스레드가 같은 메모리 공간(자원)을 바라보며 경쟁하고 통신할 수 있음
        Producer producer1 = new Producer(sharedWarehouse);
        Producer producer2 = new Producer(sharedWarehouse);
        Producer producer3 = new Producer(sharedWarehouse);


        Consumer consumer1 = new Consumer(sharedWarehouse);
        Consumer consumer2 = new Consumer(sharedWarehouse);
        Consumer consumer3 = new Consumer(sharedWarehouse);

        // 3. 스레드를 실행(start) 시키기. (이 때부터 각자의 run() 메서드가 백그라운드에서 돌기 시작)
        producer1.start();
        producer2.start();
        producer3.start();


        consumer1.start();
        consumer2.start();
        consumer3.start();    }// end of main
}
