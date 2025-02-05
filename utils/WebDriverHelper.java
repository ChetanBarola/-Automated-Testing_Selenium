package utils;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverHelper {
    private WebDriver driver;

    /*
        Constructor: WebDriverHelper
        Author: Kirtik Biswas
        Description: Initializes the WebDriverHelper with a WebDriver instance
        Parameters: WebDriver driver
    */
    public WebDriverHelper(WebDriver driver){
        this.driver = driver;
    }

    /*
        Method Name: clickOnElement
        Author: Kirtik Biswas
        Description: Waits for an element to be clickable and performs a click action
        Return Type: void
        Parameters: By locator
    */

    public void clickOnElement(By locator){
        try{
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(locator));
            WebElement webElement = driver.findElement(locator);
            webElement.click();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /*
        Method Name: sendKeys
        Author: Kirtik Biswas
        Description: Waits for an element to be visible and sends keys to it
        Return Type: void
        Parameters: By locator, String data
    */

    public void sendKeys(By locator, String data){
        try{
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(locator));
            WebElement webElement = driver.findElement(locator);
            webElement.sendKeys(data);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /*
        Method Name: getText
        Author: Kirtik Biswas
        Description: Waits for an element to be visible and retrieves its text content
        Return Type: String
        Parameters: By locator
    */

    public String getText(By locator){
        try{
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(locator));
            WebElement webElement = driver.findElement(locator);
            return webElement.getText();
        }
        catch(Exception e){
            e.printStackTrace();
            return " ";
        }
    }

    /*
        Method Name: javascriptScroll
        Author: Kirtik Biswas
        Description: Scrolls to an element using JavaScript
        Return Type: void
        Parameters: By locator
    */

    public void javascriptScroll(By locator){
        try{
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(locator));
            WebElement element = driver.findElement(locator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView()", element);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /*
        Method Name: switchToNewWindow
        Author: Kirtik Biswas
        Description: Switches to a new browser window or tab
        Return Type: void
        Parameters: None
    */

    public void switchToNewWindow(){
        try{
            String currWindowHandle = driver.getWindowHandle();
            Set<String> allwindowHandles = driver.getWindowHandles();
            for(String handle : allwindowHandles){
                if(!currWindowHandle.equals(handle)){
                    driver.switchTo().window(handle);
                    return;
                }
            }
            throw new Exception("New Window could not be retrieved");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /*
        Method Name: enterAction
        Author: Kirtik Biswas
        Description: Presses the ENTER key on an element
        Return Type: void
        Parameters: By locator
    */

    public void enterAction(By locator){
        try{
            WebElement webElement = driver.findElement(locator);
            webElement.sendKeys(Keys.ENTER);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /*
        Method Name: hoverOverElement
        Author: Kirtik Biswas
        Description: Hovers over an element using actions
        Return Type: void
        Parameters: By locator
    */

    public void hoverOverElement(By locator){
        try{
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(locator));
            WebElement webElement = driver.findElement(locator);
            Actions act = new Actions(driver);
            act.moveToElement(webElement).build().perform();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /*
        Method Name: clearInputBox
        Author: Kirtik Biswas
        Description: Clears the text from an input box
        Return Type: void
        Parameters: By locator
    */

    public void clearInputBox(By locator){
        try{
            WebElement webElement = driver.findElement(locator);
            webElement.clear();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}