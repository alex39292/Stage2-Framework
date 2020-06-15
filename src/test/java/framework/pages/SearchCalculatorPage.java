package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchCalculatorPage extends AbstractPage {

    public SearchCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public CalculatorPage openCalculator() {
        (getElement(By.linkText(SEARCHING_TEXT), driver)).click();
        return new CalculatorPage(driver);
    }
}
