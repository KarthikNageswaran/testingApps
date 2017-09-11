package com.testingApps.functions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GenericKeywords {
	public WebDriver driver;
	Properties prop;
	FileInputStream in;
	
	// load properties file 
	public GenericKeywords() throws IOException {
		prop=new Properties();
		in=new FileInputStream("E:\\testingApps\\src\\resources\\objects.properties");
		prop.load(in);
	}
		
	public void openBrowser(String browserName){
		if(prop.getProperty(browserName).equals("firefox")){
			driver=new FirefoxDriver();
			System.out.println("firefox browser opened successfully");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void loadURL(String url){
		driver.get(prop.getProperty(url));
		if(driver.getTitle().equals("Google")){
			System.out.println("url loaded successfully");
		}
	}
	
	public void click(String locator){
//			driver.findElement(By.xpath(prop.getProperty(locator))).click();
		getElement(locator).click();
		
	}
	public void enterValueInTextBox(String locator,String data){
//		driver.findElement(By.xpath(prop.getProperty(locator))).sendKeys(data);
		getElement(locator).sendKeys(data);
	}
	
	
	public WebElement getElement(String locator){
		
		WebElement e=null;
		if(locator.endsWith("_xpath")){
			e=driver.findElement(By.xpath(prop.getProperty(locator)));
		}else if(locator.endsWith("_id")){
			e=driver.findElement(By.id(prop.getProperty(locator)));
		}else if(locator.endsWith("_name")){
			e=driver.findElement(By.name(prop.getProperty(locator)));
		}else{
			System.out.println("locator not defined correctly");
		}
		
	return e;
		
	}
	
	
	
}
