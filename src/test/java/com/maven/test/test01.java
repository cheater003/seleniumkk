package com.maven.test;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test01 {
//
//    @BeforeTest
//    public  void beforetest(){System.out.println("This is a beforest");}
//    @BeforeTest
//    public  void beforemethod1(){System.out.println("This is a beforest");}
//    @BeforeTest
//    public  void aftermethod1(){System.out.println("This is a beforest");}
//    @BeforeTest
//    public  void testTest1(){System.out.println("This is a beforest");}
//    @BeforeTest
//    public  void testTest2(){System.out.println("This is a beforest");}
//


//
@Test
public void open_sina(){
    System.setProperty("webdriver.chrome.driver","C:\\Python27\\chromedriver.exe");
    WebDriver webdriver=new ChromeDriver();
    webdriver.get("https://www.sina.com.cn/");
    String title=webdriver.getTitle();
    Assert.assertEquals(title,"新浪首页");

}


}

