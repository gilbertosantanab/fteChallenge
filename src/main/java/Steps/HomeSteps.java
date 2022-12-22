package Steps;

import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomeSteps extends BaseSteps {

    HomePage homePage = PageFactory.initElements(webDriver, HomePage.class);

    public HomeSteps(WebDriver webDriver) {
        super(webDriver);
    }


    public void goToNewPost() throws InterruptedException {
        Thread.sleep(1500);
        homePage.getNewPost().click();
    }

}
