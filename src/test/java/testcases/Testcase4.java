package testcases;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import base.BaseClass;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;


import java.net.MalformedURLException;



public class Testcase4 extends BaseClass{

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		// TODO Auto-generated method stub

		AndroidDriver<AndroidElement> driver=capabilities("emulator");

	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	     driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("busyQA");

	     driver.hideKeyboard();

	     driver.findElement(By.xpath("//*[@text='Female']")).click();

	     driver.findElement(By.id("android:id/text1")).click();

	     driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Angola\"));");

	     driver.findElement(By.xpath("//*[@text='Angola']")).click();

	     driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

	     
	     driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();


	    driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

	Thread.sleep(4000);

	//Mobile Gestures

	WebElement checkbox=driver.findElement(By.className("android.widget.CheckBox"));

	TouchAction t=new TouchAction(driver);

	t.tap(tapOptions().withElement(element(checkbox))).perform();



	driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();

	Thread.sleep(9000); //for page to load properly 

	Set<String> contexts=driver.getContextHandles();

	for(String contextName :contexts)

	{

	System.out.println(contextName);

	}

	driver.context("WEBVIEW_com.androidsample.generalstore");

	driver.findElement(By.name("q")).sendKeys("facebook");

	driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

	driver.pressKey(new KeyEvent(AndroidKey.BACK));

	driver.context("NATIVE_APP");
	
	
	
	}

}
