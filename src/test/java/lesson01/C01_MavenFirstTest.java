package lesson01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_MavenFirstTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

/*
       1- https://www.amazon.com/ sayfasina gidelim
       2- arama kutusunu locate edelim
       3- “Samsung headphones” ile arama yapalim
       4- Bulunan sonuc sayisini yazdiralim
       5- Ilk urunu tiklayalim
       6- Sayfadaki tum basliklari yazdiralim
     */

        //1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://amazon.com");

        //2- arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        //3- “Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones", Keys.ENTER);

        //4- Bulunan sonuc sayisini yazdiralim
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(sonucYazisi.getText());

        //5- Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();

        //6- Sayfadaki tum basliklari yazdiralim
        System.out.println(driver.findElement(By.xpath("//h1")).getText());

        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();

        //6- Sayfadaki tum basliklari yazdiralim
        System.out.println(driver.findElement(By.xpath("//h1")).getText());
        System.out.println(driver.findElement(By.xpath("//h2")).getText());
        System.out.println(driver.findElement(By.xpath("//h3")).getText());


        /*      6- Sayfadaki tum basliklari yazdiralim
        for (int i = 1; i <=6 ; i++) {
            List<WebElement> basliklar=driver.findElements(By.tagName("h"+i));
            basliklar.stream().forEach(t-> System.out.println(t.getText()));
        }*/
      /*6- Sayfadaki tum basliklari yazdiralim
        WebElement sayfadakiBasliklar=driver.findElement(By.id("nav-xshop-container"));
        System.out.println(sayfadakiBasliklar.getText());
*/
    }


}
