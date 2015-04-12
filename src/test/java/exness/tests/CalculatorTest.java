package exness.tests;

import exness.model.Currency;
import exness.pageobject.CalculatorPage;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Features;

import static org.junit.Assert.assertTrue;

@Features("Calculator form")
public class CalculatorTest {

    static CalculatorPage page;

    @BeforeClass
    public static void setup() {
        page = new CalculatorPage();
    }

    @Test
    public void checkThatUserCanChooseAccountType() {
        page.chooseAccountType(CalculatorPage.Account.COMMON);
        assertTrue(page.checkThatValueIsSet(CalculatorPage.Account.COMMON.toString()));
    }

    @Test
    public void checkThatUserCanChooseExchange() {
        page.chooseExchange(CalculatorPage.Exchange.FOREX);
        assertTrue(page.checkThatValueIsSet(CalculatorPage.Exchange.FOREX.toString()));
    }

    @Test
    public void checkThatUserCanChooseContract() {
        page.chooseContract(CalculatorPage.CurrencyPair.EURUSD);
        assertTrue(page.checkThatValueIsSet(CalculatorPage.CurrencyPair.EURUSD.toString()));
    }

    @Test
    public void checkThatUserCanChooseLeverage() {
        page.chooseLeverage(CalculatorPage.Leverage.TWO_HUNDRED);
        assertTrue(page.checkThatValueIsSet(CalculatorPage.Leverage.TWO_HUNDRED.toString()));
    }

    @Test
    public void checkThatUserCanChooseCurrency() {
        page.chooseCcy(Currency.USD);
        assertTrue(page.checkThatValueIsSet(Currency.USD.getType()));
    }

    @Test
    public void checkThatClickingOnCalculateShowsResults() {
        page.setLot("11").calculate();
        assertTrue(page.checkCalculatedResults());
    }

}
