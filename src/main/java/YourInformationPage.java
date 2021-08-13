import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class YourInformationPage {

    SelenideElement firstName = $("#first-name");
    SelenideElement lastName = $("#last-name");
    SelenideElement postalCode = $("#postal-code");
    SelenideElement cancelClick = $("#cancel");
    SelenideElement continueClick = $("#continue");

    @Step("Заполнение информации о себе")
    public void yourInformationFilling(){
        firstName.sendKeys("first name");
        lastName.sendKeys("last name");
        postalCode.sendKeys("2020327");
    }

    @Step("Далее")
    public void continueClick(){
        continueClick.click();
    }

    @Step("Отмена покупки")
    public void cancelClick(){
        cancelClick.click();
    }


}
