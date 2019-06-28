package casestudy4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class StepFlow {
	WebDriver driver;

	@Given("Alex is registered with TextMe App")
	public void alex_is_registered_with_TextMe_App() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_c2a.05.05\\Desktop\\SeleniumDrivers\\chromedriver.exe");
			   driver= new ChromeDriver();
			   driver.get("http://10.232.237.143:443/TestMeApp/");
			   driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[1]/a")).click();
			   driver.findElement(By.id("userName")).sendKeys("AlexUser");
				 driver.findElement(By.id("password")).sendKeys("Alex@123");
				 driver.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div[4]/div/input[1]")).click();
	}

	@When("Alex search for a product like headphone")
	public void alex_search_for_a_product_like_headphone() {
		WebElement search=driver.findElement(By.name("products"));
	    search.click();
	    Actions act=new Actions(driver);
	    act.sendKeys("head").perform();
	     
	   
	}

	@And("Try to proceed to payment without adding anyitem")
	public void try_to_proceed_to_payment_without_adding_anyitem() {
		driver.findElement(By.xpath("/html/body/div[1]/form/input")).click(); 
	}

	@Then("TestMe App didn't displayed cart icon")
	public void testme_App_didn_t_displayed_cart_icon() {
	   //WebDriverWait wait=new WebDriverWait(driver,10);
	   //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")));
	Assert.assertNull(driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")));  
	}

	@Given("Alex is registered with TextMe")
	public void alex_is_registered_with_TextMe() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_c2a.05.05\\Desktop\\SeleniumDrivers\\chromedriver.exe");
			   driver= new ChromeDriver();
			   driver.get("http://10.232.237.143:443/TestMeApp/");
			   driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[1]/a")).click();
			   driver.findElement(By.id("userName")).sendKeys("AlexUser");
				 driver.findElement(By.id("password")).sendKeys("Alex@123");
				 driver.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div[4]/div/input[1]")).click();
	}

	@When("Alex searches a product like headphones")
	public void alex_searches_a_product_like_headphones() {
		WebElement search=driver.findElement(By.name("products"));
	    search.click();
	    Actions act=new Actions(driver);
	    act.sendKeys("head").perform();
	}

	@When("Selects the product from product page and adds to cart")
	public void selects_the_product_from_product_page_and_adds_to_cart() {
		driver.findElement(By.xpath("/html/body/div[1]/form/input")).click(); 
	}

	@Then("Product is added to cart and icon is displayed")
	public void product_is_added_to_cart_and_icon_is_displayed() {
driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();
		Assert.assertNotNull(driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")));
	}
	@Then("Checks Product Quantity and Pice is confirmed")
	public void checks_Product_Quantity_and_Pice_is_confirmed() {
		driver.findElement(By.xpath("//*[@id='header']/div[1]/div/div/div[2]/div/a[2]")).click();
		driver.findElement(By.xpath("//*[@id='cart']/tfoot/tr[2]/td[5]/a")).click();
		driver.findElement(By.xpath("/html/body/b/div/div/div[1]/div/div[2]/div[3]/div/form[2]/input")).click();
	}

	@Then("Alex proceed to payment page and does payment")
	public void alex_proceed_to_payment_page_and_does_payment() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h3")));
		 
		driver.findElement(By.xpath("//*[@id='swit']/div[1]/div/label")).click();
		 
		driver.findElement(By.id("btn")).click();
		 
		Assert.assertEquals(driver.getTitle(), "Payment Gateway");
		 
		driver.findElement(By.name("username")).sendKeys("123456");
		 
		driver.findElement(By.name("password")).sendKeys("Pass@456");
		 
		driver.findElement(By.xpath("//*[@id='horizontalTab']/div[2]/div/div/div/div/form/div/div[3]/input")).click();
		 
		WebDriverWait waitt = new WebDriverWait(driver, 10);
		 
		waitt.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h4")));
		 
		driver.findElement(By.name("transpwd")).sendKeys("Trans@456");
		 
		driver.findElement(By.xpath("//*[@id='horizontalTab']/div[2]/div/div/div/div/form/div/div[2]/input")).click();

	}
	@And("Order page is dispalyed")
	public void order_page_is_dispalyed() {
		Assert.assertEquals(driver.getTitle(), "Order Details");  
	}
}
