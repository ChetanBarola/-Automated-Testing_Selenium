package uistore;

import org.openqa.selenium.By;

public class HeartHealthPageLocator {
    public static By minimumBox = By.xpath("//label[text() ='Min']");
    public static By minimum = By.xpath("//input[@id = 'label-min']");
    public static By filter = By.xpath("//span[text() = 'Heart Health']");
}
