package helperClasses.chat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ChatFullSellInfo {

    private WebElement chatSellComment;

    public WebElement getChatSellComment() {
        return chatSellComment;
    }

    private String chatSellId;
    private String selling;
    private String chatSellVolume;

    private String chatSellPrice;

    private String chatSellPriceWithLogistic;
    private String[] chatSellPropertes;
    private String chatSellAddres;
    private String chatSellLogisticIsPossible;
    private String chatSellLogisticPrice;
    private String chatSellLogisticRadius;
    private String chatSellPriseCondition;
    private String chatSellDate;
    private String chatSellUser;
    private String chatSellPhoneNumber;

    private String chatSellCompany;
    private String chatSellInn;
    private String chatSellNds;


    @Override
    public String toString() {
        return "ChatFullSellInfo{" +
                "chatSellId='" + chatSellId + '\'' +
                ", selling='" + selling + '\'' +
                ", chatSellVolume='" + chatSellVolume + '\'' +
                ", chatSellPrice='" + chatSellPrice + '\'' +
                ", chatSellPriceWithLogistic='" + chatSellPriceWithLogistic + '\'' +
                ", chatSellPropertes=" + Arrays.toString(chatSellPropertes) +
                ", chatSellAddres='" + chatSellAddres + '\'' +
                ", chatSellLogisticIsPossible='" + chatSellLogisticIsPossible + '\'' +
                ", chatSellLogisticPrice='" + chatSellLogisticPrice + '\'' +
                ", chatSellLogisticRadius='" + chatSellLogisticRadius + '\'' +
                ", chatSellPriseCondition='" + chatSellPriseCondition + '\'' +
                ", chatSellDate='" + chatSellDate + '\'' +
                ", chatSellUser='" + chatSellUser + '\'' +
                ", chatSellPhoneNumber='" + chatSellPhoneNumber + '\'' +
                ", chatSellCompany='" + chatSellCompany + '\'' +
                ", chatSellInn='" + chatSellInn + '\'' +
                ", chatSellNds='" + chatSellNds + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChatFullSellInfo)) return false;
        ChatFullSellInfo that = (ChatFullSellInfo) o;
        return Objects.equals(getChatSellId(), that.getChatSellId()) &&
                Objects.equals(getSelling(), that.getSelling()) &&
                Objects.equals(getChatSellVolume(), that.getChatSellVolume()) &&
                Objects.equals(getChatSellPrice(), that.getChatSellPrice()) &&
                Objects.equals(getChatSellPriceWithLogistic(), that.getChatSellPriceWithLogistic()) &&
                Arrays.equals(getChatSellPropertes(), that.getChatSellPropertes()) &&
                Objects.equals(getChatSellAddres(), that.getChatSellAddres()) &&
                Objects.equals(getChatSellLogisticIsPossible(), that.getChatSellLogisticIsPossible()) &&
                Objects.equals(getChatSellLogisticPrice(), that.getChatSellLogisticPrice()) &&
                Objects.equals(getChatSellLogisticRadius(), that.getChatSellLogisticRadius()) &&
                Objects.equals(getChatSellPriseCondition(), that.getChatSellPriseCondition()) &&
                Objects.equals(getChatSellDate(), that.getChatSellDate()) &&
                Objects.equals(getChatSellUser(), that.getChatSellUser()) &&
                Objects.equals(getChatSellPhoneNumber(), that.getChatSellPhoneNumber()) &&
                Objects.equals(getChatSellCompany(), that.getChatSellCompany()) &&
                Objects.equals(getChatSellInn(), that.getChatSellInn()) &&
                Objects.equals(getChatSellNds(), that.getChatSellNds());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getChatSellId(), getSelling(), getChatSellVolume(), getChatSellPrice(), getChatSellPriceWithLogistic(), getChatSellAddres(), getChatSellLogisticIsPossible(), getChatSellLogisticPrice(), getChatSellLogisticRadius(), getChatSellPriseCondition(), getChatSellDate(), getChatSellUser(), getChatSellPhoneNumber(), getChatSellCompany(), getChatSellInn(), getChatSellNds());
        result = 31 * result + Arrays.hashCode(getChatSellPropertes());
        return result;
    }

    public String getSelling() {
        return selling;
    }

    public ChatFullSellInfo(WebElement chatSellInfo) {

        // получение  id

        //chatSellId = chatSellInfo.findElement(By.className("_8563dc")).getText().replaceAll("[^0-9]+", "");
//вычленение слова "Продажа"
        String temp=chatSellInfo.findElement(By.className("_8563dc")).getText();
        int headerSize = temp.length();
        int i = 0;
        selling = "";
        while (headerSize > i && temp.charAt(i) != ' ') {
            selling += temp.charAt(i);
            i++;
        }
        //вычленение id
        chatSellId = temp.substring(i).replaceAll("[^0-9,\\.]+", "");
        List<WebElement> valueList = chatSellInfo.findElements(By.className("_97058b"));
        List<WebElement> descriptionList = chatSellInfo.findElements(By.className("_624ef2"));
////////////////////////////

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
                case "Цена с логистикой + комиссия": {
                    chatSellPriceWithLogistic = valueList.get(descriptionsIterator).getText().replaceAll("[^0-9,\\.]+", "");
                    break;
                }
                case "Параметры культуры": {
                    List<WebElement> propertesList = valueList.get(descriptionsIterator).findElements(By.tagName("p"));
                    chatSellPropertes = new String[propertesList.size()];
                    for (i = 0; i < propertesList.size(); i++)
                        chatSellPropertes[i] = propertesList.get(i).getText();
                    break;
                }
                case "Адрес": {
                    chatSellAddres = valueList.get(descriptionsIterator).getText();
                    break;
                }
                case "Доставка": {
                    chatSellLogisticIsPossible = valueList.get(descriptionsIterator).getText();
                    break;
                }
                case "Стоимость логистики": {
                    chatSellLogisticPrice = valueList.get(descriptionsIterator).getText().replaceAll("[^0-9,\\.]+", "");
                    break;
                }
                case "Радиус логистики": {
                    chatSellLogisticRadius = valueList.get(descriptionsIterator).getText().replaceAll("[^0-9,\\.]+", "");
                    break;
                }
                case "Условия оплаты": {
                    chatSellPriseCondition = valueList.get(descriptionsIterator).getText();
                    break;
                }
                case "Дата публикации": {
                    chatSellDate = valueList.get(descriptionsIterator).getText();
                    break;
                }
                case "Пользователь": {
                    // вычленение фио юзера
                    temp = valueList.get(descriptionsIterator).getText();
                    i = 0;
                    chatSellUser = "";
                    while (temp.charAt(i) != ',') {
                        chatSellUser += temp.charAt(i++);
                    }

                    // мобильный телефон
                    chatSellPhoneNumber = temp.substring(++i);
                    break;
                }
                case "Компания": {
                    temp = valueList.get(descriptionsIterator).getText();
                    i = 0;
                    chatSellCompany = "";
                    while (temp.charAt(i) != ',') {
                        chatSellCompany += temp.charAt(i++);
                    }
                    i++;

                    // вычленение ИНН
                    chatSellInn = "";
                    while (temp.charAt(i) != ',') {
                        chatSellInn += temp.charAt(i++);
                    }
                    chatSellInn = chatSellInn.replaceAll("[^0-9,\\.]+", "");

                    // НДС
                    chatSellNds = temp.substring(++i);
                    break;
                }
            }
        List<WebElement> elements = chatSellInfo.findElements(By.name("comment"));
        if (elements.size() == 1)
            chatSellComment = elements.get(0);

    }

    public String getChatSellId() {
        return chatSellId;
    }

    public String getChatSellVolume() {
        return chatSellVolume;
    }

    public String getChatSellPrice() {
        return chatSellPrice;
    }

    public String getChatSellPriceWithLogistic() {
        return chatSellPriceWithLogistic;
    }

    public String[] getChatSellPropertes() {
        return chatSellPropertes;
    }

    public String getChatSellAddres() {
        return chatSellAddres;
    }

    public String getChatSellLogisticIsPossible() {
        return chatSellLogisticIsPossible;
    }

    public String getChatSellLogisticPrice() {
        return chatSellLogisticPrice;
    }

    public String getChatSellLogisticRadius() {
        return chatSellLogisticRadius;
    }

    public String getChatSellPriseCondition() {
        return chatSellPriseCondition;
    }

    public String getChatSellDate() {
        return chatSellDate;
    }

    public String getChatSellUser() {
        return chatSellUser;
    }

    public String getChatSellPhoneNumber() {
        return chatSellPhoneNumber;
    }

    public String getChatSellCompany() {
        return chatSellCompany;
    }

    public String getChatSellInn() {
        return chatSellInn;
    }

    public String getChatSellNds() {
        return chatSellNds;
    }
}