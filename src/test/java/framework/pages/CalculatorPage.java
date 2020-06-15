package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalculatorPage extends AbstractPage{
    private static final By IFRAME = By.tagName("iframe");
    private static final String URL_TO_GOOGLE_CALCULATOR = "https://cloud.google.com/products/calculator";

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    public FrameCalculatorPage switchToFrame() {
        logger.info("Calculator page has been opened");

          while(existsElement(IFRAME, driver)) {
              if (driver.findElement(IFRAME).getAttribute("id").equals("MyFrame")) {
                  break;
              }
              logger.info("Switching iframes");
              driver.get((getElement(IFRAME, driver)).getAttribute("src"));
          }
//
        return new FrameCalculatorPage(driver);
    }

    public CalculatorPage openPage() {
        driver.navigate().to(URL_TO_GOOGLE_CALCULATOR);
        return this;
    }
}
