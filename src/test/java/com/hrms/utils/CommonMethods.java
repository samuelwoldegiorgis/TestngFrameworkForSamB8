package com.hrms.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CommonMethods {
  protected static WebDriver driver;

   /**
     * this method will open a browser, set up configuration and navigate to the URL
     */    @BeforeMethod(alwaysRun = true)

   public static void setUp() {

      ConfigsReader.readProperties("/Users/syntax/IdeaProjects/Batch8/TestNGBasics/src/configs/configuration.properties");
        switch (ConfigsReader.getPropertyValue("browser").toLowerCase()) {
            case "chrome":
               WebDriverManager.chromedriver().setup();
              driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser");
        }
        driver.get(ConfigsReader.getPropertyValue("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /**
     * this method will close any open browser
     */
   @AfterMethod(alwaysRun = true)
    public static void tearDown(){
        if(driver!=null){
            driver.quit();
            /**
             *
             */
        }
   }
public static void sendText(WebElement element,String textToSend){
       element.clear();
       element.sendKeys(textToSend);
    }
    public static WebDriverWait getWait(){
        WebDriverWait wait=new WebDriverWait((driver, Constants.EXPLICIT_WAIT);
        return wait;
    }
    public static void waitForClickability(WebElement element){
       getWait().until(ExpectedConditions.elementToBeClickable(element));

    }
    public static void click(WebElement element){
       waitForClickability(element);
       element.click();
    }
}
