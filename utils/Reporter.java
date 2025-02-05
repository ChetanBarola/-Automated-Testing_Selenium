package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;


public class Reporter extends Base{
    public static TakesScreenshot ts;
    public static ExtentSparkReporter spark;
    public static ExtentReports report;

    /*
        Method Name: getRep
        Author: Kirtik Biswas
        Description: Initializes and returns the ExtentReports instance
        Return Type: ExtentReports
        Parameters: None 
    */
    public static ExtentReports getRep(){
        spark = new ExtentSparkReporter("./reports/report.html");
        report = new ExtentReports();
        report.attachReporter(spark);
        return report;
    }

    /*
        Method Name: captureScreenshot
        Author: Kirtik Biswas
        Description: Captures a screenshot and saves it with a timestamped filename
        Return Type: String
        Parameters: String filename
    */

    public static String captureScreenshot(String filename){
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String name = filename + timestamp + ".png";
        String dest = "./" + name;
        ts = (TakesScreenshot)driver;
        File file = ts.getScreenshotAs(OutputType.FILE);

        File screenshotDir = new File(System.getProperty("user.dir") + "/reports");
        if(!screenshotDir.exists()){
            screenshotDir.mkdirs();
        }
        File target = new File(screenshotDir, name);
        try{
            FileUtils.copyFile(file, target);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return dest;
    }

    /*
        Method Name: attachScreenshotToReport
        Author: Kirtik Biswas
        Description: Attaches a screenshot to the ExtentTest report with the given message
        Return Type: void
        Parameters: String filename, ExtentTest test, String msg
    */

    public static void attachScreenshotToReport(String filename, ExtentTest test, String msg){
        try{
            test.log(Status.INFO, msg, MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(filename)).build());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
