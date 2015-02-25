package lazada.pageobject;

public class ProductPage extends Page {

    public CartForm addToCart(){
        return new CartForm();
    }

    public String getProductTitle() {
        return "";
    }

    public String getProductPrice() {
        return "";
    }

    public boolean checkProductAvailability() {
        return true;
    }

    @Override
    public boolean isOpened() {
        return false;
    }

}
