package framework.pages;

import framework.service.TestDataReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

abstract class AbstractPage {
    protected static final String SEARCHING_TEXT = TestDataReader.getTestData("cloudgoogle.searchingField");
    protected static final int WAIT_TIMEOUT_SECONDS = 40;
    protected Logger logger = LogManager.getRootLogger();
    protected WebDriver driver;

    AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    protected static boolean existsElement(By by, WebDriver driver) {
        try {
            new FluentWait<>(driver).withTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                    .ignoring(NoSuchElementException.class)
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    protected static WebElement getElement(By by, WebDriver driver) {
        if (existsElement(by,driver)) {
            return driver.findElement(by);
        }
        else {
            throw new NoSuchElementException("Can't find element by selector " + by.toString());
        }
    }
}
