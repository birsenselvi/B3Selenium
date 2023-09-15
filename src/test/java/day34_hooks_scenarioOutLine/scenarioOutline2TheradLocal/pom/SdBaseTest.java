package day34_hooks_scenarioOutLine.scenarioOutline2TheradLocal.pom;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;

public class SdBaseTest {

    WebDriver driver;
    WebDriverWait wait;
    public SdBaseTest(){
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    public void click(WebElement element){
        wait.until(driver->{
            try {
                element.click();
                return true;
            }catch(StaleElementReferenceException s){
                return false;
            } catch (Exception e){
                return false;
            }
        });
    }
    public void sendKeys(WebElement element, CharSequence...text){
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);

    }
    public void waitforVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
