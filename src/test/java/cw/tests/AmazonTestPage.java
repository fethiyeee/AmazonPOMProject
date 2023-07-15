package cw.tests;

import cw.pages.amazon.AmazonCartPage;
import cw.pages.amazon.AmazonHomePage;
import cw.pages.amazon.AmazonSearchPage;
import cw.utilities.ConfigurationReader;
import cw.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTestPage {


    /*
 1.The https://www.amazon.com.tr/ site is opened.
 2.Check that the main page is opened.
 3.Accept cookies is selected from the cookie preferences.
 4.Login to the site.
 5.Login process is checked.
 6.Computer is selected from the categories tab next to the search button.
 7.Check that the Computer category is selected.
 8.Write msi in the search field and search.
 9.Check that the search has been made.
 10.The second page opens from the search results page.
 11.Check that the 2nd page is opened.
 12.2nd product on the page is added to cart.
 13.Check that the product has been added to cart.
 14.Check that the “Shopping Cart” page is opened.
 15.Number of items purchased in the basket{quantity} is increased
 16.Cart amount must be found as product price*quantity
 17.Added product is deleted from cart.
 18.It is checked that the deletion process has taken place.
 19.Member exit process is done.
 20.Check that the exit process is done.
    */


    @Test
    public void test() throws InterruptedException {

//         The https://www.amazon.com.tr/ site is opened.
        Driver.getDriver().get(ConfigurationReader.getProperty("amazonUrl"));

//         Check that the main page is opened.
        AmazonHomePage homePage = new AmazonHomePage();
        homePage.homePageIsOpened();//passed

//         Accept cookies is selected from the cookie preferences.

//         Login to the site.

        homePage.signInClick();

//         Login process is checked.

        Assert.assertTrue(homePage.hello.isDisplayed(), "user did not log in");

//         Computer is selected from the categories tab next to the search button.

        AmazonSearchPage searchPage = new AmazonSearchPage();

        searchPage.selectProduct("Computers");

//         Check that the Computer category is selected.

        Assert.assertTrue(searchPage.computersOption.isSelected(), "product is not selected");

//         Write msi in the search field and search.

        searchPage.searchFor("msi");

//         Check that the search has been made.

        Assert.assertTrue(searchPage.resultMessage.isDisplayed(), "results are not visible");

//         The second page opens from the search results page.

        searchPage.scrollandGoToSecondPageofResults();

//         Check that the 2nd page is opened.

        searchPage.selectedPageNo("2");

//         2nd product on the page is added to cart.

        searchPage.clickProduct(3);
        searchPage.addToCart.click();

//         Check that the “Shopping Cart” page is opened.

        AmazonCartPage cartPage = new AmazonCartPage();

        cartPage.cartButton.click();
        Assert.assertTrue(cartPage.shoppingCartMessage.isDisplayed(), "shopping cart page is not opened");//passed


//        Number of items purchased in the basket{quantity} is increased

        cartPage.selectQuantity(3);

//       Cart amount must be found as product price*quantity is checked
        cartPage.amoutPriceCheck(3);





//         Added product is deleted from cart.

        //cartPage.deleteButton.click();

//         It is checked that the deletion process has taken place.
       // Assert.assertTrue(cartPage.cartIsEmptyMessage.isDisplayed(), "Your cart is not empty");//passed

//         Member exit process is done.

        //cartPage.signOut();

//         Check that the exit process is done.
       // Assert.assertTrue(cartPage.eMailOrPhoneArea.isDisplayed(), "user did not sign out");


    }


}
