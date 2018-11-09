package pageObjects;

import helperClasses.WebActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import superClasses.SuperPage;

public class LoginPage extends SuperPage {

    @FindBy(name = "phone")
    private WebElement phoneField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='Войти']")
    private WebElement logInButton;

    @FindBy(xpath = "//li[text()='Невозможно авторизоваться с предоставленными учетными данными']")
    private WebElement errorMessage;

    public LoginPage(WebActions webActions) {
        super(webActions);

        currentPageLink =standartPageLink+ "/auth/sign-in";

    }

    public void toLoginPage() {
        driver.get(currentPageLink);
    }

    public void sendPhone(String inputPhone) {
        web_a.waitToBeClicable(phoneField).click();
        phoneField.sendKeys(inputPhone);
    }

    public void clearPhoneField() {
        web_a.waitToBeClicable(phoneField);
        web_a.clearField(phoneField);
    }

    public void sendPassword(String inputPassword) {
        web_a.waitToBeClicable(passwordField).click();
        passwordField.sendKeys(inputPassword);
    }

    public void clearPasswordField() {
        web_a.waitToBeClicable(passwordField);
        web_a.clearField(passwordField);
    }

    public void clickOnLogInButton() {
        web_a.waitToBeClicable(logInButton).click();
        currentPageLink = standartPageLink + "/requests/buying";
    }

    public boolean wrongPassword(){
        if (web_a.isPresent(errorMessage,2)==null)
        return false;
        return true;
    }

    public Boolean statusButton(){
        if (logInButton.isEnabled())
            return true;
        else
            return false;

    }

}



//    @FindBy(className = "_0b25ca _2a50a6 _6adc99 _7d4179")
//    private WebElement enabledButtonLogIn;
//
//    @FindBy(className = "_0b25ca _2a50a6 _6adc99 _7d4179 _4562d0")
//    private WebElement disabledButtonLogIn;