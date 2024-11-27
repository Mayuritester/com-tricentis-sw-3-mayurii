package utility;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Utility extends BaseTest {

    // Click method
    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }

    //text from element method
    public String getText(By by) {
        return driver.findElement(by).getText();
    }

    // method to find element and write text
    public void writeText (By by, String text){

    }



}
