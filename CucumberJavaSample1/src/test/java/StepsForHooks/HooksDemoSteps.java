package StepsForHooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.*;
 
public class HooksDemoSteps {

	WebDriver driver= null;
	
	@Before(order=1)
	public void BrowserSetup() {
		
		System.out.println("I am inside browser setup");
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
	    driver= new ChromeDriver();
	    
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    driver.manage().window().maximize();
	}
	
//	@Before(order=0)
	@Before("@smoke")
	public void setup2() {
		System.out.println("I am inside setup2 \n");
	}
	
	@After(order=1)
	public void teardown() {
		System.out.println("I am inside teardown setup");
		driver.close();
		driver.quit();
	}
	
	@After(value="@smoke",order=2)
	public void teardown2(){
		System.out.println(" I am inside teardown setup2 \n");
	}
	
	@After(value="@smoke",order=3)
	public void teardown3(){
		System.out.println(" I am inside teardown setup3 \n");
	}
	
	@BeforeStep
	public void BeforeStep() {
		System.out.println("I am inside Beforestep ----");
	}
	
	@AfterStep
	public void AfterStep() {
		System.out.println("I am inside Afterstep ----");
	}
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
	
	}
	
	@When("user enters valid username and password")
	public void user_enters_valid_username_and_password() {

	}
	
	@And("clicks on login button")
	public void clicks_on_login_button() {

	}
	
	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {

	}
}
