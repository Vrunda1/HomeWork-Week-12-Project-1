package utilities;

import browserfactory.BaseTest;
import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends BaseTest {

    //This method will click on Element

    public void clickOnElement(By by){
        WebElement element = driver.findElement(by);
        element.click();
    }
    //This method will get text from element
    public String getTextfromElement(By by){
        return  driver.findElement(by).getText();
    }

    //This method will send text on element
    public void sendTextFromElement(By by,String text){
        driver.findElement(by).sendKeys(text);

    }

    //This method will send text on element
    public void sendTextFromElement(By by){
        driver.findElement(by).clear();

    }
    //select by value from dropdown
    public void selectByValueFromDropDown(By by, String value){
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }
    //This method will select the option by visible text
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
       Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }
    public List<WebElement> listOfWebElementsList(By by){
        return  driver.findElements(by);
    }

    //Mouse Hover
     public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        WebElement menu = driver.findElement(by);
        actions.moveToElement(menu).build().perform();

     }
}

