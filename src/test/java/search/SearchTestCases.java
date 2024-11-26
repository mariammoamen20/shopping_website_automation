package search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTestCases {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("");
    }
    @Test
    public void check_search_with_empty_data() throws InterruptedException {
       //
        driver.findElement(By.name("name")).sendKeys("");
        driver.findElement(By.xpath("//*[@class='input-group-append']")).click();
        Thread.sleep(5000);
    }

    @Test
    public void check_search_with_numbers() throws InterruptedException {
        driver.findElement(By.name("name")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@class='input-group-append']")).click();
        Thread.sleep(5000);
    }
    @Test
    public void check_search_with_capital_characters() throws InterruptedException {
        driver.findElement(By.name("name")).sendKeys("SHOES");
        driver.findElement(By.xpath("//*[@class='input-group-append']")).click();
        Thread.sleep(5000);
    }
    @Test
    public void check_search_with_spaces() throws InterruptedException {
        //
        driver.findElement(By.name("name")).sendKeys("sh oes");
        driver.findElement(By.xpath("//*[@class='input-group-append']")).click();
        Thread.sleep(5000);
    }
    @Test
    public void check_search_with_mix_letters_with_numbers() throws InterruptedException {
        driver.findElement(By.name("name")).sendKeys("shoes40");
        driver.findElement(By.xpath("//*[@class='input-group-append']")).click();
        Thread.sleep(5000);
    }
    @Test
    public void check_search_with_max_letter() throws InterruptedException {
        driver.manage().window().maximize();
        driver.findElement(By.name("name")).sendKeys("shoesssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
        driver.findElement(By.xpath("//*[@class='input-group-append']")).click();
        Thread.sleep(5000);
    }
    @Test
    public void check_search_with_special_characters() throws InterruptedException {
        driver.manage().window().maximize();
        driver.findElement(By.name("name")).sendKeys("@shoes");
        driver.findElement(By.xpath("//*[@class='input-group-append']")).click();
        Thread.sleep(5000);
    }
    @AfterMethod
    public void cleanUp(){
        driver.quit();
    }
}
