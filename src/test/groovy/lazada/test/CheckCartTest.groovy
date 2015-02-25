package lazada.test

import com.codeborne.selenide.WebDriverRunner
import lazada.Config
import lazada.pageobject.CartForm
import lazada.pageobject.ProductPage
import spock.lang.Specification


class CheckCartTest extends Specification {

    def "Check that changing product qty in cart changes subtotal price"() {

        when: "Open first product page"
            ProductPage product = new ProductPage(Config.product1Page)
        then: "Check that page is opened"
            product.opened

        when: "Add product to cart"
            CartForm cart = product.addToCart()
        then: "Check product is added"
            cart.opened
            cart.numberOfItemsInCart == 1

        when: "Open second product page"
            product = new ProductPage(Config.product2Page)
        then: "Check that page is opened"
            product.opened

        when: "Add second product to cart"
            cart = product.addToCart()
        then: "Check that second product is added"
            cart.opened
            cart.numberOfItemsInCart == 2

        when: "Change qty of first product"
            long previousSubtotal = cart.subtotalPrice
            cart.changeProductQty(0, "2")
        then: "Check that subtotal price is changed"
            cart.subtotalPrice > previousSubtotal

    }

    def cleanup() {
        WebDriverRunner.clearBrowserCache()
    }

}
