package Study03;

// Animal 클래스의 세번째 자식 클래스
public class Tiger extends Animal {

    //호랑이 이름을 가져올 생성자
    public Tiger (String name) {
        super(name);
    }

    // 호랑이의 울음소리로 메서드 재정의
    @Override
    public void sound () {
        System.out.println("어흥");
    }
}
