package cw.pages.amazon;

import cw.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AmazonSearchPage extends AmazonBasePage{


    public AmazonSearchPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='a-section aok-relative s-image-square-aspect']")
    List<WebElement>products;


    public void clickProduct(int index){

        products.get(index).click();

    }



}
