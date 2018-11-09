package tests.metchesTests;

import helperClasses.match.MatchShortCard;
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
        requestPage.goToMatches();

        MatchShortCard defaultMatchShortCard = matchesPage.getMatchCard(0);

        String defaultCulture = defaultMatchShortCard.getMatchCulture();

        for (int numFilter = 0; numFilter < 26; numFilter++) {

            String filter = matchesPage.chooseFilter(numFilter);
            if (!filter.equals(defaultCulture)) {

                MatchShortCard newMatchShortCard = matchesPage.getMatchCard(0);

                matchesPage.clickOnDefaultFilterButton();
                if (!defaultMatchShortCard.equals(newMatchShortCard)) {
                    assertMCS.equals(defaultMatchShortCard, matchesPage.getMatchCard(0), "при нажатии кнопки все мэтчи, фильтр не вернунлся в исходное положение ");
                }

            }


        }

//        System.out.println( "\n " + matchCard.toString());
    }

    @Test
    public void defaultFilterBackButtonTest() {

        // logIn("9000001000", "N12345678");


        MatchShortCard defaultMatchShortCard = matchesPage.getMatchCard(0);

        String defaultCulture = defaultMatchShortCard.getMatchCulture();

        for (int numFilter = 0; numFilter < 26; numFilter++) {

            String filter = matchesPage.chooseFilter(numFilter);
            if (!filter.equals(defaultCulture)) {

                MatchShortCard newMatchShortCard = matchesPage.getMatchCard(0);

                matchesPage.clickOnBackToDefaultFilterButton();
                if (!defaultMatchShortCard.equals(newMatchShortCard))
                    assertMCS.equals(defaultMatchShortCard, matchesPage.getMatchCard(0), "при нажатии кнопки назад ко всем метчам, фильтр не вернунлся в исходное положение ");

            }


        }

//        System.out.println( "\n " + matchCard.toString());
    }

}

