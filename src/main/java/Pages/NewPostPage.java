package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NewPostPage extends BasePage {

    public NewPostPage(WebDriver webDriver){
        super(webDriver);
    }

    @FindBy(how = How.NAME, using = "title")
    private WebElement title;

    @FindBy(how = How.NAME, using = "subtitle")
    private WebElement subtitle;

    @FindBy(how = How.NAME, using = "body")
    private WebElement body;

    @FindBy(how = How.XPATH, using = "//body/div[1]/div[1]/div[2]/form[1]/input[2]")
    private WebElement createBtn;



    public WebElement getTitle() {
        return title;
    }

    public WebElement getSubtitle() {
        return subtitle;
    }

    public WebElement getBody() {
        return body;
    }

    public WebElement getCreateBtn() {
        return createBtn;
    }

}
