package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {

    public HomePage(WebDriver webDriver) { super(webDriver); }

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'New Post')]")
    private WebElement newPost;

    public WebElement getNewPost() {
        return newPost;
    }

}
