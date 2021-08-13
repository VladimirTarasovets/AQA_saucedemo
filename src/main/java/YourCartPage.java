import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class YourCartPage {

    SelenideElement checkout = $("#checkout");
    SelenideElement continueShopping = $("#continue-shopping");
    SelenideElement remove = $(By.xpath("//button[text()='Remove']"));
    ElementsCollection cartItems = $$(By.xpath("//div[@class='cart_item']"));

    public int getCartItems() {
        return cartItems.size();
    }

    @Step("Далее")
    public void checkout() {
        checkout.click();
    }

    @Step("Удаление всех товаров из корзины")
    public void removingAllItemsFromTheCart (){
        for (int beforeCartItems = getCartItems(); beforeCartItems > 0; beforeCartItems--) {
            remove.click();
        }
    }


}
