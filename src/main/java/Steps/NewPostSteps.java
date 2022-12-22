package Steps;

import Pages.NewPostPage;
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

    public boolean checkMissingTitleAlert() {
        String required = alertPop();
        String popUpMessage = webDriver.findElement(By.name("title")).getAttribute("validationMessage");
        if(required.equals(popUpMessage)) {
            System.out.println("The 'Please fill out this field.' message appeared in title field.");
            return true;
        } else {
            System.out.println("The 'Please fill out this field.' message did NOT appeared in title field. ");
            return false;
        }
    }

    public boolean checkMissingSubtitleAlert() {
        String required = alertPop();
        String popUpMessage = webDriver.findElement(By.name("subtitle")).getAttribute("validationMessage");
        if(required.equals(popUpMessage)) {
            System.out.println("The 'Please fill out this field.' message appeared in Subtitle field.");
            return true;
        } else {
            System.out.println("The 'Please fill out this field.' message did NOT appeared in Subtitle field.");
            return false;
        }
        }


    public boolean checkRedirectToPostPage() {
        String webTitle = postTitle();
        if(webDriver.getTitle().equals(webTitle)) {
            System.out.println("Redirected to post page");
            return true;
        } else {
            System.out.println("Not redirected to post page");
            return false;
        }
    }


}
