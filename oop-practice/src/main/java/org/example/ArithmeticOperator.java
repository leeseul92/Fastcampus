package org.example;

import java.util.Arrays;

public enum ArithmeticOperator {
    //추상메소드를 사용하여 기능 구현
    ADDITION("+"){
        @Override
        public int arithmeticCalculate(int opt1, int opt2) {
            return opt1 + opt2;
        }
    }, SUBTRACTION("-") {
        @Override
        public int arithmeticCalculate(int opt1, int opt2) {
            return opt1 - opt2;
        }
    }, MULTIPLICATION("*") {
        @Override
        public int arithmeticCalculate(int opt1, int opt2) {
            return opt1 * opt2;
        }
    }, DIVISION("/") {
        @Override
        public int arithmeticCalculate(int opt1, int opt2) {
            return opt1 / opt2;
        }
    };

    private final String operator;

    ArithmeticOperator(String operator) {
        this.operator = operator;
    }

    /** 3.
     * calculate method가 실행되고 난 다음 하기 추상메소드가 실행되며, 일치하는 연산자의 enum 값을 찾아서 실행함.
     */
    public abstract int arithmeticCalculate(final int opt1, final int opt2);

    //하기 내용이 외부에 보여지는 public interface임.
    /** 2.
     * Calculator에서 위임받음. 하기 메소드가 먼저 실행됨.
     * 그 이후, 연산자가 일치하는 enum 값을 가져와, enum 값에 해당하는 메소드 중 하나를 실행하게 됨.
     */
    public static int calculate(int opt1, String optr, int opt2) {
        ArithmeticOperator arithmeticOperator = Arrays.stream(values())
                .filter(v -> v.operator.equals(optr))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));

        return arithmeticOperator.arithmeticCalculate(opt1, opt2);
    }
}
