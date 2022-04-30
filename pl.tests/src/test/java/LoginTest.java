import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

    private WebDriver driver;
    String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    private WebElement emailInput;
    private WebElement passwordInput;
    private WebElement signInButton;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void doLogin() {
        driver.get(url);
        emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("poczta@poczta.pl");
        passwordInput = driver.findElement(By.id("passwd"));
        passwordInput.sendKeys("password");
        signInButton = driver.findElement(By.id("SubmitLogin"));
        signInButton.click();
        String title = driver.findElement(By.className("info-account")).getText();
        System.out.println(title);
        Assert.assertEquals(title, "Welcome to your account. Here you can manage all of your personal information and orders.");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
