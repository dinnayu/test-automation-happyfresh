package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import common.CommonUtils;
import common.Constants;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import utility.Hook;

public class LoginScenario {
	private AndroidDriver<MobileElement> driver;
	
	public LoginScenario() {
		this.driver = Hook.getDriver();
	}
	
	@Then("^Verify Login button is disyplayed$")
	public void verify_Login_button_is_disyplayed() throws Throwable {
		Assert.assertTrue(driver.findElement(By.id("com.happyfresh.android:id/login")).isDisplayed());
	}

	@When("^Tap on Login button$")
	public void tap_on_Login_button() throws Throwable {
		driver.findElement(By.id("com.happyfresh.android:id/login")).click();
	}

	@Then("^Verify Login screen$")
	public void verify_Login_screen() throws Throwable {
		Assert.assertTrue(driver.findElement(By.id("com.happyfresh.android:id/upper_login")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id("com.happyfresh.android:id/email")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id("com.happyfresh.android:id/password")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id("com.happyfresh.android:id/login")).isDisplayed());
	}

	@Then("^Fill all mandatory field in Login screen with valid credentials$")
	public void fill_all_mandatory_field_in_Login_screen_with_valid_credentials() throws Throwable {
		MobileElement emailTextField = new CommonUtils().getElementById(driver, "com.happyfresh.android:id/email");
		MobileElement passwordTextField = new CommonUtils().getElementById(driver, "com.happyfresh.android:id/password");
		
		if (emailTextField != null) {
			emailTextField.clear();
			Thread.sleep(1000);
			boolean isEmailFilled = new CommonUtils().isFilledTextfield(emailTextField, Constants.REGISTER_EMAIL);
			
			if (!isEmailFilled) {
				System.err.println("Please fill the email field manually within 10 seconds");
				Thread.sleep(10000);
			}
		}
		
		if (passwordTextField != null) {
			passwordTextField.clear();
			Thread.sleep(1000);
			boolean isPasswordFilled = new CommonUtils().isFilledTextfield(passwordTextField, Constants.REGISTER_PASSWORD);
			
			if (!isPasswordFilled) {
				System.err.println("Please fill the password field manually within 10 seconds");
				Thread.sleep(10000);
			}
		}
		
	    Assert.assertTrue(driver.findElement(By.id("com.happyfresh.android:id/login")).isEnabled());
	    
	}

	@When("^Tap on Sign In button$")
	public void tap_on_Sign_In_button() throws Throwable {
		driver.findElement(By.id("com.happyfresh.android:id/login")).click();
	}

	@Then("^Verify that user success to login with registered account$")
	public void verify_that_user_success_to_login_with_registered_account() throws Throwable {
	}
}
