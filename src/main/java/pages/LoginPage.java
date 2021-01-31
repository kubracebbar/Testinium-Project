package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By nameField = By.id("L-UserNameField");
    private By passwordField = By.id("L-PasswordField");
    //private By captcha= By.id("recaptcha-anchor-label"); // Şİfre yanlış girilirse burası açılacak.
    private By loginButton = By.id("gg-login-enter");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public void setUsername(String name) {

        wait.until(ExpectedConditions.presenceOfElementLocated(nameField));
        ;
        driver.findElement(nameField).sendKeys(name);
    }

    public void setPassword(String password) {

        wait.until(ExpectedConditions.presenceOfElementLocated(passwordField));
        driver.findElement(passwordField).sendKeys(password);
    }

    /*public void setCaptcha(){
        driver.findElement(captcha).click();
    }*/
    public MainPage clickLoginButton() {

        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
        return new MainPage(driver);
    }
}
