package cw.tests;

import cw.pages.amazon.AmazonHomePage;
import cw.utilities.ConfigurationReader;
import cw.utilities.Driver;
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
o 2nd product on the page is added to favourites.
o 2. Check that the product has been added to favorites.
o Go to My Account > My Favorite List page.
o Check that the “My Favorite List” page is opened.
o Added product is deleted from favorites.
o It is checked that the deletion process has taken place.
o Member exit process is done.
o Check that the exit process is done.
     */




    @Test
    public void test(){

//         The https://www.amazon.com.tr/ site is opened.
        Driver.getDriver().get(ConfigurationReader.getProperty("amazonUrl"));

//         Check that the main page is opened.
        AmazonHomePage homePage=new AmazonHomePage();
        homePage.homePageIsOpened();//passed

//         Accept cookies is selected from the cookie preferences.

//         Login to the site.

        homePage.signInClick();

//         Login process is checked.
//         Computer is selected from the categories tab next to the search button.
//         Check that the Computer category is selected.
//         Write msi in the search field and search.
//         Check that the search has been made.
//         The second page opens from the search results page.
//         Check that the 2nd page is opened.
//         2nd product on the page is added to favourites.
//         2. Check that the product has been added to favorites.
//         Go to My Account > My Favorite List page.
//         Check that the “My Favorite List” page is opened.
//         Added product is deleted from favorites.
//         It is checked that the deletion process has taken place.
//         Member exit process is done.
//         Check that the exit process is done.


    }


}