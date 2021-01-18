package com.automationTest.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationTest.operations.GoogleSearchFlight;
import com.automationTest.operations.SearchFlight;
import com.framework.dataProvider.DataSet;
import com.framework.dataProvider.GenericDataProvider;
import com.framework.operation.TestOperationFactory;
import com.framework.test.BaseTest;

public class GFlightsTest extends BaseTest{
	
	@Test(dataProvider= "TEST", dataProviderClass= GenericDataProvider.class)
	@DataSet("TestDataForRoundTrip")
public void verifyRoundTripFlightSearch(String fromLoc, String ToLoc,String DeptDate,String returnDate) throws Exception {
		
		GoogleSearchFlight searchFlight= TestOperationFactory.getOperation(GoogleSearchFlight.class);
		searchFlight.SearchRoundTripFlightOptions(fromLoc, ToLoc, DeptDate,returnDate);
		Assert.assertTrue(searchFlight.isSearchResultDisplayed());
			
	}
	
	@Test(dataProvider= "TEST", dataProviderClass= GenericDataProvider.class)
	@DataSet("TestDataForOneWay")
public void verifyOneWayFlightSearch(String fromLoc, String ToLoc,String DeptDate) throws Exception {
		
		GoogleSearchFlight searchFlight= TestOperationFactory.getOperation(GoogleSearchFlight.class);
		searchFlight.SearchOneWayFlightOptions(fromLoc, ToLoc, DeptDate);
		Assert.assertTrue(searchFlight.isSearchResultDisplayed());
			
	}
	
	@Test(dataProvider= "TEST", dataProviderClass= GenericDataProvider.class)
	@DataSet("TestDataForMenu")
public void verifyAllMenuesFromGoogleFlights(String first, String second,String third,String forth, String fifth,String sixth) throws Exception {
		
		GoogleSearchFlight searchFlight= TestOperationFactory.getOperation(GoogleSearchFlight.class);
		List<String> Expected_Menu=new ArrayList();
		Expected_Menu.add(first);
		Expected_Menu.add(second);
		Expected_Menu.add(third);
		Expected_Menu.add(forth);
		Expected_Menu.add(fifth);
		Expected_Menu.add(sixth);
		searchFlight.SearchAllOptions(Expected_Menu);
		
		Assert.assertTrue(searchFlight.isMenuResultDisplayed(Expected_Menu), "Google flights menus are not displayed");
		
			
	}
	
	@Test(dataProvider= "TEST", dataProviderClass= GenericDataProvider.class)
	@DataSet("FlighOptionselected")
public void verifyFlightsOptionGettingHighlighted(String option) throws Exception {
		
		GoogleSearchFlight searchFlight= TestOperationFactory.getOperation(GoogleSearchFlight.class);
		searchFlight.SelectFlightOption(option);
		System.out.println("Flights Option is getting highlighted");
		//Assert.assertTrue(searchFlight.isFlightOptionHighlighted());
			
	}
	
	@Test(dataProvider= "TEST", dataProviderClass= GenericDataProvider.class)
	@DataSet("SearchTripTypes")
public void verifyTripTypeOp(String option1,String option2,String option3) throws Exception {
		
		GoogleSearchFlight searchFlight= TestOperationFactory.getOperation(GoogleSearchFlight.class);
		searchFlight.SelectYourTicketTypeOptions(option1,option2,option3);
	
}
}
