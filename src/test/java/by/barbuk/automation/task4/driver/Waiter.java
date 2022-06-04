package by.barbuk.automation.task4.driver;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

@Log4j2
public class Waiter {

    private static final int WAIT_TIME = 10;

    public static void waitUntilSwitch(WebDriver driver, String frameLocator) {
        log.info("Wait until switching to frame " + frameLocator);
        new WebDriverWait(driver, WAIT_TIME).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
    }

    public static void waitUntilSwitch(WebDriver driver, int frameLocator) {
        log.info("Wait until switching to frame " + frameLocator);
        new WebDriverWait(driver, WAIT_TIME).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
    }

    public static void waitUntilSwitch(WebDriver driver, WebElement frameLocator) {
        log.info("Wait until switching to frame " + frameLocator);
        new WebDriverWait(driver, WAIT_TIME).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
    }

    public static void waitUntilClickable(WebDriver driver, WebElement webElement) {
        log.info("Wait until element to be clickable " + webElement);
        new WebDriverWait(driver, WAIT_TIME).until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void waitUntilClickableAndClick(WebDriver driver, WebElement webElement) {
        log.info("Wait until element to be clickable " + webElement + " and click");
        new WebDriverWait(driver, WAIT_TIME).until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }

    public static void waitUntilVisibilityOfElement(WebDriver driver, WebElement webElement) {
        log.info("Wait until element to be visible " + webElement);
        new WebDriverWait(driver, WAIT_TIME).until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitListElementVisible(WebDriver driver, List<WebElement> webElements) {
        log.info("Wait until list of elements to be visible " + webElements);
        waitUntilVisibilityOfElement(driver, webElements.get(0));
    }

    public static void justWait (int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
