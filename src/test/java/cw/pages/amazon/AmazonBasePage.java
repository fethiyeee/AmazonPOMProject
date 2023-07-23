package cw.pages.amazon;

import cw.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class AmazonBasePage {


    public void searchArea(String searchWord) {
        Driver.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys(searchWord + Keys.ENTER);
    }


    public void cartClick() {
        Driver.getDriver().findElement(By.className("nav-cart-icon nav-sprite")).click();
    }


    public void loginClick() {

        Driver.getDriver().findElement(By.xpath("//a[@class='nav-a']"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//a[@id='nav-link-accountList'])[1]"))).perform();
        Driver.getDriver().findElement(By.xpath("//a[@class='nav-a']")).click();
        //Die Seite ermöglicht keine direkte Anmeldung, ohne auf „Neues Konto erstellen“ zu klicken.
        Driver.getDriver().findElement(By.xpath("(//a[@class='a-link-emphasis'])[1]")).click();
    }


    public void selectDropDown() {
        WebElement searchDropdown = Driver.getDriver().findElement(By.xpath("//select[@name='url']"));
        Select select = new Select(searchDropdown);
        select.selectByVisibleText("Computers");

    }


    public WebElement loginVerify() {
        WebElement loginVerify = Driver.getDriver().findElement(By.id("nav-link-accountList-nav-line-1"));
        return loginVerify;
    }

    public String selectedCategoryVerify() {
        WebElement searchDropdown = Driver.getDriver().findElement(By.id("searchDropdownBox"));
        return searchDropdown.getText();
    }


    public void abMelden() {
        WebElement abmelden = Driver.getDriver().findElement(By.xpath("//a[@data-nav-role='signin']"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(abmelden).perform();
        Driver.getDriver().findElement(By.xpath("//span[.='Sign Out']")).click();
    }
}

