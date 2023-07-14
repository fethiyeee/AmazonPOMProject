package cw.pages.amazon;

import cw.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonBasePage {

    // navbar her sayfada ortak oldugundan tekrar tekrar her sayfada ayni webelementleri locate almamak icin
    // burda bu islemleri yapip diger classlara extends edecegiz

    public AmazonBasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement textSearch;


    @FindBy(id = "nav-cart")
    public WebElement cartButton ;

    @FindBy(id = "nav-link-accountList")
    public WebElement kontoAndListsButton;

    @FindBy(xpath = "//a[@class='nav-a']")
    public WebElement newAccount;

    @FindBy(xpath = "(//a[@class='a-link-emphasis'])[1]")
    public WebElement signIn;

    @FindBy(xpath = "//input[@id='ap_email']")
    public WebElement eMailArea;

    @FindBy(xpath = "//input[@id='continue']")
    public WebElement continueButton;

    @FindBy(xpath = "//input[@id='ap_password']")
    public WebElement passwordArea;

    @FindBy(id = "signInSubmit")
    WebElement signIn2;

    @FindBy(xpath = "//span[contains (.,'Hello')]")
    public WebElement hello;

    public void searchFor(String keyword) {
        textSearch.sendKeys(keyword + Keys.ENTER);
    }

    public void clickToCart() {
        cartButton.click();
    }

    public void signInClick(){

        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(kontoAndListsButton).perform();
        newAccount.click();
        signIn.click();
        eMailArea.sendKeys("fethiye0623@gmail.com");
        continueButton.click();
        passwordArea.sendKeys("Erfet2344.");
        signIn2.click();

    }

}
