package pages;

import java.io.IOException;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.BlogsPageLocator;
import utils.Base;
import utils.ExcelReader;
import utils.LoggerHandler;
import utils.Reporter;
import utils.Screenshot;
import utils.WebDriverHelper;

public class BlogsPage {
    WebDriverHelper webDriverHelper = new WebDriverHelper(Base.driver);
    ExcelReader excelReader = new ExcelReader();

    /*
        Method Name: clickBlog
        Author: Kirtik Biswas
        Description: Clicks on the blog section of the page
        Return Type: void
        Parameters: ExtentTtest test
    */

    public void clickBlog(ExtentTest test) {
        try{
            webDriverHelper.clickOnElement(BlogsPageLocator.blogs);

            LoggerHandler.info("clicked on blogs");
            test.log(Status.PASS, "clicked on blogs");
        }
        catch(Exception e){
            LoggerHandler.error("Couldn't click on blogs");
            test.log(Status.FAIL, "Couldn't click on blogs");
        }
    }

    /*
        Method Name: clickRegister
        Author: Kirtik Biswas
        Description: Hovers over the register element and clicks on it
        Return Type: void
        Parameters: ExtentTtest test
    */

    public void clickRegister(ExtentTest test){
        try{
            Thread.sleep(2000);
            webDriverHelper.hoverOverElement(BlogsPageLocator.register);
            LoggerHandler.info("Scrolled to register");

            Thread.sleep(2000);
            webDriverHelper.clickOnElement(BlogsPageLocator.register);

            LoggerHandler.info("clicked on register");
            test.log(Status.PASS, "clicked on register");
        }
        catch(Exception e){
            LoggerHandler.error("Click Interrupted "+ e.getMessage());
            test.log(Status.FAIL, "Couldn't click on register");
        }
    }

    /*
        Method Name: sendName
        Author: Kirtik Biswas
        Description: Reads name from the excel file and sends it to the name input field
        Return Type: void
        Parameters: ExtentTtest test
    */

    public void sendName(ExtentTest test){
        try{
            String name = excelReader.readdata("/home/coder/project/workspace/Project/testdata/data.xlsx", "Sheet1", 0, 0);
            webDriverHelper.sendKeys(BlogsPageLocator.name, name);

            LoggerHandler.logger.info("retrieved name from excel file");
            test.log(Status.PASS, "retrieved name from excel file");
        }
        catch(IOException e){
            LoggerHandler.error("File not found "+ e.getMessage());
            test.log(Status.FAIL, "File not found");
        }
    }

    /*
        Method Name: sendNumber
        Author: Kirtik Biswas
        Description: Fills in the number input field with a predefined number
        Return Type: void
        Parameters: ExtentTtest test
    */

    public void sendNumber(ExtentTest test) {
        try{
            webDriverHelper.clickOnElement(BlogsPageLocator.number);
            LoggerHandler.logger.info("Clicked on blogs");
            test.log(Status.PASS, "Clicked on blogs");
            
            webDriverHelper.clearInputBox(BlogsPageLocator.number);
            LoggerHandler.logger.info("Input box for mobile number cleared");
            test.log(Status.PASS, "Input box for mobile number cleared");

            webDriverHelper.sendKeys(BlogsPageLocator.number, "91 9876543211");
            LoggerHandler.logger.info("Mobile number entered");

            test.log(Status.PASS, "filled all details");
        }
        catch(Exception e){
            LoggerHandler.error("Blogs not found "+ e.getMessage());
            test.log(Status.FAIL, "Blogs not found");
        }
    }

    /*
        Method Name: clickSubmit
        Author: Kirtik Biswas
        Description: Clicks the submit button
        Return Type: void
        Parameters: ExtentTtest test
    */

    public void clickSubmit(ExtentTest test) {
        try{
            webDriverHelper.clickOnElement(BlogsPageLocator.submit);
            LoggerHandler.info("click on Submit");
            test.log(Status.PASS, "click on Submit");

            Screenshot.captureScreenshot("arogga_screenshot");
            Reporter.attachScreenshotToReport("arogga_screenshot", test, "arogga_screenshot");
        }
        catch(Exception e){
            LoggerHandler.error("Submit button not found "+ e.getMessage());
            test.log(Status.FAIL, "Submit button not found");
        }
    }
}
