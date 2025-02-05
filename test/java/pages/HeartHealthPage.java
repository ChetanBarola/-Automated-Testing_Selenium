package pages;

import java.io.IOException;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.HeartHealthPageLocator;
import utils.Base;
import utils.ExcelReader;
import utils.LoggerHandler;
import utils.Reporter;
import utils.Screenshot;
import utils.WebDriverHelper;

public class HeartHealthPage {
    WebDriverHelper webDriverHelper = new WebDriverHelper(Base.driver);
    ExcelReader excelReader = new ExcelReader();

    /*
        Method Name: setMin
        Author Name: Kirtik Biswas
        Description: Sets the minimum value in the Heart Health page filter using data from excel
        Return Type: void
        Parameters: None
        Throws: IOException if there is an error reading the excel file 
    */
    public void setMin(ExtentTest test){
        try{
            webDriverHelper.clickOnElement(HeartHealthPageLocator.minimumBox);
            LoggerHandler.info("Clicked on heart health");
            test.log(Status.PASS, "Clicked on heart health");

            String data = excelReader.readdata("./testdata/data.xlsx", "Sheet1", 2, 0);
            webDriverHelper.sendKeys(HeartHealthPageLocator.minimum, data);
            LoggerHandler.info("Exccel data retrieved");
            test.log(Status.PASS, "Exccel data retrieved");

            webDriverHelper.enterAction(HeartHealthPageLocator.minimum);
            LoggerHandler.info("Set the minimum price ");
            test.log(Status.PASS, "Set the minimum price");
        }
        catch(IOException e){
            LoggerHandler.error("Couldn't read the excel file "+ e.getMessage());
            test.log(Status.FAIL, "Couldn't read the excel file");
        }
    }

    /*
        Method Name: verifyFilter
        Author Name: Kirtik Biswas
        Description: Verifies that the filter is set to "Heart Health" and captures a screenshot
        Return Type: void
        Parameters: ExtentTest test
    */

    public void verifyFilter(ExtentTest test) {
        try{
            String filter = webDriverHelper.getText(HeartHealthPageLocator.filter);
            String compare = "Heart Health";
            Assert.assertEquals(filter, compare);

            Screenshot.captureScreenshot("heart_health");
            test.log(Status.PASS, "Verified filter as Heart Health");
            LoggerHandler.info("Verified filter as Heart Health");
            Reporter.attachScreenshotToReport("heart_health", test, "heart_health");
        }
        catch(Exception e){
            LoggerHandler.warn("Assertion Failed "+ e.getMessage());
            test.log(Status.FAIL, "Assertion Failed");
        }
    }
}
