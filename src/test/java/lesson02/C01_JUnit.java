package lesson02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C01_JUnit {

    /*Not:
    JUnit ile Annotation @ bu sekilde baslar Metadata da denir basit bir yapi kolaylik ozellik katar
     */

    //method olusturtuk, burada junit ile testlerimizi yapabilmek icin üzerine @ annotations dedigimiz @ isaretini
// koyuyoruz ve test yazıyoruz
//run tusu main method yazarsak veya test notasyonunu yazarsak cıkar.
//JUnit ten run yaparsak buradaki bütün methodlar calisir yani aynı anda birden fazla yerin testini yapabiliriz.
//kod calıstıktan sonar asağıda kac saniyede calıstğı ve test passed seklinde cıkar.

    @Test
    public void method1(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);

        //WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");


    }

    @Test
    public void method2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://techproeducation.com");

    }

    @Test
    public void method3(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://hepsiburada.com");

    }


}
