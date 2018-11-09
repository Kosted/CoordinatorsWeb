package tests.metchesTests;

import org.junit.Test;
import superClasses.SuperTest;

//@Category(UnitTest.class)
public class PaginationTest extends SuperTest {


    public PaginationTest() {
        super(web_a);
    }

    @Test
    public void pagination() {

        logIn("9000001000", "N12345678");

        requestPage.goToMatches();

        int sizeOfmatches = matchesPage.getMatchListSize();

        web_a.skrollY(1000);

        web_a.skrollY(1000);


        assertMCS.equalsTrue(sizeOfmatches < matchesPage.getMatchListSize(), "новые метчи не прогрузились \n было " + sizeOfmatches + "мэтчей");
    }
}

