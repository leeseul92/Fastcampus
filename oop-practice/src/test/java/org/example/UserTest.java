package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    /**
     * 이 상태에서 테스트해보면, 랜덤으로 생성한 비밀번호가 조건에 부합하면 password 변수에 담기게 되고, 아니면 담기지 않게 됨. (User.class)
     * 그렇기 때문에 랜덤하게 에러가 발생하는 모양이 되어버림.
    @DisplayName("패스워드 초기화한다.")
    @Test
    void passwordTest1() {
        //given
        User user = new User();

        //when
        user.initPassword(new RandomPasswordGenerator());
        System.out.println("*********Random Password*********");
        System.out.println(user.getPassword());
        System.out.println("*********************************");

        //then
        assertThat(user.getPassword()).isNotNull();
    }
     */

    @DisplayName("패스워드가 요구사항에 부합하지 않아 초기화가 되지 않는다.")
    @Test
    void passwordTest2() {
        //given
        User user = new User();

        //when
        user.initPassword(() -> "abcdefgh");
        System.out.println("*********Password*********");
        System.out.println(user.getPassword());
        System.out.println("**************************");

        //then
        assertThat(user.getPassword()).isNotNull();
    }

    @DisplayName("패스워드가 요구사항에 부합하지 않아 초기화가 되지 않는다.")
    @Test
    void passwordTest3() {
        //given
        User user = new User();

        //when
        user.initPassword(() -> "ab");
        System.out.println("*********Password*********");
        System.out.println(user.getPassword());
        System.out.println("**************************");

        //then
        assertThat(user.getPassword()).isNull();
    }
}