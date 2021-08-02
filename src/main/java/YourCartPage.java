import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class YourCartPage {

    SelenideElement checkout = $("#checkout");
    SelenideElement continueShopping = $("#continue-shopping");
    SelenideElement cartList = $("#cart_list");
    SelenideElement remove = $(By.xpath("//button[text()='Remove']"));
//  div[class='cart_contents_container']

    public void checkout() {
        checkout.click();
    }

    public void numberOfItemsInTheCart () {
        ElementsCollection productCollection = cartList.$$("cart_item");
        int productSizeBefore = productCollection.size();
        productCollection.first().$(By.xpath("//button[text()='Remove']")).click();
    }




}
