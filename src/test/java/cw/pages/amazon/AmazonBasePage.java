package cw.pages.amazon;

import cw.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AmazonBasePage {

    protected static int productCount = 4;
    //I assigned a static int because the number of quantity and the number of products must be the same

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
