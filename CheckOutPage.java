package CheckOutPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import MainPage.MainPage;

public class CheckOutPage extends MainPage {
    private By chkout = By.id("checkout");
    private By cont = By.id("continue");
    private By error = By.xpath("//*[@id='checkout_info_container']/div/form/div/div/h3");
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By zip = By.id("postal-code");
    private By finish = By.id("finish");

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public void check() {
        driver.findElement(chkout).click();
        driver.findElement(cont).click();
        String actualText = driver.findElement(error).getText();
        Assert.assertEquals("Error: First Name is required", actualText);

        driver.findElement(firstName).sendKeys("Ibrar");
        driver.findElement(lastName).sendKeys("Hussain");
        driver.findElement(zip).sendKeys("75460");
        driver.findElement(cont).click();
        driver.findElement(finish).click();
        System.out.println("Thank you for your order!");
    }
}