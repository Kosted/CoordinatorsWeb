package helperClasses.match;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

public class MatchShortCard {


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MatchShortCard)) return false;
        MatchShortCard matchShortCard = (MatchShortCard) o;
        return Objects.equals(getMatchHeader(), matchShortCard.getMatchHeader()) &&
                Objects.equals(getMatchBuyInfo(), matchShortCard.getMatchBuyInfo()) &&
                Objects.equals(getMatchSellInfo(), matchShortCard.getMatchSellInfo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMatchHeader(), getMatchBuyInfo(), getMatchSellInfo());
    }

    public MatchHeader getMatchHeader() {
        return matchHeader;
    }

    public MatchBuyInfo getMatchBuyInfo() {
        return matchBuyInfo;
    }

    public MatchSellInfo getMatchSellInfo() {
        return matchSellInfo;
    }


    public MatchShortCard(WebElement matchCard) {

        matchHeader = new MatchHeader(matchCard.findElement(By.tagName("header")));

        String buyAndSellClassName = "b1a733";

        List<WebElement> buyAndSellParts = matchCard.findElements(By.className(buyAndSellClassName));


        matchBuyInfo = new MatchBuyInfo(buyAndSellParts.get(0));
        matchSellInfo = new MatchSellInfo(buyAndSellParts.get(1));


    }



    private MatchHeader matchHeader;

    public String getSelling() {
        return getMatchSellInfo().getSelling();
    }

    public String getBuying() {
        return getMatchBuyInfo().getBuying();
    }

    private MatchBuyInfo matchBuyInfo;
    private MatchSellInfo matchSellInfo;

    @Override
    public String toString() {
        return "MatchShortCard{" +
                 matchHeader.toString() +
                 matchBuyInfo.toString() +
                matchSellInfo.toString() +
                '}';
    }

    public WebElement getStatusButton(){
        return matchHeader.getStatusButton();
    }

    public String getMatchSellID() {
        return matchSellInfo.getMatchSellID();
    }

    public String getMatchSellVolume() {
        return matchSellInfo.getMatchSellVolume();
    }

    public String getMatchSellPrice() {
        return matchSellInfo.getMatchSellPrice();
    }

    public String getMatchSellPriceWithlogistics() {
        return matchSellInfo.getMatchSellPriceWithlogistics();
    }

    public String getMatchSellDate() {
        return matchSellInfo.getMatchSellDate();
    }

    public String getMatchSellCompany() {
        return matchSellInfo.getMatchSellCompany();
    }

    public String getMatchBuyId() {
        return matchBuyInfo.getMatchBuyId();
    }

    public String getMatchBuyVolume() {
        return matchBuyInfo.getMatchBuyVolume();
    }

    public String getMatchBuyPrice() {
        return matchBuyInfo.getMatchBuyPrice();
    }

    public String getMatchBuyDate() {
        return matchBuyInfo.getMatchBuyDate();
    }

    public String getMatchBuyCompany() {
        return matchBuyInfo.getMatchBuyCompany();
    }

    public String getMetchId() {
        return matchHeader.getMetchId();
    }

    public String getMatchCulture() {
        return matchHeader.getMatchCulture();
    }

    public String getMainProperty() {
        return matchHeader.getMainProperty();
    }

    public String getMatchDate() {
        return matchHeader.getMatchDate();
    }

    public String getMatchRadius() {
        return matchHeader.getMatchRadius();
    }

    public String getStatus() {
        return matchHeader.getStatus();
    }
}
