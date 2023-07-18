package cw.pages.amazon;

import cw.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AmazonHomePage extends AmazonBasePage {

    public AmazonHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


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

    @FindBy(xpath = "//span[.='Sign Out']")
    WebElement signOutButton;


    public void homePageIsOpened() {

        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://www.amazon.com./";
        Assert.assertEquals(actualUrl, expectedUrl);

    }

    public void signInClick() {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(kontoAndListsButton).perform();
        newAccount.click();
        //Die Seite ermöglicht keine direkte Anmeldung, ohne auf „Neues Konto erstellen“ zu klicken.
        signIn.click();
        eMailOrPhoneArea.sendKeys("01606315327");
        continueButton.click();
        passwordArea.sendKeys("123clarusway");
        signIn2.click();
    }

    public void signOut() {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(kontoAndListsButton).perform();
        signOutButton.click();
    }
}
