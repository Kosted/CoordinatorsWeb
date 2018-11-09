package helperClasses.chat;

import helperClasses.WebActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

public class ChatBuyInfo {


    private String chatSellAnswerDate;
    private String chatBuyNeedAnswer;
    private String chatBuyId;
    private String buying;

    private String chatBuyVolume;


    private String chatBuyPrice;
    // private String chatBuyPriceWithlogistics;
    private String chatBuyDate;


    public String getBuying() {
        return buying;
    }

    public ChatBuyInfo(WebElement chatBuyInfo, WebActions web_a) {


        List<WebElement> descriptionList = chatBuyInfo.findElements(By.className("_624ef2"));
        List<WebElement> valueList = chatBuyInfo.findElements(By.className("_97058b"));


        for (int descriptionsIterator = 0; descriptionsIterator < descriptionList.size(); descriptionsIterator++)
            switch (descriptionList.get(descriptionsIterator).getText()) {
                case "Объем": {
                    chatBuyVolume = valueList.get(descriptionsIterator).getText().replaceAll("[^0-9,\\.]+", "");
                    break;
                }
                case "Цена": {
                    chatBuyPrice = valueList.get(descriptionsIterator).getText().replaceAll("[^0-9,\\.]+", "");
                    break;
                }
                case "Дата публикации": {
                    chatBuyDate = valueList.get(descriptionsIterator).getText();
                    break;
                }
                case "Дата ответа": {
                    chatSellAnswerDate = valueList.get(descriptionsIterator).getText().replaceAll("[^0-9,\\.]+", "");
                    break;
                }

            }

        String temp = chatBuyInfo.findElement(By.className("_8563dc")).getText();

//вычленение слова "Закупка"
        int headerSize = temp.length();
        int i = 0;
        buying = "";
        while (headerSize > i && temp.charAt(i) != ' ') {
            buying += temp.charAt(i);
            i++;
        }
        //вычленение id
        chatBuyId = temp.substring(i).replaceAll("[^0-9,\\.]+", "");


        List<WebElement> chatBuyNeedAnswerElem = chatBuyInfo.findElements(By.className("d0a095"));
        if (chatBuyNeedAnswerElem.size()==1)
            chatBuyNeedAnswer= chatBuyNeedAnswerElem.get(0).getText();
    }

    public String getChatBuyId() {
        return chatBuyId;
    }

    public String getChatBuyVolume() {
        return chatBuyVolume;
    }

    public String getChatBuyPrice() {
        return chatBuyPrice;
    }

    public String getChatBuyDate() {
        return chatBuyDate;
    }

    public String getChatSellAnswerDate() {
        return chatSellAnswerDate;
    }

    public String getChatBuyNeedAnswer() {
        return chatBuyNeedAnswer;
    }

    @Override
    public String toString() {
        return "ChatBuyInfo{" +
                "chatSellAnswerDate='" + chatSellAnswerDate + '\'' +
                ", chatBuyNeedAnswer='" + chatBuyNeedAnswer + '\'' +
                ", chatBuyId='" + chatBuyId + '\'' +
                ", buying='" + buying + '\'' +
                ", chatBuyVolume='" + chatBuyVolume + '\'' +
                ", chatBuyPrice='" + chatBuyPrice + '\'' +
                ", chatBuyDate='" + chatBuyDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChatBuyInfo)) return false;
        ChatBuyInfo that = (ChatBuyInfo) o;
        return Objects.equals(getChatSellAnswerDate(), that.getChatSellAnswerDate()) &&
                Objects.equals(getChatBuyNeedAnswer(), that.getChatBuyNeedAnswer()) &&
                Objects.equals(getChatBuyId(), that.getChatBuyId()) &&
                Objects.equals(getBuying(), that.getBuying()) &&
                Objects.equals(getChatBuyVolume(), that.getChatBuyVolume()) &&
                Objects.equals(getChatBuyPrice(), that.getChatBuyPrice()) &&
                Objects.equals(getChatBuyDate(), that.getChatBuyDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getChatSellAnswerDate(), getChatBuyNeedAnswer(), getChatBuyId(), getBuying(), getChatBuyVolume(), getChatBuyPrice(), getChatBuyDate());
    }
}
