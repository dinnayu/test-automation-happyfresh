package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import common.CommonUtils;
import common.Constants;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import utility.Hook;

public class RegisterScenario {
	
	private AndroidDriver<MobileElement> driver;
	
	public RegisterScenario() {
		this.driver = Hook.getDriver();
	}
	
	@Given("^Launch the application$")
	public void launch_the_application() throws Throwable {
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@text='Indonesian']")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("com.happyfresh.android:id/ui_view_skip_on_boarding_text_view")).click();
	}
	
	@Then("^Verify Home Screen$")
	public void verify_Home_Screen() throws Throwable {
		Thread.sleep(10000);
	    Assert.assertTrue(driver.findElement(By.className("android.widget.ImageButton")).isDisplayed());
	    Assert.assertTrue(driver.findElement(By.id("com.happyfresh.android:id/component_newsfeed_display_on_home_screen")).isDisplayed());
	    Assert.assertTrue(driver.findElement(By.id("com.happyfresh.android:id/component_address_info")).isDisplayed());
	    Assert.assertTrue(driver.findElement(By.id("com.happyfresh.android:id/component_supplier_nearby_list")).isDisplayed());
	    Assert.assertTrue(driver.findElement(By.id("com.happyfresh.android:id/component_supplier_brand_list")).isDisplayed());
	}

	@When("^Tap on Hamburger Menu$")
	public void tap_on_Hamburger_Menu() throws Throwable {
		Thread.sleep(4000);
		driver.findElement(By.className("android.widget.ImageButton")).click();
	}

	@Then("^Verify User Info menu with chevron is displayed$")
	public void verify_User_Info_menu_with_chevron_is_displayed() throws Throwable {
	    Assert.assertTrue(driver.findElement(By.id("com.happyfresh.android:id/component_drawer_user_info")).isDisplayed());
	}
	
	@When("^Tap on User Info menu with chevron$")
	public void tap_on_user_info_Menu() throws Throwable {
		Thread.sleep(4000);
		driver.findElement(By.id("com.happyfresh.android:id/component_drawer_user_info")).click();
	}
	
	@Then("^Verify Register button is displayed$")
	public void verify_Register_button_is_displayed() throws Throwable {
	    Assert.assertTrue(driver.findElement(By.id("com.happyfresh.android:id/signup")).isDisplayed());;
	}

	@When("^Tap on Register button$")
	public void tap_on_Register_button() throws Throwable {
		driver.findElement(By.id("com.happyfresh.android:id/signup")).click();
	}
	
	@Then("^Verify Register screen$")
	public void verify_Register_screen() throws Throwable {
	    Assert.assertTrue(driver.findElement(By.id("com.happyfresh.android:id/first_name")).isDisplayed());
	    Assert.assertTrue(driver.findElement(By.id("com.happyfresh.android:id/last_name")).isDisplayed());
	    Assert.assertTrue(driver.findElement(By.id("com.happyfresh.android:id/edittext_email")).isDisplayed());
	    Assert.assertTrue(driver.findElement(By.id("com.happyfresh.android:id/edittext_password")).isDisplayed());
	    Assert.assertTrue(driver.findElement(By.id("com.happyfresh.android:id/sign_up")).isDisplayed());
	}

	@Then("^Fill all mandatory field with valid credentials$")
	public void fill_all_mandatory_field() throws Throwable {
		Thread.sleep(10000);
		MobileElement firstName = new CommonUtils().getElementById(driver, "com.happyfresh.android:id/first_name");
		MobileElement lastName = new CommonUtils().getElementById(driver, "com.happyfresh.android:id/last_name");
		MobileElement email = new CommonUtils().getElementById(driver, "com.happyfresh.android:id/edittext_email");
		MobileElement password = new CommonUtils().getElementById(driver, "com.happyfresh.android:id/edittext_password");
		
		if (firstName != null) {
			firstName.clear();
			Thread.sleep(1000);
			
			boolean isFirstNameFilled = new CommonUtils().isFilledTextfield(firstName, Constants.REGISTER_FIRST_NAME);
			if (!isFirstNameFilled) {
				System.err.println("Please fill the first name text field manally within 10 seconds");
				Thread.sleep(10000);
			}
			
		}
		
		if (lastName != null) {
			lastName.clear();
			Thread.sleep(1000);
			boolean isLastNameFilled = new CommonUtils().isFilledTextfield(lastName, Constants.REGISTER_LAST_NAME);
			if (!isLastNameFilled) {
				System.err.println("Please fill the last name text field manally within 10 seconds");
				Thread.sleep(10000);
			}
		}
		
		if (email != null) {
			email.clear();
			Thread.sleep(1000);
			boolean isEmailFilled = new CommonUtils().isFilledTextfield(email, Constants.REGISTER_EMAIL);
			if (!isEmailFilled) {
				System.err.println("Please fill the email text field manally within 10 seconds");
				Thread.sleep(10000);
			}
		}
		
		if (password != null) {
			password.clear();
			Thread.sleep(1000);
			boolean isPasswordFilled = new CommonUtils().isFilledTextfield(password, Constants.REGISTER_PASSWORD);
			if (!isPasswordFilled) {
				System.err.println("Please fill the password text field manally within 10 seconds");
				Thread.sleep(10000);
			}
		}
		
		Assert.assertTrue(driver.findElement(By.id("com.happyfresh.android:id/sign_up")).isEnabled());
	}
	
	@When("^Tap on Next button$")
	public void tap_on_Next_button() throws Throwable {
		driver.findElement(By.id("com.happyfresh.android:id/sign_up")).click();
	}
	
	@Then("^Verify that user success to register a new account$")
	public void verify_that_user_success_to_register_a_new_account() throws Throwable {
		Assert.assertTrue(driver.findElement(By.id("com.happyfresh.android:id/country_code_picker")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id("com.happyfresh.android:id/edittext_phone_number")).isDisplayed());
	}

}
