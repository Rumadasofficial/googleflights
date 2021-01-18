package com.automationTest.operations;

import com.automationTest.pages.LandingPage;

import java.util.ArrayList;
import java.util.List;

import com.automationTest.pages.GoogleFlightsResultPage;
import com.automationTest.pages.GoogleLandingPage;
import com.framework.operation.IOperations;
import com.framework.page.TestPageFactory;

public class GoogleSearchFlight implements IOperations{
	
	GoogleFlightsResultPage googleFlightsResultPage;
	
	public void SearchRoundTripFlightOptions (String fromLoc, String ToLoc,String deptdate,String returndate) throws Exception {
		
		 Thread.sleep(2000);
		 googleFlightsResultPage= TestPageFactory.getPage(GoogleLandingPage.class)
													.clickFlight()
													.selectFrom(fromLoc)
													.selectTo(ToLoc)
													.clickonDeparturedate(deptdate);
													
													
			}
		
		public boolean isSearchResultDisplayed() throws InterruptedException {
			
			return googleFlightsResultPage.isResultDisplayed();
			
		}
		
	public void SearchOneWayFlightOptions (String fromLoc, String ToLoc,String deptdate) throws Exception {
			
			 Thread.sleep(2000);
			 googleFlightsResultPage= TestPageFactory.getPage(GoogleLandingPage.class)
														.clickFlight()
														.selectOneWay()
														.selectFrom(fromLoc)
														.selectTo(ToLoc)
														.clickonDeparturedateForOneWay(deptdate);
														
														
														
				}
	
	
	public boolean isMenuResultDisplayed(List<String> Expected_Menu)throws InterruptedException {
		
		return googleFlightsResultPage.isMenuDisplayed(Expected_Menu);
		
	}
	
	public void SearchAllOptions (List<String> Expected_Menu) throws Exception {
		
		 Thread.sleep(2000);
		 googleFlightsResultPage= TestPageFactory.getPage(GoogleLandingPage.class)
				                                .SearchMenu(Expected_Menu);
				 
				 
	}
	

	
	public void SelectFlightOption (String option) throws Exception {
		
		 Thread.sleep(2000);
		 googleFlightsResultPage= TestPageFactory.getPage(GoogleLandingPage.class)
				                                .SelectflightOption(option);
				 
				 
	}
	
	public void SelectYourTicketTypeOptions (String option1,String option2,String option3) throws Exception {
		
		 Thread.sleep(2000);
		 TestPageFactory.getPage(GoogleLandingPage.class)
				                                .TripTypeOptions(option1, option2, option3);
				 
				 
	}

}
