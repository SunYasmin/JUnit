package lesson2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class C05_HerokuAppTestCase {

    public static void main(String[] args) throws InterruptedException{

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);

        //WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //  1-https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        //    2- Add Element butonuna 10 kez basinız
        for (int i = 1; i <=10 ; i++) {
            WebElement onKez =    driver.findElement(By.xpath("//*[text()='Add Element']"));
            onKez.click();
            Thread.sleep(500);
        }
        //    3- 10 kez Add element butonuna basıldığını test ediniz
        List<WebElement> addList = driver.findElements(By.xpath("//button[@class='added-manually']"));
        System.out.println("10 kere delete butonu olustu :" +addList.size());
        //    4 - Delete butonuna görünmeyene kadar basınız

        for (int i = 10; i >=1 ; i--) {
            driver.findElement(By.xpath("//button[@class='added-manually']")).click();

        }
        //  5- Delete butonunun görünmediğini test ediniz
        String deleteButonu = "<button class=\"added-manually\" onclick=\"deleteElement()\">Delete</button>";
        if (driver.getPageSource().contains(deleteButonu)){
            System.out.println("delete butonu vardir");
        }else System.out.println("delete butonu yoktur");

        //    6- Sayfayı kapatınız
        driver.close();

    }

}
