package com.testingApps.hybrid;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testingApps.functions.GenericKeywords;

public class test1 {
	
	
	@Test
	public void sample() throws IOException{
		GenericKeywords app=new GenericKeywords();
		app.openBrowser("browsername");		
		app.loadURL("url");
		app.click("gmail_link_xpath");
		app.enterValueInTextBox("email_textbox_xpath","karthick.inform@gmail.com");
		app.click("next_button_xpath");
		
	}
}
