package tests;

import helperClasses.chat.ChatFullCard;
import helperClasses.chat.ChatShortCard;
import org.junit.Test;
import superClasses.SuperTest;

//@Category(UnitTest.class)
public class TestTestTest extends SuperTest {

    public TestTestTest() {
        super(web_a);
    }

    @Test
    public void testtest() {

        logIn("9000001000", "N12345678");
        requestPage.goToChat();

        ChatShortCard chatShortCard = chatPage.getChatShortCard(1);
        chatPage.chooseFilter(3);
        chatPage.clickOnChat(0);
        ChatFullCard chatFullCard = chatPage.getChatFullCard(0);

        //    System.out.println(": "+ driver.manage().window().getPosition());

    }
}
