package helperClasses.match;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MatchFullSellInfo {

    private WebElement matchSellComment;

    public WebElement getMatchSellComment() {
        return matchSellComment;
    }

    private String matchSellId;
    private String selling;
    private String matchSellVolume;

    private String matchSellPrice;

    private String matchSellPriceWithLogistic;
    private String[] matchSellPropertes;
    private String matchSellAddres;
    private String matchSellLogisticIsPossible;
    private String matchSellLogisticPrice;
    private String matchSellLogisticRadius;
    private String matchSellPriseCondition;
    private String matchSellDate;
    private String matchSellUser;
    private String matchSellPhoneNumber;

    private String matchSellCompany;
    private String matchSellInn;
    private String matchSellNds;


    @Override
    public String toString() {
        return "MatchFullSellInfo{" +
                "matchSellId='" + matchSellId + '\'' +
                ", selling='" + selling + '\'' +
                ", matchSellVolume='" + matchSellVolume + '\'' +
                ", matchSellPrice='" + matchSellPrice + '\'' +
                ", matchSellPriceWithLogistic='" + matchSellPriceWithLogistic + '\'' +
                ", matchSellPropertes=" + Arrays.toString(matchSellPropertes) +
                ", matchSellAddres='" + matchSellAddres + '\'' +
                ", matchSellLogisticIsPossible='" + matchSellLogisticIsPossible + '\'' +
                ", matchSellLogisticPrice='" + matchSellLogisticPrice + '\'' +
                ", matchSellLogisticRadius='" + matchSellLogisticRadius + '\'' +
                ", matchSellPriseCondition='" + matchSellPriseCondition + '\'' +
                ", matchSellDate='" + matchSellDate + '\'' +
                ", matchSellUser='" + matchSellUser + '\'' +
                ", matchSellPhoneNumber='" + matchSellPhoneNumber + '\'' +
                ", matchSellCompany='" + matchSellCompany + '\'' +
                ", matchSellInn='" + matchSellInn + '\'' +
                ", matchSellNds='" + matchSellNds + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MatchFullSellInfo)) return false;
        MatchFullSellInfo that = (MatchFullSellInfo) o;
        return Objects.equals(getMatchSellId(), that.getMatchSellId()) &&
                Objects.equals(getSelling(), that.getSelling()) &&
                Objects.equals(getMatchSellVolume(), that.getMatchSellVolume()) &&
                Objects.equals(getMatchSellPrice(), that.getMatchSellPrice()) &&
                Objects.equals(getMatchSellPriceWithLogistic(), that.getMatchSellPriceWithLogistic()) &&
                Arrays.equals(getMatchSellPropertes(), that.getMatchSellPropertes()) &&
                Objects.equals(getMatchSellAddres(), that.getMatchSellAddres()) &&
                Objects.equals(getMatchSellLogisticIsPossible(), that.getMatchSellLogisticIsPossible()) &&
                Objects.equals(getMatchSellLogisticPrice(), that.getMatchSellLogisticPrice()) &&
                Objects.equals(getMatchSellLogisticRadius(), that.getMatchSellLogisticRadius()) &&
                Objects.equals(getMatchSellPriseCondition(), that.getMatchSellPriseCondition()) &&
                Objects.equals(getMatchSellDate(), that.getMatchSellDate()) &&
                Objects.equals(getMatchSellUser(), that.getMatchSellUser()) &&
                Objects.equals(getMatchSellPhoneNumber(), that.getMatchSellPhoneNumber()) &&
                Objects.equals(getMatchSellCompany(), that.getMatchSellCompany()) &&
                Objects.equals(getMatchSellInn(), that.getMatchSellInn()) &&
                Objects.equals(getMatchSellNds(), that.getMatchSellNds());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getMatchSellId(), getSelling(), getMatchSellVolume(), getMatchSellPrice(), getMatchSellPriceWithLogistic(), getMatchSellAddres(), getMatchSellLogisticIsPossible(), getMatchSellLogisticPrice(), getMatchSellLogisticRadius(), getMatchSellPriseCondition(), getMatchSellDate(), getMatchSellUser(), getMatchSellPhoneNumber(), getMatchSellCompany(), getMatchSellInn(), getMatchSellNds());
        result = 31 * result + Arrays.hashCode(getMatchSellPropertes());
        return result;
    }

    public String getSelling() {
        return selling;
    }

    public MatchFullSellInfo(WebElement matchSellInfo) {

        // получение  id

        //matchSellId = matchSellInfo.findElement(By.className("_8563dc")).getText().replaceAll("[^0-9]+", "");
//вычленение слова "Продажа"
        String temp=matchSellInfo.findElement(By.className("_8563dc")).getText();
        int headerSize = temp.length();
        int i = 0;
        selling = "";
        while (headerSize > i && temp.charAt(i) != ' ') {
            selling += temp.charAt(i);
            i++;
        }
        //вычленение id
        matchSellId = temp.substring(i).replaceAll("[^0-9,\\.]+", "");
        List<WebElement> valueList = matchSellInfo.findElements(By.className("_97058b"));
        List<WebElement> descriptionList = matchSellInfo.findElements(By.className("_624ef2"));
////////////////////////////

        for (int descriptionsIterator = 0; descriptionsIterator < descriptionList.size(); descriptionsIterator++)
            switch (descriptionList.get(descriptionsIterator).getText()) {
                case "Объем": {
                    matchSellVolume = valueList.get(descriptionsIterator).getText().replaceAll("[^0-9,\\.]+", "");
                    break;
                }
                case "Цена": {
                    matchSellPrice = valueList.get(descriptionsIterator).getText().replaceAll("[^0-9,\\.]+", "");
                    break;
                }
                case "Цена с логистикой + комиссия": {
                    matchSellPriceWithLogistic = valueList.get(descriptionsIterator).getText().replaceAll("[^0-9,\\.]+", "");
                    break;
                }
                case "Параметры культуры": {
                    List<WebElement> propertesList = valueList.get(descriptionsIterator).findElements(By.tagName("p"));
                    matchSellPropertes = new String[propertesList.size()];
                    for (i = 0; i < propertesList.size(); i++)
                        matchSellPropertes[i] = propertesList.get(i).getText();
                    break;
                }
                case "Адрес": {
                    matchSellAddres = valueList.get(descriptionsIterator).getText();
                    break;
                }
                case "Доставка": {
                    matchSellLogisticIsPossible = valueList.get(descriptionsIterator).getText();
                    break;
                }
                case "Стоимость логистики": {
                    matchSellLogisticPrice = valueList.get(descriptionsIterator).getText().replaceAll("[^0-9,\\.]+", "");
                    break;
                }
                case "Радиус логистики": {
                    matchSellLogisticRadius = valueList.get(descriptionsIterator).getText().replaceAll("[^0-9,\\.]+", "");
                    break;
                }
                case "Условия оплаты": {
                    matchSellPriseCondition = valueList.get(descriptionsIterator).getText();
                    break;
                }
                case "Дата публикации": {
                    matchSellDate = valueList.get(descriptionsIterator).getText();
                    break;
                }
                case "Пользователь": {
                    // вычленение фио юзера
                    temp = valueList.get(descriptionsIterator).getText();
                    i = 0;
                    matchSellUser = "";
                    while (temp.charAt(i) != ',') {
                        matchSellUser += temp.charAt(i++);
                    }

                    // мобильный телефон
                    matchSellPhoneNumber = temp.substring(++i);
                    break;
                }
                case "Компания": {
                    temp = valueList.get(descriptionsIterator).getText();
                    i = 0;
                    matchSellCompany = "";
                    while (temp.charAt(i) != ',') {
                        matchSellCompany += temp.charAt(i++);
                    }
                    i++;

                    // вычленение ИНН
                    matchSellInn = "";
                    while (temp.charAt(i) != ',') {
                        matchSellInn += temp.charAt(i++);
                    }
                    matchSellInn = matchSellInn.replaceAll("[^0-9,\\.]+", "");

                    // НДС
                    matchSellNds = temp.substring(++i);
                    break;
                }
            }
        List<WebElement> elements = matchSellInfo.findElements(By.name("comment"));
        if (elements.size() == 1)
            matchSellComment = elements.get(0);

    }

    public String getMatchSellId() {
        return matchSellId;
    }

    public String getMatchSellVolume() {
        return matchSellVolume;
    }

    public String getMatchSellPrice() {
        return matchSellPrice;
    }

    public String getMatchSellPriceWithLogistic() {
        return matchSellPriceWithLogistic;
    }

    public String[] getMatchSellPropertes() {
        return matchSellPropertes;
    }

    public String getMatchSellAddres() {
        return matchSellAddres;
    }

    public String getMatchSellLogisticIsPossible() {
        return matchSellLogisticIsPossible;
    }

    public String getMatchSellLogisticPrice() {
        return matchSellLogisticPrice;
    }

    public String getMatchSellLogisticRadius() {
        return matchSellLogisticRadius;
    }

    public String getMatchSellPriseCondition() {
        return matchSellPriseCondition;
    }

    public String getMatchSellDate() {
        return matchSellDate;
    }

    public String getMatchSellUser() {
        return matchSellUser;
    }

    public String getMatchSellPhoneNumber() {
        return matchSellPhoneNumber;
    }

    public String getMatchSellCompany() {
        return matchSellCompany;
    }

    public String getMatchSellInn() {
        return matchSellInn;
    }

    public String getMatchSellNds() {
        return matchSellNds;
    }
}