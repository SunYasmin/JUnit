package lesson2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C03_BeforeClassAfterClass {

    //Beforeafter class static kullaniliyor **** public static olmali
    //normalde before ya da beforeclass ikiside aynı işlevi yapıyor değil mi
    //before her test methoddan önce çalısır beforclass birkez enbasta çalısır

    //BeforeClass ve AfterClass da bir kere calısır // before ve after da 3 kere çalısır

    /*todo BeforeClass ve AfterClass notasyonlari kullaniyorsak
    todo olusturacagimiz methodu static yapmamiz gerekir
     */

    static WebDriver driver;//static olmazsa hata verir

    @BeforeClass
    public static void beforeClass(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        //WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void tearDown(){

        driver.close();
    }

    @Test
    @Ignore("aciklama yazabilirsin mesela Baskasinin testidir Zeynep in testi...")
    /*
    Hangi testin calismasini istemiyorsak o test notasyonu altina @Ignore yaz
    Çalışmasını istemediğimiz test için @Ignore notasyonu kullanılır
     */
    public void method1() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://amazon.com");
    }
    @Test
    public void method2() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://techproeducation.com");
    }
    @Test
    public void method3() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://hepsiburada.com");
    }


}
