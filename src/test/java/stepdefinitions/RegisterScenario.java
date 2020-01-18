package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.Hook;

public class RegisterScenario {
	
	private WebDriver driver;
	
	public RegisterScenario() {
		this.driver = Hook.getDriver();
	}
	
	@Given("^Launch the application$")
	public void launch_the_application() throws Throwable {
	    System.out.println("launch....");
	    driver.findElement(By.xpath("//*[@text='Indonesian']")).click();
	}

	@Then("^Verify Home Screen$")
	public void verify_Home_Screen() throws Throwable {
	   
	}

	@When("^Tap on Hamburger Menu$")
	public void tap_on_Hamburger_Menu() throws Throwable {
	    
	}

	@Then("^Verify User Info menu with chevron is displayed$")
	public void verify_User_Info_menu_with_chevron_is_displayed() throws Throwable {
	    
	}
}
