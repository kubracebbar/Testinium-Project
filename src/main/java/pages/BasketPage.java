package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static pages.ProductPage.productPrice;

public class BasketPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By deleteProduct = By.xpath("//a[@title='Sil']");
    private By productUp = By.xpath("//span[@class='plus icon-plus gg-icon gg-icon-plus']");
    private By productCount = By.xpath("//input[@type='text']");
    String expectedProductCount = "2";
    private By basketStatus = By.xpath("//div[@class='gg-w-22 gg-d-22 gg-t-21 gg-m-18']");
    String expectedbasketStatus = "Sepetinizde ürün bulunmamaktadır.";
    private By basketTotalPrice = By.xpath("//p[@class='new-price']");

    public BasketPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public void assertPrice() {

        wait.until(ExpectedConditions.presenceOfElementLocated(basketTotalPrice));
        String totalPrice = driver.findElement(basketTotalPrice).getText();
        Assert.assertEquals(productPrice, totalPrice);
    }

    public void assertProductCount() {

        wait.until(ExpectedConditions.presenceOfElementLocated(productCount));
        String actualProductCounts = driver.findElement(productCount).getAttribute("value");
        Assert.assertEquals(expectedProductCount, actualProductCounts);
    }

    public void assertBasketStatus() {

        wait.until(ExpectedConditions.presenceOfElementLocated(basketStatus));
        String actualBasketStatus = driver.findElement(basketStatus).getText();
        Assert.assertTrue(expectedbasketStatus.contains(actualBasketStatus));
    }

    public void clickProductUp() {

        wait.until(ExpectedConditions.elementToBeClickable(productUp));
        driver.findElement(productUp).click();
    }

    public void clickDeleteProduct() {

        wait.until(ExpectedConditions.elementToBeClickable(deleteProduct));
        driver.findElement(deleteProduct).click();

    }
}
