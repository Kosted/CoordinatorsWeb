package pageObjects;

import helperClasses.WebActions;
import helperClasses.chat.ChatFullCard;
import helperClasses.chat.ChatShortCard;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import superClasses.MainPage;

import java.util.List;

public class ChatPage extends MainPage {

    protected String filterClassName;


    @FindBy(className = "_090781")
    protected WebElement filtersListElem;

    @FindBy(className = "e4d50e")
    protected List<WebElement> chatList;

    @FindBy(id = "input_search")
    protected WebElement searchField;

    @FindBy(xpath = "//button[text()='Искать']")
    protected WebElement searchButton;

    @FindBy(xpath = "//button[@class='Искать']")
    protected WebElement clearSearchFieldButton;

    @FindBy(xpath = "//*[contains(@class, 'ae37ce') and text()='Все переговоры']")
    protected WebElement defaultFilterButton;

    @FindBy(className = "_5c4dba")
    protected WebElement backToDefaultFilterButton;

    public ChatPage(WebActions webActions) {
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

    public ChatShortCard getChatShortCard(int chatCardNum) {
        web_a.waitForAjax();
        if (chatList.size() == 0)
            return null;
        return new ChatShortCard(chatList.get(chatCardNum), web_a);
    }

    public ChatFullCard getChatFullCard(int chatCardNum) {
        web_a.waitForAjax();
        if (chatList.size() == 0)
            return null;
        return new ChatFullCard(chatList.get(chatCardNum));
    }

    public void clickOnChat(int chatCardNum) {
        web_a.waitForAjax();
        chatList.get(chatCardNum).click();
        web_a.waitForAjax();
    }

    public String updateChatCommentAndReturnValue(ChatFullCard chatFullCard, String inputText, Boolean clearBeforeInsert) {

        //ChatFullCard chatFullCard = new ChatFullCard(chatList.get(chatCardNum)).getChatCommentField();

        // chatFullCard.getChatCommentField().sendKeys(inputText);

        WebElement commentField = chatFullCard.getChatCommentField();

        if (clearBeforeInsert)
            web_a.clearField(commentField);

        if (!inputText.equals(""))
            commentField.sendKeys(inputText);

        return commentField.getAttribute("value");

    }

    public String updateChatBuyCommentAndReturnValue(ChatFullCard chatFullCard, String inputText, Boolean clearBeforeInsert) {

        WebElement commentField = chatFullCard.getChatBuyComment();

        if (clearBeforeInsert)
            web_a.clearField(commentField);

        if (!inputText.equals(""))
            commentField.sendKeys(inputText);

        return commentField.getAttribute("value");

    }

    public String updateChatSellCommentAndReturnValue(ChatFullCard chatFullCard, String inputText,Boolean clearBeforeInsert) {

        WebElement commentField = chatFullCard.getChatSellComment();

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
//    public String getChatCulture(int  num){
//        WebElement chatListElem = chatList.get(num);
//        ChatShortCard chatCard= new ChatShortCard();
//        return chatCard.getCulture();
//    }

    public ChatShortCard chooseStatusOfChat(int chatCardNum, statusOfChat status) {

        WebElement chat = chatList.get(chatCardNum);

        ChatShortCard chatShortCard = new ChatShortCard(chat,web_a);

        chatShortCard.getStatusButton().click();

        chat.findElements(By.className("_8c704e")).get(status.ordinal()).click();

        return chatShortCard;
    }

    public int getChatListSize() {
        web_a.waitForAjax();
        return chatList.size();
    }

    public enum statusOfChat {NEW, ON_WORK, SET_DOWN, NOT_INTERESTING, ARCHIVE, UNDER_CALL}

}
