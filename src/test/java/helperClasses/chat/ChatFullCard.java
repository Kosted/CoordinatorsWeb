package helperClasses.chat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

public class ChatFullCard {


    private ChatHeader chatHeader;
    private ChatFullBuyInfo chatFullBuyInfo;
    private ChatFullSellInfo chatFullSellInfo;
    private WebElement chatCommentField;

    public WebElement getChatCommentField() {
        return chatCommentField;
    }
//    private int contentSize;

    public ChatFullCard(WebElement chatCard) {

        chatHeader = new ChatHeader(chatCard.findElement(By.tagName("header")));

        String buyAndSellClassName = "b1a733";

        List<WebElement> buyAndSellParts = chatCard.findElements(By.className(buyAndSellClassName));


        chatFullBuyInfo = new ChatFullBuyInfo(buyAndSellParts.get(0));
        chatFullSellInfo = new ChatFullSellInfo(buyAndSellParts.get(1));


        List<WebElement> elements = chatCard.findElements(By.name("comment"));
        if (elements.size() == 3)
            chatCommentField = elements.get(2);

    }

    @Override
    public String toString() {
        return "ChatFullCard{" +
                "chatHeader=" + chatHeader +
                ", chatFullBuyInfo=" + chatFullBuyInfo +
                ", chatFullSellInfo=" + chatFullSellInfo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChatFullCard)) return false;
        ChatFullCard that = (ChatFullCard) o;
        return Objects.equals(chatHeader, that.chatHeader) &&
                Objects.equals(chatFullBuyInfo, that.chatFullBuyInfo) &&
                Objects.equals(chatFullSellInfo, that.chatFullSellInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chatHeader, chatFullBuyInfo, chatFullSellInfo);
    }
//    public int getContentSize() {
//        return contentSize;
//    }


    public WebElement getChatSellComment() {
        return chatFullSellInfo.getChatSellComment();
    }

    public WebElement getChatBuyComment() {
        return chatFullBuyInfo.getChatBuyComment();
    }

    public ChatHeader getChatHeader() {
        return chatHeader;
    }

    public ChatFullBuyInfo getChatFullBuyInfo() {
        return chatFullBuyInfo;
    }

    public ChatFullSellInfo getChatFullSellInfo() {
        return chatFullSellInfo;
    }

    public String getSelling() {
        return chatFullSellInfo.getSelling();
    }

    public String getBuying() {
        return chatFullBuyInfo.getBuying();
    }

    public String getChatSellId() {
        return chatFullSellInfo.getChatSellId();
    }

    public String getChatSellVolume() {
        return chatFullSellInfo.getChatSellVolume();
    }

    public String getChatSellPrice() {
        return chatFullSellInfo.getChatSellPrice();
    }

    public String getChatSellPriceWithLogistic() {
        return chatFullSellInfo.getChatSellPriceWithLogistic();
    }

    public String[] getChatSellPropertes() {
        return chatFullSellInfo.getChatSellPropertes();
    }

    public String getChatSellAddres() {
        return chatFullSellInfo.getChatSellAddres();
    }

    public String getChatSellLogisticIsPossible() {
        return chatFullSellInfo.getChatSellLogisticIsPossible();
    }

    public String getChatSellLogisticPrice() {
        return chatFullSellInfo.getChatSellLogisticPrice();
    }

    public String getChatSellLogisticRadius() {
        return chatFullSellInfo.getChatSellLogisticRadius();
    }

    public String getChatSellPriseCondition() {
        return chatFullSellInfo.getChatSellPriseCondition();
    }

    public String getChatSellDate() {
        return chatFullSellInfo.getChatSellDate();
    }

    public String getChatSellUser() {
        return chatFullSellInfo.getChatSellUser();
    }

    public String getChatSellPhoneNumber() {
        return chatFullSellInfo.getChatSellPhoneNumber();
    }

    public String getChatSellCompany() {
        return chatFullSellInfo.getChatSellCompany();
    }

    public String getChatSellInn() {
        return chatFullSellInfo.getChatSellInn();
    }

    public String getChatSellNds() {
        return chatFullSellInfo.getChatSellNds();
    }

    public String getChatBuyId() {
        return chatFullBuyInfo.getChatBuyId();
    }

    public String getChatBuyVolume() {
        return chatFullBuyInfo.getChatBuyVolume();
    }

    public String getChatBuyPrice() {
        return chatFullBuyInfo.getChatBuyPrice();
    }

    public String[] getChatBuyPropertes() {
        return chatFullBuyInfo.getChatBuyPropertes();
    }

    public String getChatBuyAddres() {
        return chatFullBuyInfo.getChatBuyAddres();
    }

    public String getChatBuyLogisticIsPossible() {
        return chatFullBuyInfo.getChatBuyLogisticIsPossible();
    }

    public String getChatBuyLogisticPrice() {
        return chatFullBuyInfo.getChatBuyLogisticPrice();
    }

    public String getChatBuyLogisticRadius() {
        return chatFullBuyInfo.getChatBuyLogisticRadius();
    }

    public String getChatBuyPriseCondition() {
        return chatFullBuyInfo.getChatBuyPriseCondition();
    }

    public String getChatBuyDate() {
        return chatFullBuyInfo.getChatBuyDate();
    }

    public String getChatBuyUser() {
        return chatFullBuyInfo.getChatBuyUser();
    }

    public String getChatBuyPhoneNumber() {
        return chatFullBuyInfo.getChatBuyPhoneNumber();
    }

    public String getChatBuyCompany() {
        return chatFullBuyInfo.getChatBuyCompany();
    }

    public String getChatBuyInn() {
        return chatFullBuyInfo.getChatBuyInn();
    }

    public String getChatBuyNds() {
        return chatFullBuyInfo.getChatBuyNds();
    }

    public String getMetchId() {
        return chatHeader.getChatId();
    }

    public String getChatCulture() {
        return chatHeader.getChatCulture();
    }

    public String getMainProperty() {
        return chatHeader.getMainProperty();
    }

    public String getChatDate() {
        return chatHeader.getChatDate();
    }

    public String getChatRadius() {
        return chatHeader.getChatRadius();
    }

    public String getStatus() {
        return chatHeader.getStatus();
    }

    public WebElement getStatusButton() {
        return chatHeader.getStatusButton();
    }
}
