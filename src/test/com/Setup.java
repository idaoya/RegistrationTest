package com;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.Util;

public class Setup {

	WebDriver driver;
	WebElement element;
	Select select;
	ConnectBean con = new ConnectBean();
	Properties prop = new Properties();
	Util util = new Util();

	@Given("^User open browser$")
	public void User_open_browser() {
		con.getSystem();
		driver = con.getDriver();
	}

	@When("^User click link add new employee$")
	public void user_click_link_add_new_employee() throws Throwable {
		element = driver.findElement(By.xpath("/html/body/h1[2]/a"));
		element.click();
		Thread.sleep(2000);
	}

	@Then("^User input new employee$")
	public void user_input_new_employee() throws Throwable {
		element = driver.findElement(By.xpath("//*[@id=\"name\"]"));
		element.sendKeys(util.genString());

		Thread.sleep(1000);
		element = driver.findElement(By.xpath("//*[@id=\"joiningDate\"]"));
		element.clear();
		element.sendKeys(util.genDate());

		element = driver.findElement(By.xpath("//*[@id=\"salary\"]"));
		element.sendKeys(String.valueOf(util.genNumber()));

		element = driver.findElement(By.xpath("//*[@id=\"employeeCode\"]"));
		element.sendKeys(util.genCode());

		Thread.sleep(5000);
	}

	@Then("^User click button register$")
	public void user_click_button_register() throws Throwable {
		element = driver.findElement(By.xpath("//*[@id=\"employee\"]/table/tbody/tr[5]/td/button"));
		element.click();
		Thread.sleep(10000);
	}

	@After
	public void tearDown() {
		try {
			Thread.sleep(1);
			driver.quit();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}