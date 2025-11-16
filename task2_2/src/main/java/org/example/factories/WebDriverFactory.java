package org.example.factories;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {

    public static WebDriver createDriver(BrowserType browserType){
        switch (browserType){
            case CHROME -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--incognito");

                WebDriver chrome = new ChromeDriver(chromeOptions);
                chrome.manage().window().maximize();
                return chrome;
            }
            // TODO можно также в будущем добавить настройку для Firefox
            default -> throw new IllegalArgumentException("Неизвестный браузер: " + browserType);
        }
    }
}
