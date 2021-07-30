import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.nio.cs.US_ASCII;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class xinzeng {
    public void rigist (String us,String pas,String agpas,String em,String xm,String sex,String birthdate)
            throws InterruptedException {
        WebDriver webdriver = null;
        try {
            System.setProperty("webdriver.firefox.driver", "C:\\Python27\\geckodriver.exe");//导入驱动
            webdriver = new FirefoxDriver();//启用谷歌浏览器
            webdriver.get("http://192.168.222.131:8080/DagShop06/user?method=registUI");//打开网址
            String title = webdriver.getTitle();//检测
            Assert.assertEquals(title, "会员登录");//校验
            Thread.sleep(3000);//休眠
            WebElement account = webdriver.findElement(By.id("username"));//通过定位拿到当前标签对象
            account.sendKeys(us);//用户名
            WebElement pt = webdriver.findElement(By.id("inputPassword3"));//通过定位拿到当前标签对象
            pt.sendKeys(pas);//输入密码
            WebElement pa = webdriver.findElement(By.id("confirmpwd"));//通过定位拿到当前标签对象
            pa.sendKeys(agpas);//再次输入密码
            WebElement et = webdriver.findElement(By.id("inputEmail3"));//通过定位拿到当前标签对象
            et.sendKeys(em);//输入邮箱
            WebElement en = webdriver.findElement(By.id("usercaption"));//通过定位拿到当前标签对象
            en.sendKeys(xm);//输入姓名
            //通过定位拿到当前标签对象
            if(sex.equals("1")){
                WebElement nan = webdriver.findElement(By.xpath("//*[@id=\"inlineRadio1\"]"));
                nan.click();//筛选男
            }
            else{
                WebElement nv = webdriver.findElement(By.xpath("//*[@id=\"inlineRadio2\"]"));
                nv.click();//筛选女
            }
            WebElement date =webdriver.findElement(By.xpath("//*[@id=\"biith_id\"]"));//日期
            JavascriptExecutor js=(JavascriptExecutor)webdriver;//将webdriver数据类型强转为Javascript
            String JSS="arguments[0].value="+"'"+birthdate+"';";
            js.executeScript("arguments[0].value="+"'"+birthdate+"';",date);
            System.out.println(JSS);
            Thread.sleep(3000);

            WebElement nan = webdriver.findElement(By.xpath("/html/body/div[3]/div/div[2]/form/div[9]/div/input"));
            nan.click();//点击登录


            } catch (Exception e){
            webdriver.close();
            System.out.println("当前登录失败");}


            WebElement gongxi = webdriver.findElement(By.xpath("/html/body/div[1]/div[3]/h3"));//
            boolean ccc = gongxi.isDisplayed();//检测
            Assert.assertTrue(ccc);//校验tuichu标签是否出现在网页中
            Thread.sleep(3000);
            webdriver.close();//关闭浏览器

    }



    public void cha01() throws Exception {
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://192.168.222.131:3306/store";
        String username = "root";
        String password = "123456";
        Class.forName(driverClassName);
        Connection con = DriverManager.getConnection(url, username, password);
        Statement stmt = con.createStatement();
        String sql = "select * from kk";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
            String us = rs.getString("us");
            String pas = rs.getString("pas");
            String agpas = rs.getString("agpas");
            String em = rs.getString("em");
            String xm = rs.getString("xm");
            String sex = rs.getString("sex");
            String birthdate = rs.getString("birthdate");


           xinzeng dc = new xinzeng();

            dc.rigist(us,pas,agpas,em,xm,sex,birthdate);

            System.out.println(us +" "+pas+" "+agpas+" "+em+" "+xm+" "+sex+" "+birthdate);
        }


    }
    @Test
    public void dl02()  {
        xinzeng dl = new xinzeng();
        try {
            dl.cha01();
        } catch (Exception e) {
            System.out.println("当前登录错误");
        }
    }
}



