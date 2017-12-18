package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Ila Pandey on 16-11-2017.
 */
public class GoToAssignment {

    @FindBy(css = "#assignment>a")
    public WebElement assignment;

    @FindBy(xpath = "//div[@class='slider-viewport'][contains(text(),'Question')]")
    public WebElement questioncount;

    @FindBy(css = ".gray-count.not-open")
    public WebElement notOpen;

    @FindBy(xpath = "//div[@id='dnd-question-preview']")
    public WebElement fullpage;

    @FindBy(xpath="//span[@id = 'as-take-next-question']")
    public WebElement next;

    @FindBy(xpath = "//span[text()='Submit']")
    public WebElement submit;

    @FindBy(css="#user-drop")
    public WebElement userdropdown;

    @FindBy(css = "#signout")
    public WebElement studentSignOut;
}
