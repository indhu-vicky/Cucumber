package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.*;
import pages.loginPage;

public class LoginDemoSteps_POM {

	WebDriver driver=null;
//	update
	loginPage login;
	
	@Given("browser is open")
	public void browser_is_open() {
		System.out.println("====== POM =======");
		System.out.println("Inside step: Browser is open ");
		
		String projectPath=System.getProperty("user.dir");
		System.out.println("Project path is:"+projectPath);
		
		System.setProperty("webdriver.gecko.driver", projectPath+"/src/test/resources/Drivers/geckodriver.exe");
	    
		driver = new FirefoxDriver();
		 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		
		driver.manage().window().maximize();
	}

	@And("user is on login page")
	public void user_is_on_login_page() {
		System.out.println("Inside step: User is on login page ");
		
		driver.navigate().to("https://example.testproject.io/web/");
	}

	@When("^user enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_UserName_and_Password(String username, String password) throws InterruptedException {
		System.out.println("Inside step: User enters username and password ");
//		update
		login=new loginPage(driver);
		
		login.enterUsername(username);
		login.enterPassword(password);
		
		Thread.sleep(2000);
	}
	
	@And("user clicks on login")
	public void user_clicks_on_login() {
		System.out.println("Inside step: User clicks on login button ");
//		update
		login.clickLogin();
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() throws InterruptedException {
		System.out.println("Inside step: User is navigated to next page ");
//		update
		login.checkLogOutIsDisplayed();
		
		Thread.sleep(3000);
		
		driver.close();
	}
	
}
