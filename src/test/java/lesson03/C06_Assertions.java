package lesson03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C06_Assertions {


    // 1.Bir Class olusturalimYanlisEmailTesti
    // 2.http://automationpractice.com/index.php sayfasinagidelim
    // 3.Sign in butonunabasalim
    // 4.Email kutusuna @isareti olmayan bir mail yazip enter'a
    // bastigimizda "Invalid email address" uyarisi ciktigini testedelim


    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        //WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationpractice.com/index.php");
    }

    @After
    public void tearDown(){
        //driver.close();
    }

    @Test
    public void Test1(){
        // 3.Sign in butonunabasalim
        driver.findElement(By.xpath("//*[@class='login']")).click();

        // 4.Email kutusuna @isareti olmayan bir mail yazip enter'a
        // bastigimizda "Invalid email address" uyarisi ciktigini testedelim
        WebElement emailKutusu = driver.findElement(By.xpath("//*[@id='email_create']"));
        emailKutusu.sendKeys("qyaseminxgmail.com", Keys.ENTER);

//      bastigimizda “Invalid email address” uyarisi ciktigini test edelim
        WebElement uyariYazisiElementi = driver.findElement(By.xpath("//*[text()='Invalid email address.']"));
        Assert.assertTrue(uyariYazisiElementi.isDisplayed());

    }

}

