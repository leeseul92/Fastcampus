package org.example;

public class User {
    private String password;

    public void initPassword(PasswordGenerator passwordGenerator) {
        //RandomPasswordGenerator가 몇자의 password를 생성할지 컨트롤할 수 없기 때문에, 테스트코드를 작성하기가 쉽지 않음.
        //컨트롤할 수 없는 부분을 외부로부터 주입받자: 결합을 끊기 위해 인터페이스를 사용하였음.
//        RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator(); //Random 숫자가 0 ~ 12 사이로 만들어지고,

        //to-be for test code
        String password = passwordGenerator.generatePassword();

        /**
         * 비밀번호는 최소 8자 이상 12자 이하여야 한다.
         */
        if(password.length() >= 8 && password.length() <= 12){
            this.password = password; //RandomPasswordGenerator에서 만들어진 길이가 조건에 부합하면 password 변수에 담기게 된다. 부합하지 않으면 설정되지 않음.
        }
    }

    public String getPassword() {
        return password;
    }
}
