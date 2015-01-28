package news360.pageobject;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class NewsPage extends Page {

    private static final String SETTINGS = ".user.default";

    @Override
    public boolean isOpened() {
        return $(By.cssSelector(SETTINGS)).isDisplayed();
    }

}
