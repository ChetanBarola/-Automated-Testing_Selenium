package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.BlogsPage;
import pages.FishOilPage;
import pages.HeartHealthPage;
import pages.HomePage;
import pages.TermsAndConditionsPage;


import utils.Base;
import utils.LoggerHandler;
import utils.Reporter;

public class TestArogga extends Base{

    ExtentReports report;
    ExtentTest test;

    HomePage homePageObj;
    TermsAndConditionsPage termsAndConditionsPageObj;
    HeartHealthPage heartHealthPageObj;
    FishOilPage fishOilPageObj;
    BlogsPage blogsPageObj;

    /*
        Method Name: startReport
        Author: Kirtik Biswas
        Description: Initializes the ExtentReports instance before any tests are run
        Return Type: void
        Parameters: None
    */

    @BeforeClass
    public void startReport(){
        report = Reporter.getRep();
    }

    /*
        Method Name: startPage
        Author: Kirtik Biswas
        Description: Sets up pages and starts the browser before each test method
        Return Type: void
        Parameters: None
    */

    @BeforeMethod
    public void startPage(){
        LoggerHandler.logger.info("Page Started");
        openBrowser();

        homePageObj = new HomePage();
        termsAndConditionsPageObj = new TermsAndConditionsPage();
        heartHealthPageObj = new HeartHealthPage();
        fishOilPageObj = new FishOilPage();
        blogsPageObj = new BlogsPage();
    }

    /*
        Method Name: runCareerTest
        Author: Kirtik Biswas
        Description: Executes the career test
        Return Type: void
        Parameters: None
    */

    @Test(priority = 0)
    public void runCareerTest(){
        test = report.createTest("Test1");

        homePageObj.clickCareers(test);
    }

    /*
        Method Name: testAccountReferral
        Author: Kirtik Biswas
        Description: Tests the account referral functionality
        Return Type: void
        Parameters: None
    */

    @Test(priority = 1)
    public void testAccountReferral(){
        test = report.createTest("Test2");

        homePageObj.clickAccounts(test);
        homePageObj.enterNumber(test);
        homePageObj.clickReferral(test);

        termsAndConditionsPageObj.clickBlogs(test);
    }

    /*
        Method Name: filterHeartHealthProducts
        Author: Kirtik Biswas
        Description: Filters heart health products
        Return Type: void
        Parameters: None
    */

    @Test(priority = 2)
    public void filterHeartHealthProducts(){
        test = report.createTest("Test3");
       
        homePageObj.hoverLabTest(test);
        heartHealthPageObj.setMin(test);
        heartHealthPageObj.verifyFilter(test);
    }  

    /*
        Method Name: testFishOilSelection
        Author: Kirtik Biswas
        Description: Tests the fish oil product selection
        Return Type: void
        Parameters: None
    */

    @Test(priority = 3)
    public void testFishOilSelection(){
        test = report.createTest("Test4");

        homePageObj.clickSupplement(test);
        homePageObj.clickProbiotic(test);
        homePageObj.clickFishOil(test);
        fishOilPageObj.clickFirstProduct(test);
        fishOilPageObj.verifyDesc(test);
    }

    /*
        Method Name: registerOnBlog
        Author: Kirtik Biswas
        Description: Tests the registration feature on the blog
        Return Type: void
        Parameters: None
    */

    @Test(priority = 4)
    public void registerOnBlog(){
        test = report.createTest("Test5");
        
        blogsPageObj.clickBlog(test);
        blogsPageObj.clickRegister(test);
        blogsPageObj.sendName(test);
        blogsPageObj.sendNumber(test);
        blogsPageObj.clickSubmit(test);
    }

    /*
        Method Name: tearPage
        Author: Kirtik Biswas
        Description: Quits the browser after each test method
        Return Type: void
        Parameters: None
    */

    @AfterMethod
    public void tearPage(){
        if(driver != null){
            driver.quit();
        }
    }

    /*
        Method Name: tearReport
        Author: Kirtik Biswas
        Description: Flushes the ExtentReports instance after akk tests are completed
        Return Type: void
        Parameters: None
    */

    @AfterClass
    public void tearReport(){
        report.flush();
    }
}
