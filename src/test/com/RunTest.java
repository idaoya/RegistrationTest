package com;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/feature/Employee.feature")

public class RunTest {
	public static void main(String[] args) {
		System.out.println("Test Registration Form");
	}
}