package com.example.calculator2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Calculator2<Double> cal = new Calculator2<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {  // 스캐너로 입력값 받으면서 오류가 발생할 수 있으니 try ~ catch 문 사용
                // 1. 숫자 입력
                System.out.println("첫 번째 숫자를 입력하세요: ");
                double a = sc.nextInt();

                System.out.println("두 번째 숫자를 입력하세요: ");
                double b = sc.nextInt();
                sc.nextLine(); // 남아 있는 개행 문자 제거

                // 2. 연산자 입력
                System.out.print("사칙연산 기호(+, -, *, /)를 입력하세요: ");
                String o = sc.nextLine();
                Calculator2.Operator op = Calculator2.Operator.fromString(o);

                // 3. 사칙연산 수행
                Double result = cal.calculate(a, op, b);
                System.out.println("연산 결과: " + result);

                // 4. 연산 결과 저장 여부 확인
                System.out.println("방금 연산 결과를 저장하시겠습니까? (yes 입력 시 추가)");
                String set = sc.nextLine();
                // yes 입력 시 list 에 데이터 저장
                if (set.equals("yes")) {
                    cal.setList(result);
                }

                // 5. 결과 조회 여부 확인
                System.out.println("방금 연산의 결과를 조회하시겠습니까? (yes 입력 시 조회)");
                String get = sc.nextLine();
                // yes 입력 시 Calculator2의 list 에 저장된 데이터 조회
                if (get.equals("yes")) {
                    System.out.println(cal.getList());
                }

                // 6. 가장 오래된 연산결과 데이터 삭제 여부 확인
                System.out.println("가장 오래된 연산 결과를 삭제하시겠습니까? (yes 입력 시 삭제)");
                String del = sc.nextLine();
                if (del.equals("yes")) {
                    System.out.println("삭제 된 데이터: " + cal.removeResult());
                }

                // 7. 반복 확인
                System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                String repeat = sc.nextLine();
                // exit 입력 시 반복 종료
                if (repeat.equals("exit")) {
                    System.exit(0);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("오류가 발생하였습니다. 다시 시도해주세요.");
                sc.nextLine(); // 입력 오류 발생 시 남은 입력값 제거
            }
        }
    }
}
