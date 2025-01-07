package com.example.calculator2;

import java.util.ArrayList;
import java.util.List;

public class Calculator2 {

    //연산 결과를 저장하는 컬렉션 타입 필드 : stack 활용
    //외부에서 연산 결과를 저장한 stack 에 직접 접근하지 못하도록 캡슐화 w/ private
    private final List<Integer> list = new ArrayList<Integer>();

    // 간접 접근으로 필드를 확인할 수 있도록 Getter 메서드 구현
    public int getList() {
        return list.get(0);
    }

    // 간접 접근으로 필드에 접근하여 데이터를 추가할 수 있게 Setter 메서드 구현
    public void setList(int list) {
        this.list.add(list);
    }

    public int calculate(int a, String o, int b) throws Exception{
        int result = 0;
        try{
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
            return result;  //사칙연산 수행 후 결과값을 반환 및 연산 결과를 stack에 저장
        } catch (Exception e) {
            // 에러 로그 출력
            e.printStackTrace();
            // 에러 원인 조회 후 출력
            e.getCause().printStackTrace();
        } //
        throw new Exception();
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