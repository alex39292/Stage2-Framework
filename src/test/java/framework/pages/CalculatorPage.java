package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class CalculatorPage {
    private WebDriver driver;

    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public IframeCalculatorPage addData() {

        for (int i = 0; i<2; i++) {
            driver.get(new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20))
                    .ignoring(NoSuchElementException.class)
                    .until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe"))).getAttribute("src"));
        }

        return new IframeCalculatorPage(driver);
    }
}
