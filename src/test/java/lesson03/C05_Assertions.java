package lesson03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C05_Assertions {


    static WebDriver driver;
    /*
     * https://www.youtube.com adresine gidin
     * Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
     * titleTest => Sayfa başlığının “YouTube” oldugunu test edin
     * imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
     * Search Box 'in erisilebilir oldugunu test edin (isEnabled())
     * wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
     */

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        //WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");
    }
    @AfterClass
    public static void tearDown() {
        //driver.close();
    }
    @Test
    public void test1(){
        //* titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }
    @Test
    public void test2(){
//* imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement youtubeLogo = driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]"));
        Assert.assertTrue(youtubeLogo.isDisplayed());
    }
    @Test
    public void test3(){
//Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@id='search'])[3]")).isEnabled());
    }
    @Test
    public void test4(){
//* wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String actualTitle = driver.getTitle();
        String unExpectedTitle = "youtube";
        Assert.assertNotEquals(unExpectedTitle,actualTitle);
    }



}
