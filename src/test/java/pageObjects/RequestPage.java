package pageObjects;

import helperClasses.WebActions;
import helperClasses.request.FullRequestCard;
import helperClasses.request.ShortRequestCard;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import superClasses.MainPage;

import java.util.List;

public class RequestPage extends MainPage {

    protected String filterClassName;


    @FindBy(className = "_090781")
    protected WebElement filtersListElem;

    @FindBy(className = "_0d92db")
    protected WebElement cleanSearchFieldButton;

    @FindBy(className = "fefaea")
    protected List<WebElement> searchOptionsList;

    @FindBy(className = "_4324a2")
    protected WebElement fullRequestCard;

    @FindBy(xpath = "//*[contains(@class, 'ae37ce') and text()='Все заявки']")
    protected WebElement defaultFilterButton;

    @FindBy(className = "_5c4dba")
    protected WebElement backToDefaultFilterButton;

    @FindBy(xpath = "//*[contains(@class, '_97f95a') and contains(@class, '_8660a6')]")
    protected List<WebElement> requestList;

    @FindBy(id = "input_address")
    protected WebElement searchField;

    @FindBy(xpath = "//*[contains(@class, '_06b30d') and text()='Покупка']")// //*[text()='Покупка']
    protected WebElement buyingButton;

    @FindBy(xpath = "//*[contains(@class, '_06b30d') and text()='Продажа']") // //*[text()='Продажа']
    protected WebElement sellingButton;

    public RequestPage(WebActions webActions) {
        super(webActions);
        currentPageLink = standartPageLink + "/requests";
        filterClassName = "ae37ce";
    }

    // filterNum < 30
    public String chooseFilter(int filterNum) {

        List<WebElement> filtersList = filtersListElem.findElements(By.className(filterClassName));
        filtersList.get(filterNum).click();
        currentPageLink = /*standartPageLink + */filtersList.get(filterNum).getAttribute("href");
        //web_a.waitStalenessOf(requestList.get(0));
        web_a.waitForAjax();

        // web_a.waitChangeUrl(currentPageLink);
        //PageFactory.initElements(driver,this);
        return filtersList.get(filterNum).getText();
    }

    public ShortRequestCard getShortRequestCard(int requestCardNum) {
        if (requestList.size() == 0 || requestList.size() <= requestCardNum)
            return null;
        //System.out.println("requestList.size()=" +requestList.size());
        //System.out.println("requestCardNum=" +requestCardNum);
        return new ShortRequestCard(requestList.get(requestCardNum),web_a);
    }

    public FullRequestCard getFullRequestCard(int requestCardNum) {
        clickOnRequest(requestCardNum);
        web_a.waitForAjax();
        return new FullRequestCard(fullRequestCard);
    }

    public int getRequestListSize() {
        return requestList.size();
    }


    public String inputSearchText(String inputText) {
            searchField.sendKeys(inputText);
            web_a.waitForAjax();
            return inputText;
    }

    public Boolean clickOnSearchOptions(int position) {
        if (position < searchOptionsList.size()) {
            web_a.waitToBeClicable(searchOptionsList.get(position)).click();
            web_a.waitForAjax();
            return true;
        }
        return false;
    }

    public void clickOnBuyingButton() {
        web_a.waitToBeClicable(buyingButton).click();
    }


    public void clickOnSellinngButton() {
        web_a.waitToBeClicable(sellingButton).click();
    }

    public void clickOnDefaultFilterButton() {
        currentPageLink = defaultFilterButton.getAttribute("href");

        web_a.waitToBeClicable(defaultFilterButton,5).click();
        web_a.waitForAjax();

    }

    public void clickOnBackToDefaultFilterButton() {
        currentPageLink = backToDefaultFilterButton.getAttribute("href");

        web_a.waitToBeClicable(backToDefaultFilterButton).click();
        web_a.waitForAjax();

    }

    public void clickOnRequest(int requestCardNum) {
        currentPageLink = requestList.get(requestCardNum).getAttribute("href");

        web_a.waitToBeClicable(requestList.get(requestCardNum)).click();
        web_a.waitForAjax();

    }

    public void clickOnCleanSearchFieldButton(){
        web_a.waitToBeClicable(cleanSearchFieldButton).click();
        web_a.waitForAjax();

    }

}

