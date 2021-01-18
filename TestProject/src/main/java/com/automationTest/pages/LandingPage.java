package com.automationTest.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.framework.exceptions.DriverNotInitializedException;
import com.framework.page.BasePage;
import com.framework.page.TestPage;
import com.framework.page.TestPageFactory;

public class LandingPage extends BasePage implements TestPage {

	
	@FindBy(xpath="//*[@class='navGroup productNav withArrows']/li[1]") 
	private WebElement Flights;
	
	@FindBy(xpath="//*[@class='navGroup productNav withArrows']/li[2]") 
	private WebElement Hotels;
	
	@FindBy(xpath="//*[@class='navGroup productNav withArrows']/li[3]") 
	private WebElement Activities;
	
	@FindBy(xpath="//*[@class='navGroup productNav withArrows']/li[4]") 
	private WebElement Trains;
	
	@FindBy(xpath="//*[@class='navGroup productNav withArrows']/li[5]") 
	private WebElement FlightDeals;
	
	@FindBy(id="OneWay") 
	private WebElement OneWay;
	
	@FindBy(id="RoundTrip") 
	private WebElement RoundTrip;
	
	@FindBy(id="MultiCity") 
	private WebElement MultiCity;
	
	@FindBy(id="FromTag") 
	private WebElement From;
	
	@FindBy(id="ToTag") 
	private WebElement To;
	
	
	@FindBy(id="DepartDate") 
	private WebElement DepartDate;
	
	@FindBy(id="ReturnDate") 
	private WebElement ReturnDate;
	
	@FindBy(id="SearchBtn") 
	private WebElement SearchBtn;
	
	@FindBy(xpath="//*[@id='ui-id-2']/li[1]") 
	private WebElement FirstOptioninToList;
	
	@FindBy(xpath="//*[@id='ui-id-1']/li[1]") 
	private WebElement FirstOptioninFromList;	
	
	

	public LandingPage(WebDriver driver) throws DriverNotInitializedException {
		super(driver);
	}

	
	
	public LandingPage clickFlight() {
		wait.until(ExpectedConditions.visibilityOf(Flights));
		Flights.click();
		return this;
	}
	
	public LandingPage selectOneWay() {
		wait.until(ExpectedConditions.visibilityOf(OneWay));
		OneWay.click();
		return this;
		
	}
	
	
	public LandingPage EnterFrom(String from) {
		wait.until(ExpectedConditions.visibilityOf(From));
		From.click();
		From.sendKeys(from);
		wait.until(ExpectedConditions.visibilityOf(FirstOptioninFromList));
		FirstOptioninFromList.click();
		return this;
	}
	
	public LandingPage EnterTo(String ToLoc) {
		wait.until(ExpectedConditions.visibilityOf(To));
		To.click();
		To.sendKeys(ToLoc);
		wait.until(ExpectedConditions.visibilityOf(FirstOptioninToList));
		FirstOptioninToList.click();
		return this;
	}
	
	public LandingPage EnterDepartureDate(String Date) {
		wait.until(ExpectedConditions.visibilityOf(DepartDate));
		DepartDate.clear();
		DepartDate.sendKeys(Date);
		DepartDate.sendKeys(Keys.TAB);
		return this;
	}
	
	public LandingPage selectRoundTrip() {
		wait.until(ExpectedConditions.visibilityOf(RoundTrip));
		RoundTrip.click();
		return this;
		
	}
	
	public LandingPage EnterReturnDate(String returnDate) {
		wait.until(ExpectedConditions.visibilityOf(ReturnDate));
		ReturnDate.sendKeys(returnDate);
		ReturnDate.sendKeys(Keys.TAB);
		return this;
	}
	

 
	public FlightResultPage clickSearchFlight() throws DriverNotInitializedException {
		wait.until(ExpectedConditions.visibilityOf(SearchBtn));
		SearchBtn.click();
		return TestPageFactory.getPage(FlightResultPage.class);
	}
}
