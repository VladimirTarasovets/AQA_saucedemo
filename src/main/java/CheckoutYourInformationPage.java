import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutYourInformationPage {

    SelenideElement firstName = $("#first-name");
    SelenideElement lastName = $("#last-name");
    SelenideElement postalCode = $("#postal-code");
    SelenideElement cancel = $("#cancel");
    SelenideElement continueC = $("#continue");

}
