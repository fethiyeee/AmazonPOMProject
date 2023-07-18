package cw.pages.amazon;

import cw.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class AmazonSearchPage extends AmazonBasePage{


    public AmazonSearchPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

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

    @FindBy(xpath = "//div[@class='a-section aok-relative s-image-square-aspect']")
    List<WebElement>products;


    public void clickProduct(int index){

        products.get(index).click();

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

    public void selectedPageIsOpened(String pageNo) {
        String secondPageText = secondPageOfResults2.getText();
        Assert.assertEquals(secondPageText, pageNo);
    }



}
