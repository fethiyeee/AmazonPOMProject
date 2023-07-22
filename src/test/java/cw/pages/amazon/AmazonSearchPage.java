package cw.pages.amazon;

import cw.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class AmazonSearchPage extends AmazonBasePage {



    public String searchText() {
        WebElement searchText = Driver.getDriver().findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        return searchText.getText();
    }

    public void seiteZweiClick(){
        WebElement seiteZwei = Driver.getDriver().findElement(By.xpath("//a[@aria-label='Zu Seite 2']"));
        seiteZwei.click();
    }

    public WebElement seiteZweiVerify(){
        WebElement seiteZweiVerify = Driver.getDriver().findElement(By.xpath("//span[@aria-label='Aktuelle Seite, Seite 2']"));
        return seiteZweiVerify;
    }

    public WebElement products(){
        List<WebElement> productsList = new ArrayList<>(Driver.getDriver().findElements(By.className("s-image")));
        return productsList.get(1);
    }

    public void addtoCart() {
        Driver.getDriver().findElement(By.xpath("(//input[@id='add-to-cart-button'])[1]")).click();
    }

    public String hinzufugen(){
        return  Driver.getDriver().findElement(By.xpath("//*[@id=\"NATC_SMART_WAGON_CONF_MSG_SUCCESS\"]/span")).getText();
    }

    public void einkaufswagwen(){
        Driver.getDriver().findElement(By.xpath("//*[@id='sw-gtc']/span/a")).click();
    }
























    /*
    public AmazonSearchPage() {

        PageFactory.initElements(Driver.getDriver(), this);
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
    List<WebElement> products;


    public void clickProduct(int index) {

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

     */


}
