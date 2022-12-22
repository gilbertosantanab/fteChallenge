package Steps;

import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginSteps extends BaseSteps {

    LoginPage loginPage = PageFactory.initElements(webDriver, LoginPage.class);

    public LoginSteps(WebDriver webDriver){
        super(webDriver);
    }

    private String user = "gs24";

    private String pw = "tester123";

    public String typePw() {
        return pw;
    }

    public String typeUser() {
        return user;
    }

    public void logIn() throws InterruptedException {
        String user = typeUser();
        String pass = typePw();
        Thread.sleep(2000);
        loginPage.getUsername().sendKeys(user);
        Thread.sleep(1500);
        loginPage.getPassword().sendKeys(pass);
        Thread.sleep(1500);
        loginPage.getLoginBtn().click();
    }


}
