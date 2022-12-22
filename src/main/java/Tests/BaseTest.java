package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BaseTest {

    public WebDriver driver = get_driver();

    private WebDriver get_driver() {
        System.setProperty("webdriver.chrome.driver",
                "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://sheltered-mesa-19374.herokuapp.com/");
        return driver;
    }

    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
        System.out.println("This is the before test");
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        driver.quit();
    }

}
