package cw.pages.amazon;

import cw.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage extends AmazonBasePage{

    public AmazonHomePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    //HomePage ile ilgili diger WebElementler locate edilebilir..
}
