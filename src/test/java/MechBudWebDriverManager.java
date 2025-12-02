import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.operator.bc.BcSignerOutputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Duration;
import org.assertj.core.api.Assertions;

public class MechBudWebDriverManager {

    private static final Logger log = LoggerFactory.getLogger(MechBudWebDriverManager.class);
    static WebDriver chromeDriver;

    // dodaj kilka adresow
    String stronaNFM = "https://www.nfm.wroclaw.pl/";
    String stronaFR24 = "https://www.flightradar24.com/";
    String stronaEPL = "http://e.pl/";

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

    @BeforeEach
    void setUp() {
        chromeDriver = WebDriverManager.chromedriver().create();
    }

    @AfterEach
    void tearDown() {
        if (chromeDriver != null) {
            chromeDriver.quit();
        }
    }

    @Test
    void firstTest() {
        chromeDriver.get("http://google.com");
    }

    @Test
    void testujStronkaNFM() {
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
        // == porownuje referencje - adresy w pamieci - czy sa/jest identyczne/y dla obiektow
        // .equels() porownuje wartosc obiektu i/lub zmiennej
    }

    @Test
    void tesujStronkaFR24() {
        chromeDriver.get(stronaFR24);
        chromeDriver.manage().window().maximize();
        System.out.println("Stronka trackera lotow otwarta");
        String tytulFR24 = chromeDriver.getTitle();
        System.out.println("Tytul to " + tytulFR24);

        /*
        // utworzenie obiektu wait
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(5));

        // odrzuc cookies po 5-ciu sek.
        WebElement rejectCookiesBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-reject-all-handler")));
        rejectCookiesBtn.click();
        System.out.println("Cookiesy odrzucone");

        // naciskanie opcji logowania na konto
        WebElement logInBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".flex.h-9.flex-col.items-center.justify-center.text-white")));
        logInBtn.click();
        System.out.println("Button logIn klikniety");

        // wpisywanie adresu e-mail
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='email']")));
        emailField.sendKeys("ostrowski.patryk@gmail.com");

        // wpisywanie hasla
        WebElement pwdField = wait.until(ExpectedConditions.elementToBeClickable(By.name("props.name")));
        pwdField.sendKeys("");

        // nacisniecie przycisku logowania
        WebElement performLoginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='login__submit-button']")));
        performLoginBtn.click();
        System.out.println("Great success!");


        WebElement accountBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='whitespace-nowrap text-xs uppercase']")));
        accountBtn.click();

        System.out.println("Tekst to " + accountBtn.getText());

        System.out.println("Button konta klikniety");

         */
    }

    @Test
    void naAsercje() {
        chromeDriver.get(stronaEPL);
        String currTitle = chromeDriver.getTitle();
        String expTitle = "e.pl, konta pocztowe, domeny, hosting";
        Assertions.assertThat(currTitle).as("Tytul NOK").isEqualTo(expTitle);
    }

    @Test
    void poXPath() {
        String sut = "C:/Users/Patryk/IdeaProjects/SeleniumFinalVersion/src/test/PoXPath/index.html";
        chromeDriver.get(sut);
        System.out.println("Stronka " + chromeDriver.getTitle());
        WebElement poXPath1 = chromeDriver.findElement(By.xpath("/html/body/p[1]"));
        System.out.println("Tekst: " + poXPath1.getText());
        WebElement poXPath2 = chromeDriver.findElement(By.xpath("/html/body/p[2]"));
        System.out.println("Tekst: " + poXPath2.getText());
        WebElement poXPath3 = chromeDriver.findElement(By.xpath("/html/body/p[3]"));
        System.out.println("Tekst: " + poXPath3.getText());
        WebElement poXPath4 = chromeDriver.findElement(By.xpath("/html/body/p[4]"));
        System.out.println("Tekst: " + poXPath4.getText());
        WebElement poXPath5 = chromeDriver.findElement(By.xpath("/html/body/p[5]"));
        System.out.println("Tekst: " + poXPath5.getText());

        WebElement pierwszyPoXPathAbsolute = chromeDriver.findElement(By.xpath("/html/body/p[1]"));
        System.out.println("Element po XPath absolute " + pierwszyPoXPathAbsolute.getText());

        WebElement pierwszyPoXPathRelative = chromeDriver.findElement(By.xpath("//p[@class='XPath_wzgledny']"));
        System.out.println("Element po XPath relative " + pierwszyPoXPathRelative.getText());
    }


}
