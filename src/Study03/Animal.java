package Study03;

// 부모 클래스
// 동물의 이름과 소리를 내는 기본 형태 정의
public class Animal {
    // 동물의 이름을 저장하는 변수 선언
    String name;

    //생성자: 객체 생성 시 이름을 초기화
    public Animal (String name) {
        this.name = name;
    }

    //자식 클래스에서 재정의(Overriding)될 메서드
    public void sound (){
        //자식 클래스에서 무조건 구현해야 함
        //부모 클래스에서는 동물 개념만 있고 구체적일 실체가 없으므로
        //개발자가 실수로 자식 클래스에서 소리를 재정의하지 않았을 때
        //프로그램이 오류없이 기본 문구를 출력하게 하도록 유도
        System.out.println("소리 없음");
    };

}
