package lazada.test

import com.codeborne.selenide.WebDriverRunner
import lazada.Config
import lazada.model.ProductInfo
import lazada.pageobject.CartForm
import lazada.pageobject.ProductPage
import spock.lang.Specification


class AddToCartTest extends Specification {

    def "Add product to cart and check that information about product is correct"() {

        given: "Open product page"
            ProductPage product = new ProductPage(Config.product1Page)

        when: "Get information about product and add it to cart"
            ProductInfo fromProductPage = product.productInfo
            CartForm cart = product.addToCart()
        then: "Check that cart is open"
            cart.opened
            cart.numberOfItemsInCart == 1

        when: "Get information about product from cart"
            ProductInfo fromCart = new ProductInfo(cart.getProductTitle(0), cart.getProductPrice(0))
        then: "Check that information is correct"
            fromProductPage == fromCart

    }

    def cleanup() {
        WebDriverRunner.clearBrowserCache()
    }

}
