package tests.metchesTests;

import helperClasses.match.MatchFullCard;
import org.junit.Test;
import superClasses.SuperTest;

//@Category(UnitTest.class)
public class CommentsUpdateTest extends SuperTest {

    public CommentsUpdateTest() {
        super(web_a);
    }

    @Test
    public void commentsUpdateTest() {


        logIn("9000001000", "N12345678");
        matchesPage.goToMatches();


        matchesPage.clickOnMatch(0);
        MatchFullCard fullMatchCard = matchesPage.getFullMatchCard(0);
        assertMCS.setStandartErrorMessege("\nid проблемного метча - "+ fullMatchCard.getMetchId());

        String defoltMatchComment = matchesPage.updateMatchCommentAndReturnValue(fullMatchCard, "", true);
        String defoltMatchBuyComment = matchesPage.updateMatchBuyCommentAndReturnValue(fullMatchCard, "", true);
        String defoltMatchSellComment = matchesPage.updateMatchSellCommentAndReturnValue(fullMatchCard, "", true);

        assertMCS.equals(defoltMatchComment, matchesPage.updateMatchCommentAndReturnValue(fullMatchCard, "", false), "не удалось отчистить коммент к метчу");
        assertMCS.equals(defoltMatchBuyComment, matchesPage.updateMatchBuyCommentAndReturnValue(fullMatchCard, "", false), "не удалось отчистить коммент к заявке на покупку");
        assertMCS.equals(defoltMatchSellComment, matchesPage.updateMatchSellCommentAndReturnValue(fullMatchCard, "", false), "не удалось отчистить коммент к заявке на продажу");

        assertMCS.notEquals(defoltMatchComment, matchesPage.updateMatchCommentAndReturnValue(fullMatchCard, "123", false), "коммент к метчу не изменился ");
        assertMCS.notEquals(defoltMatchBuyComment, matchesPage.updateMatchBuyCommentAndReturnValue(fullMatchCard, "123", false), "коммент не изменился к заявке на покупку");
        assertMCS.notEquals(defoltMatchSellComment, matchesPage.updateMatchSellCommentAndReturnValue(fullMatchCard, "123", false), "коммент не изменился к заявке на продажу");

        defoltMatchComment = matchesPage.updateMatchCommentAndReturnValue(fullMatchCard, "", false);
        defoltMatchBuyComment = matchesPage.updateMatchBuyCommentAndReturnValue(fullMatchCard, "", false);
        defoltMatchSellComment = matchesPage.updateMatchSellCommentAndReturnValue(fullMatchCard, "", false);


        matchesPage.clickOnMatch(1);
        driver.navigate().refresh();

        matchesPage.clickOnMatch(0);
        fullMatchCard = matchesPage.getFullMatchCard(0);

        assertMCS.equals(defoltMatchComment, matchesPage.updateMatchCommentAndReturnValue(fullMatchCard, "", false), "не удалось отчистить коммент к метчу");
        assertMCS.equals(defoltMatchBuyComment, matchesPage.updateMatchBuyCommentAndReturnValue(fullMatchCard, "", false), "не удалось отчистить коммент к заявке на покупку");
        assertMCS.equals(defoltMatchSellComment, matchesPage.updateMatchSellCommentAndReturnValue(fullMatchCard, "", false), "не удалось отчистить коммент к заявке на продажу");


    }
}
