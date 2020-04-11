package framework.pages;

import framework.service.TestDataReader;
import org.openqa.selenium.WebDriver;

abstract class AbstractPage {
    final String SEARCHING_FIELD = TestDataReader.getTestData("cloudgoogle.searchingField");

    WebDriver driver;

    final int WAIT_TIMEOUT_SECONDS = 20;

    AbstractPage(WebDriver driver) {
        this.driver = driver;
    }
}
