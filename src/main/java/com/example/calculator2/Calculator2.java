package com.example.calculator2;

import java.util.ArrayList;
import java.util.List;

public class Calculator2<T extends Number> {

    //연산 결과를 저장하는 컬렉션 타입 필드
    //외부에서 직접 접근하지 못하도록 캡슐화 w/ private
    private final List<T> list = new ArrayList<>();

    // 간접 접근으로 필드를 확인할 수 있도록 Getter 메서드 구현
    public T getList() {
        try {
            return list.get((list.size() - 1));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("저장된 연산결과가 없습니다.");
            return null;
        }
    }

    // 간접 접근으로 필드에 접근하여 데이터를 추가할 수 있게 Setter 메서드 구현
    public void setList(T list) {
        this.list.add(list);
    }

    // Enum 타입으로 연산자 타입 정의
    public enum Operator {
        ADD("+"),
        SUBTRACT("-"),
        MULTIPLY("*"),
        DIVIDE("/");

        private final String operator;

        // 생성자
        Operator(String operator) {
            this.operator = operator;
        }

        // 연산자 문자열 반환
        public String getOperator() {
            return operator;
        }

        // 문자열을 연산자 타입으로 변환하는 메서드
        public static Operator fromString(String operator) {
            for (Operator op : Operator.values()) {
                if (op.getOperator().equals(operator)) {
                    return op;
                }
            }
            throw new IllegalArgumentException("유효하지 않은 연산자입니다: "+operator);
        }
    }

    // 제너릭 메서드로 다양한 타입의 숫자 처리
    public T calculate(T a, Operator o, T b) {
        double result = 0.0;
        double a1 = a.doubleValue();
        double b1 = b.doubleValue();

        try{
            // 3. 계산
            result = switch (o) {
                case ADD -> a1 + b1;
                case SUBTRACT -> a1 - b1;
                case MULTIPLY -> a1 * b1;
                case DIVIDE -> a1 / b1;
            };
        } catch (ArithmeticException e) {
            System.out.println("연산 오류: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("입력 오류: " + e.getMessage());
        } catch (Exception e){
            System.out.println("알 수 없는 오류가 발생했습니다: " + e.getMessage());
        }

        if (a instanceof Integer) {
            return (T) Integer.valueOf((int) result);
        } else if (a instanceof Double) {
            return (T) Double.valueOf(result);
        } else {
            throw new UnsupportedOperationException("지원하지 않는 타입입니다.");
        }
    }

    // 리스트에 가장 먼저 들어간 데이터를 삭제하는 메서드
    public T removeResult() {
        if (list.isEmpty()) {
            System.out.println("저장된 연산 결과가 없습니다.");
            return null;
        }

        T firstData = list.get(0);

        list.remove(0);

        return firstData;
    }
}