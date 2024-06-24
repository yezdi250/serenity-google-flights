import net.thucydides.core.annotations.findby.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class main {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.get("https://www.google.com/travel/flights?gl=AU&hl=en");
        WebElement element = driver.findElement(By.cssSelector("input[aria-label='Where from?']"));
        element.clear();
        element.sendKeys("Sydney");

    }
}
