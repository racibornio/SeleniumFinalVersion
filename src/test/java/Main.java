import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        WebDriver chromeDriver = new ChromeDriver();
        String sut = "http://e.pl";

        chromeDriver.get(sut);
        System.out.println("Strona otwarta to " + chromeDriver.getTitle());
        WebElement przycisk = chromeDriver.findElement(By.cssSelector("[width='87']"));
        System.out.println("Tekst przycisku to " + przycisk.getDomAttribute("alt"));

        chromeDriver.quit();
    }
}
