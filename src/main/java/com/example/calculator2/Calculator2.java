package com.example.calculator2;

import java.util.Stack;

public class Calculator2 {

    int a; // 첫 번째 숫자
    int b; // 두 번째 숫자
    String o; // 연산자(+, -, *, /)
    int result;

    //연산 결과를 저장하는 컬렉션 타입 필드 : stack 활용
    //외부에서 연산 결과를 저장한 stack 에 직접 접근하지 못하도록 캡슐화 w/ private
    private Stack<Integer> stack = new Stack<Integer>();

    // 간접 접근으로 필드를 확인할 수 있도록 Getter 메서드 구현
    public int getStack() {
        return stack.peek();
    }

    // 간접 접근으로 필드에 접근하여 데이터를 추가할 수 있게 Setter 메서드 구현
    public void setStack(int stack) {
        this.stack.push(stack);
    }

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
            return result;
        }
    }

    //stack에 가장 먼저 들어간 데이터를 삭제하는 메서드
    public Integer removeResult() {
        if (stack.isEmpty()) {
            System.out.println("저장된 연산 결과가 없습니다.");
            return null;
        }

        //스택에 저장된 모든 데이터를 꺼내야, 가장 먼저 저장된 데이터를 삭제할 수 있음.
        Stack<Integer> tempStack = new Stack<>();
        while (stack.size() > 1) {
            tempStack.push(stack.pop()); // 스택에 가장 최근에 저장된 데이터를 가져와서 tempStack에 저장
        }

        Integer firstData = stack.pop(); // 스택에 가장 먼저 들어간 데이터 제거

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop()); // tempStack에 넣어뒀던 데이터 다시 stack에 옮기기
        }

        return firstData;
    }
}