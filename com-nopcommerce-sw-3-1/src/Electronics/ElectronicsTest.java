package Electronics;

import com.google.common.base.Verify;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);

    }
//    @After
//    public void tearDown(){
//        closeBrowser();
//    }
    @Test
    public void textVerified(){
        //Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Electronics ']"));
        //Mouse Hover on “Cell phones” and click
        mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        // Verify the text “Cell phones”
        String expectedRes = "Cell phones";
        String actualRes = getTextfromElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        Assert.assertEquals(expectedRes,actualRes);

    }
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Electronics ']"));
        //Mouse Hover on “Cell phones” and click
        mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        //Verify the text “Cell phones”
//        String expectedRes1 = "Cell phones";
//        String actualRes1 = getTextfromElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
//        Assert.assertEquals(expectedRes1,actualRes1);


        //Click on List View Tab
        clickOnElement(By.xpath("//a[@class='viewmode-icon list']"));

        //	2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.xpath("//a[text()='Nokia Lumia 1020']"));
        //	2.6 Verify the text “Nokia Lumia 1020”
        String expectedPhone = "Nokia Lumia 1020";
        String actualPhone = getTextfromElement(By.xpath("//h2[@class='product-title']//a[text()='Nokia Lumia 1020']"));
        Assert.assertEquals("Not in Cell Phone page",expectedPhone,actualPhone);
        //	2.7 Verify the price “$349.00”
        String expectedprice = "$349.00";
        String priceActual = getTextfromElement(By.xpath("//span[@class='price actual-price' and text() ='$349.00']"));
        Assert.assertEquals("Price is incorrect:",expectedprice,priceActual);

        //	2.8 Change quantity to 2
        sendTextFromElement(By.xpath("//button[@id='add-to-cart-button-1']"),"2");
        //	2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[3]/div[2]/button[1]"));
        //	2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedProduct = "The product has been added to your shopping cart";
        String actualproduct =getTextfromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals("Product not added to cart ",expectedProduct,actualproduct);
        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@class='close']"));
        //Then MouseHover on "Shopping cart" and Click on "GO TO CART" buttonThen MouseHover on "Shopping cart" and Click on "GO TO CART" button
       mouseHoverToElement(By.xpath("//span[@class='cart-label']"));
       clickOnElement(By.xpath("//button[@class='button-1 cart-button']"));

//        2.12 Verify the message "Shopping cart"
        String expectedshoppingCart = "Shopping cart";
        String actualShoppingCart = getTextfromElement(By.xpath("//h1[text() ='Shopping cart']"));
        Assert.assertEquals("Shopping Cart is not displayed",expectedshoppingCart,actualShoppingCart);

//        2.13 Verify the quantity is 2
        String expectedquantity = "(2)";
        String actualquantity = getTextfromElement(By.xpath("//input[@id='itemquantity11215']"));
        Assert.assertEquals("The quantity is not correct:",expectedquantity,actualquantity);

//        2.14 Verify the Total $698.00
        String expectedTotal = "$698.00";
        String actualTotal = getTextfromElement(By.xpath("//span[@class='product-subtotal']"));
        Assert.assertEquals("Total is not correct",expectedTotal,actualTotal);
        Thread.sleep(2000);

//        2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));
        //        2.16 Click on checkout
        clickOnElement(By.id("checkout"));

//“2.17 Verify the Text “Welcome, Please Sign In!”
        String expectedWelcomeMsg = "Welcome, Please Sign In!";
        String actualWelcomeMsg = getTextfromElement(By.xpath("//h1[text()='Welcome, Please Sign In!']"));
        Assert.assertEquals("Welcome Message Is incorrect:",expectedWelcomeMsg,actualWelcomeMsg);

//        2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath(""));
//        2.19 Verify the text “Register”
        String expectedRegister = "Register";
        String actualRegister = getTextfromElement(By.xpath("//button[contains(text(),'Register')]"));
        Assert.assertEquals("User is not in Registration page",expectedRegister,actualRegister);

//        2.20 Fill the mandatory fields
        sendTextFromElement(By.id("FirstName"),"Proj1");
        sendTextFromElement(By.id("LastName"),"test");
        sendTextFromElement(By.id("Email"),"proj12@yahoo.com");
        sendTextFromElement(By.id("Password"),"Abc123456");
        sendTextFromElement(By.id("ConfirmPassword"),"Abc123456");
        clickOnElement(By.id("register-button"));//      2.21 Click on “REGISTER” Button

        //2.22 Verify the message “Your registration completed”
        String registerDone= "Your registration completed";
        String actualRegisterDone = getTextfromElement(By.xpath("//div[text()='Your registration completed']"));
        Assert.assertEquals("Registration Is Not Completed",registerDone,actualRegisterDone);
//
//        2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[@class='button-1 register-continue-button']"));
//        2.24 Verify the text “Shopping cart”
        String expectedCart = "Shopping cart";
        String actualCart = getTextfromElement(By.xpath("//h1[text()='Shopping cart']"));
        Assert.assertEquals("User is not in cart",expectedCart,actualCart);
        Thread.sleep(1000);

//        2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("termsofservice"));
//        2.26 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
//        2.27 Fill the Mandatory fields
        selectByValueFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"India");
        selectByValueFromDropDown(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"),"Others");
        sendTextFromElement(By.xpath("//input[@id='BillingNewAddress_City']"),"Ahmedabad");
          sendTextFromElement(By.id("BillingNewAddress_Address1"),"3,Wall Street");
        selectByValueFromDropDown(By.id("BillingNewAddress_ZipPostalCode"),"la1 2fh");
        sendTextFromElement(By.id("BillingNewAddress_PhoneNumber"),"07754512");

//        2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
//        2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("//button[@onclick='ShippingMethod.save()']"));
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));

//        2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
//        2.31 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
//        2.32 Select “Visa” From Select credit card dropdown
        selectByValueFromDropDown(By.id("CreditCardType"), "visa");
//        2.33 Fill all the details
       sendTextFromElement(By.id("CardholderName"),"Ms.Jonas");
       sendTextFromElement(By.id("CardNumber"),"5555555555554444");
       selectByValueFromDropDown(By.id("ExpireYear"), "202");
       sendTextFromElement(By.id("CardCode"), "449");
       Thread.sleep(1000);
       //  2.34 Click on “CONTINUE”CHECKOUT”
       clickOnElement(By.xpath("//button[@onclick='PaymentInfo.save()']"));
     //Verify “Payment Method” is “Credit Card”
        String expectedpaymentCard = "Payment Method: Credit Card";
        String actualPaymentCard = getTextfromElement(By.xpath("//li[@class='payment-method']"));
        Assert.assertEquals("Shipping method is Incorrect",expectedpaymentCard,actualPaymentCard);

        //Verify “Shipping Method” is “2nd Day Air”
        String shippingexpected = "Shipping Method: 2nd Day Air";
        String shippingActual = getTextfromElement(By.xpath("//li[@class='shipping-method']"));
//        Verify Total is “$698.00”
        String totalOrder = "Total: $698.00";
        String actualTotalOrder = getTextfromElement(By.xpath("//tr[@class='order-total']"));
        Assert.assertEquals("Total order is wrong" ,totalOrder,actualTotalOrder);
//        2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[@onclick='ConfirmOrder.save()']"));

//        2.39 Verify the Text “Thank You”
        String Thanks = "Thank you";
        String actualThanks = getTextfromElement(By.xpath("//h1[text()='Thank you']"));
        Assert.assertEquals("Thank you is not displayed ",Thanks,actualThanks);
//        2.40 Verify the message “Your order has been successfully processed!”
        String expectedProd = "Your order has been successfully processed!";
        String actualProd = getTextfromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("Oeder is not confirmed",expectedProd,actualProd);
//        2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//a[@class='ico-logout']"));
//        2.42 Verify the text “Welcome to our store”
        String welcomeMsg = "Welcome to our store";
        String actualWelcome = getTextfromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("User Is Not On Home Page",welcomeMsg,actualWelcome);
//        2.43 Click on “Logout” link

//        2.44 Verify the URL is “https://demo.nopcommerce.com
        String url = "https://demo.nopcommerce.com/";
        String actuallUrl = driver.getCurrentUrl();
        Assert.assertEquals("Wrong Url", url, actuallUrl);





    }


}
