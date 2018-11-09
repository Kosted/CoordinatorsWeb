package tests.metchesTests;

import superClasses.SuperTest;

//@Category(UnitTest.class)
public class SearchTest extends SuperTest {


    public SearchTest() {
        super(web_a);
    }

    //@Test
    public void pagination() {

        logIn("9000001000", "N12345678");

        requestPage.goToMatches();

        int i = 1;
        while (matchesPage.getMatchCard(0).getMetchId().equals(matchesPage.getMatchCard(i)))
            i++;

        String searchRequest =  matchesPage.inputSearchText(matchesPage.getMatchCard(i).getMetchId());
        matchesPage.clickOnSearchButton();

        assertMCS.equals(matchesPage.getMatchCard(0).getMetchId(),searchRequest,"");

    }
}

