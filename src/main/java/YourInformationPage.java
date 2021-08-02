import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class YourInformationPage {

    SelenideElement firstName = $("#first-name");
    SelenideElement lastName = $("#last-name");
    SelenideElement postalCode = $("#postal-code");
    SelenideElement cancelClick = $("#cancel");
    SelenideElement continueClick = $("#continue");

    public void yourInformationFilling(){
        firstName.sendKeys("first name");
        lastName.sendKeys("last name");
        postalCode.sendKeys("2020327");
    }

    public void continueClick(){
        continueClick.click();
    }

    public void cancelClick(){
        cancelClick.click();
    }


}
