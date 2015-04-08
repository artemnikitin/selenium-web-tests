package exness.tests

import exness.Currency
import exness.pageobject.ConverterPage
import spock.lang.Specification

class ConverterPageTest extends Specification {

    def "Test for converter" () {
        given: "Page is opened"
            ConverterPage page = new ConverterPage()

        when: "Set currency from popular"
            page.chooseCcyFromPopularForSource(Currency.USD)
                .chooseCcyFromPopularForTarget(Currency.EUR)
        then: "Check that currency is set"
            page.checkThatCcyIsSetForSource(Currency.USD)
            page.checkThatCcyIsSetForTarget(Currency.EUR)

        when: "Set currency from list"
            page.chooseCcyFromListForSource(Currency.EUR)
                .chooseCcyFromListForTarget(Currency.USD)
        then: "Check that currency is set"
            page.checkThatCcyIsSetForSource(Currency.EUR)
            page.checkThatCcyIsSetForTarget(Currency.USD)

        when: "Set sum and calculate"
            double calculation = page.setCcyValue("11").calculate()
        then: "Check that result is displayed"
            calculation > 0

        when: "Clean form"
            page.clean()
        then: "Check that form is cleaned"
            page.checkThatFormIsCleaned()
    }

}
