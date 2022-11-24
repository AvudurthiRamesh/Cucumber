package StepDefenition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login
{

	WebDriver driver = null;

	@Given("Browse the application")
	public void browse_the_application()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://192.168.11.50:3026");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@When("User Enters User Name")
	public void user_enters_user_name() throws InterruptedException 
	{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.id("mat-input-0")).sendKeys("kalyan.penumutchu@senecaglobal.com");
	}   

	@And("Clicks on Login Button")
	public void clicks_on_login_button() throws InterruptedException 
	{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@color=\"primary\"]")).click();
	}

	@Then("User is succesfully Logged in")
	public void user_is_succesfully_logged_in() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		System.out.println("User is sucessfully Logged in");
		driver.quit();
	}
}
