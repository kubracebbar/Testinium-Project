package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class ChosenPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By productsList = By.xpath("//ul[@class='catalog-view clearfix products-container']");
    private By secondPage = By.xpath("//ul[@class='clearfix']//li[@class='next-link']");
    private By actualPageNumberXpath = By.xpath("//a[@class='current']");
    private String expectedPageNumber = "2";

    public ChosenPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public void assertPageNumber() {

        wait.until(ExpectedConditions.presenceOfElementLocated(actualPageNumberXpath));
        String actualPageNumber = driver.findElement(actualPageNumberXpath).getText();
        Assert.assertEquals(expectedPageNumber, actualPageNumber);
    }

    public void clickSecondPageButton() {

        wait.until(ExpectedConditions.elementToBeClickable(secondPage));
        driver.findElement(secondPage).click();
    }

    public ProductPage selectProduct() {

        wait.until(ExpectedConditions.elementToBeClickable(productsList));
        List<WebElement> productList = driver.findElements(productsList);
        productList.get(0).click();
        return new ProductPage(driver);

    }
}