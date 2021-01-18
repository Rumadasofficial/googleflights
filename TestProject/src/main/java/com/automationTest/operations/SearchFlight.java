package com.automationTest.operations;

import com.automationTest.pages.FlightResultPage;
import com.automationTest.pages.LandingPage;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.operation.IOperations;
import com.framework.operation.TestOperationFactory;
import com.framework.page.TestPage;
import com.framework.page.TestPageFactory;

public class SearchFlight implements IOperations{
	FlightResultPage flightResultPage;

	public void SearchFlightOptions (String fromLoc, String ToLoc, String date) throws Exception {
		
	 Thread.sleep(1000);
	 flightResultPage= TestPageFactory.getPage(LandingPage.class)
												.clickFlight()
												.selectOneWay()
												.EnterFrom(fromLoc)
												.EnterTo(ToLoc)
												.EnterDepartureDate(date)
												.clickSearchFlight();

	}
	
	public boolean isSearchResultDisplayed() {
		
		return flightResultPage.isResultDisplayed();
		
	}
	
	public void SearchRoundTripFlightOptions(String fromLoc, String ToLoc, String departuredate,String returnDate) throws Exception{
	    
		Thread.sleep(2000);
		flightResultPage= TestPageFactory.getPage(LandingPage.class)
				                                    .clickFlight()
													.selectRoundTrip()
													.EnterFrom(fromLoc)
													.EnterTo(ToLoc)
													.EnterDepartureDate(departuredate)
													.EnterReturnDate(returnDate)
													.clickSearchFlight();
	}
}
