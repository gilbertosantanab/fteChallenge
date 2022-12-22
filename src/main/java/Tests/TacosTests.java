package Tests;

import Steps.HomeSteps;
import Steps.LoginSteps;
import Steps.NewPostSteps;
import Steps.PostSteps;
import org.testng.annotations.Test;

public class TacosTests extends BaseTest {

    LoginSteps loginSteps = new LoginSteps(driver);
    HomeSteps homeSteps = new HomeSteps(driver);
    NewPostSteps newPostSteps = new NewPostSteps(driver);
    PostSteps postSteps = new PostSteps(driver);


    @Test(description = "Test functionality of creating a new post")
    public void testCreateNewPost() throws InterruptedException {
        loginSteps.logIn();
        homeSteps.goToNewPost();
        newPostSteps.createNewPost();
        newPostSteps.checkRedirectToPostPage();
        postSteps.checkContents();
        postSteps.checkCreatorAndDate();
        Thread.sleep(3000);
    }

    @Test(description = "Test that when creating a new post it requires a title")
    public void testMissingTitleInNewPost() throws InterruptedException {
        loginSteps.logIn();
        homeSteps.goToNewPost();
        newPostSteps.missTitleOnNewPost();
        Thread.sleep(3000);
    }

    @Test(description = "Test that when creating a new post it requires a title")
    public void testMissingSubtitleInNewPost() throws InterruptedException {
        loginSteps.logIn();
        homeSteps.goToNewPost();
        newPostSteps.missSubtitleOnNewPost();
        Thread.sleep(3000);
    }

}
