package framework.pages;

import framework.model.PricingCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameCalculatorPage extends AbstractPage {
    private static final String GPU_NUMBER_BUTTON = "select_value_label_335";
    private static final String GPU_TYPE_BUTTON = "select_value_label_336";
    private static final String SEND_MAIL_BUTTON = "email_quote";
    private static final String TABLE_FROM_BUTTON = "//b[@class = 'ng-binding']";
    private static final String EMAIL_INPUT = "//input[@type=\"email\"]";
    private static final String SEND_EMAIL_BUTTON = "md-dialog-actions.layout-row > button:nth-child(2)";
    private static final String NUMBER_OF_INSTANCES = "input_58";
    private static final String INSTANCE_FOR = "input_59";
    private static final String OPERATION_SYSTEM = "select_value_label_51";
    private static final String VM_CLASS = "select_value_label_52";
    private static final String MACHINE_TYPE = "select_83";
    private static final String ADD_GPU = "//div[@class = 'md-container md-ink-ripple']";
    private static final String LOCAL_SSD = "select_170";
    private static final String DATACENTER_LOCATION = "select_85";
    private static final String COMMITTED_USAGE = "select_92";
    private static final String SUBMIT_BUTTON = "//button[@class = 'md-raised md-primary cpc-button md-button md-ink-ripple']";
    private String estimateFromButton;

    public FrameCalculatorPage(WebDriver driver) {
        super(driver);
    }

    //Add some data to Google Cloud Pricing Calculator form
    private void addToEstimate(PricingCalculator calculator) {
        //Number of instances field
        WebElement numberOfInstances = getElement(By.id(NUMBER_OF_INSTANCES),driver);
        numberOfInstances.sendKeys(calculator.getNumberOfInstances());

        //Instance For field, any text is allowed here
        WebElement instanceFor = getElement(By.id(INSTANCE_FOR),driver);
        instanceFor.sendKeys(calculator.getText());

        //Operation System/Software
        WebElement operationSystem = getElement(By.id(OPERATION_SYSTEM),driver);
        operationSystem.click();
        driver.findElement(By.xpath("//div[contains(text(),\""+ calculator.getOperationSystem() + "\")]/parent::md-option")).click();
        logger.info("Select operation system");

        //Machine Class
        WebElement vmClass = getElement(By.id(VM_CLASS),driver);
        vmClass.click();
        driver.findElements(By.xpath("//div[contains(text(),\"" + calculator.getMachineClass() + "\")]/parent::md-option"))
        .get(1).click();
        logger.info("Select VM class");

        //Machine Type
        WebElement machineType = getElement(By.id(MACHINE_TYPE),driver);
        machineType.click();
        driver.findElement(By.xpath("//div[contains(text(),\""+ calculator.getMachineType() + "\")]/parent::md-option")).click();
        logger.info("Select Machine Type");

        //Add GPU
        WebElement addGpu = getElement(By.xpath(ADD_GPU),driver);
        addGpu.click();
        driver.findElement(By.id(GPU_NUMBER_BUTTON)).click();
        driver.findElement(By.xpath(
                "//div[contains(text(),\"" + calculator.getNumberOfGPU()
                        + "\")]/parent::md-option[@ng-repeat=\"item in listingCtrl.supportedGpuNumbers[listingCtrl.computeServer.gpuType]\"]"))
                .click();
        logger.info("Select GPU Number");
        driver.findElement(By.id(GPU_TYPE_BUTTON)).click();
        driver.findElement(By.xpath("//div[contains(text(),\""+ calculator.getGPUType() + "\")]/parent::md-option")).click();
        logger.info("Select GPU Type");

        //Local SSD
        WebElement localSsd = getElement(By.id(LOCAL_SSD), driver);
        localSsd.click();
        driver.findElement(By.xpath("//div[contains(text(),\""+ calculator.getLocalSSD() + "\")]/parent::md-option")).click();
        logger.info("Select Local SSD");

        //Data center Location
        WebElement dataCenterLocation = getElement(By.id(DATACENTER_LOCATION), driver);
        dataCenterLocation.click();
        driver.findElements(By.xpath("//div[contains(text(),\""+ calculator.getDatacenterLocation()
                + "\")]/parent::md-option[@ng-repeat=\"item in listingCtrl.fullRegionList\"]"))
                .get(1).click();
        logger.info("Select Data center locatiion");

        //Committed Usage
        WebElement committedUsage = getElement(By.id(COMMITTED_USAGE), driver);
        committedUsage.click();
        driver.findElements(By.xpath("//div[contains(text(),\""+ calculator.getCommittedUsage() + "\")]/parent::md-option"))
                .get(1).click();

        //Press button ADD TO ESTIMATE
        WebElement submitButton = getElement(By.xpath(SUBMIT_BUTTON), driver);
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
