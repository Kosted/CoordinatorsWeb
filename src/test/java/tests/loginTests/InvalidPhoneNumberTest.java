package tests.loginTests;

import org.junit.Test;
import superClasses.SuperTest;


public class InvalidPhoneNumberTest extends SuperTest {

    public InvalidPhoneNumberTest() {
        super(web_a);
    }

     @Test
    public void userLogin() {

        loginPage.toLoginPage();
        loginPage.sendPhone("454545");
        loginPage.sendPassword("qwert12345");

        assertMCS.equalsFalse(loginPage.statusButton(),"кнопка входа активна при вводе невалидного номера");



    }



}


