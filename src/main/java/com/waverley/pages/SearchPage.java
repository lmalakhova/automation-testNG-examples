package com.waverley.pages;

import com.waverley.BasePage;
import org.openqa.selenium.By;

import static com.waverley.BaseConfig.BASE_CONFIG;
import static com.waverley.WaitCondition.visible;

public class SearchPage extends BasePage {
    private By inputSearch = By.cssSelector("#lst-ib");
    private By linkSearchResults = By.cssSelector("#rso h3>a");

    public SearchPage search(final String text) {
        type(inputSearch, text, visible);
        return this;
    }

    public int getLinksAmount() {
        return getTextNodes(linkSearchResults).size();
    }

    @Override
    public String url() {
        return BASE_CONFIG.url();
    }
}
