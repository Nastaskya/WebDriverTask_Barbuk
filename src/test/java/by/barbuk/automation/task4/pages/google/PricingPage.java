package by.barbuk.automation.task4.pages.google;

import by.barbuk.automation.task4.driver.Waiter;
import by.barbuk.automation.task4.pages.BasePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class PricingPage extends BasePage {

    @FindBy(linkText = "Google Cloud Platform Pricing Calculator")
    private WebElement calculatorPageLinkLocator;

    public PricingPage(WebDriver driver) {
        super(driver);
    }

    public CalculatorPage goToCalculatorPage() {
        log.info("Going to calculator page");
        Waiter.waitUntilVisibilityOfElement(driver, calculatorPageLinkLocator);
        moveToElement(calculatorPageLinkLocator);
        Waiter.waitUntilClickableAndClick(driver,calculatorPageLinkLocator);
        return new CalculatorPage(driver);
    }
}
