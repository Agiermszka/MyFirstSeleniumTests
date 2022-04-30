import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class AccountRegistrationTest {

    private WebDriver driver;
    String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    private WebElement emailInput;
    private WebElement passwordInput;
    private WebElement submitRegistration;
    private WebElement firstName;
    private WebElement lastName;
    private WebElement address;
    private WebElement city;
    private WebElement state;
    private WebElement zipCode;
    private WebElement mobilePhone;
    private WebElement myAddress;
    private boolean signOutButton;
    private WebElement createAccount;
    private WebElement phoneNumber;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void doRegister() throws InterruptedException {


        driver.get(url);
        emailInput = driver.findElement(By.id("email_create"));
        emailInput.sendKeys("");
        createAccount = driver.findElement(By.id("SubmitCreate"));
        createAccount.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("customer_firstname"))));
        passwordInput = driver.findElement(By.id("passwd"));
        passwordInput.sendKeys("");
        firstName = driver.findElement(By.id("customer_firstname"));
        firstName.sendKeys("");
        lastName = driver.findElement(By.id("customer_lastname"));
        lastName.sendKeys("");
        address = driver.findElement(By.id("address1"));
        address.sendKeys("");
        city = driver.findElement(By.id("city"));
        city.sendKeys("");
        state = driver.findElement(By.id("uniform-id_state"));
        state.click();
        Select select = new Select(driver.findElement(By.id("id_state")));
        select.selectByVisibleText("");
        zipCode = driver.findElement(By.id("postcode"));
        zipCode.sendKeys("");
        mobilePhone = driver.findElement(By.id("id_country"));
        mobilePhone.sendKeys("");
        myAddress = driver.findElement(By.id("alias"));
        myAddress.sendKeys("");
        phoneNumber = driver.findElement(By.id("phone_mobile"));
        phoneNumber.sendKeys("");
        submitRegistration = driver.findElement(By.id("submitAccount"));
        submitRegistration.click();
        signOutButton = driver.findElement(By.className("logout")).isEnabled();
        Assert.assertTrue(signOutButton);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}