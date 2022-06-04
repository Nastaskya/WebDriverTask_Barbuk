package by.barbuk.automation.task4.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public abstract class BasePage {

    protected final WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public <T> void click(T elementAttr) {
        log.info("Click to element " + elementAttr);
        if (elementAttr.getClass().getName().contains("By")) {
            driver.findElement((By) elementAttr).click();
        } else {
            ((WebElement) elementAttr).click();
        }
    }

    //Write Text in field(By or WebElement can be used)
    protected <T> void writeText(T elementAttr, String text) {
        log.info("Send text {} to element {} ", text, elementAttr);
        if (elementAttr.getClass().getName().contains("By")) {
            driver.findElement((By) elementAttr).sendKeys(text);
        } else {
            ((WebElement) elementAttr).sendKeys(text);
        }
    }

    //Read Text from field(By or WebElement can be used)
    protected <T> String readText(T elementAttr) {
        log.info("Read text from element {}", elementAttr);
        if (elementAttr.getClass().getName().contains("By")) {
            return driver.findElement((By) elementAttr).getText();
        } else {
            return ((WebElement) elementAttr).getText();
        }
    }

    //Read attribute value (By or WebElement can be used)
    protected <T> String readAttribute(T elementAttr, String attribute) {
        log.info("Read attribute {} from element {}", attribute, elementAttr);
        if (elementAttr.getClass().getName().contains("By")) {
            return driver.findElement((By) elementAttr).getAttribute(attribute);
        } else {
            return ((WebElement) elementAttr).getAttribute(attribute);
        }
    }

    // open new tab
    public void openNewTab() {
        log.info("Open new tab");
        ((JavascriptExecutor) driver).executeScript("window.open()");
        List<String> tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }

    //Switch on to previous tab
    public void tabSwitchPreviousTab() {
        log.info("Switch to previous tab");
        List<String> tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 2));
    }

    //Go to required WebElement
    protected void moveToElement(WebElement element) {
        log.info("Move to element {}", element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    protected void moveToElementAndClick(WebElement element) {
        log.info("Move to element {} and click", element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    protected void sendText(WebElement element, String text) {
        log.info("Send text {} to element {}", text, element);
        Actions actions = new Actions(driver);
        actions.sendKeys(element, text).perform();
    }

    public void highlightElement(WebElement element) {
        log.info("Highlight element " + element);
        String bg = element.getCssValue("backgroundColor");
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '" + "yellow" + "'", element);
        js.executeScript("arguments[0].style.backgroundColor = '" + bg + "'", element);
    }

}
