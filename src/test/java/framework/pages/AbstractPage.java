package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

abstract class AbstractPage implements ConstantsKeeper {
    WebDriver driver;

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

    protected static Object getElement(By by, WebDriver driver) {
        if (existsElement(by,driver)) {
            return driver.findElement(by);
        }
        else {
            throw new NoSuchElementException("Can't find element by selector " + by.toString());
        }
    }
}
