package computer;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    //    @After
//    public void tearDown(){
//        closeBrowser();
//    }
    public void testName() {
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Computers')]"));
        clickOnElement(By.xpath("//div[@class='sub-category-item']//a[contains(text(),'Desktops')]"));
        List<WebElement> listsAllDefault = listOfWebElementsList(By.xpath("//div[@class='prices']"));
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Price: Low to High");
        List<WebElement> listsAllAfterShort = listOfWebElementsList(By.xpath("//div[@class='prices']"));


        if (listsAllDefault != listsAllAfterShort) {
            System.out.println("Pass");
        }

        //Verify the Product will arrange in Descending order.
        String expectedResult = "Arrange to low to high";
        String actualResult = getTextfromElement(By.xpath("//select[@id ='products-orderby']"));

        Assert.assertEquals("Arrange low to high", expectedResult, actualResult);


    }

    @Test
    public void productwillArrangeInAssendingOrder() {
        testName();
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //Click on Computer Menu.
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Computers')]"));
        Thread.sleep(2000);
        //Click on Desktop
        clickOnElement(By.xpath("//div[@class='sub-category-item']//a[contains(text(),'Desktops')]"));
        Thread.sleep(2000);
        // selectByVisibleTextFromDropDown(By.xpath("//select[@id ='products-orderby']"), "Price:low to high");
        //Add product to cart
        //clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[2]/button[1]"));
        Thread.sleep(2000);
        //Verify the Text "Build your own computer
        String expectedMessage = "Build your own computer";
        String actualMessage = getTextfromElement(By.xpath("//h2/a[contains(text(),'Build your own computer')]"));
        Assert.assertEquals("Incorrect page:", expectedMessage, actualMessage);

        clickOnElement(By.partialLinkText("Build your own computer"));
        Thread.sleep(2000);
        //Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_1']"), "2.2 GHz Intel Pentium Dual-Core E2200");
        //Select "8GB [+$60.00]" using Select class.
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_2']"), "8GB [+$60.00]");
        // Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));
        Thread.sleep(2000);
        //Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.id("product_attribute_4_9"));
        Thread.sleep(2000);
        // Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander
        //   clickOnElement(By.id("product_attribute_5_10"));
        //Total Commander
        clickOnElement(By.id("product_attribute_5_12"));
        Thread.sleep(2000);

        //Verify the price "$1,475.00"
        String expectedPrice = "$1,475.00";
        String actualPrice = getTextfromElement(By.xpath("//span[@id='price-value-1']"));
        Assert.assertEquals("Incorrect Configuration ", expectedPrice, actualPrice);


        //Click on "ADD TO CARD" Button.
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        Thread.sleep(2000);
        // Verify the Message "The product has been added to your shopping cart" on Top green Bar

        String expectedMessage1 = "The product has been added to your shopping cart";
        String actualMessage1 = getTextfromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals("Product added to cart :", expectedMessage1, actualMessage1);
        // close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@class='close']"));
        Thread.sleep(2000);

        // MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//span[text()='Shopping cart']"));
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        Thread.sleep(2000);
        //Go to "Shopping cart"

        //  clickOnElement(By.xpath("//span[text()='Shopping cart']"));
        //  clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));

        String expectedMessage3 = "Shopping cart";

        String actualMessage3 = getTextfromElement(By.xpath("//h1[text()='Shopping cart']"));
        Assert.assertEquals("Shopping Cart:", expectedMessage3, actualMessage3);

        //Change the Qty to "2" and Click on "Update shopping cart"
        sendTextFromElement(By.xpath("//input[@class='qty-input']"));
        sendTextFromElement(By.xpath("//input[@class='qty-input']"), "2");
        clickOnElement(By.id("updatecart"));
        Thread.sleep(2000);
        //Verify the Total"$2,950.00"
        String expectedTotalAmount = "Total: $2,950.00";
        String actualTotalAmount = getTextfromElement(By.xpath("//tr[@class='order-total']"));
        Assert.assertEquals("Total is wrong:", expectedTotalAmount, actualTotalAmount);
        //click on checkbox “I agree with the terms of service
        clickOnElement(By.xpath("//label[contains(text(),'I agree with the terms of service and I adhere to ')]"));
        clickOnElement(By.xpath("//button[@class='button-1 checkout-button']"));
        //Verify the Text “Welcome, Please Sign In!”
        String expectedSignInMessage = "Welcome, Please Sign In!";
        String actualSignInMessage = getTextfromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("User Is Not On Sign In Page", expectedSignInMessage, actualSignInMessage);
        //Click on “CHECKOUT AS GUEST” Tab
        //clickOnElement(By.xpath("//button[@class='button-1 search-box-button']"));
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
        //sendTextFromElement(By.xpath("//input[@id='FirstName']']"), "Prime12");
        sendTextFromElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "Prime12");
        sendTextFromElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "Testing1");
        sendTextFromElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "abc@yahoo.com");
        //selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "London");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"Mali");
        sendTextFromElement(By.xpath("//input[@id='BillingNewAddress_City']"),"London");
       sendTextFromElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "10,Isobel House");
        sendTextFromElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"23145");
        sendTextFromElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "078784562");
//        sendTextFromElement(By.id("ConfirmPassword"), "abc321");
//        sendTextFromElement(By.id("BillingNewAddress_CountryId"), "United Kingdom");
//        sendTextFromElement(By.xpath("//select[@name='BillingNewAddress.StateProvinceId']"), "Other");
//        sendTextFromElement(By.xpath("//input[@name='BillingNewAddress.City']"), "London");
//        sendTextFromElement(By.id("BillingNewAddress_Address1"), "10,Liver Street");
//        sendTextFromElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "10,Liver Street,H1 3DT");
//        sendTextFromElement(By.id("BillingNewAddress_PhoneNumber"), "077456512345");
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));

        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        clickOnElement(By.xpath("//label[contains(text(),'Credit Card')]"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Master card");
        sendTextFromElement(By.xpath("//input[@id='CardholderName']"), "Ram shyam");
        sendTextFromElement(By.xpath("//input[@id='CardNumber']"), "5555555555554444");

        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "04");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2025");

        sendTextFromElement(By.xpath("//input[@id='CardCode']"), "420");//send CVV

        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        clickOnElement(By.xpath("//button[text()='Confirm']"));
        String expectedText = "Payment Method: Credit Card";
        String actualText = getTextfromElement(By.xpath("//li[@class='payment-method']"));
        Assert.assertEquals("Please check your payment method :", expectedText, actualText);
        String expectedTotalText = "Total: $2,950.00";
        String actualTotals = getTextfromElement(By.xpath("//tr[@class='order-total']"));
        Assert.assertEquals("Total Order is Incorrect:", expectedTotalText, actualTotals);
        clickOnElement(By.xpath("//button[@onclick='ConfirmOrder.save()']"));
        String expectedThankYou = "Thank you";
        String actualThanku = getTextfromElement(By.xpath("//h1[text()='Thank you']"));
        Assert.assertEquals("Thank you should displayed", expectedThankYou, actualThanku);//2.35
        String expectedResult = "Your order has been successfully processed!";
        String actualResult = getTextfromElement(By.xpath("//strong[text()='Your order has been successfully processed!']"));
        Assert.assertEquals("Order is successful:", expectedResult, actualResult);//2.36
        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));
        String expectedWelcome = "Welcome to our store";
        String actualWelcome = getTextfromElement(By.xpath("//h2[text()='Welcome to our store']"));
        Assert.assertEquals("This message should displayed", expectedWelcome, actualWelcome);


    }
}
