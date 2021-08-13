import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    SelenideElement loginName = $("#user-name");
    SelenideElement loginPass = $("#password");
    SelenideElement loginButton = $("#login-button");

    @Step("Авторизация на сайте")
    void logIn() throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("src/main/resources/user.properties"));
        loginName.sendKeys(props.getProperty("user.username"));
        loginPass.sendKeys(props.getProperty("user.password"));
        loginButton.click();
    }

    @Step("Открытие страницы авторизации")
    public void openLoginPage(){
        open("https://www.saucedemo.com/");
    }

}
