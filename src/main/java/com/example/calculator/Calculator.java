package com.example.calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
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
            String operator = sc.nextLine();

            // 2. 오류
            if (operator.equals("/") && b == 0) {
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
            } else {
                // 3. 계산
                // 사칙연산 종류에 적합한 연산을 진행한다.
                switch (operator) {
                    case "+":
                        System.out.println("결과: " + (a + b));
                        break;
                    case "-":
                        System.out.println("결과: " + (a - b));
                        break;
                    case "*":
                        System.out.println("결과: " + (a * b));
                        break;
                    case "/":
                        System.out.println("결과: " + (a / b));
                        break;
                }
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

