package tests.loginTests;

import org.junit.Test;
import superClasses.SuperTest;


public class UncorrectLogInTest extends SuperTest {

    public UncorrectLogInTest() {
        super(web_a);
    }

    @Test
    public void userLogin() {


        logIn("9000001000", "qwert12345");

        assertMCS.equalsTrue(loginPage.wrongPassword(), "сообщение о некорректном логине/пароле не появилось");

      //  assertMCS.equalsFalse(loginPage.isCurrentPage(), "была произведена авторизация с некоректыми данными");


    }


}


