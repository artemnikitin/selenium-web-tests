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

    public CalculatorPage chooseAccountType() {
        return this;
    }

    public CalculatorPage chooseExchange() {
        return this;
    }

    public CalculatorPage chooseContract() {
        return this;
    }

    public CalculatorPage setLot(String lot) {
        $("#id_Lot").setValue(lot);
        return this;
    }

    public CalculatorPage chooseLeverage() {
        return this;
    }

    public CalculatorPage chooseCcy() {
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

}
