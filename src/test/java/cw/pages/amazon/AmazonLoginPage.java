package cw.pages.amazon;

import cw.utilities.Driver;
import org.openqa.selenium.By;

public class AmazonLoginPage extends AmazonBasePage{


    public void loginEmail(){
        Driver.getDriver().findElement(By.xpath("//input[@type='email']")).sendKeys("01606315327");
        Driver.getDriver().findElement(By.xpath("//input[@id='continue']")).click();
    }

    public void loginPassword(){
        Driver.getDriver().findElement(By.xpath("//input[@type='password']")).sendKeys("123clarusway");
        Driver.getDriver().findElement(By.id("signInSubmit")).click();
    }

    public String abMeldenVerify(){
        return Driver.getDriver().findElement(By.xpath("//h1[@class='a-spacing-small']")).getText();
    }
}
