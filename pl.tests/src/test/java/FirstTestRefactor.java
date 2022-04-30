import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTestRefactor {

    private WebDriver driver;
    String pageTitle = "";
    String url = "http://automationpractice.com/index.php";
    String expectedTitle = "My Store";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");

        driver = new FirefoxDriver();
    }

    @Test
    public void checkPageTitle() {
        driver.get(url);
        pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, expectedTitle, "Tytuł strony się nie zgadza; sprawdź co poszło nie tak");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
