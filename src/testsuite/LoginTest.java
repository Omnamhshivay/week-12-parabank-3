package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl="https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void SetUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){

        sendTextToElement(By.name("username"),"BahuBali");
        sendTextToElement(By.name("password"),"Devsena");
        clickOnElement(By.xpath("//div[@id='loginPanel']/form/div[3]/input"));
        verifyText("Accounts Overview",By.xpath("//div[@id='rightPanel']/div/div/h1"),"Accounts Overview");
    }
    @Test
    public void verifyTheErrorMessage(){
        driver.findElement(By.name("username")).sendKeys("BahuBali");
        driver.findElement(By.name("password")).sendKeys("Devsena1");
        driver.findElement(By.xpath("//div[@id='loginPanel']/form/div[3]/input")).click();
        //verify requirement
        String expectedMessage="The username and password could not be verified.";
        String actualMessage=driver.findElement(By.xpath("//div[@id='bodyPanel']/div[2]/p")).getText();
        Assert.assertEquals(expectedMessage,actualMessage);

    }
    @Test
    public void userShouldLogOutSuccessfully(){

        sendTextToElement(By.name("username"),"BahuBali");
        sendTextToElement(By.name("password"),"Devsena");
        clickOnElement(By.xpath("//div[@id='loginPanel']/form/div[3]/input"));
        clickOnElement(By.xpath("//div[@id='bodyPanel']/div/ul/li[8]/a"));
        verifyText("Customer Login",By.xpath("//div[@id='leftPanel']/h2"),"Customer Login Message");
    }
    @After
    public void close(){
        driver.close();
    }
}
