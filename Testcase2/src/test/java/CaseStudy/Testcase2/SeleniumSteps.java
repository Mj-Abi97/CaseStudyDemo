package CaseStudy.Testcase2;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;



public class SeleniumSteps {
	WebDriver driver;
	@Given("User is in the registration page")
	public void user_is_in_the_registration_page() {
	   System.setProperty("webdriver.chrome.driver","C:\\Users\\Training_C2a.05.05\\Desktop\\SeleniumDrivers\\chromedriver.exe");
          driver=new ChromeDriver();
          driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	}

	@When("User enters the sign credentials")
	public void user_enters_the_sign_credentials() {
		driver.findElement(By.linkText("SignUp")).click();
		   driver.findElement(By.id("userName")).sendKeys("arunkumar");
		   driver.findElement(By.name("firstName")).sendKeys("arun");
		   
		   driver.findElement(By.name("lastName")).sendKeys("kumar");
		   driver.findElement(By.id("password")).sendKeys("arun123");
		   driver.findElement(By.id("pass_confirmation")).sendKeys("arun123");
		   driver.findElement(By.xpath("//*[@id='gender']")).click();
		   driver.findElement(By.id("emailAddress")).sendKeys("arunkumar@gmail.com");
		   driver.findElement(By.id("mobileNumber")).sendKeys("9500535563");
		   
		   driver.findElement(By.name("dob")).sendKeys("10/18/1997");
		   driver.findElement(By.id("address")).sendKeys("porur,chennai");
		   Select question = new Select(driver.findElement(By.id("securityQuestion")));
		   question.selectByValue("411011");
		   driver.findElement(By.id("answer")).sendKeys("red");
		  
		   
	}

	@And("User clicks the register button")
	public void user_clicks_the_register_button() {
		String user = driver.findElement(By.id("userName")).getText();
		   if(user==" ")
		   {
		    driver.findElement(By.id("userName")).sendKeys("arunkumar");
		   }
		   else
		   {
		   driver.findElement(By.name("Submit")).click();
		   }
	}

	@Then("User is directed to login page")
	public void user_is_directed_to_login_page() {
	
		
		Assert.assertEquals("Login", driver.getTitle());

}
}