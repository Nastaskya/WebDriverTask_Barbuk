package by.barbuk.automation.task4.tests;

import by.barbuk.automation.task4.model.CalculatorPageData;
import by.barbuk.automation.task4.model.User;
import by.barbuk.automation.task4.pages.email.EmailGeneratorPage;
import by.barbuk.automation.task4.pages.email.EmailPage;
import by.barbuk.automation.task4.pages.google.CalculatorPage;
import by.barbuk.automation.task4.service.CalculatorPageDataCreator;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Log4j2
public class EmailSendTest extends BaseTest {
    private String costFromCalculatorPage;
    private String costFromEmailPage;

    @BeforeMethod
    public void before() {
        log.info("Setup data to make assertions");
        CalculatorPageData calculatorPageData = CalculatorPageDataCreator.getDataProperties();
        EmailPage emailPage = new EmailPage(driver);
        EmailGeneratorPage emailGeneratorPage = emailPage.goToEmailPage().generateEmailAddress().generateNewAddress();
        User user = new User(emailGeneratorPage.getEmailAddress());
        emailGeneratorPage.openNewTab();

        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.open()
                .switchFrame()
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
        costFromCalculatorPage = calculatorPage.getTotalCostValue();
        calculatorPage.emailEstimate()
                .writeEmailAddress(user.getEmailAddress())
                .sendEmail()
                .tabSwitchPreviousTab();
        costFromEmailPage = emailGeneratorPage.checkInboxEmails()
                .readTotalCost();
    }

    @Test
    public void testEmailSendingTotalCost() {
        log.info("Start Email Sending test");
        softAssert.assertTrue(costFromCalculatorPage.contains(costFromEmailPage), "total cost is not same");
        log.info("Value from 'Calculator Page' {} is equal to value from email {}", costFromCalculatorPage, costFromEmailPage);
    }
}
