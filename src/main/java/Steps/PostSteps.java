package Steps;

import Pages.PostPage;
import Tests.CustomAsserts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PostSteps extends BaseSteps {

    PostPage postPage = PageFactory.initElements(webDriver, PostPage.class);

    public PostSteps(WebDriver webDriver) {
        super(webDriver);
    }

    private String user = "gs24";

    private String postTitle = "Hello everyone!!!";

    private String postSubTitle = "I hope you are doing great";

    private String postBody = "I am working on my challenge";

    public String postCreator() {
        return user;
    }

    public String postBody() {
        return postBody;
    }

    public String postSubtitle() {
        return postSubTitle;
    }

    public String postTitle() {
        return postTitle;
    }

    Date today = new Date();
    String pattern = "MMM. dd, yyyy,";
    SimpleDateFormat formatter = new SimpleDateFormat(pattern);

    private String date = formatter.format(today);
    public String getDate() {
        return date;
    }


    public void checkContents() {
        String posTitle = postTitle();
        String postSubtitle = postSubtitle();
        String postBody = postBody();
        CustomAsserts.isTextEqual(posTitle, postPage.getPostTitle().getText());
        CustomAsserts.isTextEqual(postSubtitle, postPage.getPostSubtitle().getText());
        CustomAsserts.isTextEqual(postBody, postPage.getPostBody().getText());
    }

    public void checkCreatorAndDate() {
        String creator = postCreator();
        String date = getDate();
        String str = postPage.getPostUser_date().getText();
        String[] myArr = str.split(" ");
        String showedUser = myArr[2];
        String receivedDate = myArr[5] + " " + myArr[6] + " " + myArr[7];
        CustomAsserts.isTextEqual(creator, showedUser);
        CustomAsserts.isTextEqual(date, receivedDate);
    }



}
