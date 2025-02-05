package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.WebDriver;

public class Base{
    public static WebDriver driver;
    public static FileInputStream file;
    public static Properties prop;

    /*
        Method Name: loadProperties
        Author: Kirtik Biswas
        Description: Loads properties from the specified properties file
        Return Type: void
        Parameters: None 
    */
    public void loadProperties() throws IOException{
        try{
            file = new FileInputStream("/home/coder/project/workspace/Project/config/browser.properties");
            prop = new Properties();
            prop.load(file);
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    /*
        Method Name: openBrowser
        Author: Kirtik Biswas
        Description: Opens a remote browser using the specified grid url and options
        Return Type: void
        Parameters: None 
    */

    public void openBrowser(){
        try{
            loadProperties();
            URL gridUrl = new URL(prop.getProperty("gridurl"));
            driver = new RemoteWebDriver(gridUrl, new ChromeOptions());
        }
        catch(IOException e){
            e.printStackTrace();
        }

        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));

        WebDriverListener listener = new EventHandler();
        driver = new EventFiringDecorator<>(listener).decorate(driver);
    }
}