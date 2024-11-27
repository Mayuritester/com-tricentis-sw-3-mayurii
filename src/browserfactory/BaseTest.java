package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    public void openbrowser (String baseURL){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.manage().window().maximize();
        driver.get(baseURL);


    }

    public void closeWindow (){
        driver.quit();
    }
}
