package tests;

import org.junit.Test;
import pages.*;


public class LoginBaseTest extends BaseTest {
    @Test
    public void testSuccessfulLogin() {

        LoginPage loginPage = homePage.clickLogin();
        loginPage.setUsername("");//kullanıcı adı yazılacak.
        loginPage.setPassword("");// şifre yazılacak.
        //loginPage.setCaptcha();
        MainPage mainPage = loginPage.clickLoginButton();
        mainPage.assertAccountName();
        mainPage.setSearchArea("bilgisayar");
        ChosenPage chosenPage = mainPage.clickFindButton();
        chosenPage.clickSecondPageButton();
        chosenPage.assertPageNumber();
        ProductPage productPage = chosenPage.selectProduct();
        productPage.clickAddBasket();
        //productPage.hoverBasket();
        BasketPage basketPage = productPage.clickBasketPage();
        basketPage.assertPrice();
        basketPage.clickProductUp();
        basketPage.assertProductCount();
        basketPage.clickDeleteProduct();
        basketPage.assertBasketStatus();


    }

}
