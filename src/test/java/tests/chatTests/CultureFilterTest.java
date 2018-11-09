package tests.chatTests;

import helperClasses.chat.ChatShortCard;
import org.junit.Test;
import superClasses.SuperTest;


public class CultureFilterTest extends SuperTest {


    public CultureFilterTest() {
        super(web_a);
    }

    @Test
    public void сultureFilterTest() {

        logIn("9000001000", "N12345678");
        requestPage.goToChat();
        for (int i = 0; i < 26; i++) {//26

            String filter = chatPage.chooseFilter(i);

            int requestListSize = chatPage.getChatListSize();

            for (int j = 0; j < requestListSize; j++) {

                ChatShortCard chatShortCard = chatPage.getChatShortCard(j);

                if (chatShortCard != null)
                    assertMCS.equals(filter, chatShortCard.getChatCulture(), "ошибка в выдаче фильтра по культуре" +"\n проблемный метч" +  chatShortCard.getChatId());
            }
        }
    }
}

