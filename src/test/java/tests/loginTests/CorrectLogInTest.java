package tests.loginTests;

import org.junit.Test;
import superClasses.SuperTest;


public class CorrectLogInTest extends SuperTest {

    public CorrectLogInTest() {
        super(web_a);
    }

     @Test
    public void userLogin() {

        logIn("9000001000","N12345678");

        assertMCS.equalsTrue(requestPage.isCurrentPage(),"не был произвед переход на страницу заявок" );
         //Assert.assertTrue("не был осуществлен переход на стараницу логин", web_a.waitToBeClicable(matchesPage.getRequestsButton()) != null);


    }


}


