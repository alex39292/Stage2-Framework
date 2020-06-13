package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchCalculatorPage extends AbstractPage {

    public SearchCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public CalculatorPage openCalculator() {
        ((WebElement) getElement(By.linkText(SEARCHING_TEXT), driver)).click();
        return new CalculatorPage(driver);
    }
}
