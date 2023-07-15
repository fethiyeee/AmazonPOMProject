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

    public static int productCount=4;

    public AmazonBasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement textSearch;

    @FindBy(className = "nav-cart-icon nav-sprite")
    public WebElement cartButton;

    @FindBy(id = "nav-link-accountList")
    public WebElement kontoAndListsButton;

    @FindBy(xpath = "//a[@class='nav-a']")
    public WebElement newAccount;

    @FindBy(xpath = "(//a[@class='a-link-emphasis'])[1]")
 //  @FindBy(xpath = "//span[@class='nav-action-inner']")
    public WebElement signIn;

    @FindBy(xpath = "//input[@id='ap_email']")
    public WebElement eMailOrPhoneArea;

    @FindBy(xpath = "//input[@id='continue']")
    public WebElement continueButton;

    @FindBy(xpath = "//input[@id='ap_password']")
    public WebElement passwordArea;

    @FindBy(id = "signInSubmit")
    WebElement signIn2;

    @FindBy(xpath = "//span[contains (.,'Hello')]")
    public WebElement hello;

    @FindBy(xpath = "//select[@name='url']")
    WebElement allButton;

    @FindBy(xpath = "//option[.='Computers']")
    public WebElement computersOption;

    @FindBy(xpath = "//span[contains (.,' results for')]")
    public WebElement resultMessage;

    @FindBy(xpath = "//a[.='2']")
    public WebElement secondPageOfResults;

    @FindBy(xpath = "//span[.='2']")
    public WebElement secondPageOfResults2;

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    public WebElement addToCart;

    @FindBy(xpath = "(//h4[.='Added to Cart'])[2]")
    public WebElement addedToCartMessage;

    @FindBy(xpath = "//h1")
    public WebElement shoppingCartMessage;

    @FindBy(xpath = "//input[@value='Delete']")
    public WebElement deleteButton;

    @FindBy(xpath = "//h1[@class='a-spacing-mini a-spacing-top-base']")
    public WebElement cartIsEmptyMessage;

    @FindBy(xpath = "//span[.='Sign Out']")
    WebElement signOutButton;


    public void signInClick() {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(kontoAndListsButton).perform();
        newAccount.click();
        //The page does not allow direct login without clicking create new account.
        signIn.click();
        eMailOrPhoneArea.sendKeys("01606315327");
        continueButton.click();
        passwordArea.sendKeys("123clarusway");
        signIn2.click();
    }

    public void searchFor(String keyword) {
        textSearch.sendKeys(keyword + Keys.ENTER);
    }

    public void selectProduct(String productVisibleText) throws InterruptedException {
        allButton.click();
        Select select = new Select(allButton);
        select.selectByVisibleText(productVisibleText);
        Thread.sleep(1000);

    }

    public void scrollandGoToSecondPageofResults() throws InterruptedException {
        JavascriptExecutor jsexecutor = (JavascriptExecutor) Driver.getDriver();
        jsexecutor.executeScript("arguments[0].scrollIntoView(true);", secondPageOfResults);
        secondPageOfResults.click();
        Thread.sleep(1000);
    }

    public void selectedPageNo(String pageNo) {
        String secondPageText = secondPageOfResults2.getText();
        Assert.assertEquals(secondPageText, pageNo);
    }

    public void signOut() {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(kontoAndListsButton).perform();
        signOutButton.click();
    }


}
