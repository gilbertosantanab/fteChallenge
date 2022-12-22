package Steps;

import Pages.NewPostPage;
import Tests.CustomAsserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class NewPostSteps extends BaseSteps {
    NewPostPage newPostPage = PageFactory.initElements(webDriver, NewPostPage.class);

    public NewPostSteps(WebDriver webDriver) {
        super(webDriver);
    }

    private String title = "Hello everyone!!!";

    private String subTitle = "I hope you are doing great";

    private String body = "I am working on my challenge";

    private String alert = "Please fill out this field.";

    public String alertPop() {
        return alert;
    }

    public String postBody() {
        return body;
    }

    public String postSubtitle() {
        return subTitle;
    }

    public String postTitle() {
        return title;
    }

    public void createNewPost() throws InterruptedException {
        String title = postTitle();
        String subtitle = postSubtitle();
        String body = postBody();
        newPostPage.getTitle().sendKeys(title);
        Thread.sleep(1500);
        newPostPage.getSubtitle().sendKeys(subtitle);
        Thread.sleep(1500);
        newPostPage.getBody().sendKeys(body);
        Thread.sleep(1500);
        newPostPage.getCreateBtn().click();
        Thread.sleep(2000);
    }

    public void missTitleOnNewPost() throws InterruptedException {
        String subtitle = "Im gonna miss the title";
        String body = "It should alert that I need a title";
        Thread.sleep(1000);
        newPostPage.getSubtitle().sendKeys(subtitle);
        Thread.sleep(1500);
        newPostPage.getBody().sendKeys(body);
        Thread.sleep(1500);
        newPostPage.getCreateBtn().click();
        checkMissingTitleAlert();
        Thread.sleep(3000);
    }

    public void missSubtitleOnNewPost() throws InterruptedException {
        String title = "Im gonna miss the subtitle";
        String body = "It should alert that I need a subtitle";
        newPostPage.getTitle().sendKeys(title);
        Thread.sleep(1500);
        newPostPage.getBody().sendKeys(body);
        Thread.sleep(1500);
        newPostPage.getCreateBtn().click();
        checkMissingSubtitleAlert();
        Thread.sleep(3000);
    }

    public void checkMissingTitleAlert() {
        String required = alertPop();
        String popUpMessage = webDriver.findElement(By.name("title")).getAttribute("validationMessage");
        CustomAsserts.isTextEqual(required, popUpMessage);
    }

    public void checkMissingSubtitleAlert() {
        String required = alertPop();
        String popUpMessage = webDriver.findElement(By.name("subtitle")).getAttribute("validationMessage");
        CustomAsserts.isTextEqual(required, popUpMessage);
    }


    public void checkRedirectToPostPage() {
        String webTitle = postTitle();
        CustomAsserts.isTextEqual(webDriver.getTitle(), webTitle);
    }


}
