package com.waverley;

import com.waverley.model.User;
import com.waverley.model.assertions.CustomAssertions;
import io.github.sskorol.core.DataSupplier;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Optional;

import static com.waverley.model.utils.JsonUtils.jsonToEntity;

/**
 * Class was implemented for Test example processing.
 */
@Slf4j
public class AuthorizationTest extends BaseTest {
    @BeforeMethod
    public void methodBeforeOne() {
        LOG.info("This is method before methodOne");
    }

    @DataSupplier
    public User getData(Method method) {
        return Optional.ofNullable(method.getDeclaredAnnotation(Data.class))
                .map(Data::source)
                .map(source -> jsonToEntity(source, User.class))
                .orElseGet(User::dummy);
    }

    @Data(source = "data.txt")
    @Test(dataProvider = "getData")
    public void methodOneTest(final User user) {
        CustomAssertions.assertThat(user).hasUsername("Masa");
    }

    @AfterMethod
    public void methodAfterOne() {
        LOG.info("This is method after methodOne");
    }
}
