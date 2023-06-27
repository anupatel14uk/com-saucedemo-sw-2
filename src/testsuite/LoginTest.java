package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){

        // Enter valid username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        // Enter valid password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        //Click on login button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        // Verify Products text display
        String expectedText = "Products";
        String actualText = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals("Products text not displayed", expectedText, actualText);


    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
       // Enter valid username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        // Enter valid password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        //Click on login button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        // Verify 6 Products are displayed on page
        List<WebElement> productList = driver.findElements(By.className("inventory_item"));
        System.out.println("Total products are : "+ productList.size());
        //Verify the number of product are 6
        int expectedSize =6;
        int actualResult =productList.size();
        Assert.assertEquals("Products size is not match ",expectedSize,actualResult);
    }
    public  void closeBrowser(){
        driver.quit();
    }
}
