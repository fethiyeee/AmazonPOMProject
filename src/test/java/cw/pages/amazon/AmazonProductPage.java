package cw.pages.amazon;

import cw.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonProductPage extends AmazonBasePage {

    public AmazonProductPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    WebElement addCart;

    public void productAddToCart(){
        addCart.click();
    }

}
