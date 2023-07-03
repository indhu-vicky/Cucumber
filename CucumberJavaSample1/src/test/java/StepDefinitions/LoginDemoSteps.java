package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class LoginDemoSteps {

	WebDriver driver=null;
	
	@Given("browser is open")
	public void browser_is_open() {
		System.out.println("Inside step: Browser is open ");
		//Absolute Path of driver file
		//System.setProperty("webdriver.chrome.driver","C:/Users/ADMIN/git/repository/CucumberJavaSample1/src/test/resources/Drivers/chromedriver.exe");
		
		//Relative Path of driver file
		String projectPath=System.getProperty("user.dir");
		System.out.println("Project path is:"+projectPath);
		
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/Drivers/chromedriver.exe");
	    
		driver = new ChromeDriver();
		 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		
		driver.manage().window().maximize();
	}

	@And("user is on login page")
	public void user_is_on_login_page() {
		System.out.println("Inside step: User is on login page ");
		
		driver.navigate().to("https://example.testproject.io/web/");
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() throws InterruptedException {
		System.out.println("Inside step: User enters username and password ");
		
		driver.findElement(By.id("name")).sendKeys("Indhumathi");
		driver.findElement(By.id("password")).sendKeys("12345");
		
		Thread.sleep(2000);
	}
	
	@And("user clicks on login")
	public void user_clicks_on_login() {
		System.out.println("Inside step: User clicks on login button ");
		
		driver.findElement(By.id("login")).click();
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() throws InterruptedException {
		System.out.println("Inside step: User is navigated to next page ");
		
		driver.findElement(By.id("logout")).isDisplayed();
		
		Thread.sleep(3000);
		
		driver.close();
		driver.quit();
	}
	
}
