package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class SearchingCalculatorPage extends AbstractPage{

    public SearchingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public CalculatorPage openCalculator() {
        new FluentWait<>(driver).withTimeout(Duration.ofSeconds(DOUBLEWAIT_TIMEOUT_SECONDS))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(By.linkText(SEARCHING_FIELD))).click();

        return new CalculatorPage(driver);
    }
}
