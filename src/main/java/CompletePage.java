import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CompletePage {

    SelenideElement backHome = $("#back-to-products");
    SelenideElement pageTitleComplete = $(By.xpath("//span[contains(text(),'Checkout: Complete!')]"));

    @Step("Страница успешной опкупки")
    public SelenideElement getPageTitleComplete() {
        return pageTitleComplete;
    }




}
