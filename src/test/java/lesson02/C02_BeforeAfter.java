package lesson02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C02_BeforeAfter {


    //her testin onunde calismasi gerekiyorsa bu sekilde yapiyorum class level da tanimla
    WebDriver driver;//bu sekilde yazinca hata vermeden tekrar tekrar kullanirim
    //NOT BEFORE DA AMAC HEP YAZDİGİM O BASTAKI 4 SATIRLIK KISIMLARI BEFORE ILE ONCESINDE YAZACAGIM
    // ONCE BUNLARİ CALISTIR BEFORE İLE SONRA TESTİMI CALİSTIR DİYECEGİM
    // AMA WEBDRİ DRIVER OBJESI ICINDE RAHAT KULLANABİLMEM ICIN CLASS LEVELDA TANIMLARIM

    // @Before kullaniyorsak method icin istedigimiz ismi kullanabiliriz ancak genel olarak kullanımı setUp seklindedir
    //@Before kullandığımızda testlerimizden önce yapmak zorunda oldugumuz driver objelerini yazmak yerine @Before ile bir kere yazarız
    //yani her testten önce burayı calıstır, sonra testlerimizi calıstır.
    // diğer testlerimizde rahat kullanabilmek icin bunu class seviyesinde tanımlamamız gerekir.
    //driver objesini direk kullanabilmek icin class seviyesine WebDriver driver yaz!!

    @Before
    //NOT before larda once method 1 degil setUp yazilir baska birsey de yazilabilir ustune basina da @Before yazilir
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver(); after i da kullanacagim icin hata veriyor o yuzden class level de tanimlarim
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);


        //driver = new ChromeDriver();  // WebDriver driver = .....diye yazinca hata veriyor
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void method1(){
        //todo 1 defa before methodu calisir
        driver.get("https://amazon.com");  //burda before otomatik calisacak
        //todo 1 defa da after methodu calisir
    }

    @After
    public void tearDown(){
        driver.close();
    }

    //todo toplam 3 method calisir

    @Test
    public void method2(){
        driver.get("https://techproeducation.com");
    }
    @Test
    public void method3() {
        //1 defa before methodu çalışır
        driver.get("https://hepsiburada.com");
        //1 defa da after methodu çalışır

        //INT SORUSU kactane method calismistir 3 *3 =9 tane method calismistir
        //BUrda java mantigi yok yukardan asagi degil
        //once before sonra method sonra after 3 method

//NOTTT after i basa alsak da sadece method3 ü calıstırsak da
// before u calistirir sayfaya gider sonra after calisir testi bitirdi
//2. sayfaya gitti ayni sekilde before sonra after sonra kpatti
//3. teste gitti


        //normalde before ya da beforeclass ikiside aynı işlevi yapıyor değil mi
        //before her test methoddan önce çalısır beforclass birkez enbasta çalısır

        //BeforeClass ve AfterClass da bir kere calısır // before ve after da 3 kere çalısır

// BeforeClass - AfterClass ---> BeforeClass+Test+Test+Test+AfterClass çalışıyor sırayla (toplam 5 method çalışıyor)
// Tüm testleri aynı browser'da açtı, son testten sonra browser'ı kapattı
// Before - After ---> Before+Test+After    Before+Test+After   Before+Test+After şeklinde (toplam 9 method çalışıyor)


        /*** Daha sade


        WebDriver driver;
        @After
        //After notasyonu her testten sonra çalışır
        public void tearDown() {
            driver.close();
        }
        @Before
        // Before notasyonu her testten önce çalışır
        public void setUp(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }


        @Test
        public void method1() {
            //1 defa before methodu çalışır
            driver.get("https://amazon.com");
            //1 defa da after methodu çalışır
        }
        @Test
        public void method2() {
            //1 defa before methodu çalışır
            driver.get("https://techproeducation.com");
            //1 defa da after methodu çalışır
        }
        @Test
        public void method3() {
            //1 defa before methodu çalışır
            driver.get("https://hepsiburada.com");
            //1 defa da after methodu çalışır
        }


        */



    }

}
