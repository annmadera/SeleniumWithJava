import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class firstTest {
    @Test
    public void demoTest(){
        System.setProperty( "webdriver.chrome.driver","src/main/resources/chromedriver.exe" );
        WebDriver driver= new ChromeDriver();
        driver.navigate().to("https://google.pl");

    }
}
