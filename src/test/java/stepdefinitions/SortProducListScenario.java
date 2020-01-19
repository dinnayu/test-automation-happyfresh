package stepdefinitions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import utility.Hook;

public class SortProducListScenario {
	
	private AndroidDriver<MobileElement> driver;
	
	public SortProducListScenario() {
		this.driver = Hook.getDriver();
	}
	
	@Then("^Verify Select Location button is displayed$")
	public void verify_Select_Location_button_is_displayed() throws Throwable {
	    Assert.assertTrue(driver.findElement(By.id("com.happyfresh.android:id/component_address_info")).isDisplayed());
	}

	@When("^Tap on Select Location button$")
	public void tap_on_Select_Location_button() throws Throwable {
		Thread.sleep(4000);
		driver.findElement(By.id("com.happyfresh.android:id/component_address_info")).click();
	}

	@Then("^Verify Location text field is diplayed$")
	public void verify_Location_text_field_is_diplayed() throws Throwable {
		Assert.assertTrue(driver.findElement(By.id("com.happyfresh.android:id/search_plate")).isDisplayed());
	}

	@When("^Fill the location text field$")
	public void fill_the_location_text_field() throws Throwable {
		Thread.sleep(4000);
		driver.findElement(By.id("com.happyfresh.android:id/search_plate")).sendKeys("Menara Palma");
	}

	@Then("^Verify location suggestions are displayed$")
	public void verify_location_suggestions_are_displayed() throws Throwable {
//		Thread.sleep(4000);
//		Assert.assertTrue(driver.findElement(By.id("com.happyfresh.android:id/component_suggestion_address")).isDisplayed());
//		System.out.println(driver.findElement(By.id("com.happyfresh.android:id/component_suggestion_address")).getSize());
	}

	@When("^Select one of location suggestions$")
	public void select_one_of_location_suggestions() throws Throwable {
	}

	@Then("^Verify Confirmation overlay is diplayed$")
	public void verify_Confirmation_overlay_is_diplayed() throws Throwable {
	}

	@When("^Select Yes button$")
	public void select_Yes_button() throws Throwable {
	}

	@Then("^Verify the location is selected$")
	public void verify_the_location_is_selected() throws Throwable {
	}

	@Then("^Verify Nearby Supermarket List is displayed$")
	public void verify_Nearby_Supermarket_List_is_displayed() throws Throwable {
	}

}
