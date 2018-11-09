package tests.requestTests;

import helperClasses.request.FullRequestCard;
import org.junit.Test;
import superClasses.SuperTest;

//@Category(UnitTest.class)
public class FullRequestContentTest extends SuperTest {


    public FullRequestContentTest() {
        super(web_a);
    }

    @Test
    public void fullRequestContentTest() {

        logIn("9000001000", "N12345678");

        requestPage.chooseFilter(0);

        FullRequestCard fullRequestCard = requestPage.getFullRequestCard(2);

        System.out.println(fullRequestCard.toString());

        //
        if (fullRequestCard.getLogisticIsPossible().equals("")){

            assertMCS.equals(fullRequestCard.getContentSize(), 12, "количество полей не соответствует виду полной карточки \n P.S. последующие ошибки могут не отражать действительности");
            assertMCS.equals(fullRequestCard.getLogisticRadius(), "", "поле радиуса логистики должно быть пустым");



        }else {

            assertMCS.equals(fullRequestCard.getContentSize(), 13, "количество полей не соответствует виду полной карточки \n P.S. последующие ошибки могут не отражать действительности");

            assertMCS.notEquals(fullRequestCard.getLogisticIsPossible(), "", "поле возможна ли логистика не заполнено");


        }
        assertMCS.notEquals(fullRequestCard.getLogisticRadius(), null, "поле радиуса логистики не должно быть равно null");


        assertMCS.notEquals(fullRequestCard.getCulture(), "", "поле культуры не заполнено");
        assertMCS.notEquals(fullRequestCard.getCulture(), null, "поле культуры не заполнено");

        assertMCS.notEquals(fullRequestCard.getId(), "", "поле ID не заполнено");
        assertMCS.notEquals(fullRequestCard.getId(), null, "поле ID не заполнено");

        assertMCS.notEquals(fullRequestCard.getVolume(), "", " поле объема не заполнено");
        assertMCS.notEquals(fullRequestCard.getVolume(), null, " поле объема не заполнено");

        assertMCS.notEquals(fullRequestCard.getPrice(), "", " поле цены не заполнено");
        assertMCS.notEquals(fullRequestCard.getPrice(), null, " поле цены не заполнено");

        assertMCS.notEquals(fullRequestCard.getPriceWithLogistic(), "", "поле цены без логистики не заполнено");
        assertMCS.notEquals(fullRequestCard.getPriceWithLogistic(), null, "поле цены без логистики не заполнено");

        assertMCS.equals(fullRequestCard.getRange(), "", "поле расстояния должно быть пустым");
        assertMCS.notEquals(fullRequestCard.getRange(), null, "поле расстояния не должно быть null");

        assertMCS.notEquals(fullRequestCard.getPropertes(),null,"поля свойства не заполнено");

        for (int i =0; i<fullRequestCard.getPropertes().length; i++){
            assertMCS.notEquals(fullRequestCard.getPropertes()[i],"","поле свойства не заполнено");

        }

        assertMCS.notEquals(fullRequestCard.getAddres(), "", "поле адреса не заполнено");
        assertMCS.notEquals(fullRequestCard.getAddres(), null, "поле адреса не заполнено");

        assertMCS.notEquals(fullRequestCard.getLogisticPrice(), "", "поле цены логистики не заполнено");
        assertMCS.notEquals(fullRequestCard.getLogisticPrice(), null, "поле цены логистики не заполнено");

        assertMCS.notEquals(fullRequestCard.getPriseCondition(), "", "поле условия оплаты не заполнено");
        assertMCS.notEquals(fullRequestCard.getPriseCondition(), null, "поле условия оплаты не заполнено");

        assertMCS.notEquals(fullRequestCard.getDate(), "", "поле даты не заполнено");
        assertMCS.notEquals(fullRequestCard.getDate(), null, "поле даты не заполнено");

        assertMCS.notEquals(fullRequestCard.getUser(), "", "поле ФИО не заполнено");
        assertMCS.notEquals(fullRequestCard.getUser(), null, "поле ФИО не заполнено");

        assertMCS.notEquals(fullRequestCard.getPhoneNumber(), "", "поле мобильного телефона не заполнено");
        assertMCS.notEquals(fullRequestCard.getPhoneNumber(), null, "поле мобильного телефона не заполнено");

        assertMCS.notEquals(fullRequestCard.getCompany(), "", "поле названия компании не заполнено");
        assertMCS.notEquals(fullRequestCard.getCompany(), null, "поле названия компании не заполнено");

        assertMCS.notEquals(fullRequestCard.getInn(), "", "поле ИНН не заполнено");
        assertMCS.notEquals(fullRequestCard.getInn(), null, "поле ИНН не заполнено");

        assertMCS.notEquals(fullRequestCard.getNds(), "", "поле НДС не заполнено");
        assertMCS.notEquals(fullRequestCard.getNds(), null, "поле НДС не заполнено");






    }
}


