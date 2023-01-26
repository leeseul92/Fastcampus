package org.example;

public class Calculator {
    public static int calculate(int opt1, String optr, int opt2) {
        /**
        //Calculator.class
        if ("+".equals(optr)) {
            return opt1 + opt2;
        } else if ("-".equals(optr)) {
            return opt1 - opt2;
        } else if ("*".equals(optr)) {
            return opt1 * opt2;
        } else if ("/".equals(optr)) {
            return opt1 / opt2;
        }

        return 0;
         */

        //enum을 사용한 ArithmeticOperator와 연결
        /** 1.
         * Calculator는 작업을 위임받으면 ArithmeticOperator로 작업을 다시 위임하게 됨.
         * 최종적으로는 ArithmeticOperator에서 진행하게 됨.
         */
        return ArithmeticOperator.calculate(opt1, optr, opt2);
    }
}
