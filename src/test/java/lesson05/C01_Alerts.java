package lesson05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C01_Alerts {


    /*
- https://the-internet.herokuapp.com/javascript_alerts adresine gidelim
- Click for js Alert butonuna tıklayalım
- Tıkladıktan sonra çıkan uyarı mesajına (alerte) tamam diyelim
  */
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test1() throws InterruptedException {
        //- https://the-internet.herokuapp.com/javascript_alerts adresine gidelim
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //   - Click for js Alert butonuna tıklayalım
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        //   - Tıkladıktan sonra çıkan uyarı mesajına (alerte) tamam diyelim
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

    }





}
