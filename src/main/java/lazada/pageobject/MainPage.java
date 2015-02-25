package lazada.pageobject;

import lazada.Config;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage extends Page {

    public MainPage() {
        open(Config.getBaseUrl());
    }

    public SignUpForm signUp() {
        $("li[data-authen='1']").click();
        return new SignUpForm();
    }

    @Override
    public boolean isOpened() {
        return $(".header__logo__img").isDisplayed() && $("#searchInput").isDisplayed();
    }

}
