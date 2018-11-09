package tests.metchesTests;

import pageObjects.MatchesPage;
import superClasses.SuperTest;


public class SwitchStatusTest extends SuperTest {


    public SwitchStatusTest() {
        super(web_a);
    }

    //@Test
    public void SwitchStatusTest() {

        logIn("9000001000", "N12345678");

        matchesPage.goToMatches();


        matchesPage.chooseStatusOfMetch(0, MatchesPage.statusOfMetch.ON_WORK);

        assertMCS.equals(matchesPage.getMatchCard(0).getStatus(), "В работе", "ошибка при выборе статуса метча");

        matchesPage.chooseStatusOfMetch(0, MatchesPage.statusOfMetch.SET_DOWN);

        assertMCS.equals(matchesPage.getMatchCard(0).getStatus(), "Отложено", "ошибка при выборе статуса метча");

        matchesPage.chooseStatusOfMetch(0, MatchesPage.statusOfMetch.NOT_INTERESTING);

        assertMCS.equals(matchesPage.getMatchCard(0).getStatus(), "Нет интереса", "ошибка при выборе статуса метча");

        matchesPage.chooseStatusOfMetch(0, MatchesPage.statusOfMetch.ARCHIVE);

        assertMCS.equals(matchesPage.getMatchCard(0).getStatus(), "Закрыть", "ошибка при выборе статуса метча");

        matchesPage.chooseStatusOfMetch(0, MatchesPage.statusOfMetch.UNDER_CALL);

        assertMCS.equals(matchesPage.getMatchCard(0).getStatus(), "Недозвон", "ошибка при выборе статуса метча");

        matchesPage.chooseStatusOfMetch(0, MatchesPage.statusOfMetch.NEW);

        assertMCS.equals(matchesPage.getMatchCard(0).getStatus(), "Новый", "ошибка при выборе статуса метча");
    }
}


