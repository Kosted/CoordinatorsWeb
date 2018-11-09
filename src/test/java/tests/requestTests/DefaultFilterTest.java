package tests.requestTests;

import helperClasses.request.ShortRequestCard;
import org.junit.Test;
import superClasses.SuperTest;

//@Category(UnitTest.class)
public class DefaultFilterTest extends SuperTest {


    public DefaultFilterTest() {
        super(web_a);
    }

    @Test
    public void defaultFilterButtonTest() {

        logIn("9000001000", "N12345678");


        ShortRequestCard defaultShortRequestCard = requestPage.getShortRequestCard(0);

        String defaultCulture = defaultShortRequestCard.getCulture();

        for (int numFilter = 0; numFilter < 2; numFilter++) {

            String filter = requestPage.chooseFilter(numFilter);
            if (!filter.equals(defaultCulture)) {

                ShortRequestCard newShortRequestCard = requestPage.getShortRequestCard(0);

                requestPage.clickOnDefaultFilterButton();

                if (!defaultShortRequestCard.equals(newShortRequestCard))
                    assertMCS.equals(defaultShortRequestCard, requestPage.getShortRequestCard(0), "при нажатии кнопки все заявки, фильтр не вернунлся в исходное положение \n было");

            }


        }

//        System.out.println( "\n " + matchCard.toString());
    }

    @Test
    public void defaultFilterBackButtonTest() {

        //logIn("9000001000", "N12345678");


        ShortRequestCard defaultShortRequestCard = requestPage.getShortRequestCard(0);

        String defaultCulture = defaultShortRequestCard.getCulture();

        for (int numFilter = 0; numFilter < 26; numFilter++) {
//        for (int numFilter = 13; numFilter < 26; numFilter++) {

            String filter = requestPage.chooseFilter(numFilter);
            if (!filter.equals(defaultCulture)) {

                ShortRequestCard newShortRequestCard = requestPage.getShortRequestCard(0);

                requestPage.clickOnBackToDefaultFilterButton();
                if (!defaultShortRequestCard.equals(newShortRequestCard))
                    assertMCS.equals(defaultShortRequestCard, requestPage.getShortRequestCard(0), "при нажатии стрелки ко всем заявкам, фильтр не вернунлся в исходное положение ");

            }


        }

//        System.out.println( "\n " + matchCard.toString());
    }

}

