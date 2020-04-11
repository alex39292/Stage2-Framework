package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class SearchingCalculatorPage extends AbstractPage{

    public SearchingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public CalculatorPage openCalculator() {
        new Actions(driver).click(new FluentWait<>(driver).withTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(By.linkText(SEARCHING_FIELD))))
                .perform();

        return new CalculatorPage(driver);
    }
}
