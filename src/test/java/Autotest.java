mport org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class FirstTest {

    By phoneNumber = By.xpath(".//input[@data-qa-node='phone-number']");
    By amount = By.xpath(".//input[@data-qa-node='amount']");
    By numberDebitSource = By.xpath(".//input[@data-qa-node='numberdebitSource']");
    By expiredebitSource = By.xpath(".//input[@data-qa-node='expiredebitSource']");
    By cvvdebitSource = By.xpath(".//input[@data-qa-node='cvvdebitSource']");
    By firstNamedebitSource = By.xpath(".//input[@data-qa-node='firstNamedebitSource']");
    By lastNamedebitSource = By.xpath(".//input[@data-qa-node='lastNamedebitSource']");

    @Test
    public void checkMinSumMobiPay(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://next.privat24.ua/mobile");

        driver
                .findElement(By.xpath(".//input[@data-qa-node='phone-number']"))
                .sendKeys("936165251");
        driver
                .findElement(By.xpath(".//input[@data-qa-node='amount']"))
                .sendKeys("1");
        driver
                .findElement(By.xpath(".//input[@data-qa-node='numberdebitSource']"))
                .sendKeys("4558 0328 5584 1715");
        driver
                .findElement(By.xpath(".//input[@data-qa-node='expiredebitSource']"))
                .sendKeys("0223");
        driver
                .findElement(By.xpath(".//input[@data-qa-node='cvvdebitSource']"))
                .sendKeys("902");

        driver
                .findElement(By.xpath(".//input[@data-qa-node='firstNamedebitSource']"))
                .sendKeys("Luis");
        driver
                .findElement(By.xpath(".//input[@data-qa-node='lastNamedebitSource']"))
                .sendKeys("Myers");

        driver.findElement(By.xpath(".//button[@data-qa-node='submit']")).click();

        Assert.assertEquals("936165251", driver.findElement(phoneNumber).getText());
        Assert.assertEquals("1", driver.findElement(amount).getText());
        Assert.assertEquals("4558 0328 5584 1715", driver.findElement(numberDebitSource).getText());
        Assert.assertEquals("0223", driver.findElement(expiredebitSource).getText());
        Assert.assertEquals("902", driver.findElement(cvvdebitSource).getText());
        Assert.assertEquals("Luis", driver.findElement(firstNamedebitSource).getText());
        Assert.assertEquals("Myers", driver.findElement(lastNamedebitSource).getText());

        driver.findElement(By.xpath(".//button[@data-qa-node='submit']")).click();

    }

}