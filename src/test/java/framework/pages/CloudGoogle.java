package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class CloudGoogle {
    private WebDriver driver;
    private final String SEARCHING_FIELD = "Google Cloud Platform Pricing Calculator";

    public CloudGoogle(WebDriver driver) {
        this.driver = driver;
    }

    public SearchingCalculatorPage searchCalculator() {
        new Actions(driver).click(new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(By.name("q"))))
                .sendKeys(SEARCHING_FIELD)
                .sendKeys(Keys.ENTER).perform();

        return new SearchingCalculatorPage(driver);
    }
}
