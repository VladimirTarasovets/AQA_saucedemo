import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CompletePage {

    SelenideElement backHome = $("#back-to-products");
    SelenideElement pageTitleComplete = $(By.xpath("//span[contains(text(),'Checkout: Complete!')]"));

    public SelenideElement getPageTitleComplete() {
        return pageTitleComplete;
    }




}
