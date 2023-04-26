package lesson2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C04_CheckBox {

    /*
     a. Verilen web sayfasına gidin.
     https://the-internet.herokuapp.com/checkboxes
     b. Checkbox1 ve checkbox2 elementlerini locate edin.
     c. Checkbox1 seçili değilse onay kutusunu tıklayın
     d. Checkbox2 seçili değilse onay kutusunu tıklayın
    */

    /*todo NOTTT tek bir sayfaya gidecegim icin before class a gerek yok dilersen olur
    todo ama gerek yok cok sayfa varsa kullan before class i

    */

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        //WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() {
        //driver.close();
    }
    @Test
    public void test1() throws InterruptedException {
        //a. Verilen web sayfasına gidin.

        //  https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        //      b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkbox1 = driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));

        //      c. Checkbox1 seçili değilse onay kutusunu tıklayın
        Thread.sleep(2000);
        if(!checkbox1.isSelected()){
            checkbox1.click();
        }

        //      d. Checkbox2 seçili değilse onay kutusunu tıklayın
        Thread.sleep(2000);
        if(!checkbox2.isSelected()){
            checkbox2.click();
        }
    }
}
