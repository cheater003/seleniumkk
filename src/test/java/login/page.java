package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.misc.JavaAWTAccess;

public class page {

    @Test
    public void dagshop() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Python27\\chromedriver.exe");
        WebDriver webdriver=new ChromeDriver();
        webdriver.get("http://192.168.222.131:8080/DagShop06/");
        String title=webdriver.getTitle();
        Assert.assertEquals(title,"WEB01");
        Thread.sleep(3000);
        WebElement webElement=webdriver.findElement(By.xpath("/html/body/div/div[1]/div[3]/ol/li[1]/a"));
        webElement.click();
        Thread.sleep(3000);
        WebElement acconut =webdriver.findElement(By.id("username"));
        acconut.sendKeys("aaa");
        WebElement password =webdriver.findElement(By.id("inputPassword3"));
        password.sendKeys("aaa");
        Thread.sleep(3000);
        WebElement login =webdriver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/form/div[5]/div/input"));
        login.click();
        Thread.sleep(3000);
        WebElement escape =webdriver.findElement(By.xpath("/html/body/div/div[1]/div[3]/ol/li[2]/a"));
        boolean aaa=escape.isDisplayed();//验证
        Assert.assertTrue(aaa);
        webdriver.quit();


    }
















}
