package helperClasses.match;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MatchFullBuyInfo {

    private WebElement matchBuyComment;

    public WebElement getMatchBuyComment() {
        return matchBuyComment;
    }

    private String matchBuyId;
    private String buying;
    private String matchBuyVolume;

    private String matchBuyPrice;


    private String[] matchBuyPropertes;
    private String matchBuyAddres;
    private String matchBuyLogisticIsPossible;
    private String matchBuyLogisticPrice;
    private String matchBuyLogisticRadius;
    private String matchBuyPriseCondition;
    private String matchBuyDate;
    private String matchBuyUser;
    private String matchBuyPhoneNumber;

    private String matchBuyCompany;
    private String matchBuyInn;
    private String matchBuyNds;


    @Override
    public String toString() {
        return "MatchFullBuyInfo{" +
                "matchBuyId='" + matchBuyId + '\'' +
                ", buying='" + buying + '\'' +
                ", matchBuyVolume='" + matchBuyVolume + '\'' +
                ", matchBuyPrice='" + matchBuyPrice + '\'' +
                ", matchBuyPropertes=" + Arrays.toString(matchBuyPropertes) +
                ", matchBuyAddres='" + matchBuyAddres + '\'' +
                ", matchBuyLogisticIsPossible='" + matchBuyLogisticIsPossible + '\'' +
                ", matchBuyLogisticPrice='" + matchBuyLogisticPrice + '\'' +
                ", matchBuyLogisticRadius='" + matchBuyLogisticRadius + '\'' +
                ", matchBuyPriseCondition='" + matchBuyPriseCondition + '\'' +
                ", matchBuyDate='" + matchBuyDate + '\'' +
                ", matchBuyUser='" + matchBuyUser + '\'' +
                ", matchBuyPhoneNumber='" + matchBuyPhoneNumber + '\'' +
                ", matchBuyCompany='" + matchBuyCompany + '\'' +
                ", matchBuyInn='" + matchBuyInn + '\'' +
                ", matchBuyNds='" + matchBuyNds + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MatchFullBuyInfo)) return false;
        MatchFullBuyInfo that = (MatchFullBuyInfo) o;
        return Objects.equals(getMatchBuyId(), that.getMatchBuyId()) &&
                Objects.equals(getBuying(), that.getBuying()) &&
                Objects.equals(getMatchBuyVolume(), that.getMatchBuyVolume()) &&
                Objects.equals(getMatchBuyPrice(), that.getMatchBuyPrice()) &&
                Arrays.equals(getMatchBuyPropertes(), that.getMatchBuyPropertes()) &&
                Objects.equals(getMatchBuyAddres(), that.getMatchBuyAddres()) &&
                Objects.equals(getMatchBuyLogisticIsPossible(), that.getMatchBuyLogisticIsPossible()) &&
                Objects.equals(getMatchBuyLogisticPrice(), that.getMatchBuyLogisticPrice()) &&
                Objects.equals(getMatchBuyLogisticRadius(), that.getMatchBuyLogisticRadius()) &&
                Objects.equals(getMatchBuyPriseCondition(), that.getMatchBuyPriseCondition()) &&
                Objects.equals(getMatchBuyDate(), that.getMatchBuyDate()) &&
                Objects.equals(getMatchBuyUser(), that.getMatchBuyUser()) &&
                Objects.equals(getMatchBuyPhoneNumber(), that.getMatchBuyPhoneNumber()) &&
                Objects.equals(getMatchBuyCompany(), that.getMatchBuyCompany()) &&
                Objects.equals(getMatchBuyInn(), that.getMatchBuyInn()) &&
                Objects.equals(getMatchBuyNds(), that.getMatchBuyNds());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getMatchBuyId(), getBuying(), getMatchBuyVolume(), getMatchBuyPrice(), getMatchBuyAddres(), getMatchBuyLogisticIsPossible(), getMatchBuyLogisticPrice(), getMatchBuyLogisticRadius(), getMatchBuyPriseCondition(), getMatchBuyDate(), getMatchBuyUser(), getMatchBuyPhoneNumber(), getMatchBuyCompany(), getMatchBuyInn(), getMatchBuyNds());
        result = 31 * result + Arrays.hashCode(getMatchBuyPropertes());
        return result;
    }

    public String getBuying() {
        return buying;
    }

    public MatchFullBuyInfo(WebElement matchBuyInfo) {

        // получение  id

        //matchBuyId = matchBuyInfo.findElement(By.className("_8563dc")).getText().replaceAll("[^0-9]+", "");

        String temp = matchBuyInfo.findElement(By.className("_8563dc")).getText();

//вычленение слова "Закупка"
        int tempSize = temp.length();
        int i = 0;
        buying = "";
        while (tempSize > i && temp.charAt(i) != ' ') {
            buying += temp.charAt(i);
            i++;
        }
        //вычленение id
        matchBuyId = temp.substring(i).replaceAll("[^0-9,\\.]+", "");


        List<WebElement> valueList = matchBuyInfo.findElements(By.className("_97058b"));
        List<WebElement> descriptionList = matchBuyInfo.findElements(By.className("_624ef2"));
////////////////////////////

        for (int descriptionsIterator = 0; descriptionsIterator < descriptionList.size(); descriptionsIterator++)
            switch (descriptionList.get(descriptionsIterator).getText()) {
                case "Объем": {
                    matchBuyVolume = valueList.get(descriptionsIterator).getText().replaceAll("[^0-9,\\.]+", "");
                    break;
                }
                case "Цена": {
                    matchBuyPrice = valueList.get(descriptionsIterator).getText().replaceAll("[^0-9,\\.]+", "");
                    break;
                }
                case "Параметры культуры": {
                    List<WebElement> propertesList = valueList.get(descriptionsIterator).findElements(By.tagName("p"));
                    matchBuyPropertes = new String[propertesList.size()];
                    for (i = 0; i < propertesList.size(); i++)
                        matchBuyPropertes[i] = propertesList.get(i).getText();
                    break;
                }
                case "Адрес": {
                    matchBuyAddres = valueList.get(descriptionsIterator).getText();
                    break;
                }
                case "Доставка": {
                    matchBuyLogisticIsPossible = valueList.get(descriptionsIterator).getText();
                    break;
                }
                case "Стоимость логистики": {
                    matchBuyLogisticPrice = valueList.get(descriptionsIterator).getText().replaceAll("[^0-9,\\.]+", "");
                    break;
                }
                case "Радиус логистики": {
                    matchBuyLogisticRadius = valueList.get(descriptionsIterator).getText().replaceAll("[^0-9,\\.]+", "");
                    break;
                }
                case "Условия оплаты": {
                    matchBuyPriseCondition = valueList.get(descriptionsIterator).getText();
                    break;
                }
                case "Дата публикации": {
                    matchBuyDate = valueList.get(descriptionsIterator).getText();
                    break;
                }
                case "Пользователь": {
                    // вычленение фио юзера
                    temp = valueList.get(descriptionsIterator).getText();
                    i = 0;
                    matchBuyUser = "";
                    while (temp.charAt(i) != ',') {
                        matchBuyUser += temp.charAt(i++);
                    }

                    // мобильный телефон
                    matchBuyPhoneNumber = temp.substring(++i);
                    break;
                }
                case "Компания": {
                    temp = valueList.get(descriptionsIterator).getText();
                    i = 0;
                    matchBuyCompany = "";
                    while (temp.charAt(i) != ',') {
                        matchBuyCompany += temp.charAt(i++);
                    }
                    i++;

                    // вычленение ИНН
                    matchBuyInn = "";
                    while (temp.charAt(i) != ',') {
                        matchBuyInn += temp.charAt(i++);
                    }
                    matchBuyInn = matchBuyInn.replaceAll("[^0-9,\\.]+", "");

                    // НДС
                    matchBuyNds = temp.substring(++i);
                    break;
                }
            }

        List<WebElement> elements = matchBuyInfo.findElements(By.name("comment"));
        if (elements.size() == 1)
            matchBuyComment = elements.get(0);
    }

    public String getMatchBuyId() {
        return matchBuyId;
    }

    public String getMatchBuyVolume() {
        return matchBuyVolume;
    }

    public String getMatchBuyPrice() {
        return matchBuyPrice;
    }

    public String[] getMatchBuyPropertes() {
        return matchBuyPropertes;
    }

    public String getMatchBuyAddres() {
        return matchBuyAddres;
    }

    public String getMatchBuyLogisticIsPossible() {
        return matchBuyLogisticIsPossible;
    }

    public String getMatchBuyLogisticPrice() {
        return matchBuyLogisticPrice;
    }

    public String getMatchBuyLogisticRadius() {
        return matchBuyLogisticRadius;
    }

    public String getMatchBuyPriseCondition() {
        return matchBuyPriseCondition;
    }

    public String getMatchBuyDate() {
        return matchBuyDate;
    }

    public String getMatchBuyUser() {
        return matchBuyUser;
    }

    public String getMatchBuyPhoneNumber() {
        return matchBuyPhoneNumber;
    }

    public String getMatchBuyCompany() {
        return matchBuyCompany;
    }

    public String getMatchBuyInn() {
        return matchBuyInn;
    }

    public String getMatchBuyNds() {
        return matchBuyNds;
    }

}