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

public class C02_Assertions {

    //KARSILASTIRMA ICIN KULLANILIR   ıf else gıbı DOGRULAMA

    /*
    Amazon sayfasina git
    3 farkli test method'u olustur
    a- url'in "amazon" icergini test et
    b- title'in "facebook" icermedigini test et
    c- sol ust kosede amazon logosunun gorundugunu test et
     */

//nott BeforeClass icinde yazarsak static oldugu icin hepsi icin gecerli
// ancak normal test methodu icine yazarsak sadece o test icin gecerli

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        //WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }

    @AfterClass
    public static void tearDown(){
        //driver.close();
    }

    @Test
    public void test1(){
        //driver.get("https://www.amazon.com"); SADECE AMAZONDA CALISACAKSAM EN BASA ALABİLİRİM
        // Her 3 test de amazon sayfasına gitmeyi gerektirdiğinden bu kodu BeforeClass'a yazıyoruz.
        // Not : BeforeAfter methodunda testleri farklı sayfalarda açıp kapatıyor, BeforeAfterCLass methodlarında aynı sayfada açıp sonra kapatıyor.
        // BeforeAfter methodunda methodların static yapmaya gerek yok ama BeforeAfterCLass'da static yapmak zorunlu.
        //before da da yapabilirim ama her method test basinda tekrar amzona gidecek bastakileri yapacak sonra devam kac test varsa tekrar tekrar

        //a- url'in "amazon" icergini test et
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "amazon";
        Assert.assertTrue(actualUrl.contains(expectedUrl));

        //a- url'in "facebook" icergini test et
        String actualUrl1 = driver.getCurrentUrl();
        String expectedUrl1 = "facebook";
        Assert.assertTrue(!(actualUrl.contains(expectedUrl)));



        //b- title'in "facebook" icermedigini test et

        String expectedTitle = "facebook";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(!(actualTitle.contains(expectedTitle)));

        //c- sol ust kosede amazon logosunun gorundugunu test et
        WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());

    }

    @Test
    public void test4 () {
        String expectedUrl1 = "facebook";
        String actualUrl1 = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl1, expectedUrl1);  //Bile bile eşit olmayan bir secenek girersek ve
        // equals ile sorarsak Failed olur

        Assert.assertNotEquals(actualUrl1, expectedUrl1); //Eşit olmayan sonucu bildiğim için  assertNotEquals kullandık

    }
//assertTrue
//beklenen bir sonucun true olduğunun kabul edilmesi gerektiği zaman kullanılır.
// Parametre olarak iki değer alır.
// İlk parametre de bir mesaj gönderilir ikinci parametrede ise gönderilen mesajın doğruluğu için koşul belirlenir.
//assertFalse
//beklenen bir sonucun false olması durumunda kullanılır.
// İki parametre alır. Parametrelerden biri mesajdır diğeri ise koşuldur.
// assertFalse ile koşul yerine getirilmez ise assertionError hatası fırlatır.

}
//@Test1, @Test2.. diye gidince sırasıyla calıstırır
//@Testlerin basına static konulmaz


/*DERS KODLARI
    - Amazon sayfasına gidelim
    3 farklı test methodu oluşturalım
      a-Url'nin amazon içerdiğini test edelim
      b-Title'in facebook içermediğini test edelim
      c- sol üst köşede amazon logosunun göründüğünü test edelim
      d- Url'nin www.facebook.com olduğunu test edin
     */
    /*
static WebDriver driver;

@BeforeClass
public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");

        }
@AfterClass
public static void tearDown() {
        driver.close();
        }
@Test
public void test1(){
        //a-Url'nin facebook içerdiğini test edelim
        String expectedUrl = "facebook";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertFalse(actualUrl.contains(expectedUrl));
        //Assert.assertNotEquals(expectedUrl,actualUrl);
        }
@Test
public void test2(){
        //b-Title'in facebook içermediğini test edelim
        String actualTitle = driver.getTitle();
        String expectedTitle = "facebook";
        Assert.assertFalse(actualTitle.contains(expectedTitle));
        }
@Test
public void test3(){
        //c- sol üst köşede amazon logosunun göründüğünü test edelim
        WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());
        }
@Test
public void test4(){
        //d- Url'nin www.facebook.com olduğunu test edin
        String expectedUrl = "www.facebook.com";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(expectedUrl,actualUrl);
        }
        }
 */
