package DriverMethods;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GettingURLSourceAndTitle {
    WebDriver driver;


    @BeforeEach
    public void driverSetup(){
        System.setProperty( "webdriver.chrome.driver","src/main/resources/chromedriver.exe" );
        driver= new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1280,720));
    }
    @AfterEach
    public void driverQuit(){
        driver.quit();
    }
    @Test
    public void getCurrentUrl(){
        String wikiUrl="https://pl.wikipedia.org/wiki/Wikipedia:Strona_g%C5%82%C3%B3wna";
        driver.navigate().to("http://wikipedia.pl");
        Assertions.assertEquals(wikiUrl, driver.getCurrentUrl(), "Current URL is not " +wikiUrl);
    }
    @Test
    public void getTitle(){
        String wikiTitle="Wikipedia, wolna encyklopedia";
        driver.navigate().to("http://wikipedia.pl");
        Assertions.assertEquals(wikiTitle, driver.getTitle(), "Title of page is not " +wikiTitle);
    }
    @Test
    public void getPageSource(){
        String wikiPageSource="lang=\"pl\"";
        driver.navigate().to("http://wikipedia.pl");
        Assertions.assertTrue(driver.getPageSource().contains(wikiPageSource), " Page source does not contain " +wikiPageSource);
    }
    @Test
    public void veryfyLangugae(){
        String wikiLanguage="lang=\"pl\"";
        driver.navigate().to("http://wikipedia.pl");
        Assertions.assertTrue(driver.getPageSource().contains(wikiLanguage), " Page language does not contain " +wikiLanguage);
    }
    @Test
    public void changeLanguage(){
        driver.navigate().to("http://wikipedia.pl");
        driver.findElement(By.cssSelector("a[title='hiszpański']")).click();
        Assertions.assertEquals("Wikipedia, la enciclopedia libre", driver.getTitle(), "Title of page is not Wikipedia, la enciclopedia libre" );
        Assertions.assertTrue(driver.getPageSource().contains("lang=\"es\""), " Page language does not contain lang=\"es\"");
        Assertions.assertEquals("https://es.wikipedia.org/wiki/Wikipedia:Portada", driver.getCurrentUrl(), "Current URL is not <link rel=\"canonical\" href=\"https://es.wikipedia.org/wiki/Wikipedia:Portada\">" );
    }


}
