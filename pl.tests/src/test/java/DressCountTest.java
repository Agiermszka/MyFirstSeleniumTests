import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class DressCountTest {

    private WebDriver driver;
    private String url = "http://automationpractice.com/index.php";
    private WebElement searchInput;
    private WebElement searchButton;
    private WebElement searchTitle;
    private List<WebElement> dresses;


    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();

    }

    @Test
    public void countDress() {
        driver.get(url);
        searchInput = driver.findElement(By.id("search_query_top"));
        searchInput.sendKeys("DRESS");
        searchButton = driver.findElement(By.name("submit_search"));
        searchButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        searchTitle = driver.findElement(By.xpath("//span[contains(text(),'7 results')]"));
        wait.until(ExpectedConditions.visibilityOf(searchTitle));
        dresses = driver.findElements(By.xpath("//div[@class='product-image-container']"));
        System.out.println(dresses.size());
        Assert.assertEquals(dresses.size(), 7);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
