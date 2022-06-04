package by.barbuk.automation.task4.pages.google;

import by.barbuk.automation.task4.driver.Waiter;
import by.barbuk.automation.task4.pages.BasePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class SearchResultPage extends BasePage {

    @FindBy(css = "a[href*='https://cloud.google.com/run/pricing']")
    private WebElement pricePage;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public PricingPage goToPricingPage() {
        log.info("Go to Pricing Page");
        Waiter.waitUntilClickableAndClick(driver, pricePage);
        return new PricingPage(driver);
    }
}
