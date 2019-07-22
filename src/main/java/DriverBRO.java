import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

class DriverBRO{

    static WebDriver driver;

    public DriverBRO(WebDriver driver) {
        this.driver = driver;
    }

    LoginPage pageLogin = PageFactory.initElements(driver, LoginPage.class);
   // pageLogin.reg();

   public static String urlProject = "http://nnmclub.to/";

    public static void startBrouserChrome() {
        BruserChrome();
        setPropertyWindow();
        setPropertyTimeOut();
    }

    public static void open(String url) {
        driver.get(url);
    }

    public static void closeDriver() {
        driver.close();
    }

    public static WebDriver BruserChrome(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver setPropertyWindow() {
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver setPropertyTimeOut() {
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        return driver;
    }
}