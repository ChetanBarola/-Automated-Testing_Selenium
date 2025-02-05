package uistore;

import org.openqa.selenium.By;

public class BlogsPageLocator {
    public static By blogs = By.xpath("//a[@href = '/blog']");
    public static By register = By.xpath("//a[@href = '/pharmacy-register']");
    public static By name = By.xpath("//input[@placeholder = 'Enter your full name']");
    public static By number = By.xpath("(//input[@class = 'input_input__q5Ft3'])[2]");
    public static By submit = By.xpath("//div[@class = 'arogga-btn primary large   mt-20 m-auto']");
}