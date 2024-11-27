package homepage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

public class TopMenuTest extends Utility {

    String baseURL = "https://demowebshop.tricentis.com/";

    @Before
    public void setBaseURL (){
        openbrowser (baseURL);
    }
   // 1.1 create a method with the name "selectMenu()" It has one parameter name "menu" of type string
    public void selectMenu (String menu){
        clickOnElement(By.linkText(menu));

    }

   @Test
   //1.3. create the @Test method name verifyPageNavigation(). Use the selectMenu() method to select the Menu and click on it and verify the page navigation.
   public void verifyPageNavigation(){
      selectMenu("Books");
       String expectedText = "Books";
       String actualText = getText(By.xpath("//h1[contains(text(),'Books')]"));
       Assert.assertEquals("no text displayed", expectedText, actualText);
   }
    public void shutdown(){
        driver.quit();
    }
}




//}
