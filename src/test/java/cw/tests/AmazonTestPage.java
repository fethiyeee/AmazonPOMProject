package cw.tests;

import cw.pages.amazon.AmazonHomePage;
import cw.pages.amazon.AmazonSearchPage;
import cw.utilities.ConfigurationReader;
import cw.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTestPage {


    /*
o The https://www.amazon.com.tr/ site is opened.
o Check that the main page is opened.
o Accept cookies is selected from the cookie preferences.
o Login to the site.
o Login process is checked.
o Computer is selected from the categories tab next to the search button.
o Check that the Computer category is selected.
o Write msi in the search field and search.
o Check that the search has been made.
o The second page opens from the search results page.
o Check that the 2nd page is opened.
o 2nd product on the page is added to cart.
o 2. Check that the product has been added to cart.
o Check that the “Shopping Cart” page is opened.
o Added product is deleted from cart.
o It is checked that the deletion process has taken place.
o Member exit process is done.
o Check that the exit process is done.
     */


    @Test
    public void test() {

//         The https://www.amazon.com.tr/ site is opened.
        Driver.getDriver().get(ConfigurationReader.getProperty("amazonUrl"));

//         Check that the main page is opened.
        AmazonHomePage homePage = new AmazonHomePage();
        homePage.homePageIsOpened();//passed

//         Accept cookies is selected from the cookie preferences.

//         Login to the site.

        homePage.signInClick();

//         Login process is checked.

        Assert.assertTrue(homePage.hello.isDisplayed());

//         Computer is selected from the categories tab next to the search button.

        AmazonSearchPage searchPage = new AmazonSearchPage();

        searchPage.selectProduct("Computers");

//         Check that the Computer category is selected.

        Assert.assertTrue(searchPage.computersOption.isSelected());

//         Write msi in the search field and search.

        searchPage.searchFor("msi");

//         Check that the search has been made.

        Assert.assertTrue(searchPage.resultMessage.isDisplayed());

//         The second page opens from the search results page.

        searchPage.scrollandGoToSecondPageofResults();

//         Check that the 2nd page is opened.

        searchPage.selectedPageNo("2");

//         2nd product on the page is added to cart.


//         Check that the “Shopping Cart” page is opened.o Added product is deleted from cart.
//         It is checked that the deletion process has taken place.
//         Member exit process is done.
//         Check that the exit process is done.


    }


}
