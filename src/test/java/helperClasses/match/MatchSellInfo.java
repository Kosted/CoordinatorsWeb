package helperClasses.match;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

public class MatchSellInfo {

    private String matchSellID;
    private String selling;

    private String matchSellVolume;
    private String matchSellPrice;
    private String matchSellPriceWithlogistics;
    private String matchSellDate;
    private String matchSellCompany;

//    private String matchSellIDClassName;
//    private String matchSellListPartsClassName;
//
//    private  List<WebElement> matchSellPartsList;


    public String getMatchSellID() {
        return matchSellID;
    }

    public String getMatchSellVolume() {
        return matchSellVolume;
    }

    public String getMatchSellPrice() {
        return matchSellPrice;
    }

    public String getMatchSellPriceWithlogistics() {
        return matchSellPriceWithlogistics;
    }

    public String getMatchSellDate() {
        return matchSellDate;
    }

    public String getMatchSellCompany() {
        return matchSellCompany;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMatchSellID(), getSelling(), getMatchSellVolume(), getMatchSellPrice(), getMatchSellPriceWithlogistics(), getMatchSellDate(), getMatchSellCompany());
    }

    public String getSelling() {
        return selling;
    }

    @Override
    public String toString() {
        return "MatchSellInfo{" +
                "matchSellID='" + matchSellID + '\'' +
                ", selling='" + selling + '\'' +
                ", matchSellVolume='" + matchSellVolume + '\'' +
                ", matchSellPrice='" + matchSellPrice + '\'' +
                ", matchSellPriceWithlogistics='" + matchSellPriceWithlogistics + '\'' +
                ", matchSellDate='" + matchSellDate + '\'' +
                ", matchSellCompany='" + matchSellCompany + '\'' +
                '}';
    }
//    public MatchSellInfo(WebElement matchSellInfo) {
//
//        matchSellIDClassName = "_8563dc";
//
//        matchSellListPartsClassName = "_97058b";
//
//        matchSellID = matchSellInfo.findElement(By.className(matchSellIDClassName)).getText().replaceAll("[^0-9,\\.]+", " ");
//
//        matchSellPartsList = matchSellInfo.findElements(By.className(matchSellListPartsClassName));
//
//        matchSellVolume = parseDouble(matchSellPartsList.get(0).getText().replaceAll("[^0-9,\\.]+", ""));
//        matchSellPrice = parseDouble(matchSellPartsList.get(1).getText().replaceAll("[^0-9,\\.]+", ""));
//        matchSellPriceWithlogistics = parseDouble(matchSellPartsList.get(2).getText().replaceAll("[^0-9,\\.]+", ""));
//        matchSellDate = matchSellPartsList.get(3).getText();
//        matchSellCompany = matchSellPartsList.get(4).getText();
//    }

    public MatchSellInfo(WebElement matchSellInfo) {


        List<WebElement> descriptionList = matchSellInfo.findElements(By.className("_624ef2"));
        List<WebElement> valueList = matchSellInfo.findElements(By.className("_97058b"));


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
                    matchSellPriceWithlogistics= valueList.get(descriptionsIterator).getText().replaceAll("[^0-9,\\.]+", "");
                    break;
                }
                case "Дата публикации": {
                    matchSellDate= valueList.get(descriptionsIterator).getText();
                    break;
                }
                case "Компания": {
                    matchSellCompany = valueList.get(descriptionsIterator).getText();
                    break;
                }

            }

       // matchSellID = matchSellInfo.findElement(By.className("_8563dc")).getText().replaceAll("[^0-9]+", "");
        String temp = matchSellInfo.findElement(By.className("_8563dc")).getText();

//вычленение слова "Продажа"
        int headerSize = temp.length();
        int i = 0;
        selling = "";
        while (headerSize > i && temp.charAt(i) != ' ') {
            selling += temp.charAt(i);
            i++;
        }
        //вычленение id
        matchSellID = temp.substring(i).replaceAll("[^0-9,\\.]+", "");

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MatchSellInfo)) return false;
        MatchSellInfo that = (MatchSellInfo) o;
        return Objects.equals(getMatchSellID(), that.getMatchSellID()) &&
                Objects.equals(getMatchSellVolume(), that.getMatchSellVolume()) &&
                Objects.equals(getMatchSellPrice(), that.getMatchSellPrice()) &&
                Objects.equals(getMatchSellPriceWithlogistics(), that.getMatchSellPriceWithlogistics()) &&
                Objects.equals(getMatchSellDate(), that.getMatchSellDate()) &&
                Objects.equals(getMatchSellCompany(), that.getMatchSellCompany());
    }

}
