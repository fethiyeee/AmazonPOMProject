package cw.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
  /*
      POM'de Driver icin TestBase class'ina extends etmek yerine
      Driver class'indan static method'lar kullanarak
      driver olusturup, ilgili ayarlarin yapilmasi
      ve en sonda driver'in kapatilmasi tercih edilmistir.
      POM'de Driver class'indaki getDriver()'nin obje olusturularak kullanilmasini
      engellemek icin
      Singleton pattern kullanimi benimsenmistir.
      Singleton Pattern : tekli kullanim, bir class'in farkli class'lardan
      obje olusturularak kullanimini engellemek icin kullanilir.
      Bunu saglamak icin yapmamiz gereken sey oldukca basit
      obje olusturmak icin kullanilan constructor'i private yaptiginizda
      baska class'larda Driver class'indan obje olusturulmasi mumkun OLAMAZ
       */






/*
`private static WebDriver driver;` ifadesindeki `private` erişim belirteci, `driver` değişkenini sadece `Driver` sınıfının içinde erişilebilir kılar.
Bu, `driver` değişkenine sadece `Driver` sınıfının içindeki metotlar tarafından erişilebileceği anlamına gelir ve diğer sınıflardan doğrudan erişim engellenir.

`private Driver() { }` ifadesindeki `private` erişim belirteci, `Driver` sınıfının yapıcısını (constructor) sınıf dışından erişilemez hale getirir.
Böylece `Driver` sınıfının örneği oluşturulamaz ve bu sınıfın statik metotlarına erişim sağlamak için sınıfın adı kullanılır.

Bu yapı, sınıfın kullanımını kontrol etmek, nesne oluşturulmasını kısıtlamak ve sınıfın içindeki verilerin güvenliğini sağlamak için kullanılır.
`Driver` sınıfının içindeki `driver` değişkeninin dışarıdan doğrudan değiştirilmesi veya erişilmesi engellenir.
Bunun yerine, `getDriver()` metodu aracılığıyla `driver` nesnesine erişim sağlanır ve gerekli kontroller yapılabilir.
 */

public class Driver {
    // create a private static WebDriver object
    private static WebDriver driver;

    private Driver() { //constructor Driver
    }

    // create getDriver method to create and initiate the driver instance
    public static WebDriver getDriver() {
        if (driver == null) {
            switch (ConfigurationReader.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        return driver;
    }

    // create a closeDriver method to close the driver
    public static void closeDriver() {
        //   quit the driver id it is pointing chromedriver, firefoxdriver....
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}