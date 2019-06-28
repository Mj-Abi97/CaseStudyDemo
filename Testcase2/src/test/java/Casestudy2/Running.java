package Casestudy2;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Running {
	WebDriver driver;
	@Given("Enter to the login Page")
	public void enter_to_the_login_Page() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_c2a.05.05\\Desktop\\SeleniumDrivers\\chromedriver.exe");
		   driver= new ChromeDriver();
		   driver.get("http://10.232.237.143:443/TestMeApp/login.htm");  
	}

	@When("Enter the username {string}")
	public void enter_the_username(String string) {

	     driver.findElement(By.id("userName")).sendKeys(string);
	}

	@And("Enter the password {string}")
	public void enter_the_password(String string) {
		driver.findElement(By.id("password")).sendKeys(string);
	}

	@And("Click the Signin button")
	public void click_the_Signin_button() {
		driver.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div[4]/div/input[1]")).click();
	}

	@Then("Logins to home page")
	public void logins_to_home_page() {
		Assert.assertEquals(driver.getTitle(),"Home");
	}

}
