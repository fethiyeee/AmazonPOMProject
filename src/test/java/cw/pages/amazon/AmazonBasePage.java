package cw.pages.amazon;

import cw.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class AmazonBasePage {


    public void searchArea(String searchWord) {
        Driver.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys(searchWord + Keys.ENTER);
    }


    public void cartClick() {
        Driver.getDriver().findElement(By.className("nav-cart-icon nav-sprite")).click();
    }


    public void loginClick() {

        Driver.getDriver().findElement(By.xpath("//a[@class='nav-a']"));
       // Driver.getDriver().findElement(By.xpath("//a[@data-nav-role='signin']")).click();

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//a[@id='nav-link-accountList'])[1]"))).perform();
        Driver.getDriver().findElement(By.xpath("//a[@class='nav-a']")).click();
        //Die Seite ermöglicht keine direkte Anmeldung, ohne auf „Neues Konto erstellen“ zu klicken.
        Driver.getDriver().findElement(By.xpath("(//a[@class='a-link-emphasis'])[1]")).click();
    }


    public void selectDropDown() {
        WebElement searchDropdown = Driver.getDriver().findElement(By.xpath("//select[@name='url']"));
        Select select = new Select(searchDropdown);
        select.selectByVisibleText("Computers");


    }


    public WebElement loginVerify() {
        WebElement loginVerify = Driver.getDriver().findElement(By.id("nav-link-accountList-nav-line-1"));
        return loginVerify;
    }

    public String selectedCategoryVerify() {
        WebElement searchDropdown = Driver.getDriver().findElement(By.id("searchDropdownBox"));
        return searchDropdown.getText();
    }


    public void abmelden() {
        WebElement abmelden = Driver.getDriver().findElement(By.xpath("//a[@data-nav-role='signin']"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(abmelden).perform();
        Driver.getDriver().findElement(By.xpath("//span[.='Abmelden']")).click();
    }
}





















    /*
    protected static int productCount = 4;
    //Ich habe ein statisches int zugewiesen, da die Anzahl der Mengen und die Anzahl der Produkte gleich sein müssen

    public AmazonBasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement textSearch;

    @FindBy(className = "nav-cart-icon nav-sprite")
    public WebElement cartButton;

    @FindBy(xpath = "//h1[@class='a-spacing-mini a-spacing-top-base']")
    public WebElement cartIsEmptyMessage;


    public void searchFor(String keyword) {
        textSearch.sendKeys(keyword + Keys.ENTER);
    }


     */


