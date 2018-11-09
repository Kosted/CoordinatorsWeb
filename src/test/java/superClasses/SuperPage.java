package superClasses;

import helperClasses.WebActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public abstract class SuperPage {

    protected WebDriver driver;
    protected WebActions web_a;
    protected String standartPageLink;
    protected String currentPageLink;

    public SuperPage(WebActions web_a) {
        this.web_a = web_a;
        driver = web_a.getDriver();

        standartPageLink = "http://dev.agroclub-coordinator.spider.ru"; //dev
        //standartPageLink = "http://stage.agroclub-coordinator.id-east.ru"; // stage

        PageFactory.initElements(driver, this);

    }

    public boolean isCurrentPage() {
        for (int i =0; i<300; i++)
        try {
            sleep(100);
            if (currentPageLink.equals(driver.getCurrentUrl()))
            return true;

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


return false;

    }


}
