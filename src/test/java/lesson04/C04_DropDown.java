package lesson04;

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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_DropDown {

    /*dropdown her acilir alan dropdown degil bir ok var oka tikliyorum cikişyor
    incele dedigim de tag select ise dropdown dir
    html select kodunda select in tagin solundaki oka tikladigimde hepsi gelir
    ekranda olan oka tikladigimda acilan liste
    select dropdown da handle icin 3 adim var cok kullanilir
    1- Dropdown menu locate et amazon all tusu gibi
    2- Select objesi olusturacagiz onemli olan select objesine parametre olarak locate ettigimiz dropdown menusunu yazarim
    3- acilan kısımdan birini sececgiz


     */
   /* Amazona git dropdown dan books secenegini secip
       Java aratalim
    ve arama sonuclarinin Java icerdigini test edelim
    */

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
        //close();

    }
    @Test
    public void test01() throws InterruptedException {

        driver.get("https://amazon.com");
        //dropdown dan bir option secmek icin 3 adim vardir
        // 1- dropdown i locate edelim

        WebElement dropDownMenu = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        // 2- bir select objesi olusturalim
        // parametre olarak bir onceki adimda locate ettigimiz bir tanesini secelim

        Select select = new Select(dropDownMenu); //icine olusturdugum webelement dropdown imi yaziyorum


        // 3- Dropdown da varolan option lardan istedigimiz bir taneyi secelim.(books)

        select.selectByVisibleText("Books");  //gorunur text ile
        //select.selectByValue("search-alias=stripbooks-intl-ship");  //value ile
        //select.selectByIndex(5);  //index ile  normal altta cikan listede sayfada *dropdown in index i sirasi 0 dan basla say
        //not 0. index orda cikan all deparments kismi sonra devami
        // NOT VALUE ILE VISIBLE TEXT FARKLI OLABLİRİ
        //SELECT İN ALTİNDAKİ OPTİON LARA BAKARİM VALUE ATTRIBUTE U VAR ONUN DEGERİ
//<option value="search-alias=arts-crafts-intl-ship">Arts &amp; Crafts</option>
//MESELA YUKARDA select tag inin altinda menusunun altinda her zaman value attribute u vardir
//value attributunun Arts&crafts in value su icindeki tirnagin icindeki yazidir
        //value ya gore secersem selectByValue
        //selectByVisibleText  Arts&crafts kismi text yazi



        //Arama kutusuna Java yazdiralim

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java", Keys.ENTER);

        WebElement sonucYazisi = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String sonucYazisiStr = sonucYazisi.getText();
        String arananKelime = "Java";

        Assert.assertTrue(sonucYazisiStr.contains(arananKelime));

        Thread.sleep(3000);


    }

}
