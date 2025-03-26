import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PolicyCenterLoginTest {

    WebDriver driver;
    PolicyCenterLoginPage loginPage;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://policycenter-test-url.com");
        loginPage = new PolicyCenterLoginPage(driver);
    }

    @Test
    public void testLogin() {
        loginPage.login("testUser", "password123");
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Login Failed!");
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }

}
