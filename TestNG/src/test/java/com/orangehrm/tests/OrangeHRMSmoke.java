package com.orangehrm.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OrangeHRMSmoke {

	private WebDriver driver;

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("--- Before Suite ---");
		driver = new ChromeDriver();
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("--- Before Test ---");
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("--- Before Class ---");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("--- Before Method ---");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("--- After Method ---");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("--- After Class ---");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("--- After Test ---");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("--- After Suite ---");
		driver.quit();
	}

	@DataProvider
	public Object[][] datadriven() {
		return new Object[][] { new Object[] { 1, "John Smith" }, new Object[] { 2, "Joe Root" }, };
	}
	
	@Test(dataProvider = "datadriven")
	public void TC001(Integer empNo, String empName) {
		driver.findElement(By.xpath("//span[.='Assign Leave']")).click();
		driver.findElement(By.id("assignleave_txtEmployee_empName")).sendKeys(empName + Keys.TAB);
		Select select = new Select(driver.findElement(By.id("assignleave_txtLeaveType")));
		select.selectByIndex(0);
		driver.findElement(By.id("assignleave_txtFromDate")).clear();
		driver.findElement(By.id("assignleave_txtFromDate")).sendKeys("2021-09-01");
		driver.findElement(By.id("assignBtn")).click();
		driver.findElement(By.xpath("//a[@id='menu_dashboard_index']")).click();
	}

}
