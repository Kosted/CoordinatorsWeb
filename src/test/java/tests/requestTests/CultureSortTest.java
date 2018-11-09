package tests.requestTests;

import helperClasses.request.ShortRequestCard;
import org.junit.Test;
import superClasses.SuperTest;

//@Category(UnitTest.class)
public class CultureSortTest extends SuperTest {


    public CultureSortTest() {
        super(web_a);
    }

    @Test
    public void CultureSort() {

        logIn("9000001000", "N12345678");

        for (int i = 0; i < 26; i++) {//26

            String filter = requestPage.chooseFilter(i);

//            web_a.skrollY(1000);
//            web_a.skrollY(1000);

            int requestListSize = requestPage.getRequestListSize();

            for (int j = 0; j < requestListSize; j++) {

                ShortRequestCard shortRequestCard = requestPage.getShortRequestCard(j);

                if (shortRequestCard != null)
                    assertMCS.equals(filter, shortRequestCard.getCulture(), "ошибка в выдаче фильтра по культуре");
            }
        }
    }
}

