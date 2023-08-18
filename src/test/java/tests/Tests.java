package tests;
import base.BaseClass;
import data.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class Tests extends BaseClass {

    @Test
    public void testMethod(){
        // 1 step("Open Test Site By URL");
        open(TestData.URL);

        // 2 step
        //By titlewait = By.xpath("//img [@id='epam-logo']");
        //WaitElementsVisible(driver.findElement(titlewait));


        // WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("[@id='epam-logo']")));


        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));


        Assert.assertEquals(driver.getTitle(), TestData.Title);


        // Step3 Login
        driver.findElement(By.id(TestData.UserIconID)).click();
        driver.findElement(By.id(TestData.NameID)).sendKeys(TestData.LOGIN);
        driver.findElement(By.id(TestData.PasswordID)).sendKeys(TestData.PASSWORD);
        driver.findElement(By.id(TestData.LoginButtonID)).click();

        // Step4  Accert login name

        String username = driver.findElement(By.id(TestData.UserNameID)).getText();
        Assert.assertEquals(username, TestData.LOGIN_NAME);


        // Step5 Accert items
       List<WebElement> home = driver.findElements(By.xpath(TestData.HomeXPath));
       List<WebElement> contact_form = driver.findElements(By.xpath(TestData.ContactFormXPath));
       List<WebElement> service = driver.findElements(By.xpath(TestData.ServiceXPath));
       List<WebElement> metals_Colors = driver.findElements(By.xpath(TestData.MetalAndColorsXPath));

        List<WebElement> webElementList = List.of(home.get(0),contact_form.get(0), service.get(0), metals_Colors.get(0) );

        for (WebElement s : webElementList
             ) {
            Assert.assertTrue(s.isDisplayed());

        }

        // Step6 Accert 4 images
        List<WebElement> img1 = driver.findElements(By.xpath(TestData.ImgPracticeXPath));
        List<WebElement> img2 = driver.findElements(By.xpath(TestData.ImgCustomXPath));
        List<WebElement> img3 = driver.findElements(By.xpath(TestData.ImgMultiXPath));
        List<WebElement> img4 = driver.findElements(By.xpath(TestData.ImgBaseXPath));

        List<WebElement> imgList = List.of(img1.get(0),img2.get(0), img3.get(0), img4.get(0) );

        for (WebElement s2 : imgList
        ) {
            Assert.assertTrue(s2.isDisplayed());

        }

        // Step7  Accert 4 texts

        WebElement txt1 = driver.findElement(By.xpath(TestData.UnderPracticeImgTxtXPath));
        WebElement txt2 = driver.findElement(By.xpath(TestData.UnderCustomImgTxtXPath));
        WebElement txt3 = driver.findElement(By.xpath(TestData.UnderMultiImgTxtXPath));
        WebElement txt4 = driver.findElement(By.xpath(TestData.UnderBaseImgTxtXPath));



        Assert.assertTrue(txt1.isDisplayed());
        Assert.assertEquals(txt1.getText(),TestData.TxtUnderPractice );

        Assert.assertTrue(txt2.isDisplayed());
        Assert.assertEquals(txt2.getText(),TestData.TxtUnderCustom );

        Assert.assertTrue(txt3.isDisplayed());
        Assert.assertEquals(txt3.getText(),TestData.TxtUnderMulti );

        Assert.assertTrue(txt4.isDisplayed());
        Assert.assertEquals(txt4.getText(),TestData.TxtUnderBase);

        // Step8 Accert iframe with framebutton

        WebElement iframe = driver.findElement(By.xpath(TestData.IFrameXPath));
        Assert.assertTrue(iframe.isDisplayed());

        driver.switchTo().frame("frame");
        WebElement iframeButton = driver.findElement(By.id(TestData.FrameButtonID));


        Assert.assertTrue(iframeButton.isDisplayed());


        // Step 9 SwitchBack
        driver.switchTo().defaultContent();
        ///


        // Step 10
        //ul.sidebar-menu.left>li>a>span
        List<WebElement> menu1 = driver.findElements(By.cssSelector(TestData.CssLeftMenu));
        List<String> menuNames = List.of(TestData.TxtMenuHome, TestData.TxtMenuContactForm, TestData.TxtMenuService,  TestData.TxtMenuMetalsColors,  TestData.TxtMenuElemetsPacks);

        for (int i= 0, j = 0; (i <= 4 ) && (j <= 4) ; i++, j++) {

            Assert.assertTrue(menu1.get(i).isDisplayed());
            String exp, act;
            exp = menuNames.get(j);
            act = menu1.get(i).getText();
            Assert.assertEquals(exp, act);

        }


















    }

}

