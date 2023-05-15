package lesson04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
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

public class C03_DropDown {


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
    @After
    public void tearDown() {
        //driver.close();
    }
    @Test
    public void test1(){

        //https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement ddm = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select select = new Select(ddm);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        //Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2"); //value string 2 "" icinde oldugu icin string olarak aldim
        System.out.println(select.getFirstSelectedOption().getText());


        //Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");//kutucukta yazan sey text olan
        System.out.println(select.getFirstSelectedOption().getText());


        //Tüm dropdown (değerleri(value) degil)  options'i yazdırın
        List<WebElement> tumOpsiyonlar = select.getOptions();//webelementten olustugu icin list foreach olmali her elementin uzerindeki text i yazsin

        for (WebElement each: tumOpsiyonlar
        ) {
            System.out.println(each.getText());
        }

        //Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
        //False yazdırın.

        int dropdownBoyut = tumOpsiyonlar.size();
        if (dropdownBoyut==4){
            System.out.println("true");
        }else System.out.println("false");



    }


}
