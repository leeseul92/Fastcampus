package org.example;

import org.assertj.core.util.Streams;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * <Requirement>
 *
 * - 간단한 사칙연산을 할 수 있다.
 * - 양수로만 계산할 수 있다.
 * - 나눗셈에서 0을 나누는 경우, IllegalArgument Exception을 발생시킨다.
 * - MVC pattern을 기반으로 구현한다.
 */
public class CalculatorTest {

    //public interface 생성하기
    // 덧셈연산 수행: 2개의 피연산자와 1개의 연산자를 calculator에 전달하여 작업을 위임한다.
    //  1 + 2 ---> calculator
    //      3 <--- calculator
    /*
    @DisplayName("덧셈 연산을 정상적으로 수행한다.")
    @Test
    void additionTest() {
        int result = Calculator.calculate(1, "+",2);
        System.out.println(result);

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("뺄셈 연산을 정상적으로 수행한다.")
    @Test
    void subtractionTest() {
        int result = Calculator.calculate(1, "-",2);
        System.out.println(result);

        assertThat(result).isEqualTo(-1);
    }
    */

    //Test method를 나눠짜지 않고 한꺼번에 수행할 수 있도록 하는 코드
    @DisplayName("사칙연산 method")
    @ParameterizedTest
    @MethodSource("formularAndResult")
    void calculateTest(int opt1, String optr, int opt2, int result) {
        int calculateResult = Calculator.calculate(opt1, optr, opt2);

        assertThat(calculateResult).isEqualTo(result);
    }

    //하기 method는 위의 method의 annotation으로 명기되어 있으므로, 하기에 기재된 parameter가 위의 method에서 paramter로 사용될 수 있음.
    private static Stream<Arguments> formularAndResult() {
        return Stream.of (
                arguments(1, "+", 2, 3),
                arguments(1, "-", 2, -1),
                arguments(4, "*", 2, 8),
                arguments(4, "/", 2, 2)
        );
    }

}
