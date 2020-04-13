package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class CloudGoogle extends AbstractPage{
    private final String URL = "https://cloud.google.com/";

    public CloudGoogle(WebDriver driver) {
        super(driver);
    }

    public SearchingCalculatorPage searchCalculator() {
        new Actions(driver).click(new FluentWait<>(driver).withTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(By.name("q"))))
                .sendKeys(SEARCHING_FIELD)
                .sendKeys(Keys.ENTER).perform();
        logger.info("Searching started");
        return new SearchingCalculatorPage(driver);
    }

    public CloudGoogle openPage() {
        driver.navigate().to(URL);
        return this;
    }
}
