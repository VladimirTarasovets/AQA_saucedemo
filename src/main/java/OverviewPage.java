import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class OverviewPage {

    SelenideElement finish = $("#finish");
    SelenideElement itemTotal = $("#summary_subtotal_label");
    SelenideElement inventoryItemPrice = $("#inventory_item_price");

    public void finish(){
        finish.click();
    }


}
