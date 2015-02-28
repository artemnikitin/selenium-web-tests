# selenium-web-tests

If you want to run tests please install the last version of Firefox browser first, tests don't have other dependencies.
To run tests you need to have Internet access and use ```./gradlew clean test``` for Linux/MacOS or ```gradlew clean test``` for Windows, it will install Gradle, if you don't have it, and launch tests.

Test data is located in the ```test.conf``` file.

I wrote tests using Spock and Selenide. Spock helps with writing nice tests in a BDD style without separating the description and the implementation. Selenide is a wrapper for the Selenium WebDriver with a very nice API.

I had two problems while writing the tests:

1) In the description of the test assignment for the second test you specified that I'll need to check delivery dates between the product page and the cart popup. But I was unable to find info about delivery dates in the cart popup. Therefore, I skipped this check.

2) In the third test when I was changing the quantity of a product in the cart popup, the cart popup refreshed and I wasn't able to find a good solution for dealing with this. My decision was using sleep for sometime. Another solution was to check for specific text on the cart popup after updating, but for big international products, such as Lazada web app, there can be a problem with this approach because of localization issues.
