package tests.requestTests;

import helperClasses.request.ShortRequestCard;
import org.junit.Test;
import superClasses.SuperTest;

//@Category(UnitTest.class)
public class ShortRequestWithAddressContentTest extends SuperTest {


    public ShortRequestWithAddressContentTest() {
        super(web_a);
    }

    @Test
    public void shortRequestWithAddressContentTest() {

        logIn("9000001000", "N12345678");

        requestPage.chooseFilter(0);

        requestPage.inputSearchText("Россия, Самарская область, Хворостянский район, село Хворостянка");

        requestPage.clickOnSearchOptions(0);

        ShortRequestCard shortRequestCard = requestPage.getShortRequestCard(0);

       // assertMCS.equals(shortRequestCard.getContentSize(), 11, "количество полей не соответствует виду краткой карточки \n P.S. последующие ошибки могут не отражать действительности");


        assertMCS.notEquals(shortRequestCard.getCulture(), "", "поле культуры не заполнено");
        assertMCS.notEquals(shortRequestCard.getCulture(), null, "поле культуры не заполнено");

        //assertMCS.equals(shortRequestCard.getPrice(), null, " поле цены должно быть пустым");

        assertMCS.notEquals(shortRequestCard.getActual(), "", "поле актуальность не заполнено");
        assertMCS.notEquals(shortRequestCard.getActual(), null, "поле актуальность не заполнено");

        assertMCS.notEquals(shortRequestCard.getActualDays(), "", "поле количества дней актуальности заявки не заполнено");
        assertMCS.notEquals(shortRequestCard.getActualDays(), null, "поле количества дней актуальности заявки не заполнено");

        assertMCS.notEquals(shortRequestCard.getMainProperty(), "", "поле осносвного свойства не заполнено");
        assertMCS.notEquals(shortRequestCard.getMainProperty(), null, "поле осносвного свойства не заполнено");

        assertMCS.notEquals(shortRequestCard.getVolume(), "", " поле объема не заполнено");
        assertMCS.notEquals(shortRequestCard.getVolume(), null, " поле объема не заполнено");

        assertMCS.notEquals(shortRequestCard.getRange(), "", " поле расстояния не должно быть пустым");
        assertMCS.notEquals(shortRequestCard.getRange(), null, " поле расстояния не должно быть пустым");

        assertMCS.notEquals(shortRequestCard.getPriceWithoutLogistic(), "", "поле цены без логистики не заполнено");
        assertMCS.notEquals(shortRequestCard.getPriceWithoutLogistic(), null, "поле цены без логистики не заполнено");

        assertMCS.notEquals(shortRequestCard.getDate(), "", "поле даты не заполнено");
        assertMCS.notEquals(shortRequestCard.getDate(), null, "поле даты не заполнено");

        assertMCS.notEquals(shortRequestCard.getId(), "", "поле ID не заполнено");
        assertMCS.notEquals(shortRequestCard.getId(), null, "поле ID не заполнено");

        assertMCS.notEquals(shortRequestCard.getUser(), "", "поле ФИО не заполнено");
        assertMCS.notEquals(shortRequestCard.getUser(), null, "поле ФИО не заполнено");


        assertMCS.notEquals(shortRequestCard.getPhoneNumber(), "", "поле мобильного телефона не заполнено");
        assertMCS.notEquals(shortRequestCard.getPhoneNumber(), null, "поле мобильного телефона не заполнено");
        assertMCS.notEquals(shortRequestCard.getCompany(), "", "поле названия компании не заполнено");
        assertMCS.notEquals(shortRequestCard.getCompany(), null, "поле названия компании не заполнено");
        assertMCS.notEquals(shortRequestCard.getInn(), "", "поле ИНН не заполнено");
        assertMCS.notEquals(shortRequestCard.getInn(), null, "поле ИНН не заполнено");
        assertMCS.notEquals(shortRequestCard.getNds(), "", "поле НДС не заполнено");
        assertMCS.notEquals(shortRequestCard.getNds(), null, "поле НДС не заполнено");

System.out.println(shortRequestCard.toString());
    }
}


