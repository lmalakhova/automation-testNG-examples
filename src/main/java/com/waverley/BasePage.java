package com.waverley;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.waverley.BaseConfig.BASE_CONFIG;
import static com.waverley.WaitCondition.allvisible;
import static com.waverley.WaitCondition.visible;
import static com.waverley.WebDriverListener.getDriver;
import static com.waverley.utils.ElementTypeUtils.elementOf;
import static com.waverley.utils.ElementTypeUtils.streamof;

public abstract class BasePage implements Page {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public BasePage() {
        this.driver = getDriver();
        this.wait = new WebDriverWait(driver, BASE_CONFIG.waitTimeout());
    }

    protected void type(final By locator, final CharSequence text, final WaitCondition condition) {
        elementOf(waitFor(locator, condition)).sendKeys(text);
    }

    protected void type(final By locator, final CharSequence text) {
        type(locator, text, visible);
    }

    protected void click(final By locator) {
        elementOf(waitFor(locator, visible)).click();
    }
    protected List<String> getTextNodes(final By locator) {
    return getTextNodes(locator, allvisible);
     }

    protected List<String> getTextNodes(final By locator, final WaitCondition condition) {
        return streamof(waitFor(locator,condition))
                .map(WebElement::getText)
                .toList();
    }

    public Page navigateTo() {
        driver.get(url());
        return this;
    }

    @SuppressWarnings("unchecked")
    private <T> T waitFor(final By locator, final WaitCondition condition) {
        return (T) wait.until(condition.getType().apply(locator, ""));
    }

    @SuppressWarnings("unchecked")
    private <T> T waitFor(final By locator, final String str, final WaitCondition condition) {
        return (T) wait.until(condition.getType().apply(locator, str));
    }
}
