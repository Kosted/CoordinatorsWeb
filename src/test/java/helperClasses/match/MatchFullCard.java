package helperClasses.match;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

public class MatchFullCard {


    private MatchHeader matchHeader;
    private MatchFullBuyInfo matchFullBuyInfo;
    private MatchFullSellInfo matchFullSellInfo;
    private WebElement matchCommentField;

    public WebElement getMatchCommentField() {
        return matchCommentField;
    }
//    private int contentSize;

    public MatchFullCard(WebElement matchCard) {

        matchHeader = new MatchHeader(matchCard.findElement(By.tagName("header")));

        String buyAndSellClassName = "b1a733";

        List<WebElement> buyAndSellParts = matchCard.findElements(By.className(buyAndSellClassName));


        matchFullBuyInfo = new MatchFullBuyInfo(buyAndSellParts.get(0));
        matchFullSellInfo = new MatchFullSellInfo(buyAndSellParts.get(1));


        List<WebElement> elements = matchCard.findElements(By.name("comment"));
        if (elements.size() == 3)
            matchCommentField = elements.get(2);

    }

    @Override
    public String toString() {
        return "MatchFullCard{" +
                "matchHeader=" + matchHeader +
                ", matchFullBuyInfo=" + matchFullBuyInfo +
                ", matchFullSellInfo=" + matchFullSellInfo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MatchFullCard)) return false;
        MatchFullCard that = (MatchFullCard) o;
        return Objects.equals(matchHeader, that.matchHeader) &&
                Objects.equals(matchFullBuyInfo, that.matchFullBuyInfo) &&
                Objects.equals(matchFullSellInfo, that.matchFullSellInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchHeader, matchFullBuyInfo, matchFullSellInfo);
    }
//    public int getContentSize() {
//        return contentSize;
//    }


    public WebElement getMatchSellComment() {
        return matchFullSellInfo.getMatchSellComment();
    }

    public WebElement getMatchBuyComment() {
        return matchFullBuyInfo.getMatchBuyComment();
    }

    public MatchHeader getMatchHeader() {
        return matchHeader;
    }

    public MatchFullBuyInfo getMatchFullBuyInfo() {
        return matchFullBuyInfo;
    }

    public MatchFullSellInfo getMatchFullSellInfo() {
        return matchFullSellInfo;
    }

    public String getSelling() {
        return matchFullSellInfo.getSelling();
    }

    public String getBuying() {
        return matchFullBuyInfo.getBuying();
    }

    public String getMatchSellId() {
        return matchFullSellInfo.getMatchSellId();
    }

    public String getMatchSellVolume() {
        return matchFullSellInfo.getMatchSellVolume();
    }

    public String getMatchSellPrice() {
        return matchFullSellInfo.getMatchSellPrice();
    }

    public String getMatchSellPriceWithLogistic() {
        return matchFullSellInfo.getMatchSellPriceWithLogistic();
    }

    public String[] getMatchSellPropertes() {
        return matchFullSellInfo.getMatchSellPropertes();
    }

    public String getMatchSellAddres() {
        return matchFullSellInfo.getMatchSellAddres();
    }

    public String getMatchSellLogisticIsPossible() {
        return matchFullSellInfo.getMatchSellLogisticIsPossible();
    }

    public String getMatchSellLogisticPrice() {
        return matchFullSellInfo.getMatchSellLogisticPrice();
    }

    public String getMatchSellLogisticRadius() {
        return matchFullSellInfo.getMatchSellLogisticRadius();
    }

    public String getMatchSellPriseCondition() {
        return matchFullSellInfo.getMatchSellPriseCondition();
    }

    public String getMatchSellDate() {
        return matchFullSellInfo.getMatchSellDate();
    }

    public String getMatchSellUser() {
        return matchFullSellInfo.getMatchSellUser();
    }

    public String getMatchSellPhoneNumber() {
        return matchFullSellInfo.getMatchSellPhoneNumber();
    }

    public String getMatchSellCompany() {
        return matchFullSellInfo.getMatchSellCompany();
    }

    public String getMatchSellInn() {
        return matchFullSellInfo.getMatchSellInn();
    }

    public String getMatchSellNds() {
        return matchFullSellInfo.getMatchSellNds();
    }

    public String getMatchBuyId() {
        return matchFullBuyInfo.getMatchBuyId();
    }

    public String getMatchBuyVolume() {
        return matchFullBuyInfo.getMatchBuyVolume();
    }

    public String getMatchBuyPrice() {
        return matchFullBuyInfo.getMatchBuyPrice();
    }

    public String[] getMatchBuyPropertes() {
        return matchFullBuyInfo.getMatchBuyPropertes();
    }

    public String getMatchBuyAddres() {
        return matchFullBuyInfo.getMatchBuyAddres();
    }

    public String getMatchBuyLogisticIsPossible() {
        return matchFullBuyInfo.getMatchBuyLogisticIsPossible();
    }

    public String getMatchBuyLogisticPrice() {
        return matchFullBuyInfo.getMatchBuyLogisticPrice();
    }

    public String getMatchBuyLogisticRadius() {
        return matchFullBuyInfo.getMatchBuyLogisticRadius();
    }

    public String getMatchBuyPriseCondition() {
        return matchFullBuyInfo.getMatchBuyPriseCondition();
    }

    public String getMatchBuyDate() {
        return matchFullBuyInfo.getMatchBuyDate();
    }

    public String getMatchBuyUser() {
        return matchFullBuyInfo.getMatchBuyUser();
    }

    public String getMatchBuyPhoneNumber() {
        return matchFullBuyInfo.getMatchBuyPhoneNumber();
    }

    public String getMatchBuyCompany() {
        return matchFullBuyInfo.getMatchBuyCompany();
    }

    public String getMatchBuyInn() {
        return matchFullBuyInfo.getMatchBuyInn();
    }

    public String getMatchBuyNds() {
        return matchFullBuyInfo.getMatchBuyNds();
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

    public WebElement getStatusButton() {
        return matchHeader.getStatusButton();
    }
}
