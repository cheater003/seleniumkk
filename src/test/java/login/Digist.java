package login;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Driver;

public class Digist {

    @Test
    public void dagshop() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Python27\\chromedriver.exe");//导入驱动
        WebDriver webdriver=new ChromeDriver();//定义
        webdriver.get("http://192.168.222.131:8080/DagShop06/user?method=registUI");//连接网址
        String title=webdriver.getTitle();
        Assert.assertEquals(title,"会员登录");//验证title
        Thread.sleep(3000); //休眠
        WebElement mvp =webdriver.findElement(By.id("username")); //输入用户名
        mvp.sendKeys("ddd");
        WebElement password =webdriver.findElement(By.id("inputPassword3"));//密码
        password.sendKeys("ddd");
        WebElement pwd =webdriver.findElement(By.id("confirmpwd"));//再次确认
        pwd.sendKeys("ddd");
        WebElement email =webdriver.findElement(By.id("inputEmail3"));//输入邮箱
        email.sendKeys("5663@qq.com");
        WebElement eml =webdriver.findElement(By.id("usercaption"));//输入人名
        eml.sendKeys("张三");
        WebElement login =webdriver.findElement(By.xpath("//*[@id=\"inlineRadio1\"]"));//点击登录
        login.click();
        WebElement date =webdriver.findElement(By.xpath("//*[@id=\"biith_id\"]"));//定位
        JavascriptExecutor js=(JavascriptExecutor)webdriver;//将webdriver数据类型强转为Javascript
        js.executeScript("arguments[0].value='2017-11-18';",date);//date:被赋值的标签对象
        WebElement bat =webdriver.findElement(By.xpath("/html/body/div[3]/div/div[2]/form/div[9]/div/input"));
        bat.click();
        WebElement bcd =webdriver.findElement(By.xpath("/html/body/div[1]/div[3]/h3"));//校验
        boolean acd=bcd.isDisplayed();
        Assert.assertTrue(acd);





//
//        WebElement login =webdriver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/form/div[5]/div/input"));
//        login.click();
//        Thread.sleep(3000);
//        WebElement escape =webdriver.findElement(By.xpath("/html/body/div/div[1]/div[3]/ol/li[2]/a"));
//        boolean aaa=escape.isDisplayed();
//        Assert.assertTrue(aaa);
//        webdriver.quit();


    }





}
