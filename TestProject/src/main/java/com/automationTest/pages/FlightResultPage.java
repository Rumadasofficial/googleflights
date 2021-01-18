package com.automationTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.framework.exceptions.DriverNotInitializedException;
import com.framework.page.BasePage;
import com.framework.page.TestPage;
import com.framework.page.TestPageFactory;

public class FlightResultPage extends BasePage implements TestPage {

	@FindBy(id = "modifySearchLink")
	private WebElement modifySearch;

	@FindBy(xpath = "//div[@class='sticky__parent']")
	private WebElement dateHeader;

	public FlightResultPage(WebDriver driver) throws DriverNotInitializedException {
		super(driver);
	}

	public FlightResultPage clickOnMOdifySearch() {
		wait.until(ExpectedConditions.visibilityOf(modifySearch));
		modifySearch.click();
		return this;
	}
	
	public boolean isResultDisplayed() {
		
		wait.until(ExpectedConditions.visibilityOf(dateHeader));
		return dateHeader.isDisplayed();
		
	}

}
