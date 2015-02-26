# selenium-web-tests

If you want to run tests please install last version of Firefox browser first, tests doesn't have another dependencies.
To run tests you need to have an Internet access and use ```./gradlew clean test``` for Linux/MacOS or ```gradlew clean test``` for Windows, it will install Gradle, if you don't have it, and launch tests.

Test data located in the ```test.conf``` file.

I wrote tests using Spock and Selenide. Spock helps with writing nice tests in a BDD style without separation description and implementation. Selenide it's a wrapper for the Selenium WebDriver with a very nice API.

I had two problems during writing tests:

1) In the description of the test assignment for the second test you specified that I'll need to check delivery dates between product page and cart popup. But I was unable to find info about delivery dates into cart popup. Therefore, I skipped this check.

2) In the third test when I changing quantity of a product in the cart popup, refresh of cart popup happens and I wasn't been able to find a best solution for dealing with this. My decision was using sleep for sometime. Another solution was to check for specific text on cart popup after updating, but in the big international product, such as Lazada web app, there can be problem with this approach because of localization issues.

