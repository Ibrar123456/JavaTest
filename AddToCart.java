import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import MainPage.MainPage;

public class AddToCart extends MainPage {
    private By zToA = By.className("product_sort_container");
    private By cart = By.xpath("//a[@class='shopping_cart_link']");

    public AddToCart(WebDriver driver) {
        super(driver);
    }

    public void addToCart() {
        int count = 0;

        driver.findElement(zToA).sendKeys("Name(Z to A)");

        String[] productPriceArray = new String[6];
        for (int i = 0; i < productPriceArray.length; i++) {
            int j = i + 1;
            productPriceArray[i] = driver.findElement(By.xpath("//*[@id='inventory_container']/div/div[" + j + "]/div[2]/div[2]/div"))
                    .getText();
            System.out.println("AllProducts Prices: " + productPriceArray[i]);
        }

        int check = 0;
        for (int i = 0; i < productPriceArray.length; i++) {
            check++;
            String[] parts = productPriceArray[i].split("\\$");
            float prodPrice = Float.parseFloat(parts[1]);
            if (prodPrice < 15.99) {
                driver.findElement(By.xpath("//*[@id='inventory_container']/div/div[" + check + "]/div[2]/div[2]/button"))
                        .click();
                count++;
            }
        }

        driver.findElement(cart).click();
        String[] newproductPriceArray = new String[count];

        for (int i = 0; i < count; i++) {
            int j = 3 + i;
            newproductPriceArray[i] = driver.findElement(By.xpath("//*[@id='cart_contents_container']/div/div[1]/div[" + j + "]/div[2]/div[2]/div"))
                    .getText();
            System.out.println("Less than 15.99 Products Prices: " + newproductPriceArray[i]);
        }

        int check2 = 0;
        for (int i = 0; i < newproductPriceArray.length; i++) {
            check2 = 3 + i;
            String[] parts2 = newproductPriceArray[i].split("\\$");
            float newprodPrice = Float.parseFloat(parts2[1]);
            if (newprodPrice > 9.00) {
                driver.findElement(By.xpath("//*[@id='cart_contents_container']/div/div[1]/div[" + check2 + "]/div[2]/div[2]/button"))
                        .click();
            }
        }
    }
}

