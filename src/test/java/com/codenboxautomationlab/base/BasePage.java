package com.codenboxautomationlab.base;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage {
    //Driver
    protected WebDriver driver;

    //Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("get Current Url")
    public String getCurrentPageUrl() {
        return driver.getCurrentUrl();
    }

    public Select interactWithDropDown(WebElement dropDownElement) {
        return new Select(dropDownElement);
    }

    public WebDriverWait explicitWait() {
        return new WebDriverWait(this.driver, Duration.ofSeconds(15));

    }

    public Actions actions() {
        return new Actions(this.driver);

    }

    public int random(int size) {
        Random random = new Random();
        return random.nextInt(size);
    }

    public void selectRandomOptionByIndexFromDropDown(WebElement dropDownElement) {
        Select dropDown = interactWithDropDown(dropDownElement);
        List<WebElement> options = dropDown.getOptions();
        int randomIndex = random(options.size());
        dropDown.selectByIndex(randomIndex);
    }

}
