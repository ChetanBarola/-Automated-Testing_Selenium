package pages;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.FishOilPageLocator;
import utils.Base;
import utils.LoggerHandler;
import utils.Reporter;
import utils.Screenshot;
import utils.WebDriverHelper;

public class FishOilPage {
    WebDriverHelper webDriverHelper = new WebDriverHelper(Base.driver);

    /*
        Method Name: clickFirstProduct
        Author: Kirtik Biswas
        Description: Clicks on the first product listed on the fish oil page
        Return Type: void
        Parameters: ExtentTest test 
    */
    public void clickFirstProduct(ExtentTest test) {
        try{
            webDriverHelper.clickOnElement(FishOilPageLocator.firstProduct);

            LoggerHandler.logger.info("clicked on first product");
            test.log(Status.INFO, "clicked on first product");
        }
        catch(Exception e){
            LoggerHandler.error("First product couldn't be clicked "+ e.getMessage());
            test.log(Status.FAIL, "First product couldn't be clicked");
        }
    }

    /*
        Method Name: verifyDesc
        Author: Kirtik Biswas
        Description: Captures a screenshot of the product description and verifies it matches the expected text
        Return Type: void
        Parameters: ExtentTest test 
    */

    public void verifyDesc(ExtentTest test) {
        try{
            Screenshot.captureScreenshot("product_description");
            LoggerHandler.logger.info("screenshot captured");
            test.log(Status.INFO, "screenshot captured");
            Reporter.attachScreenshotToReport("product_description", test, "product_description");

            String text = webDriverHelper.getText(FishOilPageLocator.desc);
            String text2 = "Product Description";
            Assert.assertEquals(text, text2);

            LoggerHandler.info("Assertion successful");
            test.log(Status.PASS, "Assertion successful");
        }
        catch(Exception e){
            LoggerHandler.error("Assertion Failed "+ e.getMessage());
            test.log(Status.FAIL, "Assertion Failed");
        }
    }
}
