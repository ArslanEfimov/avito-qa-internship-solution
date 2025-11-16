package org.example.pages;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@Data
@RequiredArgsConstructor
public abstract class Page {
    private final WebDriver driver;

    protected void open(String pageURL){
        driver.get(pageURL);
    }

    private WebDriverWait getWait(long seconds){
        return new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }

    protected WebElement waitToBeClickable(By locator, long timeoutSeconds){
        return getWait(timeoutSeconds).until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected WebElement waitForVisibility(By locator, long timeoutSeconds) {
        return getWait(timeoutSeconds).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected List<WebElement> waitForVisibilityOfAll(By locator, long timeoutSeconds){
        return getWait(timeoutSeconds).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }


    protected void type(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }

    protected void scrollToElement(){
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        try {
            Thread.sleep(1800);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
