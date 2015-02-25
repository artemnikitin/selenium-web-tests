package lazada.pageobject;

public class CartForm extends Page {

    public int getNumberOfItemsInCart() {
        return 1;
    }

    public long getSubtotalPrice(){
        return 1;
    }

    public String getProductTitle(int position) {
        return "";
    }

    public String getProductPrice(int position){
        return "";
    }

    public CartForm changeProductQty(int position, int qty) {
        return this;
    }

    @Override
    public boolean isOpened() {
        return false;
    }

}
