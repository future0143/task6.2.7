import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BrowserTest {

    private String url = TestProperties.getValue("test.url");
    private WebDriver driver;

    @AfterEach
    public void driverClose() {
        driver.quit();
    }

    @Test
    public void openChrome() {
        WebDriverManager.chromedriver().driverVersion("117.0.5938.92").setup();

        driver = new ChromeDriver();

        generalStep();
    }

    @Test
    public void openFirefox() {
        WebDriverManager.firefoxdriver().setup();

        driver = new FirefoxDriver();

        generalStep();
    }

    @Test
    public void openEdge() {
        WebDriverManager.edgedriver().setup();

        driver = new EdgeDriver();

        generalStep();
    }

    @Step
    public void generalStep() {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}