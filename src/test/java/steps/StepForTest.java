package steps;

import config.TestProperties;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class StepForTest {

    private static String url = TestProperties.getValue("test.url");

    @Step
    public static void openWebPageWithWait(WebDriver driver) {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}