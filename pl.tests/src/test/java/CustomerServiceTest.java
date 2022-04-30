import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class CustomerServiceTest {

    private WebDriver driver;
    String url = "http://automationpractice.com/index.php";

    private WebElement contactUsButton;
    private WebElement emailInput;
    private Select subjectHeader;
    private WebElement fileInput;
    private WebElement messageInput;
    private WebElement sendButton;
    private boolean successMessage;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void sendMessage() {
        driver.get(url);
        contactUsButton = driver.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?controller=contact']"));
        contactUsButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        emailInput = driver.findElement(By.id("email"));
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        subjectHeader = new Select(driver.findElement(By.id("id_contact")));
        subjectHeader.selectByVisibleText("Customer service");
        emailInput.sendKeys("poczta@poczta.pl");
        File file = new File("src/main/resources/test.txt");
        fileInput = driver.findElement(By.id("fileUpload"));
        fileInput.sendKeys(file.getAbsolutePath());
        messageInput = driver.findElement(By.id("message"));
        messageInput.sendKeys("dddddddddd");
        sendButton = driver.findElement(By.id("submitMessage"));
        sendButton.click();
        successMessage = driver.findElement(By.xpath("//p[@class='alert alert-success']")).isDisplayed();
        Assert.assertTrue(successMessage);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
