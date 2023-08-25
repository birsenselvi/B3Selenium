package gun20.pom.withBy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1 {


    WebDriver driver;
    LoginPage lp;

    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test1(){
        lp = new LoginPage(driver);
        lp.gotoSite();
        lp.assertTitle("Swag Labs");
        lp.login("standard_user", "secret_sauce");
        lp.assertLogin();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
