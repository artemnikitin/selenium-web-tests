package lazada.pageobject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartForm extends Page {

    public CartForm() {
        $(".submit_btn.mtssel-cart-checkout-button").should(appear);
    }

    public int getNumberOfItemsInCart() {
        String items = $(".cartintro").innerText();
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(items);
        if (matcher.find())
            return Integer.parseInt(matcher.group(0));
        else
            return 0;
    }

    public long getSubtotalPrice(){
        String price = $(".sub .width_30.right_align.lastcolumn>div").innerText();
        return convertPrice(price);
    }

    public String getProductTitle(int position) {
        return $$(".productdescription").get(position).innerText();
    }

    public String getProductPrice(int position){
        return $$(".width_15.price.center>span:first-child").get(position).innerText();
    }

    public CartForm changeProductQty(int position, String qty) throws InterruptedException {
        $$(".width_10.price.center>select").get(position).selectOption(qty);
        Thread.sleep(1500);// FIXME
        return this;
    }

    @Override
    public boolean isOpened() {
        return $(".submit_btn.mtssel-cart-checkout-button").isDisplayed();
    }

    private long convertPrice(String price) {
       return Long.parseLong(price.replace(" VND", "").replace(".", ""));
    }

}
