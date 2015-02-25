package lazada.model;

public class ProductInfo {

    private final String productTitle;
    private final String productPrice;

    public ProductInfo(String productTitle, String productPrice) {
        this.productPrice = productPrice;
        this.productTitle = productTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductInfo that = (ProductInfo) o;

        if (!productPrice.equals(that.productPrice)) return false;
        if (!productTitle.equals(that.productTitle)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productTitle.hashCode();
        result = 31 * result + productPrice.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ProductInfo{" +
                "productTitle='" + productTitle + '\'' +
                ", productPrice='" + productPrice + '\'' +
                '}';
    }

}
