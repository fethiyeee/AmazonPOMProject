package cw.pages.amazon;

import cw.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AmazonCartPage extends AmazonBasePage {

    public AmazonCartPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//select[@id='quantity']")
    WebElement dropQuantity;

    public void selectQuantity(int index) {

        Select select = new Select(dropQuantity);
        select.selectByIndex(index);
    }

    @FindBy(id = "sc-subtotal-label-activecart")
    public WebElement subtotalLabel;

    @FindBy(id = "sc-subtotal-amount-activecart")
    public WebElement subtotalAmount;

    @FindBy(xpath = "//div[@class='sc-badge-price-to-pay']")
    public WebElement productPrice;


    public double getProductPrice() {

        return Double.parseDouble(productPrice.getText().substring(1));
    }

    public double getSubTotalAmount() {
        return Double.parseDouble(subtotalAmount.getText().substring(2));
    }

}
