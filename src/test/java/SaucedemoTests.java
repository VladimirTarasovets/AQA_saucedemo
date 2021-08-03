import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Configuration;


import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import java.io.IOException;


public class SaucedemoTests extends BeAfAll{

    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();
    YourCartPage yourCartPage = new YourCartPage();
    YourInformationPage yourInformationPage = new YourInformationPage();
    OverviewPage overviewPage = new OverviewPage();
    CompletePage completePage = new CompletePage();

    @Test
    @DisplayName("Тест авторизация на сайте")
    public void loginTest() throws IOException {
        loginPage.openLoginPage();
        loginPage.logIn();
        Assertions.assertTrue(productsPage.getPageTitle().isDisplayed(), "Открыта правильная страница");
    }

    @Test
    @DisplayName("Тест покупки")
    public void purchaseTest() throws IOException {
        loginPage.openLoginPage();
        loginPage.logIn();
        productsPage.addOneItemToCart();
        productsPage.clickContainer();
        yourCartPage.checkout();
        yourInformationPage.yourInformationFilling();
        yourInformationPage.continueClick();
        overviewPage.finish();
        Assertions.assertTrue(completePage.getPageTitleComplete().isDisplayed(), "Открыта правильная страница");
    }

    @Test
    @DisplayName("Тест отмены покупки")
    public void cancellationOfPurchaseTest() throws IOException {
        loginPage.openLoginPage();
        loginPage.logIn();
        productsPage.addOneItemToCart();
        productsPage.clickContainer();
        yourCartPage.checkout();
        yourInformationPage.yourInformationFilling();
        yourInformationPage.continueClick();
        yourInformationPage.cancelClick();
        Assertions.assertTrue(productsPage.getPageTitle().isDisplayed(), "Открыта правильная страница");
    }

    @Test
    @DisplayName("Тест удаления всех товаров из корзины")
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
    @DisplayName("Тест проверка корректности подсчета общей суммы набранных товаров")
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
