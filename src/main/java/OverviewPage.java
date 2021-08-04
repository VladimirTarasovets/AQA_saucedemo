import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OverviewPage {

    SelenideElement finish = $("#finish");
    SelenideElement itemTotal = $(".summary_subtotal_label");
    ElementsCollection inventoryItemPrice = $$(".inventory_item_price");

    public void finish(){
        finish.click();
    }

    public double getItemTotal() {
        String sPrice = itemTotal.getText().replace("Item total: $", "");
        Double dPrice = Double.parseDouble(sPrice);
        return dPrice;
    }

    public double getInventoryItemPriceSum() {
        List<Double> prices = inventoryItemPrice.stream()
                .map(m -> m.getText().replace("$", ""))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        Double itemsPriceSum = prices.stream().reduce(0.0, Double::sum);
        return itemsPriceSum;
    }
}
