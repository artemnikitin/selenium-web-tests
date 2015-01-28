package news360.pageobject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import news360.Config;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends Page {

    public MainPage(){
        if(WebDriverRunner.url().equals(Config.getBaseUrl())) Selenide.refresh();
        else Selenide.open(Config.getBaseUrl());
    }

    public AuthByEmailPage goToEmailAuth() {
        $(".eNav.startreading").shouldBe("Button 'Start Reading' must be displayed", visible).click();
        $(".expand.fancybox.login-signin").shouldBe("Option 'Sign In with email' must be displayed", visible).click();
        $(".simplepopup.expand>p").shouldBe("Form for email sign in must be displayed", visible);
        return new AuthByEmailPage();
    }

    @Override
    public boolean isOpened() {
        boolean check1 = $(".bLogo").isDisplayed();
        boolean check2 = $(".eNav.startreading").isDisplayed();
        boolean check3 = $(".eHSignIn_buttons").isDisplayed();
        return check1 && check2 && check3;
    }

}
