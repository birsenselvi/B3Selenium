package day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class _02DriverMethods {
    static WebDriver driver;
    public static void main(String[] args) {
        // driver tamamlandi
       driver = getDriver("chrome");
        // guidersoft sayfasina gidildi
        driver.get("https://guidersoft.com");
        sleep();
        driver.quit();
    }
    public static WebDriver getDriver(String browser){
        switch(browser.toLowerCase().trim()){
            case "edge":
                return new EdgeDriver();
            case "firefox":
                return new FirefoxDriver();
            default:
                return new ChromeDriver();

        }
    }
    public static WebDriver getDriver(){
        return getDriver("chrome");
    }
    public static void sleep(){
        sleep(1000);
    }
    public static void sleep(long milis){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            throw new RuntimeException();
        }
    }
}
