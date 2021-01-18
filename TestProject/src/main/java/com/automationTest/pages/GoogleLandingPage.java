package com.automationTest.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.framework.exceptions.DriverNotInitializedException;
import com.framework.page.BasePage;
import com.framework.page.TestPage;
import com.framework.page.TestPageFactory;

public class GoogleLandingPage extends BasePage implements TestPage {
	
	@FindBy(xpath="//*[@id=\"ow3\"]/div[3]/div/div[2]/nav/div[5]/a/button/div[1]")
	private WebElement Hotels;
	
	@FindBy(xpath="//div//button//div/span[text()='Flights']")
	private WebElement Flight;
	
	@FindBy(xpath="//*[@id=\"ow3\"]/div[3]/div/div[2]/nav/div[1]/a/button/div[1]")
	private WebElement Trips;
	
	@FindBy(xpath="//*[@id=\"ow3\"]/div[3]/div/div[2]/nav/div[3]/a/button/div[1]")
	private WebElement ThingsToDo;
	
	@FindBy(xpath="//*[@id=\"ow3\"]/div[3]/div/div[2]/nav/div[6]/a/button/div[1]")
	private WebElement VacationRentals;
	
	@FindBy(xpath="//div//div/span[text()='Explore']")
	private WebElement Explore;
	
	@FindBy(xpath="//div//button[@aria-label='Round trip']")
	private WebElement RoundTrip;
	
    @FindBy(xpath="//div[@jsaction='click:bsFV9d']/ul")
	private WebElement SelectYourTripDD;
	
	@FindBy(xpath="//*[@id=\"NojMnf725\"]")
	private WebElement OneWay;
	
    @FindBy(xpath="//*[@id=\"NojMnf726\"]")
    private WebElement Multicity;
    
    @FindBy(xpath="//body/c-wiz[2]/div[1]/div[2]/div[1]/c-wiz[1]/div[1]/c-wiz[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
    private WebElement FromCity;
    
    
    @FindBy(xpath="/html[1]/body[1]/c-wiz[2]/div[1]/div[2]/div[1]/c-wiz[1]/div[1]/c-wiz[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
    private WebElement ToCity;
    
    
    @FindBy(xpath="//*[@id=\"ow1167\"]/div[1]/div/button/div[2]")
    private WebElement ClickDropDown;
    
    @FindBy(xpath="//input[@aria-label='Departure date'][1]")
    private WebElement DepartDate;
    
    @FindBy(xpath="//div//div[text()='19'][1]")
    private WebElement SelectDepartDateFromCalender;
    
     
    @FindBy(xpath="//input[@aria-label='Return date'][1]")
    private WebElement ReturnDate;
    
    @FindBy(xpath="//div//div[@jsname='RAZSvb']")
    private WebElement Calender;
    
    @FindBy(xpath="//div//div[text()='23'][1]")
    private WebElement SelectReturnDateFromCalender;
    
    @FindBy(xpath="//div/button[@aria-label='One way']")
    private WebElement UpadtedSecondOptionFromTripTypeList;
    
    @FindBy(xpath="//div/button[@aria-label='Multi-city']")
    private WebElement UpadtedLastOptionFromTripTypeList;
    
    @FindBy(xpath="//div/button//span[text()='Search']")
    private WebElement Search;
    
    @FindBy(xpath="//li[@role='option'][contains(@aria-label,'Kolkata')]")
    private WebElement SelectFirstCityFromList;
    
    @FindBy(xpath="//li[@role='option'][contains(@aria-label,'Pune')]")
    private WebElement SelectFirstCityToList;
   
    @FindBy(xpath="//input[@type='text'][@aria-label='Where from?'][@aria-expanded='true']")
    private WebElement ExpendedFromCityTextBox;
    
    @FindBy(xpath="//input[@type='text'][@aria-label='Where to?'][@aria-expanded='true']")
    private WebElement ExpendedToCityTextBox;

    @FindBy(xpath="//div//button/div/span[contains(@aria-label,'Selected Tab: Flights')]")
    private WebElement FlightOptionSelected;
    
    @FindBy(xpath="//div//div/nav[contains(@jsname,'WA9qLc')]")
    private WebElement Values;
    
    
	public GoogleLandingPage(WebDriver driver) throws DriverNotInitializedException {
		super(driver);
		
	}
	
	public GoogleLandingPage clickFlight() {
		//wait.until(ExpectedConditions.visibilityOf(Flight));
		Flight.click();
		return this;
	}
	
	public GoogleLandingPage selectOneWay() {
		
		RoundTrip.click();
		List<WebElement> myElements=driver.findElements(By.xpath("//div[@jsaction='click:bsFV9d']/ul/li"));
		for(WebElement e:myElements) {
		if(e.getText().equals("One way")) {
		 e.click();
		
		}
			
		}
		
		//wait.until(ExpectedConditions.visibilityOf(SelectYourTripDD));
		
		return this;
		
	}
	
	
	public GoogleLandingPage selectMultiCity() {
		//wait.until(ExpectedConditions.visibilityOf(RoundTrip));
		RoundTrip.click();
		List<WebElement> myElements=driver.findElements(By.xpath("//div[@jsaction='click:bsFV9d']/ul/li"));
		for(WebElement l:myElements) {
		if(l.getText().equalsIgnoreCase("Multi-city")) {
		 l.click();
		
		}
			
		}
		
		return this;
	}
	
	
	public GoogleLandingPage selectFrom(String from) {
		//wait.until(ExpectedConditions.visibilityOf(FromCity));
		
		FromCity.click();
		wait.until(ExpectedConditions.visibilityOf(ExpendedFromCityTextBox));
		ExpendedFromCityTextBox.sendKeys(from);
		wait.until(ExpectedConditions.visibilityOf(SelectFirstCityFromList));
		SelectFirstCityFromList.click();
		return this;
		
	}
	
	public GoogleLandingPage selectTo(String to) {
		//wait.until(ExpectedConditions.visibilityOf(ToCity));
		ToCity.click();
		wait.until(ExpectedConditions.visibilityOf(ExpendedToCityTextBox));
		ExpendedToCityTextBox.sendKeys(to);
		wait.until(ExpectedConditions.visibilityOf(SelectFirstCityToList));
		SelectFirstCityToList.click();
		return this;
		
	}
	
	
	public GoogleFlightsResultPage clickonDeparturedate(String deptDate) throws DriverNotInitializedException, InterruptedException {
		//wait.until(ExpectedConditions.visibilityOf(DepartDate));
		DepartDate.click();
		wait.until(ExpectedConditions.visibilityOf(Calender));
		SelectDepartDateFromCalender.click();
		SelectDepartDateFromCalender.click();
		FromCity.click();
		//wait.until(ExpectedConditions.visibilityOf(ResetBtn));
		//DepartDate.sendKeys(deptDate);
        //Calender.sendKeys(Keys.TAB);
		//wait.until(ExpectedConditions.elementToBeClickable(clickDoneBtn));
		Thread.sleep(2000);
		
		return TestPageFactory.getPage(GoogleFlightsResultPage.class);
		
	}
	
	public GoogleFlightsResultPage clickonDeparturedateForOneWay(String deptDate) throws DriverNotInitializedException {
		//wait.until(ExpectedConditions.visibilityOf(ReturnDate));
		DepartDate.click();
		wait.until(ExpectedConditions.visibilityOf(Calender));
		SelectDepartDateFromCalender.click();
		FromCity.click();
		//ReturnDate.sendKeys(returnDate);
		//wait.until(ExpectedConditions.visibilityOf());
		//clickDoneBtn.click();
		return TestPageFactory.getPage(GoogleFlightsResultPage.class);
	
	}
	
	
	public GoogleFlightsResultPage clickonSearch()throws Exception {
		wait.until(ExpectedConditions.visibilityOf(Search));
		Search.click();
		return TestPageFactory.getPage(GoogleFlightsResultPage.class);
		
	}
	
	public  GoogleFlightsResultPage SearchMenu(List<String> Expected_Menu) throws Exception{
		List<WebElement> menu=driver.findElements(By.xpath("//div//div/nav[contains(@jsname,'WA9qLc')]"));
		
			
	 return TestPageFactory.getPage(GoogleFlightsResultPage.class);
	}
	
	public GoogleFlightsResultPage SelectflightOption(String option) throws DriverNotInitializedException {
		FlightOptionSelected.isSelected();
		FlightOptionSelected.getText().equalsIgnoreCase(option);
		return TestPageFactory.getPage(GoogleFlightsResultPage.class);
	}
	
	public GoogleLandingPage TripTypeOptions(String option1,String option2,String option3) throws InterruptedException {
		RoundTrip.click();
		Thread.sleep(2000);
		List<String> mylist=new ArrayList();
		mylist.add(option1);
		mylist.add(option2);
		mylist.add(option3);
		List<WebElement> options=driver.findElements(By.xpath("//div[@jsaction='click:bsFV9d']/ul"));
	for(WebElement o:options) {
		mylist.contains(o);
			}
	   return this;
	}
		
	
	}


