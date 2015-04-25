package com.wimdu.pageobject;

import static com.codeborne.selenide.Selenide.$;

public class PersonalPage extends Page {

    @Override
    public boolean isOpened() {
        boolean notification_is_displayed = $(".flash-message.message-green.rounded").isDisplayed();
        boolean dashboard_is_available = $(".current .dashboard").isDisplayed();
        return notification_is_displayed && dashboard_is_available;
    }

}
