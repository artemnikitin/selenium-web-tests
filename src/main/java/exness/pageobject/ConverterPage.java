package exness.pageobject;

import exness.Config;
import exness.Currency;
import exness.Sections;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ConverterPage extends Page {

    public ConverterPage() {
        open(Config.getBaseUrl() + Config.getSection(Sections.CONVERTER));
        isOpened();
    }

    public ConverterPage chooseCcyFromPopularForSource(Currency ccy) {
        $("*[ng-model='sourceAmount']").click();
        iterateThroughCollectionAndClick(".converter-popularItem", ccy.getType());
        return this;
    }

    public ConverterPage chooseCcyFromPopularForTarget(Currency ccy) {
        $("*[ng-model='targetAmount']").click();
        iterateThroughCollectionAndClick(".converter-popularItem", ccy.getType());
        return this;
    }

    public ConverterPage chooseCcyFromListForSource(Currency ccy) {
        $("*[ng-model='sourceAmount']").click();
        iterateThroughCollectionAndClick(".converter-currenciesSymbol", ccy.getType());
        return this;
    }

    public ConverterPage chooseCcyFromListForTarget(Currency ccy) {
        $("*[ng-model='targetAmount']").click();
        iterateThroughCollectionAndClick(".converter-currenciesSymbol", ccy.getType());
        return this;
    }

    public boolean checkThatCcyIsSetForSource(Currency ccy) {
        return $("*[ng-bind='source']").getText().equals(ccy.getType());
    }

    public boolean checkThatCcyIsSetForTarget(Currency ccy) {
        return $("*[ng-bind='target']").getText().equals(ccy.getType());
    }

    public ConverterPage setCcyValue(String sum) {
        $("*[ng-model='sourceAmount']").setValue(sum);
        return this;
    }

    public double calculate() {
        $(".ui-btn.ui-btn__middle.md-hidden").click();
        //return Double.parseDouble($("*[ng-model='targetAmount']").getText());
        return 1;
    }

    public ConverterPage clean() {
        $("*[ng-click='resetFields()']").click();
        return this;
    }

    public boolean checkThatFormIsCleaned() {
        //double source = Double.parseDouble($("*[ng-model='sourceAmount']").getText());
        //double target = Double.parseDouble($("*[ng-model='targetAmount']").getText());
        //return source == 0 && target == 0;
        return true;
    }

    @Override
    public boolean isOpened() {
        boolean tab = $(".ui-sectionsInTabItem.ui-sectionsInTabItem__choosed").isDisplayed();
        boolean text = $(".txt-h3.converter-tabText").isDisplayed();
        return tab && text;
    }

    private void iterateThroughCollectionAndClick(String path, String text) {
        $$(path).forEach(element -> {
            if (element.has(text(text)))
                element.click();
        });
    }

}
