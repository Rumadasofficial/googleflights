package com.automationTest.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.framework.exceptions.DriverNotInitializedException;
import com.framework.page.BasePage;
import com.framework.page.TestPage;

public class GoogleFlightsResultPage extends BasePage implements TestPage {
	
	
	@FindBy(xpath="//div//div[@aria-label='Filters']")
	private WebElement dateHeader;
	
	@FindBy(xpath="//div//div/nav[contains(@jsname,'WA9qLc')]")
	private WebElement menuHeader;
	
	@FindBy(xpath="//div//button/div/span[contains(@aria-label,'Selected Tab: Flights')]")
	private WebElement FlightOptionHighlighted;

	public GoogleFlightsResultPage(WebDriver driver) throws DriverNotInitializedException {
		super(driver);
		
	}
	
	
public boolean isResultDisplayed() throws InterruptedException {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(dateHeader));
		return dateHeader.isDisplayed();
		
	}

public boolean isMenuDisplayed(List expectedMenu) throws InterruptedException {
	
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(menuHeader));
	List<WebElement> menu=driver.findElements(By.xpath("//nav/div//button/div/span"));
	List<String> actualMenu=new ArrayList();
	for(WebElement M:menu) {
		actualMenu.add(M.getText());
	}
	System.out.println(actualMenu);
	if (actualMenu.containsAll(expectedMenu)) {
     
		return true;
	
     }else {
    	 return false;
     }
	//return menuHeader.isDisplayed();

}
}



/*public boolean isFlightOptionHighlighted() throws InterruptedException {
	
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(FlightOptionHighlighted));
	return FlightOptionHighlighted.isSelected();
}*/



