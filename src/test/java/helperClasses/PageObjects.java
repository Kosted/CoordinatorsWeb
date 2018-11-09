package helperClasses;

import pageObjects.ChatPage;
import pageObjects.LoginPage;
import pageObjects.MatchesPage;
import pageObjects.RequestPage;

public class PageObjects {
    protected static LoginPage loginPage;
    protected static MatchesPage matchesPage;
    protected static RequestPage requestPage;
    protected static ChatPage chatPage;
    private WebActions web_a;

    public PageObjects(WebActions web_a) {
        this.web_a=web_a;
        loginPage = new LoginPage(web_a);
        matchesPage = new MatchesPage(web_a);
        requestPage = new RequestPage(web_a);
        chatPage = new ChatPage(web_a);
    }

    public void logIn(String login, String password){

        loginPage.toLoginPage();

        //loginPage.sendPhone("9000001000"); //dev
        //loginPage.sendPhone("9000003000"); // stage
        loginPage.sendPhone(login);

        // loginPage.sendPassword("123"); //dev
        //loginPage.sendPassword("N12345678"); //stage
        loginPage.sendPassword(password);


        loginPage.clickOnLogInButton();

        web_a.waitForAjax();

    }

}
