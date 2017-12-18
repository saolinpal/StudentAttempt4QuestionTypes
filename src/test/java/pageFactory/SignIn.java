package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Ila Pandey on 15-11-2017.
 */
public class SignIn {

    @FindBy(id="login-email")
    public WebElement username;

    @FindBy(id="login-password")
    public WebElement password;

    @FindBy(id="signIn")
    public WebElement loginButton;
}
