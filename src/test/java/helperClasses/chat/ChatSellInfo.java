package helperClasses.chat;

import helperClasses.WebActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

public class ChatSellInfo {

    private String chatSellID;
    private String selling;

    private String chatSellVolume;
    private String chatSellPrice;
    private String chatSellAnswerDate;
    private String chatSellDate;
    private String chatSellNeedAnswer;

//    private String chatSellIDClassName;
//    private String chatSellListPartsClassName;
//
//    private  List<WebElement> chatSellPartsList;


    public String getChatSellID() {
        return chatSellID;
    }

    public String getChatSellVolume() {
        return chatSellVolume;
    }

    public String getChatSellPrice() {
        return chatSellPrice;
    }

    public String getChatSellAnswerDate() {
        return chatSellAnswerDate;
    }

    public String getChatSellDate() {
        return chatSellDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getChatSellID(), getSelling(), getChatSellVolume(), getChatSellPrice(), getChatSellAnswerDate(), getChatSellDate());
    }

    public String getSelling() {
        return selling;
    }

    @Override
    public String toString() {
        return "ChatSellInfo{" +
                "chatSellID='" + chatSellID + '\'' +
                ", selling='" + selling + '\'' +
                ", chatSellVolume='" + chatSellVolume + '\'' +
                ", chatSellPrice='" + chatSellPrice + '\'' +
                ", chatSellAnswerDate='" + chatSellAnswerDate + '\'' +
                ", chatSellDate='" + chatSellDate + '\'' +
                '}';
    }
//    public ChatSellInfo(WebElement chatSellInfo) {
//
//        chatSellIDClassName = "_8563dc";
//
//        chatSellListPartsClassName = "_97058b";
//
//        chatSellID = chatSellInfo.findElement(By.className(chatSellIDClassName)).getText().replaceAll("[^0-9,\\.]+", " ");
//
//        chatSellPartsList = chatSellInfo.findElements(By.className(chatSellListPartsClassName));
//
//        chatSellVolume = parseDouble(chatSellPartsList.get(0).getText().replaceAll("[^0-9,\\.]+", ""));
//        chatSellPrice = parseDouble(chatSellPartsList.get(1).getText().replaceAll("[^0-9,\\.]+", ""));
//        chatSellAnswerDate = parseDouble(chatSellPartsList.get(2).getText().replaceAll("[^0-9,\\.]+", ""));
//        chatSellDate = chatSellPartsList.get(3).getText();
//        chatSellCompany = chatSellPartsList.get(4).getText();
//    }

    public ChatSellInfo(WebElement chatSellInfo, WebActions web_a) {


        List<WebElement> descriptionList = chatSellInfo.findElements(By.className("_624ef2"));
        List<WebElement> valueList = chatSellInfo.findElements(By.className("_97058b"));


        for (int descriptionsIterator = 0; descriptionsIterator < descriptionList.size(); descriptionsIterator++)
            switch (descriptionList.get(descriptionsIterator).getText()) {
                case "Объем": {
                    chatSellVolume = valueList.get(descriptionsIterator).getText().replaceAll("[^0-9,\\.]+", "");
                    break;
                }
                case "Цена": {
                    chatSellPrice = valueList.get(descriptionsIterator).getText().replaceAll("[^0-9,\\.]+", "");
                    break;
                }
                case "Дата ответа": {
                    chatSellAnswerDate = valueList.get(descriptionsIterator).getText().replaceAll("[^0-9,\\.]+", "");
                    break;
                }
                case "Дата публикации": {
                    chatSellDate= valueList.get(descriptionsIterator).getText();
                    break;
                }

            }

       // chatSellID = chatSellInfo.findElement(By.className("_8563dc")).getText().replaceAll("[^0-9]+", "");
        String temp = chatSellInfo.findElement(By.className("_8563dc")).getText();

//вычленение слова "Продажа"
        int headerSize = temp.length();
        int i = 0;
        selling = "";
        while (headerSize > i && temp.charAt(i) != ' ') {
            selling += temp.charAt(i);
            i++;
        }
        //вычленение id
        chatSellID = temp.substring(i).replaceAll("[^0-9,\\.]+", "");

        WebElement element = web_a.isPresent(chatSellInfo, By.className("d0a095"), 1);
        if (element!=null)

        chatSellNeedAnswer= element.getText();
    }

    public String getChatSellNeedAnswer() {
        return chatSellNeedAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChatSellInfo)) return false;
        ChatSellInfo that = (ChatSellInfo) o;
        return Objects.equals(getChatSellID(), that.getChatSellID()) &&
                Objects.equals(getChatSellVolume(), that.getChatSellVolume()) &&
                Objects.equals(getChatSellPrice(), that.getChatSellPrice()) &&
                Objects.equals(getChatSellAnswerDate(), that.getChatSellAnswerDate()) &&
                Objects.equals(getChatSellDate(), that.getChatSellDate());
    }

}
