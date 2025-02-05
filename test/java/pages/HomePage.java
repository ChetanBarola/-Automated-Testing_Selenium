package pages;

import java.io.IOException;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.HomePageLocator;
import utils.Base;
import utils.ExcelReader;
import utils.LoggerHandler; 
import utils.WebDriverHelper;

public class HomePage {
    WebDriverHelper webDriverHelper = new WebDriverHelper(Base.driver);
    ExcelReader excelReader = new ExcelReader();

    /*
        Method Name: clickCareers
        Author: Kirtik Biswas
        Description: Clicks the careers link on the homepage
        Return Type: void
        Parameters: ExtentTest test 
    */
    public void clickCareers(ExtentTest test){
        try{
            webDriverHelper.clickOnElement(HomePageLocator.careers);

            test.log(Status.PASS, "Clicked on careers");
            LoggerHandler.info("Clicked on careers");
        }
        catch(Exception e){
            LoggerHandler.error("Blogs not found "+ e.getMessage());
            test.log(Status.FAIL, "Blogs not found");
        }
    }

    /*
        Method Name: clickAccounts
        Author: Kirtik Biswas
        Description: Clicks on the user accounts section
        Return Type: void
        Parameters: None 
    */

    public void clickAccounts(ExtentTest test){
        try{
            webDriverHelper.clickOnElement(HomePageLocator.helloUser);

            LoggerHandler.info("clicked on hello user");
            test.log(Status.PASS, "clicked on hello user");
        }
        catch(Exception e){
            LoggerHandler.error("hello user not found "+ e.getMessage());
            test.log(Status.FAIL, "hello user not found");
        }
    }

    /*
        Method Name: enterNumber
        Author: Kirtik Biswas
        Description: Enters a phone number in the phone number input field
        Return Type: void
        Parameters: None
    */

    public void enterNumber(ExtentTest test){
        try{
            webDriverHelper.sendKeys(HomePageLocator.phoneNum, "08765427890");

            LoggerHandler.info("Phone number sent");
            test.log(Status.PASS, "Phone number sent");
        }
        catch(Exception e){
            LoggerHandler.error("Phone number inout field not found "+ e.getMessage());
            test.log(Status.FAIL, "Phone number inout field not found");
        }
    }

    /*
        Method Name: clickReferral
        Author: Kirtik Biswas
        Description: Clicks the referral code element, enters the referral code from the excel file, submits it and then clicks the terms and conditions element
        Return Type: void
        Parameters: ExtentTest test 
    */

    public void clickReferral(ExtentTest test) {
        try{
            webDriverHelper.clickOnElement(HomePageLocator.referalCode);
            LoggerHandler.info("Clicked on referral code");
            test.log(Status.PASS, "Clicked on referral code");

            String data = excelReader.readdata("./testdata/data.xlsx", "Sheet1", 1, 0);
            webDriverHelper.sendKeys(HomePageLocator.refNo, data);
            LoggerHandler.info("Retrieved data from excel sheet");
            test.log(Status.PASS, "Retrieved data from excel sheet");

            webDriverHelper.clickOnElement(HomePageLocator.send);
            LoggerHandler.info("Clicked on send button");
            test.log(Status.PASS, "Clicked on send button");

            webDriverHelper.clickOnElement(HomePageLocator.termsAndCond);
            LoggerHandler.info("Clicked on terms and conditions");
            test.log(Status.PASS, "Clicked on terms and conditions");
            
            webDriverHelper.switchToNewWindow();

            LoggerHandler.info("Retrieved referral number and clicked on terms and conditions");
            test.log(Status.PASS, "Retrieved referral number and clicked on terms and conditions");
        }
        catch(IOException e){
            LoggerHandler.error("File Not Found " + e.getMessage());
            test.log(Status.FAIL, "File Not Found");
        }
    }

    /*
        Method Name: hoverLabTest
        Author: Kirtik Biswas
        Description: Hovers over the lab test element and clicks on the heart health option
        Return Type: void
        Parameters: None
    */

    public void hoverLabTest(ExtentTest test){
        try{
            webDriverHelper.hoverOverElement(HomePageLocator.labTest);
            LoggerHandler.info("Hovered over lab test");
            test.log(Status.PASS, "Hovered over lab test");

            webDriverHelper.clickOnElement(HomePageLocator.heartHealth);

            LoggerHandler.info("clicked on heart health");
            test.log(Status.PASS, "clicked on heart health");
        }
        catch(Exception e){
            LoggerHandler.error("LabTest couldn't be hovered over " + e.getMessage());
            test.log(Status.FAIL, "LabTest couldn't be hovered over");
        }
    }

    /*
        Method Name: clickSupplement
        Author: Kirtik Biswas
        Description: Clicks on the supplement option on the homepage
        Return Type: void
        Parameters: ExtentTest test 
    */

    public void clickSupplement(ExtentTest test){
        try{
            webDriverHelper.clickOnElement(HomePageLocator.supplement);

            LoggerHandler.info("clicked on supplement");
            test.log(Status.PASS, "clicked on supplement");
        }
        catch(Exception e){
            LoggerHandler.error("Coudln't click on supplement " + e.getMessage());
            test.log(Status.FAIL, "Coudln't click on supplement");
        }
    }

    /*
        Method Name: clickProbiotic
        Author: Kirtik Biswas
        Description: Clicks on the probiotic option on the homepage
        Return Type: void
        Parameters: ExtentTest test 
    */

    public void clickProbiotic(ExtentTest test){
        try{
            webDriverHelper.clickOnElement(HomePageLocator.probiotic);

            LoggerHandler.info("clicked on probiotic");
            test.log(Status.PASS, "clicked on probiotic");
        }
        catch(Exception e){
            LoggerHandler.error("Couldn't click on probiotic " + e.getMessage());
            test.log(Status.FAIL, "Couldn't click on probiotic");
        }
    }

    /*
        Method Name: clickFishOil
        Author: Kirtik Biswas
        Description: Clicks on the fish oil option on the homepage
        Return Type: void
        Parameters: ExtentTest test 
    */

    public void clickFishOil(ExtentTest test){
        try{
            webDriverHelper.clickOnElement(HomePageLocator.fishOil);

            LoggerHandler.info("clicked on fishoil");
            test.log(Status.PASS, "clicked on fishoil");
        }
        catch(Exception e){
            LoggerHandler.error("Couldn't click on fish oil " + e.getMessage());
            test.log(Status.FAIL, "Couldn't click on fish oil");
        }
    }
}
