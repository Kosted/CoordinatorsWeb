package tests.loginTests;

import org.junit.Test;
import superClasses.SuperTest;


public class EmptyPasswordOrPhoneFieldsTest extends SuperTest {

    public EmptyPasswordOrPhoneFieldsTest() {
        super(web_a);
    }

    @Test
    public void emptyPassword() {
        loginPage.toLoginPage();
        loginPage.sendPhone("9000001000");

        assertMCS.equalsFalse(loginPage.statusButton(), "кнопка авторизации активна");


    }

    @Test
    public void emptyPhone() {
        loginPage.toLoginPage();
        loginPage.sendPassword("qwert12345");

        assertMCS.equalsFalse(loginPage.statusButton(), "кнопка авторизации активна");

    }

    @Test
    public void emptyPhoneAndPassword() {
        loginPage.toLoginPage();

        assertMCS.equalsFalse(loginPage.statusButton(), "кнопка авторизации активна");

    }


}


