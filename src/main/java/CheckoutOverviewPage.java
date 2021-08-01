import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutOverviewPage {

    SelenideElement finish = $("#finish");
    SelenideElement itemTotal = $("#summary_subtotal_label");
    SelenideElement inventoryItemPrice = $("#inventory_item_price");


}
