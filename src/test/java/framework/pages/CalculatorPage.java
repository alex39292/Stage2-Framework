package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class CalculatorPage extends AbstractPage{
    private final String URL = "https://cloud.google.com/products/calculator";

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    private boolean existsElement(By by) {
        try {
            new FluentWait<>(driver).withTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public FrameCalculatorPage switchToFrame() {
        logger.info("Calculator page has been opened");
        while(existsElement(By.tagName("iframe"))) {
            logger.info("Switching iframes");
            driver.get(new FluentWait<>(driver).withTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                    .ignoring(NoSuchElementException.class)
                    .until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe"))).getAttribute("src"));
        }
        logger.info("Switched to needed iframe");
        return new FrameCalculatorPage(driver);
    }

    public CalculatorPage openPage() {
        driver.navigate().to(URL);
        return this;
    }
}
