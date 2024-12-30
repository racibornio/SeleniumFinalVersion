import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MechBudWebDriver {

    static WebDriver chromeDriver;

    @BeforeAll
    static void setupClass() {
        // Mechanizm budowania WebDriver - 2/2
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        chromeDriver = RemoteWebDriver.builder().oneOf(new ChromeOptions()).build();
    }

    @Test
    void testNumer1() {
        chromeDriver.get("http://gazetawroclawska.pl");
    }

    @Test
    void testNumer2() {
        chromeDriver.get("http://toyota.com");
    }

    @AfterEach
    void tearDown() {
        chromeDriver.quit();
    }

    @AfterAll
    static void finalizeAll() {
        if (chromeDriver != null) {
            chromeDriver.quit();
            // zamkniecie polaczenia z baza danych itp.


        }
    }
}