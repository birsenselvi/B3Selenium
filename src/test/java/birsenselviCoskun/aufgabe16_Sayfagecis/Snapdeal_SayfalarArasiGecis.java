package birsenselviCoskun.aufgabe16_Sayfagecis;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Snapdeal_SayfalarArasiGecis {
    /**
     * 1.  https://www.snapdeal.com/
     * 2.  teddy bear aratin
     * 3.  listelenen ürün sayisi icinden random bir sayi secin
     * 4.  o ürüne scroll edin
     * 5.  o sayfayi ve o ürünün ekran kaydini alin
     * 6.  ürüne tiklayin ve detay sayfasina gidin
     * 7.  ürün resmi üzerinde sol üst köseden sag alt köseye kadar mouse ile hareket edin
     * 8.  ekran görüntüsünü kaydedin
     */
    WebDriver driver;
    WebDriverWait wait;

    {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    String url = "https://www.snapdeal.com/";

    @Test
    public void test() throws IOException {
        driver.get(url);
        By lSearch = By.xpath("//input[@name='keyword'][1]");
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(lSearch));
        Actions actions = new Actions(driver);
        actions
                .click(search)
                .sendKeys("teddy bear")
                .keyDown(Keys.TAB)
                .keyDown(Keys.ENTER)
                .perform();
        By listOfBear = By.cssSelector(".product-title");
        List<WebElement> productList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(listOfBear));
        String mainWin = driver.getWindowHandle();

       /* WebElement result =driver.findElement (By.id("products"));
        WebElement firstProduct = result.findElement(By.xpath("//p[@class ='product-title'][1]"));
        File sourceProduct = firstProduct.getScreenshotAs(OutputType.FILE);
        File targetProduct = new File("screenshots/resimProduct.png");
        FileUtils.copyFile(sourceProduct, targetProduct);*/


        int randomIndex = new Random().nextInt(productList.size());
        WebElement selectedBear = productList.get(randomIndex);


        // By xpath = By.xpath("(//*[@id='bx-slider-left-image-panel']//img)[1]");
        actions
                .scrollToElement(selectedBear)
                .pause(100)
                .click(selectedBear)
                .pause(100)
                .perform();

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> wins = driver.getWindowHandles();
        String newWin = wins.stream()
                .filter(s -> !s.equals(mainWin))
                .findFirst()
                .get();
        driver.switchTo().window(newWin);

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofMillis(10));


        By lCookies = By.cssSelector("div#adroll_reject.adroll_consent_button");
        wait1.until(ExpectedConditions.visibilityOfElementLocated(lCookies)).click();
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(lCookies));

        By lImg = By.cssSelector("#bx-slider-left-image-panel");
        WebElement img = wait.until(ExpectedConditions.visibilityOfElementLocated(lImg));
        move(img, 100, 100);
        move(img, -100, 100);
        move(img, 100, -100);
        TakesScreenshot screenshotss = (TakesScreenshot) driver;
        File source = screenshotss.getScreenshotAs(OutputType.FILE);
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String name = "Resim " + now + ".png";
        File target = new File("Screenshotsss/" + name);
        FileUtils.copyFile(source, target);



    }

    public void move(WebElement element, int x, int y) {
        new Actions(driver)
                .moveToElement(element, x, y)
                .perform();
    }
}
