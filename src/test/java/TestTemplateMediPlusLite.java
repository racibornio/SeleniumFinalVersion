import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.operator.bc.BcSignerOutputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
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
import java.util.List;

public class TestTemplateMediPlusLite {

    private static final Logger log = LoggerFactory.getLogger(MechBudWebDriverManager.class);
    static WebDriver chromeDriver;

    @BeforeAll
    static void setupClass() {
        chromeDriver = WebDriverManager.chromedriver().create();
    }

    @AfterEach
    void tearDown() {
        chromeDriver.quit();
    }

    @Test
    void testujStronkeSzablonu() {
        String sut = "C:/Users/pos/Documents/Szkolenia/WSB Merito/SeleniumFinalVersion/src/test/mediplus-lite/index.html";

        chromeDriver.get(sut);
        List<WebElement> listaP = chromeDriver.findElements(By.tagName("p"));

        int licznikP = 0;
        for (WebElement elementP: listaP) {
            System.out.println("Paragraf: " + elementP.getText());
            licznikP++;
        }
        System.out.println("Elementow P jest " + licznikP);
    }

}
