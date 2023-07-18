package cw.tests;

import cw.pages.amazon.AmazonCartPage;
import cw.pages.amazon.AmazonHomePage;
import cw.pages.amazon.AmazonProductPage;
import cw.pages.amazon.AmazonSearchPage;
import cw.utilities.ConfigurationReader;
import cw.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTestPage {

    /*
    1. Die Seite https://www.amazon.com.tr/ wird geöffnet.
    2. Überprüfen Sie, ob die Startseite geöffnet ist.
    3. In den Cookie-Einstellungen ist „Cookies akzeptieren“ ausgewählt.
    4. Melden Sie sich auf der Website an.
    5. Der Registrierungsprozess wird überprüft.
    6. Computer ist auf der Registerkarte „Kategorien“ neben der Suchschaltfläche ausgewählt.
    7. Stellen Sie sicher, dass die Kategorie „Computer“ ausgewählt ist.
    8. Geben Sie msi in das Suchfeld ein und suchen Sie.
    9. Überprüfen Sie, ob der Suche getätigt wurde.
    10. Die zweite Seite wird von der Suchergebnisseite aus geöffnet.
    11. Überprüfen Sie, ob die Seite geöffnet ist.
    12. Das dritte Produkt auf der Seite wird dem Warenkorb hinzugefügt.
    13. Überprüfen Sie, ob das Produkt zum Warenkorb hinzugefügt wurde.
    14. Überprüfen Sie, ob die Warenkorbseite geöffnet ist.
    15. Die Anzahl der im Warenkorb gekauften {amount} Artikel wurde erhöht
    16. Der Betrag im Warenkorb muss als Produktpreis*Betrag angegeben werden.
    17. Das hinzugefügte Produkt wird aus dem Warenkorb gelöscht.
    18. Es wird geprüft, ob die Löschung erfolgt ist oder nicht.
    19. Der Austrittsprozess für Mitglieder ist abgeschlossen.
    20. Überprüfen Sie, ob der Abmeldevorgang abgeschlossen ist.
    */


    @Test
    public void test() throws InterruptedException {

//   Die Seite https://www.amazon.com.tr/ wird geöffnet.
        Driver.getDriver().get(ConfigurationReader.getProperty("amazonUrl"));

//   Überprüfen Sie, ob die Startseite geöffnet ist.
        AmazonHomePage homePage = new AmazonHomePage();
        homePage.homePageIsOpened();//passed

//   In den Cookie-Einstellungen ist „Cookies akzeptieren“ ausgewählt.

//   Melden Sie sich auf der Website an.

        homePage.signInClick();

//   Der Registrierungsprozess wird überprüft.

        Assert.assertTrue(homePage.hello.isDisplayed(), "user did not log in");

//   Computer ist auf der Registerkarte „Kategorien“ neben der Suchschaltfläche ausgewählt.

        AmazonSearchPage searchPage = new AmazonSearchPage();

        searchPage.selectProduct("Computers");

//   Stellen Sie sicher, dass die Kategorie „Computer“ ausgewählt ist.

        Assert.assertTrue(searchPage.computersOption.isSelected(), "product is not selected");

//   Geben Sie msi in das Suchfeld ein und suchen Sie.

        searchPage.searchFor("msi");

//   Überprüfen Sie, ob der Suche getätigt wurde.

        Assert.assertTrue(searchPage.resultMessage.isDisplayed(), "results are not visible");

//   Die zweite Seite wird von der Suchergebnisseite aus geöffnet.

        searchPage.scrollandGoToSecondPageofResults();

//    Überprüfen Sie, ob die Seite geöffnet ist.

        searchPage.selectedPageIsOpened("2");

//    Das dritte Produkt auf der Seite wird dem Warenkorb hinzugefügt.

        searchPage.clickProduct(2);

        AmazonProductPage productPage=new AmazonProductPage();
        productPage.productAddToCart();

//    Überprüfen Sie, ob das Produkt zum Warenkorb hinzugefügt wurde.

        AmazonCartPage cartPage = new AmazonCartPage();

        cartPage.cartButton.click();
        Assert.assertTrue(cartPage.shoppingCartMessage.isDisplayed(), "shopping cart page is not opened");//passed

//    Die Anzahl der im Warenkorb gekauften {amount} Artikel wurde erhöht

        cartPage.selectQuantity();

//    Der Betrag im Warenkorb muss als Produktpreis*Betrag angegeben werden.
        cartPage.amoutPriceCheck();

//    Das hinzugefügte Produkt wird aus dem Warenkorb gelöscht.

        cartPage.deleteButton.click();

//    Es wird geprüft, ob die Löschung erfolgt ist oder nicht.
        Assert.assertTrue(cartPage.cartIsEmptyMessage.isDisplayed(), "Your cart is not empty");//passed

//    Der Austrittsprozess für Mitglieder ist abgeschlossen.

        homePage.signOut();

//    Überprüfen Sie, ob der Abmeldevorgang abgeschlossen ist.
        Assert.assertTrue(homePage.eMailOrPhoneArea.isDisplayed(), "user did not sign out");

    }


}
