package Config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ila Pandey on 15-11-2017.
 */
public class Driver {

    public static WebDriver driver;

    public static WebDriver startDriver(String browser) {



        if(browser.equalsIgnoreCase("Chrome")){


            System.setProperty("webdriver.chrome.driver", "C://Users/Ila Pandey/AutomationRelated/chromedriver_win32/chromedriver.exe");
            driver= new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

            driver.manage().window().maximize();


        }else if(browser.equals("Firefox")){

            driver=new FirefoxDriver();
            driver.manage().window().maximize();
        }
        return driver;

    }
}
