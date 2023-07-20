package cw.pages.amazon;

import cw.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AmazonBasePage {

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


}
