package common;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CommonUtils {

	public MobileElement getElementById(AndroidDriver<MobileElement> driver, String id) {
		try {
			return driver.findElement(By.id(id));
		}
		catch (Throwable t) {
			System.out.println(" >>> ERROR " + t.getMessage());
			return null;
		}
	}
}
