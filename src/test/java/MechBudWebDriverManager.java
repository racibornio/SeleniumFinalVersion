import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.operator.bc.BcSignerOutputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class MechBudWebDriverManager {

    static WebDriver chromeDriver;

    // dodaj kilka adresow
    String stronaNFM = "https://www.nfm.wroclaw.pl/";

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

    @Test
    void stronkaNFM() {
        chromeDriver.get(stronaNFM);
        System.out.println("Otwarto strone NFM.");
        // pobierz jej URL
        System.out.println("Otwarty adres to " + chromeDriver.getCurrentUrl());

        // sprawdz zgodnosc adresu pobranego z oczekiwanym
        if (chromeDriver.getCurrentUrl().equals(stronaNFM)) {
            System.out.println("Adres jest poprawny");
        } else {
            System.out.println("Adres nie jest poprawny");
        }
        // == porownuje referenjce - adresy w pamieci - czy sa/jest identyczne/y dla obiektow
        // .equels() porownuje wartosc obiektu i/lub zmiennej
    }
}
