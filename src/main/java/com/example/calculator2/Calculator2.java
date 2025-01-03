package com.example.calculator2;

import java.util.Stack;

public class Calculator2 {

    int a; // 첫 번째 숫자
    int b; // 두 번째 숫자
    String o; // 연산자(+, -, *, /)
    int result;

    //연산 결과를 저장하는 컬렉션 타입 필드 : stack 활용
    Stack<Integer> stack = new Stack<Integer>();

    int calculate(int a, String o, int b) {
        if (o.equals("/") && b == 0) {
            System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
            return 0;
        } else {
            // 3. 계산
            // 사칙연산 종류에 적합한 연산을 진행한다.
            switch (o) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    result = a / b;
                    break;
            }
            //사칙연산 수행 후 결과값을 반환 및 연산 결과를 stack에 저장
            stack.push(result);
            return result;
        }
    }
}
