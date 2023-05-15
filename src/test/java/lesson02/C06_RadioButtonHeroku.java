package lesson02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C06_RadioButtonHeroku {

    /*
   1. Bir class oluşturun : RadioButtonTest
   2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
       - https://www.facebook.com adresine gidin
       - Cookies’i kabul edin
       - “Create an Account” button’una basin
       - “radio buttons” elementlerini locate edin
       - Secili degilse cinsiyet butonundan size uygun olani secin
    */
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        //WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown() {
        //   driver.close();
    }

    @Test
    public void test1 () throws InterruptedException {
        //    https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
        //    Cookies’i kabul edin
        //    “Create an Account” button’una basin
        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();
        //    “radio buttons” elementlerini locate edin
        WebElement femaleButton = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement maleButton = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement customButton = driver.findElement(By.xpath("//input[@value='-1']"));
        //    Secili degilse cinsiyet butonundan size uygun olani secin
        if (!maleButton.isSelected()) {
            maleButton.click();
        }
        Thread.sleep(2000);
        femaleButton.click();
        Thread.sleep(2000);
        customButton.click();
    }

}
