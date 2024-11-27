package search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownWithSearch {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver =new ChromeDriver();
        driver.get("");
    }
    @Test
    public void check_numbers_with_accessories_item() throws InterruptedException {
        driver.findElement(By.name("name")).sendKeys("123456");
        WebElement list = driver.findElement(By.name("category_id[]"));
        Select select = new Select(list);
        select.selectByVisibleText("اكسسوارات");
        driver.findElement(By.xpath("//*[@class='input-group-append']")).click();
        Thread.sleep(5000);
    }
    @Test
    public void check_special_characters_with_accessories_item() throws InterruptedException {
        driver.findElement(By.name("name")).sendKeys("@shoes");
        WebElement list = driver.findElement(By.name("category_id[]"));
        Select select = new Select(list);
        select.selectByVisibleText("اكسسوارات");
        driver.findElement(By.xpath("//*[@class='input-group-append']")).click();
        Thread.sleep(5000);
    }
    @Test
    public void check_empty_input_with_accessories_item() throws InterruptedException {
        WebElement list = driver.findElement(By.name("category_id[]"));
        Select select = new Select(list);
        select.selectByVisibleText("ملابس");
        driver.findElement(By.name("name")).sendKeys("");
        driver.findElement(By.xpath("//*[@class='input-group-append']")).click();
        Thread.sleep(5000);
    }

    @AfterMethod
    public void cleanUp(){
        driver.quit();
    }
}
