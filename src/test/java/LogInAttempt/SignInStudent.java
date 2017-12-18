package LogInAttempt;

import Config.Driver;
import pageUtils.DataProviders_edu;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageFactory.SignIn;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Saolin Pal on 15-11-2017.
 */


public class SignInStudent extends Driver {

    SignIn signIn;

    @BeforeTest
    public void launchBrowser() {

       startDriver("chrome");
       signIn = PageFactory.initElements(driver, SignIn.class);
    }

    @Test(dataProvider = "Authentication",dataProviderClass = DataProviders_edu.class)

    //How to take dynamic parameters using DataProviders
    public void studentSignIn(String Username, String Password,String Q1,String Q2,String Q3,String Q4,String Q5,String Q6,String Q7,String Q8,String Q9,String Q10,String Q11,String Q12,String Q13,String Q14,String Q15,String Q16,String Q17,String Q18,String Q19,String Q20) throws InterruptedException {


        WebDriverWait wait1 = new WebDriverWait(driver, 80);

        Thread.sleep(5000);

        driver.get("https://app.edulastic.com/login#login");

        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        signIn.username.sendKeys(Username);
        signIn.password.sendKeys(Password);
        signIn.loginButton.click();
        new MultiAttempt().setAttempt();
       // new MultiAttempt().setQuestionCount();


        new MultiAttempt().attempt(Q1);
        new MultiAttempt().attempt(Q2);
        new MultiAttempt().attempt(Q3);
        new MultiAttempt().attempt(Q4);
        new MultiAttempt().attempt(Q5);
        new MultiAttempt().attempt(Q6);
        new MultiAttempt().attempt(Q7);
        new MultiAttempt().attempt(Q8);
        new MultiAttempt().attempt(Q9);
        new MultiAttempt().attempt(Q10);
        new MultiAttempt().attempt(Q11);
        new MultiAttempt().attempt(Q12);
        new MultiAttempt().attempt(Q13);
        new MultiAttempt().attempt(Q14);
        new MultiAttempt().attempt(Q15);
        new MultiAttempt().attempt(Q16);
        new MultiAttempt().attempt(Q17);
        new MultiAttempt().attempt(Q18);
        new MultiAttempt().attempt(Q19);
        new MultiAttempt().attempt(Q20);

        new MultiAttempt().submit();





    }
}
