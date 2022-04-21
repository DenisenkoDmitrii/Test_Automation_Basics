package Module_13;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.jupiter.api.Assertions.*;


public class AppTest 
{
    static WebDriver driver;

    @BeforeAll
    static void setDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    //============================Тест 1=========================================
    @Test
    void test_1() {
        WebElement webElement;
        driver.get("http://localhost:7000/");
        driver.findElement(By.id("login")).sendKeys("user");
        driver.findElement(By.id("pwd")).sendKeys("user");
        driver.findElement(By.id("signIn")).click();
        driver.findElement(By.xpath("/html/body/div/div/main/div[1]/a")).click();
        driver.findElement(By.id("firstName")).sendKeys("dd");
        driver.findElement(By.id("lastName")).sendKeys("dd2");
        driver.findElement(By.xpath("//*[@id=\"titleForNewEmployee\"]/option[2]")).click();
        driver.findElement(By.name("action")).click();
        assertEquals("dd dd2", driver.findElement(By.xpath("/html/body/div/div/main/div[2]/div[2]/div/div/div[1]/h5")).getText());
        driver.findElement(By.xpath("//*[@id=\"delete-employees-form\"]/button")).click();
    }

    //============================Тест 2=========================================
    @Test
    void test_2() {
        WebElement webElement;
        driver.get("http://localhost:7000/");
        driver.findElement(By.id("login")).sendKeys("user");
        driver.findElement(By.id("pwd")).sendKeys("user");
        driver.findElement(By.id("signIn")).click();
        driver.findElement(By.xpath("/html/body/div/div/main/div[1]/a")).click();
        driver.findElement(By.id("firstName")).sendKeys("dd");
        driver.findElement(By.id("lastName")).sendKeys("dd2");
        driver.findElement(By.xpath("//*[@id=\"titleForNewEmployee\"]/option[3]")).click();
        driver.findElement(By.cssSelector("#new-title-form > div > div > div.col-md-6 > ul > li:nth-child(2)")).click();
        driver.findElement(By.id("metadata0.key")).sendKeys("city");
        driver.findElement(By.id("metadata0.value")).sendKeys("moscow");
        driver.findElement(By.id("submitButton")).click();
        driver.findElement(By.name("action")).click();
        assertEquals("dd dd2", driver.findElement(By.xpath("/html/body/div/div/main/div[2]/div[2]/div/div/div[1]/h5")).getText());
        driver.findElement(By.xpath("//*[@id=\"delete-employees-form\"]/button")).click();
    }

    //============================Тест 3=========================================
    @Test
    void test_3() {

        WebElement webElement;
        driver.get("http://localhost:7000/");
        driver.findElement(By.id("login")).sendKeys("user");
        driver.findElement(By.id("pwd")).sendKeys("user");
        driver.findElement(By.id("signIn")).click();
        driver.findElement(By.xpath("/html/body/div/div/main/div[1]/a")).click();
        driver.findElement(By.id("firstName")).sendKeys("dd");
        driver.findElement(By.id("lastName")).sendKeys("dd2");
        driver.findElement(By.xpath("//*[@id=\"titleForNewEmployee\"]/option[4]")).click();
        driver.findElement(By.cssSelector("#new-title-form > div > div > div.col-md-6 > ul > li:nth-child(2)")).click();
        driver.findElement(By.id("metadata0.key")).sendKeys("email");
        driver.findElement(By.id("metadata0.value")).sendKeys("dd@dd.ru");
        driver.findElement(By.id("submitButton")).click();
        driver.findElement(By.name("action")).click();
        assertEquals("dd dd2", driver.findElement(By.xpath("/html/body/div/div/main/div[2]/div[2]/div/div/div[1]/h5")).getText());
        assertEquals("System Administrator", driver.findElement(By.xpath("/html/body/div/div/main/div[2]/div[2]/div/div/div[2]/h5")).getText());
        driver.findElement(By.xpath("//*[@id=\"edit-employee-form\"]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"titleForNewEmployee\"]/option[3]")).click();
        driver.findElement(By.id("secondName")).sendKeys("ii");
        driver.findElement(By.name("action")).click();
        assertEquals("Senior Software Engineer", driver.findElement(By.xpath("/html/body/div/div/main/div[2]/div[2]/div/div/div[2]/h5")).getText());
        driver.findElement(By.xpath("//*[@id=\"delete-employees-form\"]/button")).click();
    }
}
