package cucumber;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Steps {

    @Допустим("^открыта страница \"([^\"]*)\"$")
    public void openPage(String pageURL) {
        Configuration.startMaximized = true;
        open(pageURL);
    }
    @Допустим("^в поле ввода логина введено значение \"([^\"]*)\"$")
    public void inTheLoginInputFieldEnteredValue(String userName) {
        $("#user-name").sendKeys(userName);
    }
    @Допустим("^в поле ввода пароля введено значение \"([^\"]*)\"$")
    public void inThePasswordInputFieldEnteredValue(String password) {
        $("#password").sendKeys(password);
    }
    @Допустим("^нажата кнопка \"([^\"]*)\"$")
    public void buttonPressed(String text) {
        $(By.cssSelector("input[value='" + text + "']")).click();
    }
    @Тогда("^пользователь авторизован на странице \"([^\"]*)\"$")
    public void userLoggedInToPage(String siteURL) {
        String currentPageURL = getWebDriver().getCurrentUrl();
        Assertions.assertEquals(siteURL, currentPageURL, "Значения ссылок не сопадают");
    }




    @Тогда("^выполнено нажатие на ссылку \"([^\"]*)\"$")
    public void clickOnLink(String link) {
        $(By.xpath("//*[contains(text(), \"" + link + "\")]")).click();
    }
    @Тогда("^цена товара равна \"([^\"]*)\"$")
    public void checkProductPrice(String price) {
        String actualPriceInfo = $(By.className("inventory_details_price")).getText();
        Assertions.assertTrue(actualPriceInfo.contains(price), "Актуальная и ожидаемая цена не совпадают");
    }
}
