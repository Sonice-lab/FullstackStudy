package Study03;

// 다형성을 구현하는 메서드는 어떻게 구현해야할까?
public class Main {

    //메서드1. 매개변수를 부모클래스 타입으로 받아 코드의 중복 방지

//    public static void printAnimalInfo(Dog dog) {
//        dog.sound();
//    }

    public static void printAnimalInfo (Animal animal) {
        System.out.println("동물이름: " + animal.name);
        System.out.println("울음소리: ");
        // 왜 울음소리 옆에 +를 붙일 수 없을까?
        animal.sound();
    }

    public static void main(String[] args) {
    //배열을 활용하여 동물의 이름과 울음소리를 변수 바구니에 담아서 출력해보자!
        Animal[] animals = new Animal[3];
        animals[0] = new Dog("바둑이");
        animals[1] = new Cat("나비");
        animals[2] = new Tiger("티거");


        //본격적으로 동물 소리가 나올 것입니다!><
        System.out.println("동작 예시");

        //향상된 for문을 활용하여 동물 소리 출력!
        for (Animal animal : animals) {
            printAnimalInfo(animal);
        }

    }//end of main

}
