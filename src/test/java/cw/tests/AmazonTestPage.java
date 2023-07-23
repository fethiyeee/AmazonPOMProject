package cw.tests;

import cw.pages.amazon.*;
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

        AmazonBasePage basePage = new AmazonBasePage();
        AmazonCartPage cartPage = new AmazonCartPage();
        AmazonLoginPage loginPage = new AmazonLoginPage();
        AmazonHomePage homePage = new AmazonHomePage();
        AmazonSearchPage searchPage = new AmazonSearchPage();

        // Amazon-Website öffnen https://www.amazon.com.tr/
        Driver.getDriver().get(ConfigurationReader.getProperty("amazonUrl"));

        // Startseite wird geöffnet und überprüft
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Amazon"));

        // Cookies akzeptieren
        // homePage.cerezAccept();

        // Login auf der Website
        basePage.loginClick();
        loginPage.loginEmail();
        loginPage.loginPassword();

        // Login-Seite wird geöffnet und überprüft
        Assert.assertTrue(basePage.loginVerify().getText().contains("Hello"));

        // Kategorien-Tab "Computer" auswählen
        basePage.selectDropDown();

        // Computer-Kategorie ausgewählt und überprüft
        Assert.assertTrue(basePage.selectedCategoryVerify().contains("Computer"));

        // In die Suchleiste "msi" eingeben und Suche ausführen
        basePage.searchArea("msi");

        // Die Suchergebnisseite wird geöffnet und überprüft
        Assert.assertTrue(searchPage.searchText().contains("msi"));

        // Auf die 2. Seite der Suchergebnisse navigieren
        searchPage.seiteZweiClick();

        // 2. Seite wird geöffnet und überprüft
        Assert.assertTrue(searchPage.seiteZweiVerify().getText().contains("2"));

        // Wählen Sie das zweite Produkt aus
        searchPage.products().click();

        // Das zweite Produkt auf der Seite wird dem Warenkorb hinzugefügt.
        searchPage.addtoCart();
        Thread.sleep(2000);

        // Überprüfen Sie, ob das Produkt zum Warenkorb hinzugefügt wurde.
        Assert.assertTrue(searchPage.hinzufugen().contains("Added to Cart"));

        // Überprüfen Sie, ob die Warenkorbseite geöffnet ist.
        searchPage.einKaufsWagwen();

        // Die Anzahl der im Warenkorb gekauften {amount} Artikel wurde erhöht
        cartPage.mengeDropDown();

        // Der Betrag im Warenkorb muss als Produktpreis*Betrag angegeben werden.
        System.out.println("ProduktStückPreis = " + cartPage.price());
        System.out.println("Warenkorb-GesamtPreis = " + cartPage.priceSumme()*3);
        Assert.assertEquals(cartPage.price()*3, cartPage.priceSumme()*3);


        // Das hinzugefügte Produkt wird aus dem Warenkorb gelöscht.
        Driver.getDriver().navigate().refresh();
        Thread.sleep(3000);
        cartPage.loschen().click();

        // Es wird geprüft, ob die Löschung erfolgt ist oder nicht.
        Assert.assertTrue(cartPage.loschungVerifizieren().contains("Your Amazon Cart is empty."));

        // Melden Sie sich ab.
        basePage.abMelden();
        Thread.sleep(3000);

        // Überprüfen Sie, ob der Abmeldevorgang abgeschlossen ist.
        Assert.assertTrue(loginPage.abMeldungVerifizieren().contains("Sign in")); //Beim Abmelden wird die Anmeldung erneut angezeigt


    }
}
