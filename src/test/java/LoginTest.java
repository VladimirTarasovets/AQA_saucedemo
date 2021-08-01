import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Configuration;


import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.IOException;


public class LoginTest {

    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();
    YourCartPage yourCartPage = new YourCartPage();
    CheckoutYourInformationPage checkoutYourInformationPage = new CheckoutYourInformationPage();
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();

    @BeforeEach
    public void setUp() {
    Configuration.startMaximized = true;
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    public void loginTest() throws IOException {
        loginPage.openLoginPage();
        loginPage.logIn();
//        Assertions.assertEquals("https://www.saucedemo.com/inventory.html",
//                "Открыта не правильная страница или адресс страницы неверный");

    }

    @Test
    public void purchaseTest() throws IOException {
        loginPage.openLoginPage();
        loginPage.logIn();
        productsPage.addSauceLabsBackpack.click();
        productsPage.shoppingCartContainer.click();
        yourCartPage.checkout.click();
        checkoutYourInformationPage.firstName.sendKeys("first name");
        checkoutYourInformationPage.lastName.sendKeys("last name");
        checkoutYourInformationPage.postalCode.sendKeys("2020327");
        checkoutYourInformationPage.continueC.click();
        checkoutOverviewPage.finish.click();
        //        Assertions.assertEquals("https://www.saucedemo.com/inventory.html",
//                "Открыта не правильная страница или адресс страницы неверный");

    }

    @Test
    public void cancellationOfPurchaseTest() throws IOException {
        loginPage.openLoginPage();
        loginPage.logIn();
        productsPage.addSauceLabsBackpack.click();
        productsPage.shoppingCartContainer.click();
        yourCartPage.checkout.click();
        checkoutYourInformationPage.firstName.sendKeys("first name");
        checkoutYourInformationPage.lastName.sendKeys("last name");
        checkoutYourInformationPage.postalCode.sendKeys("2020327");
        checkoutYourInformationPage.continueC.click();
        checkoutYourInformationPage.cancel.click();

        //        Assertions.assertEquals("https://www.saucedemo.com/inventory.html",
//                "Открыта не правильная страница или адресс страницы неверный");

    }

    @Test
    public void removingItemsFromTheCartTest() throws IOException {
        loginPage.openLoginPage();
        loginPage.logIn();
        productsPage.addSauceLabsBackpack.click();
        productsPage.addSauceLabsBikeLight.click();
        productsPage.addSauceLabsBoltTShirt.click();
        productsPage.addSauceLabsOnesie.click();
        productsPage.shoppingCartContainer.click();
        ElementsCollection productCollection = yourCartPage.cartItem.$$("cart_item");
        int productSizeBefore = productCollection.size();
        productCollection.first().$(By.xpath("//button[text()='Remove']")).click();


        //        Assertions.assertEquals("https://www.saucedemo.com/inventory.html",
//                "Открыта не правильная страница или адресс страницы неверный");

    }

    @Test
    public void countSumsGoodsTest() throws IOException {
        loginPage.openLoginPage();
        loginPage.logIn();
        productsPage.addSauceLabsBackpack.click();
        productsPage.addSauceLabsBikeLight.click();
        productsPage.addSauceLabsBoltTShirt.click();
        productsPage.addSauceLabsOnesie.click();
        productsPage.shoppingCartContainer.click();
        yourCartPage.checkout.click();
        checkoutYourInformationPage.firstName.sendKeys("first name");
        checkoutYourInformationPage.lastName.sendKeys("last name");
        checkoutYourInformationPage.postalCode.sendKeys("2020327");
        checkoutYourInformationPage.continueC.click();

    }


}
