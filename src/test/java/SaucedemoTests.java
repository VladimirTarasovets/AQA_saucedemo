import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;


public class SaucedemoTests extends BeAfAll{

    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();
    YourCartPage yourCartPage = new YourCartPage();
    YourInformationPage yourInformationPage = new YourInformationPage();
    OverviewPage overviewPage = new OverviewPage();
    CompletePage completePage = new CompletePage();

    @Flaky
    @Severity(SeverityLevel.BLOCKER)
    @Description("Логин тест")
    @Feature("Логирование")
    @Issue("SD001")
    @Link("https://github.com/VladimirTarasovets/AQA_saucedemo")
    @Owner("Vladimir Tarasovets")
    @Test
    @DisplayName("Тест авторизация на сайте")
    public void loginTest() throws IOException {
        loginPage.openLoginPage();
        loginPage.logIn();
        Assertions.assertTrue(productsPage.getPageTitle().isDisplayed(), "Открыта правильная страница");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Тест покупки")
    @Feature("Покупка")
    @Issue("SD002")
    @Link("https://github.com/VladimirTarasovets/AQA_saucedemo")
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

    @Severity(SeverityLevel.MINOR)
    @Description("Тест отмены покупки")
    @Feature("Отмена покупки")
    @Issue("SD003")
    @Link("https://github.com/VladimirTarasovets/AQA_saucedemo")
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

    @Severity(SeverityLevel.TRIVIAL)
    @Description("Тест удаления всех товаров из корзины")
    @Feature("Удаление товаров")
    @Issue("SD004")
    @Link("https://github.com/VladimirTarasovets/AQA_saucedemo")
    @Test
    @DisplayName("Тест удаления всех товаров из корзины")
    public void removingItemsFromTheCartTest() throws IOException {
        loginPage.openLoginPage();
        loginPage.logIn();
        productsPage.addMultipleItemsToCart();
        productsPage.clickContainer();
        yourCartPage.removingAllItemsFromTheCart();
        Assertions.assertEquals(yourCartPage.getCartItems(), 0, "Товары не удалены из корзины");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Тест проверка корректности подсчета общей суммы набранных товаров")
    @Feature("Считаем деньги")
    @Issue("SD005")
    @Link("https://github.com/VladimirTarasovets/AQA_saucedemo")
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
        Assertions.assertEquals(overviewPage.getItemTotal(), overviewPage.getInventoryItemPriceSum(),
                "Общая сумма товара подсчитана не коректно");

        System.out.println(overviewPage.getItemTotal());
        System.out.println(overviewPage.getInventoryItemPriceSum());
    }

}
