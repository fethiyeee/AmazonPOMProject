package cw.pages.amazon;

import cw.utilities.Driver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AmazonHomePage extends AmazonBasePage{

    public AmazonHomePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    public void homePageIsOpened(){

        String actualUrl= Driver.getDriver().getCurrentUrl();
        String expectedUrl="https://www.amazon.com./";
        Assert.assertEquals(actualUrl,expectedUrl);

    }
}
