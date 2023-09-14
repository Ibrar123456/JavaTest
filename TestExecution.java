import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import LoginPage.LoginPage1;
import LoginPage.LoginPage2;
import MainPage.MainPage;

public class TestExecution {
    private WebDriver driver;
    private MainPage mainPage;
    private LoginPage1 loginPage1;
    private AddToCart addToCart;
    private CheckOutPage checkOutPage;
    private LoginPage2 loginPage2;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        loginPage1 = new LoginPage1(driver);
        addToCart = new AddToCart(driver);
        checkOutPage = new CheckOutPage(driver);
        loginPage2 = new LoginPage2(driver);
    }

    @Test
    public void testCase_001() {
        mainPage.seleniumInit();
        loginPage1.login1("https://www.saucedemo.com/", "standard_user", "secret_sauce");
        // Use appropriate waits instead of Thread.sleep
        // Thread.sleep(7000);
        addToCart.addToCart();
        checkOutPage.checkout();
        loginPage2.login2("https://courses.ultimateqa.com/users/sign_in", "standard_user", "secret_sauce");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}