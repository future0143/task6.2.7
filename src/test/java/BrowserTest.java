import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import steps.StepForTest;

public class BrowserTest {

    private WebDriver driver;

    @AfterEach
    public void driverClose() {
        driver.quit();
    }

    @Test
    public void openChrome() {
        WebDriverManager.chromedriver().driverVersion("117.0.5938.92").setup();

        driver = new ChromeDriver();

        StepForTest.openWebPageWithWait(driver);
    }

    @Test
    public void openFirefox() {
        WebDriverManager.firefoxdriver().setup();

        driver = new FirefoxDriver();

        StepForTest.openWebPageWithWait(driver);
    }

    @Test
    public void openEdge() {
        WebDriverManager.edgedriver().setup();

        driver = new EdgeDriver();

        StepForTest.openWebPageWithWait(driver);
    }
}