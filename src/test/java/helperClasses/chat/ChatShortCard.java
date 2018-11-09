package helperClasses.chat;

import helperClasses.WebActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

public class ChatShortCard {


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChatShortCard)) return false;
        ChatShortCard chatShortCard = (ChatShortCard) o;
        return Objects.equals(getChatHeader(), chatShortCard.getChatHeader()) &&
                Objects.equals(getChatBuyInfo(), chatShortCard.getChatBuyInfo()) &&
                Objects.equals(getChatSellInfo(), chatShortCard.getChatSellInfo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getChatHeader(), getChatBuyInfo(), getChatSellInfo());
    }

    public ChatHeader getChatHeader() {
        return chatHeader;
    }

    public ChatBuyInfo getChatBuyInfo() {
        return chatBuyInfo;
    }

    public ChatSellInfo getChatSellInfo() {
        return chatSellInfo;
    }


    public ChatShortCard(WebElement chatCard, WebActions web_a) {
        //this.web_a = web_a;
        chatHeader = new ChatHeader(chatCard.findElement(By.tagName("header")));

        String buyAndSellClassName = "b1a733";

        List<WebElement> buyAndSellParts = chatCard.findElements(By.className(buyAndSellClassName));


        chatBuyInfo = new ChatBuyInfo(buyAndSellParts.get(0),web_a);
        chatSellInfo = new ChatSellInfo(buyAndSellParts.get(1),web_a);


    }


    private ChatHeader chatHeader;
    //private WebActions web_a;

    public String getSelling() {
        return getChatSellInfo().getSelling();
    }

    public String getBuying() {
        return getChatBuyInfo().getBuying();
    }

    private ChatBuyInfo chatBuyInfo;
    private ChatSellInfo chatSellInfo;

    @Override
    public String toString() {
        return "ChatShortCard{" +
                chatHeader.toString() +
                chatBuyInfo.toString() +
                chatSellInfo.toString() +
                '}';
    }

    public WebElement getStatusButton() {
        return chatHeader.getStatusButton();
    }

    public String getChatSellID() {
        return chatSellInfo.getChatSellID();
    }

    public String getChatSellVolume() {
        return chatSellInfo.getChatSellVolume();
    }

    public String getChatSellPrice() {
        return chatSellInfo.getChatSellPrice();
    }

    public String getChatSellPriceWithlogistics() {
        return chatSellInfo.getChatSellAnswerDate();
    }

    public String getChatSellDate() {
        return chatSellInfo.getChatSellDate();
    }

    public String getChatBuyId() {
        return chatBuyInfo.getChatBuyId();
    }

    public String getChatBuyVolume() {
        return chatBuyInfo.getChatBuyVolume();
    }

    public String getChatBuyPrice() {
        return chatBuyInfo.getChatBuyPrice();
    }

    public String getChatBuyDate() {
        return chatBuyInfo.getChatBuyDate();
    }

    public String getChatId() {
        return chatHeader.getChatId();
    }

    public String getChatSellAnswerDate() {
        return getChatBuyInfo().getChatSellAnswerDate();
    }

    public String getChatBuyNeedAnswer() {
        return getChatBuyInfo().getChatBuyNeedAnswer();
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

}
