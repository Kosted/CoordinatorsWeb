package superClasses;

import helperClasses.WebActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public abstract class MainPage extends SuperPage {

    @FindBy(xpath = "//a[text()='Заявки']")
    @CacheLookup
    protected WebElement requestsButton;

    @FindBy(xpath = "//a[text()='Мэтчи']")
    @CacheLookup
    protected WebElement matchesButton;

    @FindBy(xpath = "//a[text()='Переговоры']")
    @CacheLookup
    protected WebElement chatButton;

    @FindBy(xpath = "//a[text()='Сделки']")
    @CacheLookup
    protected WebElement dealsButton;

    @FindBy(xpath = "//a[text()='Пользователи']")
    @CacheLookup
    protected WebElement usersButton;


    protected final String requestsLink;
    protected final String matchesLink;
    protected final String chatLink;
    protected final String dealsLink;
    protected final String usersLink;

    protected final String buyingLink;
    protected final String saleLink;

    public MainPage(WebActions webActions) {
        super(webActions);

        requestsLink = "/requests";
        matchesLink = "/matches";
        chatLink = "/chat";
        dealsLink = "/deals";
        usersLink = "/users";

        buyingLink = "/buying";
        saleLink = "/sale";

        currentPageLink = standartPageLink + requestsLink + buyingLink;

        //  filtersList = filtersListElem.findElements(By.className("ae37ce"));

    }

    public void goToRequest() {
        web_a.waitToBeClicable(requestsButton).click();
        currentPageLink = standartPageLink + requestsLink + buyingLink;
    }

    public void goToMatches() {
        web_a.waitToBeClicable(matchesButton).click();
        currentPageLink = standartPageLink + matchesLink;
        web_a.waitForAjax();
    }

    public void goToChat() {
        web_a.waitToBeClicable(chatButton).click();
        currentPageLink = standartPageLink + chatLink;
        web_a.waitForAjax();
    }

    public void goToDeals() {
        web_a.waitToBeClicable(dealsButton).click();
        currentPageLink = standartPageLink + dealsLink;
        web_a.waitForAjax();
    }

    public void goToUsers() {
        web_a.waitToBeClicable(usersButton).click();
        currentPageLink = standartPageLink + usersLink;
        web_a.waitForAjax();
    }

    public WebElement getRequestsButton() {
        return requestsButton;
    }
}

//    @FindBy(className = "_0b25ca _2a50a6 _6adc99 _7d4179")
//    private WebElement enabledButtonLogIn;
//
//    @FindBy(className = "_0b25ca _2a50a6 _6adc99 _7d4179 _4562d0")
//    private WebElement disabledButtonLogIn;