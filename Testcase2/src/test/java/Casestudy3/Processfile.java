package Casestudy3;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Processfile {
WebDriver driver;
WebElement search;
	@Given("User is in Testme app Home page")
	public void user_is_in_Testme_app_Home_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_c2a.05.05\\Desktop\\SeleniumDrivers\\chromedriver.exe");
		   driver= new ChromeDriver();
		   driver.get("http://10.232.237.143:443/TestMeApp/"); 
	}

	@When("User clicks the sigin icon")
	public void user_clicks_the_sigin_icon() {
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[1]/a")).click();
	}

	@When("User enters login credentials in login page")
	public void user_enters_login_credentials_in_login_page() {
		 driver.findElement(By.id("userName")).sendKeys("lalitha");
		 driver.findElement(By.id("password")).sendKeys("password123");
	}

	@And("User clicks login button and proceed to homepage")
	public void user_clicks_login_button_and_proceed_to_homepage() {
		driver.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div[4]/div/input[1]")).click();
		Assert.assertEquals(driver.getTitle(),"Home");	
	}

	@And("User searches for a product in search tab")
	public void user_searches_for_a_product_in_search_tab() {
    search=driver.findElement(By.name("products"));
    search.click();
    Actions act=new Actions(driver);
    act.sendKeys("head").perform();
    
	}

	@Then("User selects the product")
	public void user_selects_the_product() {
		driver.findElement(By.xpath("/html/body/div[1]/form/input")).click();   
	}

	@And("Searched product is displayed in product page")
	public void searched_product_is_displayed_in_product_page() {
		 Assert.assertEquals(driver.getTitle(), "Search");				
	}

}
