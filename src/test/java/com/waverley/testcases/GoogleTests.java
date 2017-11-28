package com.waverley.testcases;

import com.waverley.pages.SearchPage;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static com.waverley.PageFactory.at;
import static com.waverley.PageFactory.open;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test Class for testing google search.
 */
public class GoogleTests {
    @Test
    public void shouldSearchForKeyword() throws InterruptedException {
        open(SearchPage.class)
                .search("Testing" + Keys.ENTER);

        assertThat(at(SearchPage.class).getLinksAmount()).isEqualTo(14);
        Thread.sleep(5000);
    }
}
