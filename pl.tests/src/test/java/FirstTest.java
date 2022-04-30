import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class FirstTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                // w przypadku przeglądarki chrome: gecko --> chrome ("webdriver.gecko.driver")

        WebDriver driver = new FirefoxDriver();
        String pageTitle = "";
        String url = "http://automationpractice.com/index.php";
        String expectedTitle = "My Store";
        driver.get(url);
        pageTitle = driver.getTitle();
      /*  if (pageTitle.equals(expectedTitle)) {
            System.out.println("Test pozytywny");
        } else {
            System.out.println("Coś jest nie tak");
        }*/
        Assert.assertEquals(pageTitle, expectedTitle, "Tytuł strony się nie zgadza; sprawdź co poszło nie tak");

        driver.quit();
    }
}
