package pageObjects;

import helperClasses.match.MatchFullCard;
import helperClasses.match.MatchShortCard;
import helperClasses.WebActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import superClasses.MainPage;

import java.util.List;

public class MatchesPage extends MainPage {

    protected String filterClassName;


    @FindBy(className = "_090781")
    protected WebElement filtersListElem;

    @FindBy(className = "_96b468")
    protected List<WebElement> matchesList;

    @FindBy(id = "input_search")
    protected WebElement searchField;

    @FindBy(xpath = "//button[text()='Искать']")
    protected WebElement searchButton;

    @FindBy(xpath = "//button[@class='Искать']")
    protected WebElement clearSearchFieldButton;

    @FindBy(xpath = "//*[contains(@class, 'ae37ce') and text()='Все мэтчи']")
    protected WebElement defaultFilterButton;

    @FindBy(className = "_5c4dba")
    protected WebElement backToDefaultFilterButton;

    public MatchesPage(WebActions webActions) {
        super(webActions);

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

    public void clickOnDefaultFilterButton() {

        currentPageLink = defaultFilterButton.getAttribute("href");

        web_a.waitToBeClicable(defaultFilterButton, 5).click();
        web_a.waitForAjax();

    }

    public void clickOnBackToDefaultFilterButton() {
        currentPageLink = backToDefaultFilterButton.getAttribute("href");

        web_a.waitToBeClicable(backToDefaultFilterButton).click();
        web_a.waitForAjax();

    }

    public MatchShortCard getMatchCard(int matchCardNum) {
        web_a.waitForAjax();
        if (matchesList.size() == 0)
            return null;
        return new MatchShortCard(matchesList.get(matchCardNum));
    }

    public MatchFullCard getFullMatchCard(int matchCardNum) {
        web_a.waitForAjax();
        if (matchesList.size() == 0)
            return null;
        return new MatchFullCard(matchesList.get(matchCardNum));
    }

    public void clickOnMatch(int matchCardNum) {
        web_a.waitForAjax();
        matchesList.get(matchCardNum).click();
        web_a.waitForAjax();
    }

    public String updateMatchCommentAndReturnValue(MatchFullCard matchFullCard, String inputText, Boolean clearBeforeInsert) {

        //ChatFullCard matchFullCard = new ChatFullCard(matchesList.get(matchCardNum)).getMatchCommentField();

        // matchFullCard.getMatchCommentField().sendKeys(inputText);

        WebElement commentField = matchFullCard.getMatchCommentField();

        if (clearBeforeInsert)
            web_a.clearField(commentField);

        if (!inputText.equals(""))
            commentField.sendKeys(inputText);

        return commentField.getAttribute("value");

    }

    public String updateMatchBuyCommentAndReturnValue(MatchFullCard matchFullCard, String inputText, Boolean clearBeforeInsert) {

        WebElement commentField = matchFullCard.getMatchBuyComment();

        if (clearBeforeInsert)
            web_a.clearField(commentField);

        if (!inputText.equals(""))
            commentField.sendKeys(inputText);

        return commentField.getAttribute("value");

    }

    public String updateMatchSellCommentAndReturnValue(MatchFullCard matchFullCard, String inputText,Boolean clearBeforeInsert) {

        WebElement commentField = matchFullCard.getMatchSellComment();

        if (clearBeforeInsert)
            web_a.clearField(commentField);

        if (!inputText.equals(""))
            commentField.sendKeys(inputText);

        return commentField.getAttribute("value");

    }


    public String inputSearchText(String inputText) {
        if (isCurrentPage()) {
            searchField.sendKeys(inputText);
            return inputText;
        }
        return null;
    }

    public void clickOnSearchButton() {
        web_a.waitToBeClicable(searchButton).click();
        web_a.waitForAjax();
    }
//    public String getMatchCulture(int  num){
//        WebElement matchListElem = matchesList.get(num);
//        ChatShortCard matchCard= new ChatShortCard();
//        return matchCard.getCulture();
//    }

    public MatchShortCard chooseStatusOfMetch(int matchCardNum, statusOfMetch status) {

        WebElement match = matchesList.get(matchCardNum);

        MatchShortCard matchShortCard = new MatchShortCard(match);

        matchShortCard.getStatusButton().click();

        match.findElements(By.className("_8c704e")).get(status.ordinal()).click();

        return matchShortCard;
    }

    public int getMatchListSize() {
        web_a.waitForAjax();
        return matchesList.size();
    }

    public enum statusOfMetch {NEW, ON_WORK, SET_DOWN, NOT_INTERESTING, ARCHIVE, UNDER_CALL}

}

//    @FindBy(className = "_0b25ca _2a50a6 _6adc99 _7d4179")
//    private WebElement enabledButtonLogIn;
//
//    @FindBy(className = "_0b25ca _2a50a6 _6adc99 _7d4179 _4562d0")
//    private WebElement disabledButtonLogIn;