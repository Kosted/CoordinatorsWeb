package tests.metchesTests;

import helperClasses.match.MatchShortCard;
import org.junit.Test;
import superClasses.SuperTest;


public class ShortMatchContentTest extends SuperTest {


    public ShortMatchContentTest() {
        super(web_a);
    }

    @Test
    public void shortMatchContentTest() {

        logIn("9000001000", "N12345678");
        matchesPage.goToMatches();


        MatchShortCard matchShortCard = matchesPage.getMatchCard(0);

        assertMCS.notEquals(matchShortCard.getStatus(), null,"пустой статус мэтча");
        assertMCS.notEquals(matchShortCard.getStatus(), "","пустой статус мэтча");


        assertMCS.notEquals(matchShortCard.getMetchId(), null,"у метча отсутствует id");
        assertMCS.notEquals(matchShortCard.getMetchId(), "","у метча отсутствует id");


        assertMCS.notEquals(matchShortCard.getMainProperty(), null,"у метча отсутствует основное свойство");
        assertMCS.notEquals(matchShortCard.getMainProperty(), "","у метча отсутствует основное свойство");


        assertMCS.notEquals(matchShortCard.getMatchCulture(), null,"у мэтча отсутствует культура");
        assertMCS.notEquals(matchShortCard.getMatchCulture(), "","у мэтча отсутствует культура");


        assertMCS.notEquals(matchShortCard.getMatchDate(), null,"у мэтча отсутствует дата появления");
        assertMCS.notEquals(matchShortCard.getMatchDate(), "","у мэтча отсутствует дата появления");


        assertMCS.notEquals(matchShortCard.getMatchRadius(), null,"у мэтча отсутствует удаленность");
        assertMCS.notEquals(matchShortCard.getMatchRadius(), "","у мэтча отсутствует удаленность");


        assertMCS.equals(matchShortCard.getBuying(), "Закупка","у мэтча отсутствует обознаяенмие Закупка");


        assertMCS.equals(matchShortCard.getSelling(), "Продажа","у мэтча отсутствует обозначение Продажа");


        assertMCS.notEquals(matchShortCard.getMatchBuyVolume(), null,"у мэтча отсутствует объем покупки");
        assertMCS.notEquals(matchShortCard.getMatchBuyVolume(), "","у мэтча отсутствует объем покупки");


        assertMCS.notEquals(matchShortCard.getMatchSellVolume(), null,"у мэтча отсутствует объем продажи");
        assertMCS.notEquals(matchShortCard.getMatchSellVolume(), "","у мэтча отсутствует объем продажи");

        assertMCS.notEquals(matchShortCard.getMatchBuyId(), null,"у мэтча отсутствует id заявки на покупку");
        assertMCS.notEquals(matchShortCard.getMatchBuyId(), "","у мэтча отсутствует id заявки на покупку");

        assertMCS.notEquals(matchShortCard.getMatchSellID(), null,"у мэтча отсутствует id заявки на продажу");
        assertMCS.notEquals(matchShortCard.getMatchSellID(), "","у мэтча отсутствует id заявки на продажу");

        assertMCS.notEquals(matchShortCard.getMatchBuyPrice(), null,"у мэтча отсутствует цена покупки");
        assertMCS.notEquals(matchShortCard.getMatchBuyPrice(), "","у мэтча отсутствует цена покупки");


        assertMCS.notEquals(matchShortCard.getMatchSellPrice(), null,"у мэтча отсутствует цена продажи");
        assertMCS.notEquals(matchShortCard.getMatchSellPrice(), "","у мэтча отсутствует цена продажи");


        assertMCS.notEquals(matchShortCard.getMatchSellPriceWithlogistics(), null,"у мэтча отсутствует цена логистики продажи");
        assertMCS.notEquals(matchShortCard.getMatchSellPriceWithlogistics(), "","у мэтча отсутствует цена логистики продажи");


        assertMCS.notEquals(matchShortCard.getMatchBuyDate(), null,"у мэтча отсутствует дата публикации заявки на покупку");
        assertMCS.notEquals(matchShortCard.getMatchBuyDate(), "","у мэтча отсутствует дата публикации заявки на покупку");


        assertMCS.notEquals(matchShortCard.getMatchSellDate(), null,"у мэтча отсутствует дата публикации заявки на продажу");
        assertMCS.notEquals(matchShortCard.getMatchSellDate(), "","у мэтча отсутствует дата публикации заявки на продажу");


        assertMCS.notEquals(matchShortCard.getMatchBuyCompany(), null,"у мэтча отсутствует название покупающей компании");
        assertMCS.notEquals(matchShortCard.getMatchBuyCompany(), "","у мэтча отсутствует название покупающей компании");


        assertMCS.notEquals(matchShortCard.getMatchSellCompany(), null,"у мэтча отсутствует название продающей компании");
        assertMCS.notEquals(matchShortCard.getMatchSellCompany(), "","у мэтча отсутствует название продающей компании");


    }
}



