package exness.tests

import exness.model.Currency
import exness.pageobject.CalculatorPage
import spock.lang.Specification

class CalculatorPageTest extends Specification {

    def "Test for calculator" () {
        given: "Calculator page is opened"
            CalculatorPage page = new CalculatorPage()

        when: "Choose data and calculate result"
            page.chooseAccountType(CalculatorPage.Account.COMMON)
                .chooseExchange(CalculatorPage.Exchange.FOREX)
                .chooseContract(CalculatorPage.CurrencyPair.EURUSD)
                .setLot("11")
                .chooseLeverage(CalculatorPage.Leverage.TWO_HUNDRED)
                .chooseCcy(Currency.USD)
                .calculate()
        then: "Check that result is displayed"
            page.checkCalculatedResults()
    }

}
