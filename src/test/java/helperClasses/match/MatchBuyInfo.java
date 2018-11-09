package helperClasses.match;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

public class MatchBuyInfo {


    private String matchBuyId;
    private String buying;

    private String matchBuyVolume;


    private String matchBuyPrice;
    // private String matchBuyPriceWithlogistics;
    private String matchBuyDate;
    private String matchBuyCompany;

//    private String matchBuyIDClassName;
//    private String matchBuyListPartsClassName;

//    private  List<WebElement> matchBuyPartsList;

    @Override
    public int hashCode() {
        return Objects.hash(getMatchBuyId(), getBuying(), getMatchBuyVolume(), getMatchBuyPrice(), getMatchBuyDate(), getMatchBuyCompany());
    }

    @Override
    public String toString() {
        return "MatchBuyInfo{" +
                "matchBuyId='" + matchBuyId + '\'' +
                ", buying='" + buying + '\'' +
                ", matchBuyVolume='" + matchBuyVolume + '\'' +
                ", matchBuyPrice='" + matchBuyPrice + '\'' +
                ", matchBuyDate='" + matchBuyDate + '\'' +
                ", matchBuyCompany='" + matchBuyCompany + '\'' +
                '}';
    }

    public String getBuying() {
        return buying;
    }

    public MatchBuyInfo(WebElement matchBuyInfo) {


        List<WebElement> descriptionList = matchBuyInfo.findElements(By.className("_624ef2"));
        List<WebElement> valueList = matchBuyInfo.findElements(By.className("_97058b"));


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
                case "Дата публикации": {
                    matchBuyDate = valueList.get(descriptionsIterator).getText();
                    break;
                }
                case "Компания": {
                    matchBuyCompany = valueList.get(descriptionsIterator).getText();
                    break;
                }

            }

        String temp = matchBuyInfo.findElement(By.className("_8563dc")).getText();

//вычленение слова "Закупка"
        int headerSize = temp.length();
        int i = 0;
        buying = "";
        while (headerSize > i && temp.charAt(i) != ' ') {
            buying += temp.charAt(i);
            i++;
        }
        //вычленение id
        matchBuyId = temp.substring(i).replaceAll("[^0-9,\\.]+", "");

//        matchBuyIDClassName = "_8563dc";
//
//        matchBuyListPartsClassName = "_97058b";
//
//        matchBuyId = matchBuyInfo.findElement(By.className(matchBuyIDClassName)).getText().replaceAll("[^0-9,\\.]+", " ");
//
//        matchBuyPartsList = matchBuyInfo.findElements(By.className(matchBuyListPartsClassName));
//
//        matchBuyVolume = parseDouble(matchBuyPartsList.get(0).getText().replaceAll("[^0-9,\\.]+", ""));
//        matchBuyPrice = parseDouble(matchBuyPartsList.get(1).getText().replaceAll("[^0-9,\\.]+", ""));
//      //  matchBuyPriceWithlogistics = matchBuyPartsList.get(2).getText();
//        matchBuyDate = matchBuyPartsList.get(2).getText();
//        matchBuyCompany = matchBuyPartsList.get(3).getText();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MatchBuyInfo)) return false;
        MatchBuyInfo that = (MatchBuyInfo) o;
        return Objects.equals(getMatchBuyId(), that.getMatchBuyId()) &&
                Objects.equals(getMatchBuyVolume(), that.getMatchBuyVolume()) &&
                Objects.equals(getMatchBuyPrice(), that.getMatchBuyPrice()) &&
                Objects.equals(getMatchBuyDate(), that.getMatchBuyDate()) &&
                Objects.equals(getMatchBuyCompany(), that.getMatchBuyCompany());
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

    public String getMatchBuyDate() {
        return matchBuyDate;
    }

    public String getMatchBuyCompany() {
        return matchBuyCompany;
    }
}
