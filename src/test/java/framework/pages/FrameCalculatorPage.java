package framework.pages;

import framework.model.PricingCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameCalculatorPage extends AbstractPage {
    private String estimateFromButton;

    public FrameCalculatorPage(WebDriver driver) {
        super(driver);
    }

    //Add some data to Google Cloud Pricing Calculator form
    private void addToEstimate(PricingCalculator calculator) {
        //Number of instances field
        WebElement numberOfInstances = (WebElement) getElement(By.id(NUMBER_OF_INSTANCES),driver);
        numberOfInstances.sendKeys(calculator.getNumberOfInstances());

        //Instance For field, any text is allowed here
        WebElement instanceFor = (WebElement) getElement(By.id(INSTANCE_FOR),driver);
        instanceFor.sendKeys(calculator.getText());

        //Operation System/Software
        WebElement operationSystem = (WebElement) getElement(By.id(OPERATION_SYSTEM),driver);
        operationSystem.click();
        driver.findElement(By.id(calculator.getOperatingSystem())).click();

        //Machine Class
        WebElement vmClass = (WebElement) getElement(By.id(VM_CLASS),driver);
        vmClass.click();
        driver.findElement(By.id(calculator.getMachineClass())).click();

        //Machine Type
        WebElement machineType = (WebElement) getElement(By.id(MACHINE_TYPE),driver);
        machineType.click();
        driver.findElement(By.id(calculator.getMachineType())).click();

        //Add GPU
        WebElement addGpu = (WebElement) getElement(By.xpath(ADD_GPU),driver);
        addGpu.click();
        driver.findElement(By.id(GPU_NUMBER_BUTTON)).click();
        driver.findElement(By.id(calculator.getNumberOfGPU())).click();
        driver.findElement(By.id(GPU_TYPE_BUTTON)).click();
        driver.findElement(By.id(calculator.getGPUType())).click();

        //Local SSD
        WebElement localSsd = (WebElement) getElement(By.id(LOCAL_SSD), driver);
        localSsd.click();
        driver.findElement(By.id(calculator.getLocalSSD())).click();

        //Data center Location
        WebElement dataCenterLocation = (WebElement) getElement(By.id(DATACENTER_LOCATION), driver);
        dataCenterLocation.click();
        driver.findElement(By.id(calculator.getDatacenterLocation())).click();

        //Committed Usage
        WebElement committedUsage = (WebElement) getElement(By.id(COMMITTED_USAGE), driver);
        committedUsage.click();
        driver.findElement(By.id(calculator.getCommittedUsage())).click();

        //Press button ADD TO ESTIMATE
        WebElement submitButton = (WebElement) getElement(By.xpath(SUBMIT_BUTTON), driver);
        submitButton.click();
        logger.info("Button Add to estimate has been pressed");
    }

    public MailHandler sendMail() {
        driver.findElement(By.id(SEND_MAIL_BUTTON)).click();
        return new MailHandler(driver);
    }

    public FrameCalculatorPage setEstimateFromButton(PricingCalculator calculator) {
        addToEstimate(calculator);
        estimateFromButton = driver.findElement(By.xpath(TABLE_FROM_BUTTON)).getText();
        estimateFromButton = estimateFromButton.substring(estimateFromButton.lastIndexOf("USD") + 4,estimateFromButton.indexOf("per")).trim();
        logger.info("The estimate data from button has been taken");
        return this;
    }

    public void pasteMailAndSend(String mailAddress, String mailPageTab) {
        driver.findElement(By.xpath(EMAIL_INPUT)).sendKeys(mailAddress);
        driver.findElement(By.cssSelector(SEND_EMAIL_BUTTON)).click();
        logger.info("The mail has been sent");

        driver.switchTo().window(mailPageTab);
        logger.info("Switched to Mail Page");
    }

    public String getEstimateFromButton() {
        return estimateFromButton;
    }
}
