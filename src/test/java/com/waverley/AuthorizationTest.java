package com.waverley;

import com.waverley.model.User;
import io.github.sskorol.core.DataSupplier;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.stream.Stream;

/**
 * Class was implemented for Test example processing.
 */
public class AuthorizationTest extends BaseTest {
    @BeforeMethod
    public void methodBeforeOne() {
        LOG.info("This is method before methodOne");
    }

    @DataSupplier
    public Stream<User> getData() {
        return Stream.of(
                new User("Anna", "pass1"),
                new User("Sasha", "pass2"));
    }

    @Test(dataProvider = "getData")
    public void methodOneTest(final User user) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @AfterMethod
    public void methodAfterOne() {
        LOG.info("This is method after methodOne");
    }
}


