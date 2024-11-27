package electronics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utility.Utility;

public class electronicTest extends Utility {

    String baseURL = "https://demowebshop.tricentis.com/";


    @Before
    public void setUp() {
        openbrowser(baseURL);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully(){

//        1.1 Mouse Hover on the “ELECTRONICS” Tab
        //        1.2 Mouse Hover on the “Cell phones” and click
        WebElement electronics = driver.findElement(By.xpath("//body/div[4]/div[1]/div[2]/ul[1]/li[3]/a[1]"));
        WebElement cellPhones = driver.findElement(By.xpath("//body/div[4]/div[1]/div[2]/ul[1]/li[3]/ul[1]/li[2]/a[1]"));
        Actions action = new Actions(driver);
        action.moveToElement(electronics).moveToElement(cellPhones).click().build().perform();


//        1.3 Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualText = getText(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals("Wrong page", expectedText, actualText);
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {

//        2.1 Mouse Hover on the “ELECTRONICS” Tab
//        2.2 Mouse Hover on the “Cell phones” and click
        WebElement electronics = driver.findElement(By.xpath("//body/div[4]/div[1]/div[2]/ul[1]/li[3]/a[1]"));
        WebElement cellPhones = driver.findElement(By.xpath("//body/div[4]/div[1]/div[2]/ul[1]/li[3]/ul[1]/li[2]/a[1]"));
        Actions action = new Actions(driver);
        action.moveToElement(electronics).moveToElement(cellPhones).click().build().perform();

//        2.3 Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualText = getText(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals("Wrong page", expectedText, actualText);

//        2.4 Select View as option ‘List’
        WebElement viewAs = driver.findElement(By.xpath("//select[@id='products-viewmode']"));
        Select view = new Select(viewAs);
        view.selectByVisibleText("List");

//        2.5 Click on the product name “Smartphone” link
        clickOnElement(By.xpath("//a[contains(text(),'Smartphone')]"));

//        2.6 Verify the text “Smartphone”
        String expectedText1 = "Smartphone";
        String actualText1 = getText(By.xpath("//h1[contains(text(),'Smartphone')]"));
        Assert.assertEquals("Wrong phone", expectedText1, actualText1);

//        2.7 Verify the price “100.00”
        String expectedText2 = "100.00";
        String actualText2 = getText(By.xpath("//span[contains(text(),'100.00')]"));
        Assert.assertEquals("Wrong phone", expectedText2, actualText2);


//        2.8 Change the quantity to 2
        driver.findElement(By.xpath("//input[@id='addtocart_43_EnteredQuantity']")).clear();
        driver.findElement(By.xpath("//input[@id='addtocart_43_EnteredQuantity']")).sendKeys("2");


//        2.9 Click on the “Add to cart” tab
        clickOnElement(By.xpath("//input[@id='add-to-cart-button-43']"));

//        2.10 Verify the Message "The product has been added to your shopping cart" on  Top green Bar
        String expectedText3 = "The product has been added to your shopping cart";
        String actualText3 = getText(By.xpath("//body/div[@id='bar-notification']/p[1]"));
        Assert.assertEquals("Wrong phone", expectedText3, actualText3);

//        2.11 After that close the bar by clicking on the cross button.
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/span[1]"));

//        2.12 Then MouseHover on "Shopping cart" and click on the "Go to cart" button.
        WebElement shoppingCart = driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        WebElement goToCart = driver.findElement(By.xpath("//body/div[4]/div[1]/div[1]/div[2]/div[2]/div[1]/div[4]/input[1]"));
        Actions action1 = new Actions(driver);
        action1.moveToElement(shoppingCart).moveToElement(goToCart).click().build().perform();

//        2.13 Verify the message "Shopping cart"
        String expectedText4 = "Shopping cart";
        String actualText4 = getText(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("no text displayed", expectedText4, actualText4);

//        2.14 Verify the quantity is 2
//        String expectedText5 = "2";
//        Thread.sleep(2000);
//        String actualText5 = getText(By.xpath(""));
//        Assert.assertEquals("INCORRECT qty", expectedText5, actualText5);

//        2.15 Verify the Total “200.00”
        String expectedText6 = "200.00";
        String actualText6 = getText(By.xpath("//body[1]/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/span[1]/strong[1]"));
        Assert.assertEquals("Incorrect price", expectedText6, actualText6);

//        2.16 click on the checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

//        2.17 Click on the “Checkout” button
        clickOnElement(By.id("checkout"));

//        2.18 Verify the Text “Welcome, Please Sign In!”
        String expectedText7 = "Welcome, Please Sign In!";
        String actualText7 = getText(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("Incorrect page", expectedText7, actualText7);

//        2.19 Click on the “Register” tab
        clickOnElement(By.xpath("//body/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/input[2]"));

//        2.20 Verify the text “Register”
        String expectedText8 = "Register";
        String actualText8 = getText(By.xpath("//h1[contains(text(),'Register')]"));
        Assert.assertEquals("Incorrect page", expectedText8, actualText8);

//        2.21 Select the Male radio button
         clickOnElement(By.id("gender-male"));

//        2.22 Enter the First name
        driver.findElement(By.id("FirstName")).sendKeys("Seema");
//        2.23 Enter the Last name
        driver.findElement(By.id("LastName")).sendKeys("Patel");
//        2.24 Enter the Email
        driver.findElement(By.id("Email")).sendKeys("computer.tester009@gmail.com");
//        2.25 Enter the Password
        driver.findElement(By.id("Password")).sendKeys("Test1234");
//        2.26 Enter the Confirm password
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Test1234");
//        2.27 Click on the “Register” button
        clickOnElement(By.id("register-button"));
//
//        2.28 Verify the message “Your registration completed”
        String expectedText9 = "Your registration completed";
        String actualText9 = getText(By.xpath("//div[contains(text(),'Your registration completed')]"));
        Assert.assertEquals("Registration completed message not displayed", expectedText, actualText);

//        2.29 Click on the “Continue” button
        clickOnElement(By.xpath("//body/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[2]/input[1]"));

//        2.30 Verify the text “Shopping card”
        String expectedText10 = "Shopping cart";
        String actualText10 = getText(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Registration completed message not displayed", expectedText10, actualText10);

//        2.31 click on the checkbox “I agree with the terms of service”
clickOnElement(By.xpath("//input[@id='termsofservice']"));

//        2.32 Click on the “Checkout”
clickOnElement(By.xpath("//button[@id='checkout']"));

//        2.33 Select the Country “United Kingdom” using the select class
        WebElement country = driver.findElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"));
        Select selectCountry = new Select(country);
        selectCountry.selectByVisibleText("United Kingdom");

//        2.34 Enter the city
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']")).sendKeys("London");
//        2.35 Enter the Address1
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address1']")).sendKeys("10 Mead close");
//        2.36 Enter the Zip/Postal code
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']")).sendKeys("HA3 6TT");
//        2.37 Enter the Phone number
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']")).sendKeys("02083573578");

//        2.38 Click on the “Continue” button
        clickOnElement(By.xpath("//body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/input[1]"));

//        2.39 Click on the “Continue” button
        clickOnElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ol[1]/li[2]/div[2]/div[1]/input[1]"));

//        2.40 Click on the Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_2']"));

//        2.41 Click on the “Continue” button
        clickOnElement(By.xpath("//body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/input[1]"));

//        2.42 Select the Radio Button “Credit Card”
        clickOnElement(By.cssSelector("#paymentmethod_2"));

//        2.43 Click on the “Continue” button
          clickOnElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/form[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/div[1]/div[2]/input[1]"));

          //        2.44 Select the “Visa” From Select credit card dropdown
        clickOnElement(By.xpath("//select[@id='CreditCardType']"));

//        2.45 Enter the Cardholder's name
        driver.findElement(By.xpath("//input[@id='CardholderName']")).sendKeys("C PATEL");

//        2.46 Enter the Card number
        driver.findElement(By.xpath("//input[@id='CardNumber']")).sendKeys("1234 1234 1234 1234");

//        2.47 Select the Expiration date using the select class
        WebElement expireMonth = driver.findElement(By.cssSelector("#ExpireMonth"));
        Select expire = new Select(expireMonth);
        expire.selectByVisibleText("06");
        WebElement expireYear = driver.findElement(By.xpath("//select[@id='ExpireYear']"));
        Select expireY = new Select(expireYear);
        expireY.selectByVisibleText("2028");

//        2.48 Enter the Card code
        driver.findElement(By.xpath("//input[@id='CardCode']")).sendKeys("123");

//        2.49 Click on the “Continue” button
        clickOnElement(By.xpath("//body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/input[1]"));

//        2.50 Verify the “Payment Method” is “Credit Card”
        String expectedText11 = "Credit Card";
        String actualText11 = getText(By.xpath("//li[contains(text(),'Credit Card')]"));
        Assert.assertEquals("incorrect payment type", expectedText11, actualText11);

//        2.51 Verify the “Shipping Method” is “2nd Day Air”
        String expectedText12 = "2nd Day Air";
        String actualText12 = getText(By.xpath("//span[contains(text(),'(2nd Day Air)')]"));
        Assert.assertEquals("incorrect sipping type", expectedText12, actualText12);

//        2.52 Verify the Total is “200.00”
        String expectedText13 = "200.00";
        String actualText13 = getText(By.xpath("//body[1]/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/span[1]/strong[1]"));
        Assert.assertEquals("incorrect total", expectedText8, actualText8);

//        2.53 Click on the “Confirm” button
        clickOnElement(By.xpath("//body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[2]/input[1]"));

//        2.54 Verify the Text “Thank You”
        String expectedText14 = "Thank You";
        String actualText14 = getText(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals("incorrect text", expectedText14, actualText14);


//        2.55 Verify the message “Your order has been successfully processed!”
        String expectedText15 = "Your order has been successfully processed!";
        String actualText15 = getText(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("incorrect text", expectedText15, actualText15);

//        2.56 Click on the “Continue” button
        clickOnElement(By.xpath("//body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[2]/input[1]"));

//        2.57 Verify the text “Welcome to our store”
        String expectedText16 = "Welcome to our store";
        String actualText16 = getText(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("Order not successfull", expectedText11, actualText11);

//        2.58 Click on the “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));

//        2.59 Verify the URL is “https://demowebshop.tricentis.com/”
           driver.get(baseURL);
    }
    public void shutdown(){
        driver.quit();
    }
}
