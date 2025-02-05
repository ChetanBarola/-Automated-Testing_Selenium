package pages;

import utils.WebDriverHelper;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.TermsAndConditionsLocator;
import utils.Base;
import utils.LoggerHandler;
import utils.Reporter;
import utils.Screenshot;

public class TermsAndConditionsPage {
    WebDriverHelper webDriverHelper = new WebDriverHelper(Base.driver);

    /*
        Method Name: clickBlogs
        Author: Kirtik Biswas
        Description: Clicks on the blogs link, captures a screenshot, and attached it to the report
        Return Type: void
        Parameters: ExtentTest test
    */

    public void clickBlogs(ExtentTest test){
        try{
            webDriverHelper.clickOnElement(TermsAndConditionsLocator.blogs);
            
            Screenshot.captureScreenshot("blogs");
            Reporter.attachScreenshotToReport("blogs", test, "blogs");

            test.log(Status.PASS, "Screenshot captured");
            LoggerHandler.info("Screenshot captured");
        }
        catch(Exception e){
            test.log(Status.FAIL, "Couldn't capture screenshot");
            LoggerHandler.error("Couldn't capture screenshot");
        }
    }
}
