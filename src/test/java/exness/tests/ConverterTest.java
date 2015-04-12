package exness.tests;

import exness.model.Currency;
import exness.pageobject.ConverterPage;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static org.junit.Assert.assertTrue;

@Features("Converter form")
public class ConverterTest {

    static ConverterPage page;

    @BeforeClass
    public static void setup() {
        page = new ConverterPage();
    }

    @Stories("User can set currency from list of currencies")
    @Test
    public void checkThatUserCanSetCcyFromList() {
        page.chooseCcyFromListForSource(Currency.EUR)
            .chooseCcyFromListForTarget(Currency.USD);
        assertTrue(page.checkThatCcyIsSetForSource(Currency.EUR));
        assertTrue(page.checkThatCcyIsSetForTarget(Currency.USD));
    }

    @Stories("User can set currency from list of popular")
    @Test
    public void checkThatUserCanSetCcyFromPopular() {
        page.chooseCcyFromPopularForSource(Currency.USD)
            .chooseCcyFromPopularForTarget(Currency.EUR);
        assertTrue(page.checkThatCcyIsSetForSource(Currency.USD));
        assertTrue(page.checkThatCcyIsSetForTarget(Currency.EUR));
    }

    @Stories("User can click on 'Convert' and see results of convertation")
    @Test
    public void checkThatClickOnCalculateShowsResults() {
        page.setCcyValue("11");
        double result = page.calculate();
        assertTrue(result > 0);
    }

    @Stories("User can clear values by clicking 'Clear'")
    @Test
    public void checkThatClickOnClearClearsValues() {
        page.setCcyValue("1211").clean();
        assertTrue(page.checkThatFormIsCleaned());
    }

}
