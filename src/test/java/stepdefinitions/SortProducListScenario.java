package stepdefinitions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import common.CommonUtils;
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

	@When("^Tap on Select Location button and allow permission$")
	public void tap_on_Select_Location_button() throws Throwable {
		Thread.sleep(4000);
		driver.findElement(By.id("com.happyfresh.android:id/component_address_info")).click();
		driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
	}

	@Then("^Verify Location text field is diplayed$")
	public void verify_Location_text_field_is_diplayed() throws Throwable {
		System.out.println("Verify Location text field is diplayed...");
		MobileElement element = new CommonUtils().getElementById(driver, "com.happyfresh.android:id/search_src_text");
		if (element != null) {
			Assert.assertTrue(element.isDisplayed());
		}
	}

	@When("^Fill the location text field$")
	public void fill_the_location_text_field() throws Throwable {
		System.out.println("Try to find search location text field...");
		MobileElement element = new CommonUtils().getElementById(driver, "com.happyfresh.android:id/search_src_text");
		if (element != null) {
			element.click();
			boolean isLocationFilled = new CommonUtils().isFilledTextfield(element, "Menara Palma");
			if (!isLocationFilled) {
				System.err.println("Please fill the search location textfield with 'Menara Palma' manually within 10 seconds");
				Thread.sleep(4000);
			}
		} else {
			System.err.println("Please fill the search location textfield with 'Menara Palma' manually within 10 seconds");
			Thread.sleep(4000);
		}
	}

	@Then("^Verify location suggestions are displayed$")
	public void verify_location_suggestions_are_displayed() throws Throwable {
		System.out.println("Verify location suggestions are displayed...");
		MobileElement element = new CommonUtils().getElementById(driver, "com.happyfresh.android:id/component_suggestion_address");
		if (element != null) {
			Assert.assertTrue(element.isDisplayed());
			
			List<MobileElement> list = driver.findElements(By.id("com.happyfresh.android:id/ui_view_suggestion_address_container"));
			list.get(0).click();
		} else {
			System.err.println("Please select one of location");
			Thread.sleep(1000);
		}
	}

	@Then("^Verify Confirmation overlay is diplayed$")
	public void verify_Confirmation_overlay_is_diplayed() throws Throwable {
		System.out.println("Verify confirmation overlay ....");
		MobileElement element = new CommonUtils().getElementById(driver, "com.happyfresh.android:id/component_popup_dialog");
		if (element != null) {
			Assert.assertTrue(element.isDisplayed());
		}
	}

	@When("^Select Yes button$")
	public void select_Yes_button() throws Throwable {
		MobileElement element = new CommonUtils().getElementById(driver, "com.happyfresh.android:id/ui_view_popup_dialog_primary_action_button");
		if (element != null) {
			element.click();
		}
	}

	@Then("^Verify the location is selected$")
	public void verify_the_location_is_selected() throws Throwable {
		MobileElement element = new CommonUtils().getElementById(driver, "com.happyfresh.android:id/ui_view_address_info_text_view_address");
		if (element != null) {
			Assert.assertTrue(!element.getText().equals("Indonesia"));
		}
	}

	@Then("^Verify Nearby Supermarket List is displayed$")
	public void verify_Nearby_Supermarket_List_is_displayed() throws Throwable {
		Thread.sleep(1000);
		System.out.println("Verify supermarket list is displayed...");
		Assert.assertTrue(driver.findElement(By.id("com.happyfresh.android:id/ui_view_supplier_list_recylerview")).isDisplayed());
	}
	
	@When("^Select one of Supermarket List$")
	public void select_one_of_Supermarket_List() throws Throwable {
		List<MobileElement> supermarketView = driver.findElements(By.id("com.happyfresh.android:id/container"));
		if (supermarketView.size() > 0) {
			supermarketView.get(0).click();
		}	    
	}
	
	@Then("^Dismiss poster$")
	public void dismiss_poster() throws Throwable {
		MobileElement element = new CommonUtils().getElementById(driver, "com.happyfresh.android:id/com_appboy_inappmessage_full_button_one");
		if (element != null) {
			element.click();
		}
	}
	
	@Then("^Verify Category list$")
	public void verify_Category_list() throws Throwable {
		MobileElement element = new CommonUtils().getElementById(driver, "com.happyfresh.android:id/component_category_list");
		if (element != null) {
			System.out.println("Category list is displayed...");
			Assert.assertTrue(element.isDisplayed());
		}
	}

	@When("^Select one of Category List$")
	public void select_one_of_Category_List() throws Throwable {
		Thread.sleep(10000);
		List<MobileElement> card = driver.findElements(By.id("com.happyfresh.android:id/container"));
		if (card.size() > 0) {
			card.get(0).click();
		}
	}

	@Then("^Verify Product List is displayed$")
	public void verify_Product_List_is_displayed() throws Throwable {
		Thread.sleep(1000);
		Assert.assertTrue(driver.findElement(By.id("com.happyfresh.android:id/ui_view_product_list_page_sortby_container")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id("com.happyfresh.android:id/ui_view_product_list_page_filter_by_brand_container")).isDisplayed());
		
		Thread.sleep(10000);
		Assert.assertTrue(driver.findElement(By.id("com.happyfresh.android:id/component_product_list")).isDisplayed());
	}

	@When("^Select Sort button$")
	public void select_Sort_button() throws Throwable {
		driver.findElement(By.id("com.happyfresh.android:id/ui_view_product_list_page_sortby_container")).click();
	}

	@Then("^Verify Sort options is displayed$")
	public void verify_Sort_category_list_is_displayed() throws Throwable {
		Assert.assertTrue(driver.findElement(By.id("com.happyfresh.android:id/sort_by_options")).isDisplayed());
	}

	@When("^Select one of sort option eg. the lowest price$")
	public void select_one_of_sort_category() throws Throwable {
		MobileElement element = new CommonUtils().getElementById(driver, "com.happyfresh.android:id/sort_by_lowest_price");
		if (element != null) {
			element.click();
		}
	}

	@Then("^Verify product list is sorted by selected sort option$")
	public void verify_product_list_is_sorted() throws Throwable {
		Thread.sleep(10000);
		Assert.assertTrue(driver.findElement(By.id("com.happyfresh.android:id/component_product_list")).isDisplayed());
	}

}
