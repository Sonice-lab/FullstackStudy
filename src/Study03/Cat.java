package Study03;

// Animal의 두번째 자식 클래스
public class Cat extends Animal {

    //고양이 이름을 받기 위한 Cat 생성자 정의
    public Cat (String name) {
        super(name);
    }

    //sound를 고양이 소리에 맞게 재정의
    @Override
    public void sound () {
        System.out.println("야옹");
    }
}
