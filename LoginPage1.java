package LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage1 extends MainPage {
    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");

    public LoginPage1(WebDriver driver) {
        super(driver);
    }

    public void login1(String url, String username, String password) {
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(this.username).sendKeys(username);
        driver.findElement(this.password).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}