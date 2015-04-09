package exness.pageobject;

import exness.Config;
import exness.model.Currency;
import exness.model.Sections;

import static com.codeborne.selenide.Selenide.*;

public class CalculatorPage extends Page {

    public CalculatorPage() {
        open(Config.getBaseUrl() + Config.getSection(Sections.CALCULATOR));
        isOpened();
    }

    public CalculatorPage chooseAccountType(Account account) {
        $$(".ui-select.ng-scope").get(0).click();
        $(".ui-selectItem.ng-scope[data-value='" + account.type + "']").click();
        return this;
    }

    public CalculatorPage chooseExchange(Exchange exchange) {
        $$(".ui-select.ng-scope").get(1).click();
        $(".ui-selectItem.ng-scope[data-value='" + exchange.type + "']").click();
        return this;
    }

    public CalculatorPage chooseContract(CurrencyPair contract) {
        $$(".ui-select.ng-scope").get(2).click();
        $(".ui-selectItem.ng-scope[data-value='" + contract.type + "']").click();
        return this;
    }

    public CalculatorPage setLot(String lot) {
        $("#id_Lot").setValue(lot);
        return this;
    }

    public CalculatorPage chooseLeverage(Leverage leverage) {
        $$(".ui-select.ng-scope").get(3).click();
        $(".ui-selectItem.ng-scope[data-value='" + leverage.type + "']").click();
        return this;
    }

    public CalculatorPage chooseCcy(Currency ccy) {
        $$(".ui-select.ng-scope").get(4).click();
        $(".ui-selectItem.ng-scope[data-value='" + ccy.getType() + "']").click();
        return this;
    }

    public CalculatorPage calculate() {
        $(".ui-btn.ui-btn__btn.ui-btn__big").click();
        return this;
    }

    public boolean checkCalculatedResults() {
        return $$(".col.calc-colResultLabel").size() == 5 && !isOpened();
    }

    @Override
    public boolean isOpened() {
        return $(".col.calc-colResult.calc-colResult__prepareState").isDisplayed();
    }

    public enum Exchange {
        FOREX("Forex"),
        NYMEX("NYMEX");

        private final String type;

        Exchange(String type) {
            this.type = type;
        }
    }

    public enum Leverage {
        HUNDRED("100"),
        TWO_HUNDRED("200");

        private final String type;

        Leverage(String type) {
            this.type = type;
        }
    }

    public enum Account {
        COMMON("common"),
        CENT("cent");

        private final String type;

        Account(String type) {
            this.type = type;
        }
    }

    public enum CurrencyPair {
        EURUSD("EURUSD");

        private final String type;

        CurrencyPair(String type) {
            this.type = type;
        }
    }

}

