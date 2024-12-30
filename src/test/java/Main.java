import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Main {
    public static void main(String[] args) {
        WebDriver chromeDriver = new ChromeDriver();
        String sut = "http://e.pl";

        chromeDriver.get(sut);
        System.out.println("Strona otwarta to " + chromeDriver.getTitle());

        chromeDriver.quit();
    }
}
