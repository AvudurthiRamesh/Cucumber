package StepDefenition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearch 
{
    WebDriver driver = null;
	@Given("Browser is open")
	public void browser_is_open() 
	{
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
		driver.get("http://www.google.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		
	}

	@When("User perfor search functionality")
	public void user_perfor_search_functionality() 
	{
	    driver.findElement(By.name("q")).sendKeys("news");
	}

	@When("Clicks on enter")
	public void clicks_on_enter() 
	{
	    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

	@Then("User must succesfully nagivates to the serach results")
	public void user_must_succesfully_nagivates_to_the_serach_results()
	{
	    System.out.println("It sucessfully navigated to the search results");
	    
	    driver.findElement(By.xpath("//h3[text() ='Google News']")).click();
	}

	
}
