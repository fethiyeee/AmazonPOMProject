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
    public WebElement signIn;

    @FindBy(xpath = "//a[@class='nav-a']")
    public WebElement newAccount;

    public void searchFor(String keyword) {
        textSearch.sendKeys(keyword + Keys.ENTER);
    }

    public void clickToCart() {
        cartButton.click();
    }

    public void signInClick(){

        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(signIn).perform();
        newAccount.click();

    }

}
