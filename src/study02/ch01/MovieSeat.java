package study02.ch01;

import java.util.Scanner;


// 1. Reservable 인터페이스 생성
// 객체가 '예약 가능함'을 나타내기 위한 추상 메서드 정의
interface Reservable {
    // 예약을 수행하는 추상 메서드
    void reserve();

    // 예약을 취소하는 추상 메서드
    void cancel();
}

// 2. Seat 클래스 생성 및 Reservable 인터페이스 구현

class Seat implements Reservable {
    // 좌석 번호
    private String seatNumber;

    //예약 여부(true: 예약됨, false: 예약 안 됨)
    private boolean reserved;

    // 생성자: 좌석을 처음 만들 때 번호를 부여하고, 예약 상태는 기본값(false)으로 둔다.
    public Seat(String seatNumber) {
        this.seatNumber = seatNumber;
        this.reserved = false;
    }

    // 좌석 번호를 가져오는 Getter
    public String getSeatNumber() {
        return seatNumber;
    }

    // 좌석 번호를 변경하는 Setter (좌석 정보 수정 기능에 사용)
    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    //예약 여부를 확인하는 Getter
    public boolean isReserved() {
        return reserved;
    }

    //Reservable 인터페이스의 추상 메서드 오버라이딩(구현)
    @Override
    public void reserve() {
        // 예약 상태를 true로 변경
        this.reserved = true;
    }

    @Override
    public void cancel() {
        // 예약 상태를 false로 변경(취소)
        this.reserved = false;

    }
}

// 메인 실행 클래스
public class MovieSeat {
    public static void main(String[] args) {
        //Scanner 불러오기
        Scanner scanner = new Scanner(System.in);

        boolean found = false;

        // 3. 좌석은 Seat[] 배열에 저장
        // 최대 10개의 좌석을 관리할 수 있는 배열 생성
        Seat[] seats = new Seat[10];

        // 테스트와 실습을 위해 기본적으로 5개의 좌석을 미리 배열에 등록해 두기
        seats[0] = new Seat("A1");
        seats[1] = new Seat("A2");
        seats[2] = new Seat("A3");
        seats[3] = new Seat("B1");
        seats[4] = new Seat("B2");

        //4. 무한 루프(while)와 Scanner를 활용한 메뉴 시스템
        while (true) {
            System.out.println("\n 영화관 좌석 관리 프로그램");
            System.out.println("1. 전체 좌석 조회");
            System.out.println("2. 좌석 예약");
            System.out.println("3. 예약 취소");
            System.out.println("4. 좌석 정보 수정");
            System.out.println("5. 좌석 삭제");
            System.out.println("6. 종료");
            System.out.println("메뉴를 선택하세요.: ");

            // 사용자로부터 메뉴 번호를 숫자로 입력
            int menu = scanner.nextInt();

            // nextInt() 이후에 남은 엔터(개행문자)를 비워주는 역할
            scanner.nextLine();

            if (menu == 1) {
                // 1. 전체 좌석 조회 - READ
                System.out.println("\n 전체 좌석 조회");
                for (int i = 0; i < seats.length; i++) {
                    //배열의 해당 칸이 비어있지 않은(좌석 객체가 있는) 경우만 출력
                    if (seats[i] != null) {
                        String status = seats[i].isReserved() ? "[예약 완료 ]" : "[예약 가능]";
                        System.out.println("- 좌석 번호: " + seats[i].getSeatNumber() + " " + status);
                    }
                }
                // 2. 좌석 예약 -  UPDATE (예약 상태 변경)
            } else if (menu == 2) {
                System.out.println("예약할 좌석 번호를 입력하세요. (예:A1): ");
                String targetSeat = scanner.nextLine();
                //좌석을 찾았는지 확인하기 위한 플래그 변수
//                boolean found = false;

                for (int i = 0; i < seats.length; i++) {
                    // 좌석이 존재하고, 입력한 번호와 현재 좌석의 번호가 일치하는 지 확인
                    if (seats[i] != null && seats[i].getSeatNumber().equals(targetSeat)) {
                        found = true;
                        if (seats[i].isReserved()) {
                            System.out.println("이미 예약된 좌석입니다.");

                        } else {
                            //인터페이스를 통해 구현한 reserve() 호출
                            seats[i].reserve();
                            System.out.println("✅" + targetSeat + "좌석이 성공적으로 예약되었습니다.");
                        }
                        //좌석을 찾아서 처리했으므로 반복문을 종료시킴
                        break;
                    }
                } //end of for
                if (!found) {
                    System.out.println("해당 좌석을 찾을 수 없습니다.");
                }

            } // end of menu == 2

            else if (menu == 3) {
                //3. 예약 취소 - UPDATE(예약 상태 변경)
                System.out.println("예약 취소할 좌석 번호를 입력하세요: ");
                String targetSeat = scanner.nextLine();
//                boolean found = false;

                for (int i = 0; i < seats.length; i++) {
                    if (seats[i] != null && seats[i].getSeatNumber().equals(targetSeat)) {
                        found = true;
                        if (seats[i].isReserved()) {
                            // 인터페이스를 통해 구현한 cancel() 호출
                            seats[i].cancel();
                            System.out.println("✅" + targetSeat + "좌석 예약이 취소되었습니다.");
                        } else {
                            System.out.println("예약되지 않은 빈 좌석입니다.");
                        }
                        break;
                    }
                }
                if (!found) {
                    System.out.println("해당 좌석을 찾을 수 없습니다.");
                }

            } else if (menu == 4) {
                //4. 좌석 정보 수정 - UPDATE (좌석 번호 자체를 변경)
                System.out.println("수정할 기존 좌석 번호를 입력하세요.: ");
                String oldSeat = scanner.nextLine();
//                //boolean found = false;

                for (int i = 0; i < seats.length; i++) {
                    // 현재 확인 중인 자리가 빈자리가 아니면서,
                    // 동시에 그 좌석 번호가 내가 찾던 번호와 정확히 일치한다면 찾았다는 표시를 남겨라
                    if (seats[i] != null && seats[i].getSeatNumber().equals(oldSeat)) {
                        found = true;
                        System.out.println("새로운 좌석 번호를 입력하세요.: ");
                        String newSeat = scanner.nextLine();

                        //Setter를 이용해 좌석 번호 변경
                        seats[i].setSeatNumber(newSeat);
                        System.out.println("좌선 번호가 " + newSeat + "(으)로 수정되었습니다.");
                        break;
                    }
                }
                if (!found) {
                    System.out.println("해당 좌석을 찾을 수 없습니다.");

                }
            }// end of menu == 4

            else if (menu == 5) {
                // 5. 좌석 삭제 - DELETE(배열에서 해당 객체를 삭제)
                System.out.println("삭제할 좌석 번호를 입력하세요.");
                String targetSeat = scanner.nextLine();
                //boolean found = false;

                for (int i = 0; i < seats.length; i++) {
                    if (seats[i] != null && seats[i].getSeatNumber().equals(targetSeat)) {
                        found = true;
                        // 배열의 해당 인덱스를 null로 비워버림으로써 삭제 처리
                        seats[i] = null;
                        System.out.println("✅" + targetSeat + "좌석이 시스템에서 삭제되었습니다.");
                        break;
                    }
                }

                if (!found) {
                    System.out.println("해당 좌석을 찾을 수 없습니다.");
                }
            } // end of menu == 5
            else if (menu == 6) {
                //6. 종료 - exit
                System.out.println("프로그램을 종료합니다. 이용해주셔서 감사합니다.");
                //while(true) 무한 루프를 빠져나가기
                break;

            } else {
                //잘못된 메뉴 번호(1~6 이외의 숫자) 입력 시 예외처리
                System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
            }

        }// end of while
        //프로그램 종료 시 Scanner 자원 반납
        scanner.close();

    }// emd of main

}// end of class
