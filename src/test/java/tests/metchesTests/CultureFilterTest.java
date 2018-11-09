package tests.metchesTests;

import helperClasses.match.MatchShortCard;
import org.junit.Test;
import superClasses.SuperTest;


public class CultureFilterTest extends SuperTest {


    public CultureFilterTest() {
        super(web_a);
    }

    @Test
    public void CultureSort() {

        logIn("9000001000", "N12345678");
        matchesPage.goToMatches();
        for (int i = 0; i < 26; i++) {//26

            String filter = matchesPage.chooseFilter(i);

            int requestListSize = matchesPage.getMatchListSize();

            for (int j = 0; j < requestListSize; j++) {

                MatchShortCard matchShortCard = matchesPage.getMatchCard(j);

                if (matchShortCard != null)
                    assertMCS.equals(filter, matchShortCard.getMatchCulture(), "ошибка в выдаче фильтра по культуре" +"\n проблемный метч" +  matchShortCard.getMetchId());
            }
        }
    }
}

