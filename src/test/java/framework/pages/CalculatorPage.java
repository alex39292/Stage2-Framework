package framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculatorPage extends AbstractPage{

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    public FrameCalculatorPage switchToFrame() {
        logger.info("Calculator page has been opened");

          while(existsElement(IFRAME, driver)) {
              if (driver.findElement(IFRAME).getAttribute("id").equals("MyFrame"))
                  break;
              logger.info("Switching iframes");
              driver.get(((WebElement) getElement(IFRAME, driver)).getAttribute("src"));
          }
          logger.info("Switched to needed iframe");

        return new FrameCalculatorPage(driver);
    }

    public CalculatorPage openPage() {
        driver.navigate().to(URL_TO_GOOGLE_CALCULATOR);
        return this;
    }
}
