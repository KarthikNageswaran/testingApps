package com.testingApps.hybrid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test {
	WebDriver driver;
	@BeforeTest
	public void open_browser(){
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void sample(){
		driver.get("http://google.com");
		System.out.println("Test");
	}
}
