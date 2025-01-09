package com.example.calculator2;

import java.util.ArrayList;
import java.util.List;

public class Calculator2 {

    //연산 결과를 저장하는 컬렉션 타입 필드 : stack 활용
    //외부에서 연산 결과를 저장한 stack 에 직접 접근하지 못하도록 캡슐화 w/ private
    private final List<Integer> list = new ArrayList<>();

    // 간접 접근으로 필드를 확인할 수 있도록 Getter 메서드 구현
    public int getList() {
        return list.get((list.size() - 1));
    }

    // 간접 접근으로 필드에 접근하여 데이터를 추가할 수 있게 Setter 메서드 구현
    public void setList(int list) {
        this.list.add(list);
    }

    // Enum 타입으로 연산자 타입 정의
    public enum Operator {
        ADD("+"),
        SUBSTRACT("-"),
        MULTIPLY("*"),
        DIVIDE("/");

        private final String operator;

        Operator(String operator) {
            this.operator = operator;
        }

        public String getOperator() {
            return operator;
        }

        public static Operator fromString(String operator) {
            for (Operator op : Operator.values()) {
                if (op.getOperator().equals(operator)) {
                    return op;
                }
            }
            throw new IllegalArgumentException("유효하지 않은 연산자입니다: "+operator);
        }
    }


    public int calculate(int a, Operator o, int b) {
        int result = 0;
        try{
            // 3. 계산
            result = switch (o) {
                case ADD -> a + b;
                case SUBSTRACT -> a - b;
                case MULTIPLY -> a * b;
                case DIVIDE -> a / b;
            };
        } catch (ArithmeticException e) {
            System.out.println("연산 오류: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("입력 오류: " + e.getMessage());
        } catch (Exception e){
            System.out.println("알 수 없는 오류가 발생했습니다: " + e.getMessage());
        }
        return result;
    }

    // 리스트에 가장 먼저 들어간 데이터를 삭제하는 메서드
    public Integer removeResult() {
        if (list.isEmpty()) {
            System.out.println("저장된 연산 결과가 없습니다.");
            return null;
        }

        int firstData = list.get(0);

        list.remove(0);

        return firstData;
    }
}