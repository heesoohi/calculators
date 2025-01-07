package com.example.calculator2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Calculator2 인스턴스 생성
        Calculator2 cal = new Calculator2();

        Scanner sc = new Scanner(System.in);

        while (true) {
            // 1. 입력값
            // 양의 정수 두개를 입력 받는다.
            System.out.println("첫 번째 숫자를 입력하세요: ");
            String no1 = sc.nextLine();
            int a = Integer.parseInt(no1);

            System.out.println("두 번째 숫자를 입력하세요: ");
            String no2 = sc.nextLine();
            int b = Integer.parseInt(no2);
            // 사칙연산 기호를 입력 받는다.
            System.out.print("사칙연산 기호(+, -, *, /)를 입력하세요: ");
            String o = sc.nextLine();

            int result = cal.calculate(a,o,b);

            // 연산 결과 저장 여부 확인
            System.out.println("방금 연산 결과를 저장하시겠습니까? (yes 입력 시 추가)");
            String set = sc.nextLine();
            // yes 입력 시 stack 에 데이터 저장
            if (set.equals("yes")) {
                cal.setStack(result);
            }

            // 연산 결과 조회 여부 확인
            System.out.println("방금 연산의 결과를 조회하시겠습니까? (yes 입력 시 조회)");
            String get = sc.nextLine();
            // yes 입력 시 Calculator2의 stack 에 저장된 데이터 조회
            if (get.equals("yes")) {
                System.out.println(cal.getStack());
            }

            // 가장 먼저 저장된 연산결과 데이터 삭제 여부 확인
            System.out.println("가장 오래된 연산 결과를 삭제하시겠습니까? (yes 입력 시 삭제)");
            String del = sc.nextLine();
            if (del.equals("yes")) {
                System.out.println("삭제 된 데이터: " + cal.removeResult());
                cal.removeResult();
            }

            // 반복 확인
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String repeat = sc.nextLine();
            // exit 입력 시 반복 종료
            if (repeat.equals("exit")) {
                System.exit(0);
            }
        }
    }
}
