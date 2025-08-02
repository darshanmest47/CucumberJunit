package stepDefinitions;

import com.tests.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Apphooks {
    @Before(order = 0)
    public void setUp() throws Exception {
        BaseTest.getInstance().initializeMethod();
    }

    @After(order = 1)
    public void tearDown() throws Throwable {
        BaseTest.getInstance().quitMethod();
    }
}
