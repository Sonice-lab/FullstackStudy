package study02.ch02;

public class HybridCar extends Car {
    //2. 자식클래스
    // 문자열 해석 메서드
    // 문자열 형태의 input을 재료로 받아서 최종적으로 정수 int 값을 반환하겠다는 메서드 선언
    public int parseSpeedSetting(String input) {
        //trim() 문자열의 맨 앞과 맨 뒤에 있는 불필요한 여백 잘라내기
        // toUpperCase(): 모든 영문자를 대문자로 통일하기, 문자 표준화
        String formattedInput = input.trim().toUpperCase();
        // replaceAll( 패턴, 바꿀문자) 는 특정 패턴을 찾아 다른 문자로 교체
        //[^0-9]는 정규 표현식으로 0부터 9까지의 숫자를 제외(^)한 모든 문자를 의미
        // 즉, 숫자가 아닌 알파벳, 특수 기호, 콜론 등을 모두 빈 문자열로 덮어씌워 삭제
        // 결과: "80"이라는 숫자만 남게 됨
        String numberOnly = formattedInput.replaceAll("[^0-9]", "");
        // Integer.parseInt()는 텍스트 형태의 숫자를 대소 비교나 산술 연산이 가능한
        // 진짜 정수 데이터로 변환
        // 최종 변환된 숫자를 return을 통해 돌려보냄
        return Integer.parseInt(numberOnly);
    }

    // 주행 메서드 오버라이딩
    @Override
    public void drive(int speed) {
        if (speed < 60) {
            System.out.println("[EV 모드 가동]:  전기 모터로 소음 없이 " + speed + "km/h로 주행합니다.");
        } else {
            //super -> 부모의 기존 기능 재사용
            // 자바에서 '나의 부모 클래스를 가리키는 중요한 키워드'
            // 부모 클래스인 Car에 원래 정의되어있던 drive 메서드를 호출하려 실행하라
            super.drive(speed);
            System.out.println("-> [하이브리드 모드] 전기 모터가 출력을 보조합니다.");
        }
    }
}
