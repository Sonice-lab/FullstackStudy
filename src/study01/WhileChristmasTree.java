package study01;

import java.util.Scanner;

public class WhileChristmasTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("트리의 최대 높이 (N)를 입력하세요: ");
        int n = sc.nextInt();

        int i = 1; // 줄(행)을 담당하는 변수

        while (i <= n) {
            // 조건 4: 최대 10줄까지만 출력 후 강제 종료 (break 활용)
            if (i > 10) {
                System.out.println("(최대 출력 높이 10에 도달하여 종료되었습니다.)");
                break;
            }

            // 조건 3: 별의 층수(줄)가 3의 배수인 경우 공백과 별을 출력하지 않고 건너뛰기 (continue 활용)
            if (i % 3 == 0) {
                System.out.println();
                i++; // 무한 루프 방지를 위해 i를 먼저 증가시킨 후 continue
                continue;
            }

            // 1. 공백 그리기 (n - i 개)
            int space = 1;
            while (space <= n - i) {
                System.out.print(" ");
                space++;
            }

            // 2. 별 그리기 (2 * i - 1 개 - 홀수 개씩 증가)
            int star = 1;
            while (star <= (2 * i) - 1) {
                System.out.print("*");
                star++;
            }

            System.out.println(); // 줄바꿈
            i++; // 다음 줄로 이동
        }

        sc.close();
    }
}
