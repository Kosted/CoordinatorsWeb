package helperClasses.chat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ChatFullBuyInfo {

    private WebElement chatBuyComment;

    public WebElement getChatBuyComment() {
        return chatBuyComment;
    }

    private String chatBuyId;
    private String buying;
    private String chatBuyVolume;

    private String chatBuyPrice;


    private String[] chatBuyPropertes;
    private String chatBuyAddres;
    private String chatBuyLogisticIsPossible;
    private String chatBuyLogisticPrice;
    private String chatBuyLogisticRadius;
    private String chatBuyPriseCondition;
    private String chatBuyDate;
    private String chatBuyUser;
    private String chatBuyPhoneNumber;

    private String chatBuyCompany;
    private String chatBuyInn;
    private String chatBuyNds;


    @Override
    public String toString() {
        return "ChatFullBuyInfo{" +
                "chatBuyId='" + chatBuyId + '\'' +
                ", buying='" + buying + '\'' +
                ", chatBuyVolume='" + chatBuyVolume + '\'' +
                ", chatBuyPrice='" + chatBuyPrice + '\'' +
                ", chatBuyPropertes=" + Arrays.toString(chatBuyPropertes) +
                ", chatBuyAddres='" + chatBuyAddres + '\'' +
                ", chatBuyLogisticIsPossible='" + chatBuyLogisticIsPossible + '\'' +
                ", chatBuyLogisticPrice='" + chatBuyLogisticPrice + '\'' +
                ", chatBuyLogisticRadius='" + chatBuyLogisticRadius + '\'' +
                ", chatBuyPriseCondition='" + chatBuyPriseCondition + '\'' +
                ", chatBuyDate='" + chatBuyDate + '\'' +
                ", chatBuyUser='" + chatBuyUser + '\'' +
                ", chatBuyPhoneNumber='" + chatBuyPhoneNumber + '\'' +
                ", chatBuyCompany='" + chatBuyCompany + '\'' +
                ", chatBuyInn='" + chatBuyInn + '\'' +
                ", chatBuyNds='" + chatBuyNds + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChatFullBuyInfo)) return false;
        ChatFullBuyInfo that = (ChatFullBuyInfo) o;
        return Objects.equals(getChatBuyId(), that.getChatBuyId()) &&
                Objects.equals(getBuying(), that.getBuying()) &&
                Objects.equals(getChatBuyVolume(), that.getChatBuyVolume()) &&
                Objects.equals(getChatBuyPrice(), that.getChatBuyPrice()) &&
                Arrays.equals(getChatBuyPropertes(), that.getChatBuyPropertes()) &&
                Objects.equals(getChatBuyAddres(), that.getChatBuyAddres()) &&
                Objects.equals(getChatBuyLogisticIsPossible(), that.getChatBuyLogisticIsPossible()) &&
                Objects.equals(getChatBuyLogisticPrice(), that.getChatBuyLogisticPrice()) &&
                Objects.equals(getChatBuyLogisticRadius(), that.getChatBuyLogisticRadius()) &&
                Objects.equals(getChatBuyPriseCondition(), that.getChatBuyPriseCondition()) &&
                Objects.equals(getChatBuyDate(), that.getChatBuyDate()) &&
                Objects.equals(getChatBuyUser(), that.getChatBuyUser()) &&
                Objects.equals(getChatBuyPhoneNumber(), that.getChatBuyPhoneNumber()) &&
                Objects.equals(getChatBuyCompany(), that.getChatBuyCompany()) &&
                Objects.equals(getChatBuyInn(), that.getChatBuyInn()) &&
                Objects.equals(getChatBuyNds(), that.getChatBuyNds());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getChatBuyId(), getBuying(), getChatBuyVolume(), getChatBuyPrice(), getChatBuyAddres(), getChatBuyLogisticIsPossible(), getChatBuyLogisticPrice(), getChatBuyLogisticRadius(), getChatBuyPriseCondition(), getChatBuyDate(), getChatBuyUser(), getChatBuyPhoneNumber(), getChatBuyCompany(), getChatBuyInn(), getChatBuyNds());
        result = 31 * result + Arrays.hashCode(getChatBuyPropertes());
        return result;
    }

    public String getBuying() {
        return buying;
    }

    public ChatFullBuyInfo(WebElement chatBuyInfo) {

        // получение  id

        //chatBuyId = chatBuyInfo.findElement(By.className("_8563dc")).getText().replaceAll("[^0-9]+", "");

        String temp = chatBuyInfo.findElement(By.className("_8563dc")).getText();

//вычленение слова "Закупка"
        int tempSize = temp.length();
        int i = 0;
        buying = "";
        while (tempSize > i && temp.charAt(i) != ' ') {
            buying += temp.charAt(i);
            i++;
        }
        //вычленение id
        chatBuyId = temp.substring(i).replaceAll("[^0-9,\\.]+", "");


        List<WebElement> valueList = chatBuyInfo.findElements(By.className("_97058b"));
        List<WebElement> descriptionList = chatBuyInfo.findElements(By.className("_624ef2"));
////////////////////////////

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
                case "Параметры культуры": {
                    List<WebElement> propertesList = valueList.get(descriptionsIterator).findElements(By.tagName("p"));
                    chatBuyPropertes = new String[propertesList.size()];
                    for (i = 0; i < propertesList.size(); i++)
                        chatBuyPropertes[i] = propertesList.get(i).getText();
                    break;
                }
                case "Адрес": {
                    chatBuyAddres = valueList.get(descriptionsIterator).getText();
                    break;
                }
                case "Доставка": {
                    chatBuyLogisticIsPossible = valueList.get(descriptionsIterator).getText();
                    break;
                }
                case "Стоимость логистики": {
                    chatBuyLogisticPrice = valueList.get(descriptionsIterator).getText().replaceAll("[^0-9,\\.]+", "");
                    break;
                }
                case "Радиус логистики": {
                    chatBuyLogisticRadius = valueList.get(descriptionsIterator).getText().replaceAll("[^0-9,\\.]+", "");
                    break;
                }
                case "Условия оплаты": {
                    chatBuyPriseCondition = valueList.get(descriptionsIterator).getText();
                    break;
                }
                case "Дата публикации": {
                    chatBuyDate = valueList.get(descriptionsIterator).getText();
                    break;
                }
                case "Пользователь": {
                    // вычленение фио юзера
                    temp = valueList.get(descriptionsIterator).getText();
                    i = 0;
                    chatBuyUser = "";
                    while (temp.charAt(i) != ',') {
                        chatBuyUser += temp.charAt(i++);
                    }

                    // мобильный телефон
                    chatBuyPhoneNumber = temp.substring(++i);
                    break;
                }
                case "Компания": {
                    temp = valueList.get(descriptionsIterator).getText();
                    i = 0;
                    chatBuyCompany = "";
                    while (temp.charAt(i) != ',') {
                        chatBuyCompany += temp.charAt(i++);
                    }
                    i++;

                    // вычленение ИНН
                    chatBuyInn = "";
                    while (temp.charAt(i) != ',') {
                        chatBuyInn += temp.charAt(i++);
                    }
                    chatBuyInn = chatBuyInn.replaceAll("[^0-9,\\.]+", "");

                    // НДС
                    chatBuyNds = temp.substring(++i);
                    break;
                }
            }

        List<WebElement> elements = chatBuyInfo.findElements(By.name("comment"));
        if (elements.size() == 1)
            chatBuyComment = elements.get(0);
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

    public String[] getChatBuyPropertes() {
        return chatBuyPropertes;
    }

    public String getChatBuyAddres() {
        return chatBuyAddres;
    }

    public String getChatBuyLogisticIsPossible() {
        return chatBuyLogisticIsPossible;
    }

    public String getChatBuyLogisticPrice() {
        return chatBuyLogisticPrice;
    }

    public String getChatBuyLogisticRadius() {
        return chatBuyLogisticRadius;
    }

    public String getChatBuyPriseCondition() {
        return chatBuyPriseCondition;
    }

    public String getChatBuyDate() {
        return chatBuyDate;
    }

    public String getChatBuyUser() {
        return chatBuyUser;
    }

    public String getChatBuyPhoneNumber() {
        return chatBuyPhoneNumber;
    }

    public String getChatBuyCompany() {
        return chatBuyCompany;
    }

    public String getChatBuyInn() {
        return chatBuyInn;
    }

    public String getChatBuyNds() {
        return chatBuyNds;
    }

}