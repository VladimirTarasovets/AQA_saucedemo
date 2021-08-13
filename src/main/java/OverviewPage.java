import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OverviewPage {

    SelenideElement finish = $("#finish");
    SelenideElement itemTotal = $(".summary_subtotal_label");
    ElementsCollection inventoryItemPrice = $$(".inventory_item_price");

    @Step("Завершить покупку")
    public void finish(){
        finish.click();
    }

    @Step("Стоимость одного товара")
    public double getItemTotal() {
        String sPrice = itemTotal.getText().replace("Item total: $", "");
        return Double.parseDouble(sPrice);
    }

    @Step("Проверка корректности стоимости товаров в корзине")
    public double getInventoryItemPriceSum() {
        List<Double> prices = inventoryItemPrice.stream()
                .map(m -> m.getText().replace("$", ""))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        return prices.stream().reduce(0.0, Double::sum);
    }
}
