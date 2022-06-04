package by.barbuk.automation.task4.tests;

import by.barbuk.automation.task4.model.CalculatorPageData;
import by.barbuk.automation.task4.pages.google.CalculatorPage;
import by.barbuk.automation.task4.pages.google.GoogleCloudPage;
import by.barbuk.automation.task4.pages.google.PricingPage;
import by.barbuk.automation.task4.pages.google.SearchResultPage;
import by.barbuk.automation.task4.service.CalculatorPageDataCreator;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Log4j2
public class CalculatorFieldsAccordanceTest extends BaseTest {

    private CalculatorPageData calculatorPageData;
    private String vmText;
    private String instanceTypeText;
    private String locationText;
    private String ssdText;
    private String usageText;
    private String costText;


    @BeforeMethod
    public void before() {
        log.info("Setup data to make assertions");
        calculatorPageData = CalculatorPageDataCreator.getDataProperties();
        GoogleCloudPage cloudPage = new GoogleCloudPage(driver);
        SearchResultPage searchResultPage = cloudPage.goToGoogleCloudPage()
                .useSearchBoxAndGoToSearchResultPage();
        PricingPage pricingPage = searchResultPage.goToPricingPage();
        CalculatorPage calculatorPage = pricingPage.goToCalculatorPage();
        calculatorPage.switchFrame()
                .chooseComputeEngineOption()
                .setNumberOfInstance(calculatorPageData.getInstanceNumber())
                .chooseOperationSystem(calculatorPageData.getOperationSystem())
                .chooseSeries(calculatorPageData.getSeries())
                .chooseInstanceType(calculatorPageData.getInstanceType())
                .chooseVirtualMachineClass(calculatorPageData.getVirtualMachineClass())
                .addGPU(calculatorPageData.getNumberOfGPU(), calculatorPageData.getGpuType())
                .chooseLocalSSD(calculatorPageData.getLocalSsd())
                .chooseUsageTime(calculatorPageData.getUsageTime())
                .chooseServerLocation(calculatorPageData.getLocation())
                .AddToEstimate();
        vmText = calculatorPage.readVirtualMachineValueText();
        instanceTypeText = calculatorPage.readInstanceTypeValueText();
        locationText = calculatorPage.readRegionValueText();
        ssdText = calculatorPage.readSSDValueText();
        usageText = calculatorPage.readTermOfUseText();
        costText = calculatorPage.readCostText();
    }

    @Test
    public void testCalculatorPage() {
        log.info("Start Calculator Page test");
        softAssert.assertTrue(vmText.contains(calculatorPageData.getVirtualMachineClass()), "VM class is not same");
        log.info("Given 'VM Class' {} is same to 'VM Class' {} from estimate", calculatorPageData.getVirtualMachineClass(), vmText);
        softAssert.assertTrue(instanceTypeText.contains(calculatorPageData.getInstanceType()), "instance type is not same");
        log.info("Given 'Instance Type' {} is same to 'Instance Type' {} from estimate", calculatorPageData.getInstanceType(), instanceTypeText);
        softAssert.assertTrue(locationText.contains(calculatorPageData.getLocation()), "location is not same");
        log.info("Given 'Location' {} is same to 'Location' {} from estimate", calculatorPageData.getLocation(), locationText);
        softAssert.assertTrue(ssdText.contains(calculatorPageData.getLocalSsd()), "SSD value is not same");
        log.info("Given 'SSD' {} is same to 'SSD' {} from estimate", calculatorPageData.getLocalSsd(), ssdText);
        softAssert.assertTrue(usageText.contains(calculatorPageData.getUsageTime()), "usage time type is not same");
        log.info("Given 'Usage Time' {} is same to 'Usage Time' {} from estimate", calculatorPageData.getUsageTime(), usageText);
        softAssert.assertTrue(costText.contains(calculatorPageData.getTotalCost()), "total cost is not same");
        log.info("Given 'Total Cost' {} is same to 'Total Cost' {} from estimate", calculatorPageData.getTotalCost(), costText);
        softAssert.assertAll();
    }

}
