package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class CalculatorPage extends AbstractPage{
    private final String URL = "https://cloud.google.com/products/calculator";

    public CalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    public IframeCalculatorPage addData() {
        for (int i = 0; i<2; i++) {
            driver.get(new FluentWait<>(driver).withTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                    .ignoring(NoSuchElementException.class)
                    .until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe"))).getAttribute("src"));
        }
        return new IframeCalculatorPage(driver);
    }

    public CalculatorPage openPage() {
        driver.navigate().to(URL);
        return this;
    }
}
