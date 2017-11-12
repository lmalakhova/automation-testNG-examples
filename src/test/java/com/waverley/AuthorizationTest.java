package com.waverley;

import com.waverley.model.User;
import io.github.sskorol.core.DataSupplier;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Optional;
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
    public Stream getData(Method method) {
        final String datasource = Optional.ofNullable(method.getDeclaredAnnotation(Data.class))
                .map(Data::source)
                .orElse("dummy.json");
        LOG.info(datasource);
        return Stream.of(
                new User("Anna", "pass1"),
                new User("Sasha", "pass2"));
    }

    @Data(source = "data.json")
    @Test(dataProvider = "getData")
    public void methodOneTest(final User user) {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(user.getFirstName()).as("Users list").isEqualTo("Ana");
        softAssertions.assertThat(user.getPassword()).as("Users list").isEqualTo("pass1");
        softAssertions.assertAll();
    }

    @AfterMethod
    public void methodAfterOne() {
        LOG.info("This is method after methodOne");
    }
}
