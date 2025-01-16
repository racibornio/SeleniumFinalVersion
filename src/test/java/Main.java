import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        WebDriver chromeDriver = new ChromeDriver();
        String sut = "http://e.pl";

        chromeDriver.get(sut);

        String expTitle = "e.pl, konta pocztowe, domeny, hosting";
        String currTitle = chromeDriver.getTitle();

        if (expTitle.equals(currTitle)) {
            System.out.println("Tytul OK");
        } else {
            System.out.println("Tytul NOK");
        }

        System.out.println("Strona otwarta to " + chromeDriver.getTitle());
        WebElement przycisk = chromeDriver.findElement(By.cssSelector("[width='87']"));
        System.out.println("Tekst przycisku to " + przycisk.getDomAttribute("alt"));


        int[] tablica = {33, 44, 55};

        for (Integer i: tablica) {
            System.out.println("Value is " + i);
        }

        WebElement pierwsze = chromeDriver.findElement(By.tagName("h2"));
        System.out.println(pierwsze.getText());

        chromeDriver.quit();
    }
}
