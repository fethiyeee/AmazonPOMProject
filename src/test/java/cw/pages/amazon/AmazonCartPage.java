package cw.pages.amazon;

import cw.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AmazonCartPage extends AmazonBasePage{




    public void mengeDropDown() {
        WebElement mengeDropdown = Driver.getDriver().findElement(By.id("quantity"));
        Select select = new Select(mengeDropdown);
        select.selectByVisibleText("3");
    }

    public double price(){
        WebElement productPrice = Driver.getDriver().findElement(By.xpath("//p[@class='a-spacing-mini']"));
        String pp = productPrice.getText().replace("$", "").replace(" ", "").replace(",", ".");
        return Double.parseDouble(pp);
    }

    public double priceSumme(){
        WebElement productPriceSumme = Driver.getDriver().findElement(By.id("sc-subtotal-amount-activecart"));
        String ppS = productPriceSumme.getText().replace("$", "").replace(" ", "").replace(",", ".");
        return Double.parseDouble(ppS);
    }

    public WebElement loschen(){
        return Driver.getDriver().findElement(By.xpath("//input[@value='Delete']"));
    }

    public String loschenVerify(){
        return Driver.getDriver().findElement(By.xpath("//h1[@class='a-spacing-mini a-spacing-top-base']")).getText();
    }


































    /*

    public AmazonCartPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//select[@name='quantity']")
    WebElement dropQuantity;

    public void selectQuantity() {

        Select select = new Select(dropQuantity);
        select.selectByIndex(productCount);
    }

    @FindBy(id = "sc-subtotal-label-activecart")
    public WebElement subTotalof1Item;

    @FindBy(id = "sc-subtotal-amount-activecart")
    public WebElement subTotalAmount;

    @FindBy(xpath = "//div[@class='sc-badge-price-to-pay']")
    public WebElement productPrice;

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    public WebElement addToCart;

    @FindBy(xpath = "(//h4[.='Added to Cart'])[2]")
    public WebElement addedToCartMessage;

    @FindBy(xpath = "//h1")
    public WebElement shoppingCartMessage;

    @FindBy(xpath = "//input[@value='Delete']")
    public WebElement deleteButton;


    public double getProductPrice() {

        return Double.parseDouble(productPrice.getText().substring(1));
    }

    public double getSubTotalAmount() {
        return Double.parseDouble(subTotalAmount.getText().substring(2));
    }


    public void amoutPriceCheck(){

        double expectedPrice= getProductPrice()*productCount;
        double actualPrice= getSubTotalAmount()*productCount;

        System.out.println(actualPrice);

        Assert.assertEquals(actualPrice,expectedPrice);
    }

     */

}
