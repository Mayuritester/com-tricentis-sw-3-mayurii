package computer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utility.Utility;

public class TestSuite extends Utility {

    String baseURL = "https://demowebshop.tricentis.com/";


    @Before
    public void setUp() {
        openbrowser(baseURL);
    }


    @Test
    //Method
    public void verifyProductArrangeInAlphaBaticalOrder() {
        // Click on the COMPUTERS Menu.
        clickOnElement(By.xpath("//body/div[4]/div[1]/div[2]/ul[1]/li[2]/a[1]"));

//        1.2 Click on the Desktop
        clickOnElement(By.xpath("//body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[1]/a[1]"));

//        1.3 Select Sort By option "Name: Z to A"
        WebElement dropwndown = driver.findElement(By.id("products-orderby"));
        Select drop = new Select(dropwndown);
        drop.selectByVisibleText("Name: Z to A");

//        1.4 Verify the Product will be arranged in Descending order.
        String expectedText = "Name: A to Z";
        String actualText = getText(By.xpath("//option[contains(text(),'Name: A to Z')]"));
        Assert.assertEquals("not in descending order", expectedText, actualText);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() {
//    2.1 Click on the COMPUTERS Menu.
        clickOnElement(By.xpath("//body/div[4]/div[1]/div[2]/ul[1]/li[2]/a[1]"));

//    2.2 Click on the Desktop
        clickOnElement(By.xpath("//body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[1]/a[1]"));

//    2.3 Select Sort By option "Name: A to Z"
        WebElement dropwndown = driver.findElement(By.id("products-orderby"));
        Select drop = new Select(dropwndown);
        drop.selectByVisibleText("Name: A to Z");

//    2.4 Click on the "Add To Cart" button of the product name ‘Build your own computer’
        clickOnElement(By.xpath("//body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[2]/div[1]/div[2]/div[3]/div[2]/input[1]"));

//    2.5 Verify the Text "Build your own computer"
        String expectedText1 = "Build your own computer";
        String actualText1 = getText(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        Assert.assertEquals("Text not displayed", expectedText1, actualText1);


//    2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using the Select class
        WebElement processorDrop1 = driver.findElement(By.xpath("//select[@id='product_attribute_16_5_4']"));
        Select processorDown = new Select(processorDrop1);
        processorDown.selectByVisibleText("2.2 GHz Intel Pentium Dual-Core E2200");

//    2.7.Select "8GB [+$60.00]" using the Select class.
        WebElement ramDrop = driver.findElement(By.xpath("//select[@id='product_attribute_16_6_5']"));
        Select processor = new Select(ramDrop);
        processor.selectByVisibleText("8GB [+60.00]");

//    2.8 Select HDD radio button "400 GB [+$100.00]"
//        driver.findElement(<locator>).isSelected();
        clickOnElement(By.xpath("//input[@id='product_attribute_16_3_6_19']"));


//    2.9 Select the OS radio button "Windows 10 [+$60.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_16_4_7_21']"));

//        2.10 Check Two Checkboxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_16_8_8_24']"));


        // 2.11 Verify the price "1200.00"
        String expectedText = "1200.00";
        String actualText = getText(By.xpath("//span[contains(text(),'1200.00')]"));
        Assert.assertEquals("No price printed", expectedText, actualText);

//       2.12 Click on the "Add to card" Button.
        clickOnElement(By.xpath("//input[@id='add-to-cart-button-16']"));

//        2.13 Verify the Message "The product has been added to your shopping cart" on the Top green Bar
        String expectedText2 = "The product has been added to your shopping cart";
        String actualText2 = getText(By.xpath("//body/div[@id='bar-notification']/p[1]"));
        Assert.assertEquals("No message printed", expectedText2, actualText2);

//        2.14 After that close the bar by clicking on the cross button.
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/span[1]"));

//       2.15 Then MouseHover on "Shopping cart" and click on the "Go to cart" button.
        WebElement shoppingCart = driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        WebElement goToCart = driver.findElement(By.xpath("//body/div[4]/div[1]/div[1]/div[2]/div[2]/div[1]/div[4]/input[1]"));
        Actions action = new Actions(driver);
        action.moveToElement(shoppingCart).moveToElement(goToCart).click().build().perform();

//       2.16 Verify the message "Shopping cart"
        String expectedText3 = "Shopping cart";
        String actualText3 = getText(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("no text displayed", expectedText3, actualText3);


//        2.17 Change the Qty to "2" and Click on "Update shopping cart"
        driver.findElement(By.xpath("//tbody/tr[1]/td[5]/input[1]")).clear();
        driver.findElement(By.xpath("//tbody/tr[1]/td[5]/input[1]")).sendKeys("2");
        clickOnElement(By.xpath("//body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/input[1]"));


//      2.18 Verify the Total "2,950.00"
        String expectedText4 = "2950.00";
        String actualText4 = getText(By.xpath("//body[1]/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/span[1]/strong[1]"));
        Assert.assertEquals("Incorrect price", expectedText4, actualText4);

//        2.19 click on the checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

//        2.20 Click on “Checkout”
        clickOnElement(By.id("checkout"));
//        2.21 Verify the Text “Welcome, Please Sign In!”
        String expectedText5 = "Welcome, Please Sign In!";
        String actualText5 = getText(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("Incorrect page", expectedText5, actualText5);

//        2.22 Click on the “Checkout as Guest” Tab
        clickOnElement(By.xpath("//body/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/input[1]"));

//        2.23 Enter the First name
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_FirstName']")).sendKeys("Prime");
        //   2.24 Enter the Last name
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_LastName']")).sendKeys("Testing");
        //       2.25 Enter the email
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_Email']")).sendKeys("computer.tester009@gmail.com");
//       2.26 Select the Country “United Kingdom” using the select class
        WebElement country = driver.findElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"));
        Select selectCountry = new Select(country);
        selectCountry.selectByVisibleText("United Kingdom");
//        2.27 Enter the city
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']")).sendKeys("London");
//        2.28 Enter the Address1
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address1']")).sendKeys("10 Mead close");
//        2.29 Enter the Zip/Postal code
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']")).sendKeys("HA3 6TT");
//        2.30 Enter the Phone number
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']")).sendKeys("02083573578");
//        2.31 Click on the “Continue” button
        clickOnElement(By.xpath("//body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/input[1]"));

//        2.32 Click on the “Continue” button
        clickOnElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ol[1]/li[2]/div[2]/div[1]/input[1]"));
//        //  2.33 Click on the Radio Button “Next Day Air($
                clickOnElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/input[1]"));

//        2.34 Click on the “Continue” button

        clickOnElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/input[1]"));
//        2.35 Select the Radio Button “Credit Card”
        clickOnElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/form[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/div[1]/div[2]/input[1]"));
//        2.36 Click on the “Continue” button
        clickOnElement(By.xpath("//body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/input[1]"));
//        2.37 Select “Master card” From the Select credit card dropdown using the Select class
        WebElement credit= driver.findElement(By.xpath("//select[@id='CreditCardType']"));
        Select masterCard = new Select(credit);
        masterCard.selectByVisibleText("Master card");
//        2.38 Enter the Cardholder's name
        driver.findElement(By.xpath("//input[@id='CardholderName']")).sendKeys("C PATEL");
//        2.39 Enter the Card number
        driver.findElement(By.xpath("//input[@id='CardNumber']")).sendKeys("1234 1234 1234 1234");
//        2.40 Select the Expiration date using the select class
        WebElement expireMonth = driver.findElement(By.cssSelector("#ExpireMonth"));
        Select expire = new Select(expireMonth);
        expire.selectByVisibleText("03");
        WebElement expireYear = driver.findElement(By.xpath("//select[@id='ExpireYear']"));
        Select expireY = new Select(expireYear);
        expireY.selectByVisibleText("2026");

//        2.41 Enter the Card code
        driver.findElement(By.xpath("//input[@id='CardCode']")).sendKeys("123");
//        2.42 Click on the “Continue” button
        clickOnElement(By.xpath("//body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/input[1]"));

//        2.43 Verify “Payment Method” is “Credit Card”
        String expectedText6 = "Credit Card";
        String actualText6 = getText(By.xpath("//li[contains(text(),'Credit Card')]"));
        Assert.assertEquals("incorrect payment type", expectedText6, actualText6);

//        2.44 Verify “Shipping Method” is “Next Day Air”
        String expectedText7 = "Next Day Air";
        String actualText7 = getText(By.xpath("//span[contains(text(),'(Next Day Air)')]"));
        Assert.assertEquals("incorrect sipping type", expectedText7, actualText7);
//        2.45 Verify Total is “2,950.00”
        String expectedText8 = "2950.00";
        String actualText8 = getText(By.xpath("//tbody/tr[4]/td[2]/span[1]/span[1]"));
        Assert.assertEquals("incorrect total", expectedText8, actualText8);

//        2.46 Click on the “Confirm” button
        clickOnElement(By.xpath("//body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[2]/input[1]"));

        //  2.47 Verify the Text “Thank You”
        String expectedText14 = "Thank You";
       String actualText14 = getText(By.xpath("//h1[contains(text(),'Thank you')]"));
       Assert.assertEquals("incorrect text", expectedText14, actualText14);

////        2.48 Verify the message “Your order has been successfully processed!”
        String expectedText15 = "Your order has been successfully processed!";
        String actualText15 = getText(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("incorrect text", expectedText15, actualText15);


//        2.49 Click on the “Continue” button
        clickOnElement(By.xpath("//body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[2]/input[1]"));

//        2.50 Verify the text “Welcome to our store”
        String expectedText11 = "Welcome to our store";
        String actualText11 = getText(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("Order not successfull", expectedText11, actualText11);
    }

    public void shutdown(){
        driver.quit();
    }

}


