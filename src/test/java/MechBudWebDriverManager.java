import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class MechBudWebDriverManager {

    static WebDriver chromeDriver;

    @BeforeAll
    static void setupClass() {
        // Mechanizm budowania WebDriver - 2/2
        //WebDriverManager.chromedriver().setup();

        /** ten jest silniejszy niz "WebDriverManager.chromedriver().setup();" bo rozwiazuje sterownik, ale i tworzy
         instancje wlasciwego typu WebDriver, przy czym obiekt klasy WebDriver zainstancjonowany na
         poczatku musi byc statycznym; mozna tez wtedy pominac metode build() pisana w BeforeEach - i
         cala ta adnotacje - pod warunkiem przypisania od razu wyniku dzialnia metody inicjujacej w @BeforeAll do
         zmiennej sterownika przegladarki*/
        chromeDriver = WebDriverManager.chromedriver().create();
    }

    @AfterEach
    void tearDown() {
        chromeDriver.quit();
    }

    @Test
    void firstTest() {
        chromeDriver.get("http://google.com");
    }
}
