package lazada.pageobject;

import lazada.Config;
import lazada.model.ProductInfo;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProductPage extends Page {

    public ProductPage(String product) {
       open(Config.getBaseUrl() + "/" + product);
    }

    public CartForm addToCart(){
        $("#AddToCart").click();
        return new CartForm();
    }

    public String getProductTitle() {
        return $("#prod_title").innerText();
    }

    public String getProductPrice() {
        return $("#special_price_box").innerText();
    }

    public ProductInfo getProductInfo() {
        return new ProductInfo($("#prod_title").innerText(), $("#special_price_box").innerText());
    }

    @Override
    public boolean isOpened() {
        return $("#AddToCart").isDisplayed();
    }

}
