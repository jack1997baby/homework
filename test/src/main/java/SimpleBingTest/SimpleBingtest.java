package SimpleBingTest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class SimpleBingtest {
    static WebDriver driver;

    @BeforeClass
    public static void beforeBingTest() {
        System.setProperty("webdriver.chrome.driver", "D:\\tools\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.baidu.com/");
    }

    @Test
    public void titleTest() throws Exception {
        assertEquals("百度一下，你就知道",driver.getTitle());
    }

    @Test
    public void titleByIdTest() throws Exception {
        WebElement element = driver.findElement(By.id("kw"));
        element.sendKeys("网易云音乐");
        element.submit();
        assertEquals("百度一下，你就知道",driver.getTitle());
    }

    @Test
    public void titleByNameTest() throws Exception {
        WebElement element = driver.findElement(By.name("wd"));
        element.clear();
        element.sendKeys("QQ音乐");
        element.submit();
        assertEquals("百度一下，你就知道",driver.getTitle());
    }

    @AfterClass
    public static void afterBingTest() {
        driver.quit();
    }
}
