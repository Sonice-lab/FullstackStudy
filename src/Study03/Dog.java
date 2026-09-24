package Study03;

//Animal 클래스를 상속받는 첫번째 자식 클래스
public class Dog extends Animal {

    //Dog 클래스의 생성자 -> Dog 객체가 생성될 때 이름을 생성하기 위함
    public Dog (String name) {
        super(name);
    }

    //부모의 sound() 메서드를 강아지 소리에 맞게 재정의
    @Override
    public void sound () {
        System.out.println("멍멍");
    }

}
