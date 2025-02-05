package uistore;

import org.openqa.selenium.By;

public class HomePageLocator {
    public static By careers = By.id("/jobs");

    public static By helloUser = By.xpath("//div[@class = 'ml-10']");
    public static By phoneNum = By.cssSelector("#phone");
    public static By referalCode = By.xpath("//span[text() = 'Have a referral code?']");
    public static By refNo = By.xpath("(//input[@class = 'input_input__q5Ft3'])[2]");
    public static By send = By.xpath("//div[@class = 'arogga-btn primary large  ']");
    public static By termsAndCond = By.xpath("//a[text() = 'Terms & Conditions']");
    
    public static By labTest = By.xpath("//div[@id = '/lab-test']");
    public static By heartHealth = By.xpath("//a[text() = 'Heart Health']");

    public static By supplement = By.xpath("//li[@name = 'Supplement']//div/span/a");
    public static By probiotic = By.xpath("(//a[text() = 'Digestive Probiotic '])[2]");
    public static By fishOil = By.xpath("(//a[text() = 'Fish Oil'])[2]");
}