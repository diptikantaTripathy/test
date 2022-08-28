package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class NoPOMTest99GuruLogin {

	/**
	 * This test case will login in http://demo.guru99.com/V4/
	 * Verify login page title as guru99 bank
	 * Login to application
	 * Verify the home page using Dashboard message
	 */
	@Test(priority=0)
	public void test_Home_Page_Appear_Correct(){
		String driverPath = "C:\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/V4/");
		//Find user name and fill user name
	    driver.findElement(By.name("uid")).sendKeys("mgr123");
	    //find password and fill it
	    driver.findElement(By.name("password")).sendKeys("mgr!23");
	    //click login button
	    driver.findElement(By.name("btnLogin")).click(); 
	    String homeText = driver.findElement(By.xpath("//table//tr[@class='heading3']")).getText();
	    //verify login success
		Assert.assertTrue(homeText.toLowerCase().contains("guru99 bank"));
	}
	
}
