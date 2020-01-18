package utility;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Hook {
	private static String DEVICE_ID = "S8W8QCTCAA9SSCMV";
	private static AndroidDriver<MobileElement> driver;
	
	@Before("@appium")
	public void setUpAppium() throws MalformedURLException{
		
		// APK file's location
		File appDir = new File(System.getProperty("user.dir")+"/app/");
		File app = new File(appDir, "HappyFresh.apk");
		
		// Configuration to invoke Appium
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "OPPO F11");
		cap.setCapability(MobileCapabilityType.UDID, DEVICE_ID);
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown(){
		driver.removeApp("com.example.AppName");
	}
	
	public static AndroidDriver<MobileElement> getDriver(){
		return driver;
	}
}
