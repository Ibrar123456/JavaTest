package LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class LoginPage2 extends MainPage {
    private By username = By.id("user[email]");
    private By password = By.id("user[password]");
    private By signInButton = By.xpath("//button[@class='button button-primary g-recaptcha']");

    public LoginPage2(WebDriver driver) {
        super(driver);
    }

    public void login2(String url, String username, String password) {
        ((JavascriptExecutor) driver).executeScript("window.open();");
        String currentWindowHandle = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
        driver.get(url);
        // Use appropriate waits instead of Thread.sleep
        // Thread.sleep(4000);
        driver.findElement(this.username).sendKeys(username);
        driver.findElement(this.password).sendKeys(password);
        driver.findElement(signInButton).click();
        driver.close();
        driver.switchTo().window(currentWindowHandle);
    }
}