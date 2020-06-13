package framework.pages;

import framework.service.TestDataReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

abstract class AbstractPage {
    protected final Logger logger = LogManager.getRootLogger();
    final String SEARCHING_FIELD = TestDataReader.getTestData("cloudgoogle.searchingField");

    WebDriver driver;

    final int WAIT_TIMEOUT_SECONDS = 20;
    final int DOUBLEWAIT_TIMEOUT_SECONDS = 40;

    AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    protected boolean existsElement(By by) {
        try {
            new FluentWait<>(driver).withTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}
