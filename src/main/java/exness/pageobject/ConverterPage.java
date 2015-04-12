package exness.pageobject;

import exness.Config;
import exness.model.Currency;
import exness.model.Sections;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ConverterPage extends Page {

    public ConverterPage() {
        open(Config.getBaseUrl() + Config.getSection(Sections.CONVERTER));
        isOpened();
    }

    @Step("Choose currency from popular for source")
    public ConverterPage chooseCcyFromPopularForSource(Currency ccy) {
        $("*[ng-model='sourceAmount']").click();
        $(By.xpath("//li[@class='converter-popularItem' and text()='" + ccy.getType() + "']")).click();
        return this;
    }

    @Step("Choose currency from popular for target")
    public ConverterPage chooseCcyFromPopularForTarget(Currency ccy) {
        $("*[ng-model='targetAmount']").click();
        $(By.xpath("//li[@class='converter-popularItem' and text()='" + ccy.getType() + "']")).click();
        return this;
    }

    @Step("Choose currency from list for source")
    public ConverterPage chooseCcyFromListForSource(Currency ccy) {
        $("*[ng-model='sourceAmount']").click();
        $(By.xpath("//li[@class='converter-currenciesItem']//span[text()='" + ccy.getType() + "']")).click();
        return this;
    }

    @Step("Choose currency from list for target")
    public ConverterPage chooseCcyFromListForTarget(Currency ccy) {
        $("*[ng-model='targetAmount']").click();
        $(By.xpath("//li[@class='converter-currenciesItem']//span[text()='" + ccy.getType() + "']")).click();
        return this;
    }

    @Step("Check that currency is set for source")
    public boolean checkThatCcyIsSetForSource(Currency ccy) {
        return $("*[ng-bind='source']").getText().equals(ccy.getType());
    }

    @Step("Check that currency is set for target")
    public boolean checkThatCcyIsSetForTarget(Currency ccy) {
        return $("*[ng-bind='target']").getText().equals(ccy.getType());
    }

    @Step("Set value for source currency")
    public ConverterPage setCcyValue(String sum) {
        $("*[ng-model='sourceAmount']").click();
        $("*[ng-model='sourceAmount']").setValue(sum);
        return this;
    }

    @Step("Press 'Calculate'")
    public double calculate() {
        $(".ui-btn.ui-btn__middle.md-hidden").click();
        $("*[ng-model='targetAmount']").click();
        return Double.parseDouble($("*[ng-model='targetAmount']").getAttribute("value"));
    }

    @Step("Press 'Clean'")
    public ConverterPage clean() {
        $("*[ng-click='resetFields()']").click();
        return this;
    }

    @Step("Check that currencies value are cleaned")
    public boolean checkThatFormIsCleaned() {
        double source, target;
        try {
            source = Double.parseDouble($("*[ng-model='sourceAmount']").getAttribute("value"));
        } catch (NumberFormatException e) {
            source = 0;
        }
        try {
            target = Double.parseDouble($("*[ng-model='targetAmount']").getAttribute("value"));
        } catch (NumberFormatException e) {
            target = 0;
        }
        return source == 0 && target == 0;
    }

    @Override
    public boolean isOpened() {
        boolean tab = $(".ui-sectionsInTabItem.ui-sectionsInTabItem__choosed").isDisplayed();
        boolean text = $(".txt-h3.converter-tabText").isDisplayed();
        return tab && text;
    }

}
