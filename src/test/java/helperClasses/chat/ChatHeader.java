package helperClasses.chat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

public class ChatHeader {

    private String chatSellPriseCondition;
    private String logisticType;
    private String chatStatus;
    private String chatId;
    private String chatCulture;
    private String mainProperty;
    private String chatDate;
    private String chatRadius;
    private String status;

    private WebElement statusButton;

//    private  String headerPartsClassName;
//    private  List<WebElement> headerpartsList;


    public String getChatId() {
        return chatId;
    }

    public String getChatCulture() {
        return chatCulture;
    }

    public String getMainProperty() {
        return mainProperty;
    }

    public String getChatDate() {
        return chatDate;
    }

    public String getChatRadius() {
        return chatRadius;
    }

    public String getStatus() {
        return status;
    }

    public ChatHeader(WebElement chatHeader) {

        statusButton = chatHeader.findElement(By.tagName("button"));
        status = statusButton.getText();

        List<WebElement> chatStatusElem = chatHeader.findElements(By.className("_8a13be"));
        if (chatStatusElem.size() == 2)
            chatStatus = chatStatusElem.get(0).getText();

        List<WebElement> descriptionList = chatHeader.findElements(By.className("c03fc2"));
        List<WebElement> valueList = chatHeader.findElements(By.className("f1e9c6"));

        for (int descriptionsIterator = 0; descriptionsIterator < descriptionList.size(); descriptionsIterator++)
            switch (descriptionList.get(descriptionsIterator).getText()) {
                case "ID Переговоров": {
                    chatId = valueList.get(descriptionsIterator).getText();
                    break;
                }
                case "Культура": {
                    chatCulture = valueList.get(descriptionsIterator).getText();
                    break;
                }
                case "Дата создания Переговоров": {
                    chatDate = valueList.get(descriptionsIterator).getText().replaceAll("[^0-9,\\.]+", "");
                    break;
                }
                case "Удаленность": {
                    chatRadius = valueList.get(descriptionsIterator).getText();
                    break;
                }
                case "Доставка": {
                    logisticType = valueList.get(descriptionsIterator).getText();
                    break;
                }
                case "Условия оплаты": {
                    chatSellPriseCondition = valueList.get(descriptionsIterator).getText();
                    break;
                }
                default: {
                    mainProperty = valueList.get(descriptionsIterator).getText().replaceAll("[^0-9,\\.]+", "");
                    break;
                }
            }
    }

    public WebElement getStatusButton() {
        return statusButton;
    }

    @Override
    public String toString() {
        return "ChatHeader{" +
                "chatSellPriseCondition='" + chatSellPriseCondition + '\'' +
                ", logisticType='" + logisticType + '\'' +
                ", chatStatus='" + chatStatus + '\'' +
                ", chatId='" + chatId + '\'' +
                ", chatCulture='" + chatCulture + '\'' +
                ", mainProperty='" + mainProperty + '\'' +
                ", chatDate='" + chatDate + '\'' +
                ", chatRadius='" + chatRadius + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChatHeader)) return false;
        ChatHeader that = (ChatHeader) o;
        return Objects.equals(chatSellPriseCondition, that.chatSellPriseCondition) &&
                Objects.equals(logisticType, that.logisticType) &&
                Objects.equals(chatStatus, that.chatStatus) &&
                Objects.equals(getChatId(), that.getChatId()) &&
                Objects.equals(getChatCulture(), that.getChatCulture()) &&
                Objects.equals(getMainProperty(), that.getMainProperty()) &&
                Objects.equals(getChatDate(), that.getChatDate()) &&
                Objects.equals(getChatRadius(), that.getChatRadius()) &&
                Objects.equals(getStatus(), that.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(chatSellPriseCondition, logisticType, chatStatus, getChatId(), getChatCulture(), getMainProperty(), getChatDate(), getChatRadius(), getStatus());
    }
}
