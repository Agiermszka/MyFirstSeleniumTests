import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WarningDisplayTest {

    private WebDriver driver;
    private String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    private WebElement emailInput;
    private WebElement createAccountButton;
    private boolean warning;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");

        driver = new FirefoxDriver();
    }

    @Test
    public void tryToRegister() {
        driver.get(url);
        emailInput = driver.findElement(By.id("email_create"));
        emailInput.sendKeys("poczta@poczta.pl");
        createAccountButton = driver.findElement(By.id("SubmitCreate"));
        createAccountButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("create_account_error"))));
        warning = driver.findElement(By.id("create_account_error")).isDisplayed();
        Assert.assertTrue(warning);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
