import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Configuration;


import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.IOException;


public class SaucedemoTests {

    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();
    YourCartPage yourCartPage = new YourCartPage();
    YourInformationPage yourInformationPage = new YourInformationPage();
    OverviewPage overviewPage = new OverviewPage();

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
        productsPage.addOneItemToCart();
        productsPage.clickContainer();
        yourCartPage.checkout();
        yourInformationPage.yourInformationFilling();
        yourInformationPage.continueClick();
        overviewPage.finish();

        //        Assertions.assertEquals("https://www.saucedemo.com/inventory.html",
//                "Открыта не правильная страница или адресс страницы неверный");
    }

    @Test
    public void cancellationOfPurchaseTest() throws IOException {
        loginPage.openLoginPage();
        loginPage.logIn();
        productsPage.addOneItemToCart();
        productsPage.clickContainer();
        yourCartPage.checkout();
        yourInformationPage.yourInformationFilling();
        yourInformationPage.continueClick();
        overviewPage.finish();
        yourInformationPage.cancelClick();

        //        Assertions.assertEquals("https://www.saucedemo.com/inventory.html",
//                "Открыта не правильная страница или адресс страницы неверный");
    }

    @Test
    public void removingItemsFromTheCartTest() throws IOException {
        loginPage.openLoginPage();
        loginPage.logIn();
        productsPage.addMultipleItemsToCart();
        productsPage.clickContainer();
        yourCartPage.numberOfItemsInTheCart(); // не доделан

        //        Assertions.assertEquals("https://www.saucedemo.com/inventory.html",
//                "Открыта не правильная страница или адресс страницы неверный");
    }

    @Test
    public void countSumsGoodsTest() throws IOException {
        loginPage.openLoginPage();
        loginPage.logIn();
        productsPage.addMultipleItemsToCart();
        productsPage.clickContainer();
        yourCartPage.checkout();
        yourInformationPage.yourInformationFilling();
        yourInformationPage.continueClick();

    }


}
