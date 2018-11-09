package tests.metchesTests;

import helperClasses.match.MatchFullCard;
import org.junit.Test;
import superClasses.SuperTest;


public class FullMatchContentTest extends SuperTest {


    public FullMatchContentTest() {
        super(web_a);
    }

    @Test
    public void fullMatchContentTest() {

        logIn("9000001000", "N12345678");
        matchesPage.goToMatches();

        matchesPage.clickOnMatch(0);
        MatchFullCard matchFullCard = matchesPage.getFullMatchCard(0);

        assertMCS.setStandartErrorMessege("\nid проблемного метча - "+ matchFullCard.getMetchId());
// header
        assertMCS.notEquals(matchFullCard.getStatus(), null, "пустой статус мэтча");
        assertMCS.notEquals(matchFullCard.getStatus(), "", "пустой статус мэтча");


        assertMCS.notEquals(matchFullCard.getMetchId(), null, "у метча отсутствует id");
        assertMCS.notEquals(matchFullCard.getMetchId(), "", "у метча отсутствует id");


        assertMCS.notEquals(matchFullCard.getMainProperty(), null, "у метча отсутствует основное свойство");
        assertMCS.notEquals(matchFullCard.getMainProperty(), "", "у метча отсутствует основное свойство");


        assertMCS.notEquals(matchFullCard.getMatchCulture(), null, "у мэтча отсутствует культура");
        assertMCS.notEquals(matchFullCard.getMatchCulture(), "", "у мэтча отсутствует культура");


        assertMCS.notEquals(matchFullCard.getMatchDate(), null, "у мэтча отсутствует дата появления");
        assertMCS.notEquals(matchFullCard.getMatchDate(), "", "у мэтча отсутствует дата появления");


        assertMCS.notEquals(matchFullCard.getMatchRadius(), null, "у мэтча отсутствует удаленность");
        assertMCS.notEquals(matchFullCard.getMatchRadius(), "", "у мэтча отсутствует удаленность");


        assertMCS.notEquals(matchFullCard.getStatus(), null, "у мэтча отсутствует статус");
        assertMCS.notEquals(matchFullCard.getStatus(), "", "у мэтча отсутствует статус");

//
        assertMCS.equals(matchFullCard.getBuying(), "Закупка", "у мэтча покупки отсутствует обознаяенмие Закупка");


        assertMCS.equals(matchFullCard.getSelling(), "Продажа", "у мэтча продавца отсутствует обозначение Продажа");

        assertMCS.notEquals(matchFullCard.getMatchBuyId(), null, "у мэтча покупки отсутствует id заявки на покупку");
        assertMCS.notEquals(matchFullCard.getMatchBuyId(), "", "у мэтча покупки отсутствует id заявки на покупку");
        assertMCS.notEquals(matchFullCard.getMatchSellId(), null, "у мэтча продавца отсутствует id заявки на продажу");
        assertMCS.notEquals(matchFullCard.getMatchSellId(), "", "у мэтча продавца отсутствует id заявки на продажу");


        assertMCS.notEquals(matchFullCard.getMatchBuyVolume(), null, "у мэтча отсутствует объем покупки");
        assertMCS.notEquals(matchFullCard.getMatchBuyVolume(), "", "у мэтча отсутствует объем покупки");
        assertMCS.notEquals(matchFullCard.getMatchSellVolume(), null, "у мэтча продавца отсутствует объем продажи");
        assertMCS.notEquals(matchFullCard.getMatchSellVolume(), "", "у мэтча продавца отсутствует объем продажи");


        assertMCS.notEquals(matchFullCard.getMatchBuyPrice(), null, "у мэтча покупки отсутствует цена покупки");
        assertMCS.notEquals(matchFullCard.getMatchBuyPrice(), "", "у мэтча покупки отсутствует цена покупки");
        assertMCS.notEquals(matchFullCard.getMatchSellPrice(), null, "у мэтча продавца отсутствует цена продажи");
        assertMCS.notEquals(matchFullCard.getMatchSellPrice(), "", "у мэтча продавца отсутствует цена продажи");


        assertMCS.notEquals(matchFullCard.getMatchSellPriceWithLogistic(), null, "у мэтча продавца отсутствует цена логистики продажи");
        assertMCS.notEquals(matchFullCard.getMatchSellPriceWithLogistic(), "", "у мэтча продавца отсутствует цена логистики продажи");


        assertMCS.notEquals(matchFullCard.getMatchSellPropertes(), null, "у мэтча продавца в описании отсутствует свойства культуры ");
        assertMCS.notEquals(matchFullCard.getMatchSellPropertes().length, 0, "у мэтча продавца в описании отсутствует свойства культуры ");


        assertMCS.notEquals(matchFullCard.getMatchBuyPropertes(), null, "у мэтча покупателя в описании отсутствует свойства культуры ");
        assertMCS.notEquals(matchFullCard.getMatchBuyPropertes().length, 0, "у мэтча покупателя в описании отсутствует свойства культуры ");


        assertMCS.notEquals(matchFullCard.getMatchBuyAddres(), null, "у мэтча покупателя отсутствует");
        assertMCS.notEquals(matchFullCard.getMatchBuyAddres(), "", "у мэтча покупателя отсутствует");

        assertMCS.notEquals(matchFullCard.getMatchSellAddres(), null, "у мэтча продажи отсутствует");
        assertMCS.notEquals(matchFullCard.getMatchSellAddres(), "", "у мэтча продажи отсутствует");


        // не у всех есть эта графа
        if (matchFullCard.getMatchBuyLogisticIsPossible() != null) {

            assertMCS.notEquals(matchFullCard.getMatchBuyLogisticIsPossible(), null, "у мэтча покупателя отсутствует возможность логистики");
            assertMCS.notEquals(matchFullCard.getMatchBuyLogisticIsPossible(), "", "у мэтча покупателя отсутствует возможность логистики");

            assertMCS.notEquals(matchFullCard.getMatchBuyLogisticPrice(), null, "у мэтча покупателя отсутствует цена логистики");
            assertMCS.notEquals(matchFullCard.getMatchBuyLogisticPrice(), "", "у мэтча покупателя отсутствует цена логистики");


            assertMCS.notEquals(matchFullCard.getMatchBuyLogisticRadius(), null, "у мэтча покупателя отсутствует радиус логистики");
            assertMCS.notEquals(matchFullCard.getMatchBuyLogisticRadius(), "", "у мэтча покупателя отсутствует радиус логистики");
        } else {

            // assertMCS.equals(matchFullCard.getMatchBuyLogisticIsPossible(), null, "у мэтча отсутствует");
            assertMCS.equals(matchFullCard.getMatchBuyLogisticPrice(), null, "у мэтча покупателя не должно быть цены логистики");
            assertMCS.equals(matchFullCard.getMatchBuyLogisticRadius(), null, "у мэтча покупателя не должно быть радиуса логистики");

        }

        if (matchFullCard.getMatchSellLogisticIsPossible() != null) {


            assertMCS.notEquals(matchFullCard.getMatchSellLogisticIsPossible(), null, "у мэтча продавца отсутствует возможность логистики");
            assertMCS.notEquals(matchFullCard.getMatchSellLogisticIsPossible(), "", "у мэтча продавца отсутствует возможность логистики");

            assertMCS.notEquals(matchFullCard.getMatchSellLogisticPrice(), null, "у мэтча продавца отсутствует цена логистики");
            assertMCS.notEquals(matchFullCard.getMatchSellLogisticPrice(), "", "у мэтча продавца отсутствует цена логистики");

            assertMCS.notEquals(matchFullCard.getMatchSellLogisticRadius(), null, "у мэтча продавца отсутствует радиус логистики");
            assertMCS.notEquals(matchFullCard.getMatchSellLogisticRadius(), "", "у мэтча продавца отсутствует радиус логистики");
        } else {

            assertMCS.equals(matchFullCard.getMatchSellLogisticPrice(), null, "у мэтча продавца не должно быть цены логистики");
            assertMCS.equals(matchFullCard.getMatchSellLogisticRadius(), null, "у мэтча продавца не должно быть радиуса логистики");


        }
        // не у всех есть эта графа

//        assertMCS.notEquals(matchFullCard.getMatchBuyLogisticPrice(), null, "у мэтча отсутствует");
//        assertMCS.notEquals(matchFullCard.getMatchBuyLogisticPrice(), "", "у мэтча отсутствует");
//        assertMCS.notEquals(matchFullCard.getMatchSellLogisticPrice(), null, "у мэтча отсутствует");
//        assertMCS.notEquals(matchFullCard.getMatchSellLogisticPrice(), "", "у мэтча отсутствует");

        // не у всех есть эта графа

//        assertMCS.notEquals(matchFullCard.getMatchBuyLogisticRadius(), null, "у мэтча отсутствует");
//        assertMCS.notEquals(matchFullCard.getMatchBuyLogisticRadius(), "", "у мэтча отсутствует");
//        assertMCS.notEquals(matchFullCard.getMatchSellLogisticRadius(), null, "у мэтча отсутствует");
//        assertMCS.notEquals(matchFullCard.getMatchSellLogisticRadius(), "", "у мэтча отсутствует");

        assertMCS.notEquals(matchFullCard.getMatchBuyPriseCondition(), null, "у мэтча покупателя отсутствует");
        assertMCS.notEquals(matchFullCard.getMatchBuyPriseCondition(), "", "у мэтча покупателя отсутствует");
        assertMCS.notEquals(matchFullCard.getMatchSellPriseCondition(), null, "у мэтча продавца отсутствует");
        assertMCS.notEquals(matchFullCard.getMatchSellPriseCondition(), "", "у мэтча продавца отсутствует");

        assertMCS.notEquals(matchFullCard.getMatchBuyDate(), null, "у мэтча покупателя отсутствует дата публикации заявки на покупку");
        assertMCS.notEquals(matchFullCard.getMatchBuyDate(), "", "у мэтча покупателя отсутствует дата публикации заявки на покупку");
        assertMCS.notEquals(matchFullCard.getMatchSellDate(), null, "у мэтча продавца отсутствует дата публикации заявки на продажу");
        assertMCS.notEquals(matchFullCard.getMatchSellDate(), "", "у мэтча продавца отсутствует дата публикации заявки на продажу");


        assertMCS.notEquals(matchFullCard.getMatchBuyUser(), null, "у мэтча покупателя отсутствует");
        assertMCS.notEquals(matchFullCard.getMatchBuyUser(), "", "у мэтча покупателя отсутствует");
        assertMCS.notEquals(matchFullCard.getMatchSellUser(), null, "у мэтча продавца отсутствует");
        assertMCS.notEquals(matchFullCard.getMatchSellUser(), "", "у мэтча продавца отсутствует");


        assertMCS.notEquals(matchFullCard.getMatchBuyPhoneNumber(), null, "у мэтча покупателя отсутствует");
        assertMCS.notEquals(matchFullCard.getMatchBuyPhoneNumber(), "", "у мэтча покупателя отсутствует");
        assertMCS.notEquals(matchFullCard.getMatchSellPhoneNumber(), null, "у мэтча продавца отсутствует");
        assertMCS.notEquals(matchFullCard.getMatchSellPhoneNumber(), "", "у мэтча продавца отсутствует");


        assertMCS.notEquals(matchFullCard.getMatchBuyCompany(), null, "у мэтча покупателя отсутствует название покупающей компании");
        assertMCS.notEquals(matchFullCard.getMatchBuyCompany(), "", "у мэтча покупателя отсутствует название покупающей компании");
        assertMCS.notEquals(matchFullCard.getMatchSellCompany(), null, "у мэтча продавца отсутствует название продающей компании");
        assertMCS.notEquals(matchFullCard.getMatchSellCompany(), "", "у мэтча продавца  отсутствует название продающей компании");


        assertMCS.notEquals(matchFullCard.getMatchBuyInn(), null, "у мэтча покупателя отсутствует");
        assertMCS.notEquals(matchFullCard.getMatchBuyInn(), "", "у мэтча покупателя отсутствует");
        assertMCS.notEquals(matchFullCard.getMatchSellInn(), null, "у мэтча продавца отсутствует");
        assertMCS.notEquals(matchFullCard.getMatchSellInn(), "", "у мэтча продавца отсутствует");


        assertMCS.notEquals(matchFullCard.getMatchBuyNds(), null, "у мэтча покупателя отсутствует");
        assertMCS.notEquals(matchFullCard.getMatchBuyNds(), "", "у мэтча покупателя отсутствует");
        assertMCS.notEquals(matchFullCard.getMatchSellNds(), null, "у мэтча продавца отсутствует");
        assertMCS.notEquals(matchFullCard.getMatchSellNds(), "", "у мэтча продавца отсутствует");

        //assertMCS.notEquals(matchFullCard.getMatchCommentField(), null, "поле комментария метча отсутствует");
        assertMCS.notEquals(web_a.isPresent(matchFullCard.getMatchCommentField()), null, "поле комментария метча отсутствует на странице");

      // assertMCS.notEquals(matchFullCard.getMatchBuyComment(), null, "поле комментария заявки на покупку отсутствует");
        assertMCS.notEquals(web_a.isPresent(matchFullCard.getMatchBuyComment()), null, "поле комментария заявки на покупку отсутствует");

       // assertMCS.notEquals(matchFullCard.getMatchSellComment(), null, "поле комментария заявки на продажу отсутствует");
        assertMCS.notEquals(web_a.isPresent(matchFullCard.getMatchSellComment()), null, "поле комментария заявки на продажу отсутствует");
    }
}



