package DriverMethods;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class NavigationAndClosing {

    WebDriver driver;
    String actualTitle;


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
    public void getUrl(){
        driver.get("https://google.pl");
    }

    @Test
    public void navigateUrl(){
         driver.navigate().to("http://wikipedia.pl");
         driver.navigate().to("https://nasa.gov");
         driver.navigate().back();
         actualTitle=driver.getTitle();
         Assertions.assertEquals("Wikipedia, wolna encyklopedia",actualTitle);
         driver.navigate().forward();
         actualTitle=driver.getTitle();
         Assertions.assertEquals("NASA",actualTitle);


        driver.navigate().refresh();
    }
    @Test
    public void navigateUrl2(){
        URL googleURL= null;
        try {
            googleURL = new URL("https://google.pl");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.navigate().to(googleURL);
    }
}
