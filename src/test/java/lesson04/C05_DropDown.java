package lesson04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C05_DropDown {


     /*
    Amazon sayfasina gidip dropdown menuden
    books u secelim
    sectigimiz option i yazdiralim

    dropdown daki opsiyonlarin toplam sayisinin
    23 oldugunu test edin

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
        driver.get("https://www.amazon.com");

    }
    @After
    public void tearDown(){
        //driver.close();
    }
    @Test
    public void test1() {
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Books");

        //Bir dropdown ile calisiyorken son secilen option a ulasmak isterseniz
        //select.getFirstSelectedOption() methodunu kullanmalisiniz
        //Bu method bize webelement dondurur,
        //uerindeki yaziyi yazdirmak icin getText() unutulmamalidir
        System.out.println(select.getFirstSelectedOption().getText());

        /*
        dropdown daki opsiyonlarin toplam sayisinin
        28 oldugunu test edin  //28 ymis 23 u duzelttim
        */

        List<WebElement> optionList = select.getOptions();//select.getOptions bana webElemetlerden olusan bir list donduruyor bu yuzden aldim
        //option lari aldim liste attim

        int actualOptionSayisi = optionList.size();
        int expectedOptionSayisi = 28;

        Assert.assertEquals(actualOptionSayisi,expectedOptionSayisi);


    }


}
