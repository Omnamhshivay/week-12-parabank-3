package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class RegisterTest extends Utility {
    String baseUrl="https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyThatSigningUpPageDisplay(){

        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        verifyText("Signing up is easy!",By.xpath("//h1[contains(text(),'Signing up is easy!')]"),"Signing up is easy!");
    }
    @Test
    public void userSholdRegisterAccountSuccessfully(){

        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));

        sendTextToElement(By.id("customer.firstName"),"Bahu");
        sendTextToElement(By.id("customer.lastName"),"Bali");
        sendTextToElement(By.id("customer.address.street"),"007 Bahubali");
        sendTextToElement(By.id("customer.address.city"),"Shivgamini");
        sendTextToElement(By.id("customer.address.state"),"Maheshmati");
        sendTextToElement(By.id("customer.address.zipCode"),"007007");
        sendTextToElement(By.id("customer.phoneNumber"),"00700700707");
        sendTextToElement(By.id("customer.ssn"),"7777777");
        sendTextToElement(By.id("customer.username"),"BahuBali01");
        sendTextToElement(By.id("customer.password"),"Devsena");
        sendTextToElement(By.id("repeatedPassword"),"Devsena");
        clickOnElement(By.xpath("//tbody/tr[13]/td[2]/input[1]"));
        verifyText("Your account was created successfully. You are now logged in.",By.xpath("//div[@id='mainPanel']/div[3]/div[2]/p"),"Your account was created successfully. You are now logged in.");

    }
    @After
    public void close(){
        closeDriver();
    }
}
