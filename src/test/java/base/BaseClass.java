package base;

import data.TestData;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

import java.time.Duration;

public class BaseClass {

    protected WebDriver driver = сommon.CommonAction.createDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    protected void switchWindow(){
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
        alert.accept();
    }

    public WebElement WaitElementsVisible(WebElement element){
        //   new WebDriverWait(driver, EXPLICIT_WAIT).until(ExpectedConditions.visibilityOf(element));
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(element));
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(element));


        return element;
    }

    protected void open(String url){
        driver.get(url);
    }



    @AfterSuite(alwaysRun = true)
    public void quite(){
        driver.quit();
    }

}

