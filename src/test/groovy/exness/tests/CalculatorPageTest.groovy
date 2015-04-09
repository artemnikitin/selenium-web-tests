package exness.tests

import exness.pageobject.CalculatorPage
import spock.lang.Specification

class CalculatorPageTest extends Specification {

    def "Test for calculator" () {
        given: "Calculator page is opened"
            CalculatorPage page = new CalculatorPage()

        when: "Choose data and calculate result"
            page.chooseAccountType("Common")
                .chooseExchange("Forex - Foreign Exchange")
                .chooseContract("AUDGBP")
                .setLot("11")
                .chooseLeverage("1:400")
                .chooseCcy("AUD - Австралийский доллар")
                .calculate()
        then: "Check that result is displayed"
            page.checkCalculatedResults()
    }

}
