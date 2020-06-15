package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class CloudGoogle extends AbstractPage{
    private static final String SEARCH_FIELD = "q";
    private static final String URL_TO_GOOGLE = "https://cloud.google.com/";

    public CloudGoogle(WebDriver driver) {
        super(driver);
    }

    public SearchCalculatorPage searchCalculator() {
        new Actions(driver).click(getElement(By.name(SEARCH_FIELD), driver))
                .sendKeys(SEARCHING_TEXT)
                .sendKeys(Keys.ENTER).perform();
        logger.info("Searching started");

        return new SearchCalculatorPage(driver);
    }

    public CloudGoogle openPage() {
        driver.navigate().to(URL_TO_GOOGLE);
        return this;
    }
}
