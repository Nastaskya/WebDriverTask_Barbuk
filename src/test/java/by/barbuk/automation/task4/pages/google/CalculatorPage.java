package by.barbuk.automation.task4.pages.google;

import by.barbuk.automation.task4.driver.Waiter;
import by.barbuk.automation.task4.pages.BasePage;
import by.barbuk.automation.task4.utill.StringToCostValueParser;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Log4j2
public class CalculatorPage extends BasePage {

    private static final String CALCULATOR_PAGE_URL = "https://cloud.google.com/products/calculator/";

    @FindBy(xpath = "//*[@id='cloud-site']/devsite-iframe/iframe")
    private WebElement pricingCalculatorFrame;

    @FindBy(xpath = "//div[@class='tab-holder compute']")
    private WebElement toolbar;

    @FindBy(xpath = "//div[@class='tab-holder compute']")
    private WebElement computeEngineLocator;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement numberOfInstanceLocator;

    @FindBy(css = "[placeholder='Instance type']")
    private WebElement instanceTypeLocator;

    @FindBy(xpath = "//*[@id='select_container_113']//md-optgroup[@label='standard']/md-option")
    private List<WebElement> instanceTypeList;

    @FindBy(css = "[ng-model='listingCtrl.computeServer.os']")
    private WebElement operatingSystemLocator;

    @FindBy(xpath = "//*[@id='select_container_99']//md-content/md-option")
    private List<WebElement> operationSystemList;

    @FindBy(css = "[placeholder='Series']")
    private WebElement seriesLocator;

    @FindBy(xpath = "//*[@id='select_container_111']//md-content/md-option")
    private List<WebElement> seriesList;

    @FindBy(css = "[placeholder='VM Class']")
    private WebElement virtualMachineClassLocator;

    @FindBy(xpath = "//div[@id='select_container_103']//md-content/md-option")
    private List<WebElement> vmClassList;

    @FindBy(css = "[aria-label='Add GPUs']")
    private WebElement addGPULocator;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.gpuCount']")
    private WebElement numberGPULocator;

    @FindBy(xpath = "//div[@id='select_container_456']//md-content/md-option")
    private List<WebElement> numberOfGpuList;

    @FindBy(css = "[placeholder='GPU type']")
    private WebElement typeGPULocator;

    @FindBy(xpath = "//div[@id='select_container_454']//md-content/md-option")
    private List<WebElement> gpuTypeList;

    @FindBy(xpath = "//*[@placeholder='Local SSD']")
    private WebElement localSSDLocator;

    @FindBy(xpath = "//div[@id='select_container_411']//md-content/md-option")
    private List<WebElement> ssdList;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.location']")
    private WebElement serverLocationLocator;

    @FindBy(xpath = "//div[@id='select_container_169']//md-content/md-option")
    private List<WebElement> locationList;

    @FindBy(xpath = "//div[@id='select_container_119']//md-optgroup/md-option")
    private List<WebElement> serverLocationList;

    @FindBy(css = "[placeholder='Committed usage']")
    private WebElement usageTimeLocator;

    @FindBy(xpath = "//div[@id='select_container_126']//md-content/md-option")
    private List<WebElement> usageTimeList;

    @FindBy(css = "[ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']")
    private WebElement addToEstimateBtn;

    @FindBy(xpath = "//*[@class='ng-binding ng-scope']")
    private WebElement receivedInstanceValueLocator;

    @FindBy(xpath = "//*[@id='email_quote']")
    private WebElement emailEstimateBtn;

    @FindBy(xpath = "//*[@ng-model='emailQuote.user.email']")
    private WebElement emailAddressField;

    @FindBy(xpath = "//*[@aria-label='Send Email']")
    private WebElement sendEmailBtn;

    @FindBy(xpath = "//*[@role='listitem' and @ng-if='item.items.editHook && item.items.editHook.initialInputs.class']")
    private WebElement receivedVirtualMachineValueLocator;

    @FindBy(xpath = "//*[contains(@class,'md-list-item-text ng-binding') and contains(text(),'Instance type: n1-standard-8')]")
    private WebElement receivedInstanceTypeLocator;

    @FindBy(xpath = "//*[@class='md-list-item-text ng-binding' and contains(text(),'Region: Frankfurt')]")
    private WebElement receivedRegion;

    @FindBy(xpath = "//*[@ng-if='item.items.ssd && item.items.ssd != 0' and @role='listitem']")
    private WebElement receivedSSDValueLocator;

    @FindBy(xpath = "//*[@ng-if='item.items.termText && item.items.termText.length != 0' and @role='listitem']")
    private WebElement receivedTermsOfUse;

    @FindBy(xpath = "//*/h2/b")
    private WebElement receivedCostLocator;

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    public CalculatorPage open() {
        driver.get(CALCULATOR_PAGE_URL);
        log.info("Calculator page is opened.");
        return this;
    }

    public CalculatorPage switchFrame() {
        log.info("Switching to Calculator frame");
        Waiter.waitUntilSwitch(driver, pricingCalculatorFrame);
        Waiter.justWait(6000);
        Waiter.waitUntilSwitch(driver, "myFrame");
        return this;
    }

    public CalculatorPage switchToDefault() {
        log.info("Switch to default");
        driver.switchTo().defaultContent();
        return this;
    }

    public CalculatorPage chooseComputeEngineOption() {
        log.info("Click to Compute Engine");
        Waiter.waitUntilClickableAndClick(driver, computeEngineLocator);
        return this;
    }

    public CalculatorPage setNumberOfInstance(int numberOfInstance) {
        log.info("Set number of instance to " + numberOfInstance);
        Waiter.waitUntilClickable(driver, numberOfInstanceLocator);
        new Actions(driver).sendKeys(numberOfInstanceLocator, String.valueOf(numberOfInstance)).build().perform();
        return this;
    }

    public CalculatorPage chooseInstanceType(String instanceType) {
        log.info("Set instance type " + instanceType);
        Waiter.waitUntilClickableAndClick(driver, instanceTypeLocator);
        Waiter.waitListElementVisible(driver, instanceTypeList);
        instanceTypeList.stream().filter(webElement -> webElement.getText().contains(instanceType))
                .findFirst().get().click();
        return this;
    }

    public CalculatorPage chooseOperationSystem(String OS) {
        log.info("Set Operation System" + OS);
        operatingSystemLocator.click();
        Waiter.waitListElementVisible(driver, operationSystemList);
        chooseOptionFromDropDownByPropertyContains(operationSystemList, OS);
        return this;
    }

    public CalculatorPage chooseVirtualMachineClass(String VMClass) {
        log.info("Set VM class to " + VMClass);
        Waiter.waitUntilClickableAndClick(driver, virtualMachineClassLocator);
        Waiter.waitListElementVisible(driver, vmClassList);
        chooseOptionFromDropDownByPropertyEquals(vmClassList, VMClass);
        return this;
    }

    public CalculatorPage addGPU(int number, String gpyTypeValue) {
        log.info("Click to 'Add GPU'");
        Waiter.waitUntilClickableAndClick(driver, addGPULocator);
        log.info("Set GPU type " + gpyTypeValue);
        highlightElement(addGPULocator);
        Waiter.waitUntilClickableAndClick(driver, typeGPULocator);
        gpuTypeList = driver.findElements(By.xpath("//div[@id='select_container_454']//md-content/md-option"));
        Waiter.waitListElementVisible(driver, gpuTypeList);
        gpuTypeList.stream().filter(webElement -> webElement.getText().contains(gpyTypeValue)).findFirst().get().click();
        log.info("Set amount of GPU to " + number);
        Waiter.waitUntilClickableAndClick(driver, numberGPULocator);
        numberOfGpuList = driver.findElements(By.xpath("//div[@id='select_container_456']//md-content/md-option"));
        Waiter.waitListElementVisible(driver, numberOfGpuList);
        numberOfGpuList.stream().filter(webElement -> webElement.getText()
                .contains(String.valueOf(number))).findFirst().get().click();
        return this;
    }

    public CalculatorPage chooseLocalSSD(String ssdValue) {
        log.info("Set SSD value to " + ssdValue);
        Waiter.waitUntilClickableAndClick(driver, localSSDLocator);
        Waiter.waitListElementVisible(driver, ssdList);
        ssdList.stream().filter(webElement -> webElement.getText().contains(ssdValue)).findFirst().get().click();
        return this;
    }

    public CalculatorPage chooseServerLocation(String location) {
        log.info("Set Server Location to " + location);
        Waiter.waitUntilClickableAndClick(driver, serverLocationLocator);
        Waiter.waitListElementVisible(driver, serverLocationList);
        serverLocationList.stream().filter(webElement -> webElement.getText().contains(location))
                .findFirst().get().click();
        return this;
    }

    public CalculatorPage chooseUsageTime(String usageTime) {
        log.info("Set Usage Time to " + usageTime);
        Waiter.waitUntilVisibilityOfElement(driver, usageTimeLocator);
        usageTimeLocator.click();
        Waiter.waitListElementVisible(driver, usageTimeList);
        usageTimeList.stream().filter(webElement -> webElement.getText().contains(usageTime)).findFirst().get().click();
        return this;
    }

    public CalculatorPage chooseSeries(String series) {
        seriesLocator.click();
        Waiter.waitListElementVisible(driver, seriesList);
        chooseOptionFromDropDownByPropertyContains(seriesList, series);
        return this;
    }

    public void AddToEstimate() {
        log.info("Click 'Add to estimate");
        Waiter.waitUntilClickableAndClick(driver, addToEstimateBtn);
    }

    public CalculatorPage emailEstimate() {
        log.info("Click email estimate");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", operatingSystemLocator);
        Waiter.waitUntilClickableAndClick(driver, emailEstimateBtn);
        return this;
    }

    public CalculatorPage writeEmailAddress(String email) {
        log.info("Set Email address to " + email);
        writeText(emailAddressField, email);
        return this;
    }

    public CalculatorPage sendEmail() {
        log.info("Click Send Email button");
        Waiter.waitUntilClickableAndClick(driver, sendEmailBtn);
        return this;
    }

    public String readVirtualMachineValueText() {
        return readText(receivedVirtualMachineValueLocator);
    }

    public String readInstanceTypeValueText() {
        return readText(receivedInstanceTypeLocator);
    }

    public String readRegionValueText() {
        return readText(receivedRegion);
    }

    public String readSSDValueText() {
        return readText(receivedSSDValueLocator);
    }

    public String readTermOfUseText() {
        return readText(receivedTermsOfUse);
    }

    public String readCostText() {
        return readText(receivedCostLocator);
    }

    public String getTotalCostValue() {
        return StringToCostValueParser.mailTextToCostParser(readCostText());
    }

    private void chooseOptionFromDropDownByPropertyEquals(List<WebElement> webElementsList, String option) {
        for (WebElement webElement : webElementsList) {
            moveToElement(webElement);
            if (webElement.getText().equals(option)) {
                webElement.click();
                break;
            }
        }
    }

    private void chooseOptionFromDropDownByPropertyContains(List<WebElement> webElementList, String option) {
        for (WebElement webElement : webElementList) {
            moveToElement(webElement);
            if (webElement.getText().contains(option)) {
                webElement.click();
                break;
            }
        }
    }
}
