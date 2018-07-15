import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Login {
    WebDriver driver;
//BeforeMethod
    @BeforeClass
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("https://courses.ultimateqa.com/users/sign_in");
    }

    @Test
    public void Login1() {
        WebElement email = driver.findElement(By.name("user[email]"));
        email.sendKeys("automation.diplomado.dh@outlook.com");

        WebElement password = driver.findElement(By.xpath("//*[@id=\"user_password\"]"));
        password.sendKeys("Password");

        WebElement submitButton1 = driver.findElement(By.cssSelector(
                "#btn-signin"));
        submitButton1.click();

        WebElement confirmationMessage1 = driver.findElement(
                By.xpath("//*[@id=\"notifications-error\"]/ul/li"));
        String actualMessage = confirmationMessage1.getAttribute("innerText");
        Assert.assertEquals("Invalid email or password.",actualMessage );
    }

    @Test
    public void Login2() {
        WebElement email = driver.findElement(By.name("user[email]"));
        email.sendKeys("automation.diplomado.dh@outlook.com");

        WebElement password = driver.findElement(By.xpath("//*[@id=\"user_password\"]"));
        password.sendKeys("Password123");

        WebElement submitButton1 = driver.findElement(By.cssSelector(
                "#btn-signin"));
        submitButton1.click();
    }


    @AfterClass
    public void closeBrowser(){
        driver.close();
    }
}