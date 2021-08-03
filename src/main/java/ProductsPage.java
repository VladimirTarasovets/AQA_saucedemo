import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProductsPage {

    SelenideElement addSauceLabsBackpack = $("#add-to-cart-sauce-labs-backpack");
    SelenideElement addSauceLabsBikeLight = $("#add-to-cart-sauce-labs-bike-light");
    SelenideElement addSauceLabsBoltTShirt = $("#add-to-cart-sauce-labs-bolt-t-shirt");
    SelenideElement addSauceLabsFleeceJacket = $("#add-to-cart-sauce-labs-fleece-jacket");
    SelenideElement addSauceLabsOnesie = $("#add-to-cart-sauce-labs-onesie");
    SelenideElement addTestAllTheThingsTShirtRed = $(By.name("#add-to-cart-test.allthethings()-t-shirt-(red)"));
    SelenideElement removeSauceLabsBackpack = $("#remove-sauce-labs-backpack");
    SelenideElement removeSauceLabsBikeLight = $("#remove-sauce-labs-bike-light");
    SelenideElement removeSauceLabsBoltTShirt = $("#remove-sauce-labs-bolt-t-shirt");
    SelenideElement removeSauceLabsFleeceJacket = $("#remove-sauce-labs-fleece-jacket");
    SelenideElement removeSauceLabsOnesie = $("#remove-sauce-labs-onesie");
    SelenideElement removeTestAllTheThingsTShirtRed = $("#remove-test.allthethings()-t-shirt-(red)");
    SelenideElement shoppingCartContainer = $("#shopping_cart_container");
    SelenideElement menu = $("#react-burger-menu-btn");
    SelenideElement pageTitle = $(By.xpath("//span[contains(text(),'Products')]"));

    public SelenideElement getPageTitle() {
        return pageTitle;
    }

    public void addOneItemToCart() {
        addSauceLabsBackpack.click();
    }

    public void addMultipleItemsToCart () {
        addSauceLabsBackpack.click();
        addSauceLabsBikeLight.click();
        addSauceLabsBoltTShirt.click();
        addSauceLabsOnesie.click();
    }

    public void clickContainer () {
        shoppingCartContainer.click();
    }


}
