package tests.requestTests;

import helperClasses.request.ShortRequestCard;
import org.junit.Test;
import superClasses.SuperTest;

//@Category(UnitTest.class)
public class CancelSearchFilterTest extends SuperTest {


    public CancelSearchFilterTest() {
        super(web_a);
    }

    @Test
    public void cancelSearchFilterTest() {

        logIn("9000001000", "N12345678");

        ShortRequestCard defaultShortRequestCard = requestPage.getShortRequestCard(0);

        requestPage.inputSearchText("Россия, Самарская область, Хворостянский район, село Хворостянка");
        requestPage.clickOnSearchOptions(0);

        ShortRequestCard newShortRequestCard = requestPage.getShortRequestCard(0);

        assertMCS.equals(newShortRequestCard.getId(),defaultShortRequestCard.getId(),"после ввода адреса первая карточка измнилась, дальнейшая проверка не возможна");
        assertMCS.equals(defaultShortRequestCard.getRange(),null,"у первой карточки имеется удаленость, дальнейшая проверка невозможна");

        if (newShortRequestCard.getRange()==null) {
            assertMCS.notEquals(newShortRequestCard.getRange(),null,"при вводе адреса не появилась удаленность, дальнейшая проверка не возможна");
        }else
        assertMCS.notEquals(newShortRequestCard.getRange(),"","при вводе адреса не появилась удаленность, дальнейшая проверка не возможна");


        requestPage.clickOnCleanSearchFieldButton();

        assertMCS.equals(requestPage.getShortRequestCard(0),defaultShortRequestCard,"после отмены фильтра на адрес, изменилась первая карточка");







//        System.out.println( "\n " + matchCard.toString());
    }
}

