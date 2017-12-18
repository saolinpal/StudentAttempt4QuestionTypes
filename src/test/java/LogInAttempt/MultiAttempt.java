package LogInAttempt;

import Config.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageFactory.GoToAssignment;
import pageUtils.DataProviders_edu;
import pageUtils.ExcelInputs;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ila Pandey on 15-11-2017.
 */

public class MultiAttempt extends Driver {

    GoToAssignment goToAssignment;



    @Test(dataProvider = "Authentication", dataProviderClass = DataProviders_edu.class)
    public void setAttempt() throws InterruptedException {

        Thread.sleep(10000);
        goToAssignment = PageFactory.initElements(driver, GoToAssignment.class);
        WebDriverWait wait = new WebDriverWait(driver, 60);

        //clicking Assignments tab after logging in
        wait.until(ExpectedConditions.elementToBeClickable(goToAssignment.assignment));
        goToAssignment.assignment.click();

        //clicking the NOT OPEN Filter
        wait.until(ExpectedConditions.elementToBeClickable(goToAssignment.notOpen));
        goToAssignment.notOpen.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.className("assignment-card-header")));
        //Reading Assessment Names under Not Open Filter
        List<WebElement> assignmentName = driver.findElements(By.className("assignment-card-header"));
        //Storing Start Buttons
        Thread.sleep(5000);
        List<WebElement> startButton = driver.findElements(By.cssSelector(".create-practice-button>a"));

        //Clicking on the Correct Assignment Name and Click the Corresponding Start Button

        for (int j = 0; j < assignmentName.size(); j++) {
            String name = assignmentName.get(j).getText();
            if (name.contains("CorrectOrNot")) {
                System.out.print(name);
                Thread.sleep(5000);
                startButton.get(j).click();
                wait.until(ExpectedConditions.elementToBeClickable(goToAssignment.fullpage));
                break;
            } else {
                System.out.println("Assignment Not Found");

            }
        }

    }




    //How to take dynamic parameters using DataProviders
    public void attempt(String choice) throws InterruptedException {




        goToAssignment = PageFactory.initElements(driver, GoToAssignment.class);

        WebDriverWait wait = new WebDriverWait(driver, 60);

        Thread.sleep(5000);
        List<WebElement> mcq = driver.findElements(By.className("choice-value"));
        System.out.println(mcq);

        Thread.sleep(5000);
        List<WebElement> te = driver.findElements(By.xpath(".//*[@class='visible_redactor_input bg-color-white']"));
        System.out.println(te);

        Thread.sleep(5000);
        List<WebElement> number = driver.findElements(By.xpath("//div[@class='wrs_formulaDisplay wrs_content_box']"));
        System.out.println(number);

        Thread.sleep(5000);
        List<WebElement> Eval = driver.findElements(By.cssSelector(".wrs_formulaDisplay"));
        System.out.println(Eval);





        //Attempt if Question is mcq
        if (mcq.size() > 0)

        {

            driver.findElement(By.xpath("//span[@class='choice-value'][text()='" + choice + "']")).click();
            wait.until(ExpectedConditions.elementToBeClickable(goToAssignment.next));
            goToAssignment.next.click();
            Thread.sleep(5000);

         //Attempt if Question is Text Entry
        } else if (te.size() > 0) {

            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(By.xpath(".//*[@class='visible_redactor_input bg-color-white']")));
            actions.click();

            actions.sendKeys(choice);

            actions.build().perform();
            wait.until(ExpectedConditions.elementToBeClickable(goToAssignment.next));
            goToAssignment.next.click();
            Thread.sleep(3000);

        }
        //Attempt if Question is Numeric
        else if (number.size() > 0) {


            WebElement test = driver.findElement(By.cssSelector(".wrs_formulaDisplay.wrs_content_box"));
            wait.until(ExpectedConditions.elementToBeClickable(test));
            Actions actions = new Actions(driver);
            actions.moveToElement(test);
            actions.click();
            actions.sendKeys(choice);
            actions.build().perform();
            wait.until(ExpectedConditions.elementToBeClickable(goToAssignment.next));
            goToAssignment.next.click();
            Thread.sleep(5000);

        //Attempt if Question is Expression Eval
        } else if (Eval.size() > 0) {

            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(By.cssSelector(".wrs_formulaDisplay")));
            actions.click();
            actions.sendKeys(choice);
            actions.build().perform();
            goToAssignment.next.click();
            Thread.sleep(5000);
        }

    }



    public void submit() throws InterruptedException
    {

        goToAssignment = PageFactory.initElements(driver, GoToAssignment.class);

        WebDriverWait wait = new WebDriverWait(driver, 60);

        wait.until(ExpectedConditions.elementToBeClickable(goToAssignment.submit));
        goToAssignment.submit.click();
        wait.until(ExpectedConditions.elementToBeClickable(goToAssignment.userdropdown));
        goToAssignment.userdropdown.click();
        goToAssignment.studentSignOut.click();


    }
}
