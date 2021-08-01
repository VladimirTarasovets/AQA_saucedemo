import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class YourCartPage {

    SelenideElement checkout = $("#checkout");
    SelenideElement continueShopping = $("#continue-shopping");
    SelenideElement cartItem = $("#item_pricebar");
    SelenideElement remove = $(By.xpath("//button[text()='Remove']"));
//  div[class='cart_contents_container']




}
