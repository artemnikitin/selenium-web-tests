package exness.pageobject;

import exness.Config;
import exness.Sections;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class CalculatorPage extends Page {

    public CalculatorPage() {
        open(Config.getBaseUrl() + Config.getSection(Sections.CALCULATOR));
        isOpened();
    }

    public CalculatorPage chooseAccountType(String type) {
        $$(".ui-select.ng-scope").get(0).click();
        selectElementFromList(type);
        return this;
    }

    public CalculatorPage chooseExchange(String exchange) {
        $$(".ui-select.ng-scope").get(1).click();
        selectElementFromList(exchange);
        return this;
    }

    public CalculatorPage chooseContract(String contract) {
        $$(".ui-select.ng-scope").get(2).click();
        selectElementFromList(contract);
        return this;
    }

    public CalculatorPage setLot(String lot) {
        $("#id_Lot").clear();
        $("#id_Lot").setValue(lot);
        return this;
    }

    public CalculatorPage chooseLeverage(String leverage) {
        $$(".ui-select.ng-scope").get(3).click();
        selectElementFromList(leverage);
        return this;
    }

    public CalculatorPage chooseCcy(String ccy) {
        $$(".ui-select.ng-scope").get(4).click();
        selectElementFromList(ccy);
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

    private void selectElementFromList(String elementText) {
       $$(".ui-selectItem.ng-scope").forEach(element -> {
           if (element.getText().equals(elementText))
               element.click();
       });
    }

}
