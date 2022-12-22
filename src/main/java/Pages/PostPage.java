package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PostPage extends BasePage{

    public PostPage(WebDriver webDriver){
        super(webDriver);
    }

    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/h1[1]")
    private WebElement postTitle;

    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/h5[1]")
    private WebElement postSubtitle;

    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/p[1]")
    private WebElement postBody;

    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/small[1]")
    private WebElement postUser_date;

    public WebElement getPostTitle() {
        return postTitle;
    }

    public WebElement getPostSubtitle() {
        return postSubtitle;
    }

    public WebElement getPostBody() {
        return postBody;
    }

    public WebElement getPostUser_date() {
        return postUser_date;
    }

}
