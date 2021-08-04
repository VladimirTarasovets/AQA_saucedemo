import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class YourCartPage {

    SelenideElement checkout = $("#checkout");
    SelenideElement continueShopping = $("#continue-shopping");
    SelenideElement cartList = $(".item_pricebar");
    SelenideElement remove = $(By.xpath("//button[text()='Remove']"));


    public void checkout() {
        checkout.click();
    }

    public void numberOfItemsInTheCart () {
        ElementsCollection productCollection = cartList.$$("button");
        int productSizeBefore = productCollection.size();
        // добавить условие для удаления всех товаров
        productCollection.first().click();
    }


}
