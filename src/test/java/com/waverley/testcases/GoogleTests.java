package com.waverley.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.waverley.listeners.TestsListener.driver;
import static org.assertj.core.api.Assertions.assertThat;
/**
 * Test Class for testing google search.
 */
public class GoogleTests {
    @Test
    public void shouldSearchForKeyword() throws InterruptedException {
        driver.get("https://google.com/ncr");
        final WebElement element = driver.findElement(By.cssSelector("#lst-ib"));
        element.sendKeys("Testing" + Keys.ENTER);
        assertThat(driver.findElements(By.cssSelector("#rso h3>a")).size()).isEqualTo(10);
        Thread.sleep(5000);
    }
}
