package study02.ch02;

public class Main {
    public static void main(String[] args) {
        //별도의 파일에 있는 HybridCar 클래스를 불러와서 객체 생성
        HybridCar hybridCar = new HybridCar();

        String recognizrdText = "Speed : 90km/h";

        int targetSpeed = hybridCar.parseSpeedSetting(recognizrdText);
        System.out.println("인식한 속도: " + targetSpeed);
        System.out.println("---------------------------------");

        hybridCar.drive(targetSpeed);
    } //end of main
}// end of class
