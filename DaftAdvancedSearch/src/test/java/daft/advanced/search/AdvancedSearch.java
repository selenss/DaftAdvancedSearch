package daft.advanced.search;


import org.testng.annotations.Test;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class AdvancedSearch extends DaftPageObjects {
	
	public WebDriver driver;
	//Will be used for verification test case
	public String selectedMinBedroom;
	public String selectedMaxBedroom;
	public String selectedMinBathroom;
	public String selectedMaxBathroom;
	
	public int selectedMinBedroomNumber;
	public int selectedMaxBedroomNumber;
	public int selectedMinBathroomNumber;
	public int selectedMaxBathroomNumber;
	
  @Test (priority=1,testName="Category",description="Random category selection")
  public void randomCategorySelection() throws InterruptedException {
	  
	  driver.get("http://www.daft.ie/");
      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      
      //number of Categories
      int categories_size = categories.size();
      //random number generation according to number of Categories
      int random_category = new Random().nextInt(categories_size);
      //Random selection for the first 4 elements of Categories  	  
	  if (random_category<=3) {
		  categories.get(random_category).click();
	  } else {
		  //Random selection for non-visible category elements unless clicking the "More" button 
		  categoryMoreSelection.click();
		  categories.get(random_category).click();
	  }
	  
	  //Check for any category is selected
	  Assert.assertEquals(categories.get(random_category).isDisplayed(), true); 
	  Reporter.log("Category selected randomly", true);
  }
	  
  @Test (priority=2,testName="County / City",description="Random county/city selection")
  public void randomCountyCitySelection() throws InterruptedException {

	 //City-county dropdown is opened
	 countyCityDropdown.click(); 
	 Thread.sleep(2000);   
	
	 // According to size of the list random number is generated 
	 //Note: xPath does not contain zero element and first element is not required to be selected to activate Areas dropdown
	 int cityRandomNumber = (int)(Math.random() * (cityCountyDropdownElements.size() - 2)) + 1;
	 
	 // Randomly selected dropdown list item is clicked
	 cityCountyDropdownElements.get(cityRandomNumber).click();
	 Thread.sleep(2000);
	 Reporter.log("City/County selected randomly", true);
  }
  
  @Test (priority=3,testName="Areas",description="Random area selection",dependsOnMethods = { "randomCountyCitySelection" })
  public void randomAreaSelection() throws InterruptedException {
	  
	 //All areas dropdown is opened
     allAreasDropdown.click();
     Thread.sleep(2000);
      
     //if any area exists
     if(!areaElements.isEmpty()){
         // According to size of the list random number is generated
         int areaRandomNumber = (int)(Math.random() * (areaElements.size()));
         // Randomly selected dropdown list item is clicked
         areaElements.get(areaRandomNumber).click();
         Thread.sleep(2000);
         Reporter.log("Area selected randomly", true);
      } else{
    	 Reporter.log("No property is available", true);
      }
      
  }
  
  @Test (priority=4,testName="First Search",description="Search based on category, city/county and area")
  public void mainSearch() throws InterruptedException {
	  
	  searchButton.click();
	  //Thread.sleep(5000);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  Reporter.log("First search button is clicked.", true);	 
	  
  }  
   
  @Test(priority=5,testName="Present Advanced Search",description="Checking advanced search text link presence and clicking it",dependsOnMethods = { "mainSearch" })
  public void advancedSearchPresent() throws InterruptedException {
	 
	  advancedSearchTextLink.click();  
  }
  
  @Test (priority=6,testName="Minimum Price",description="Random minimum price selection",dependsOnMethods = { "advancedSearchPresent" })
  public void minPrice() throws InterruptedException {
	  
	  //Minimum Price dropdown availability check
	  if (!minPriceBoxCheck.isEmpty()){
		  
		  //Minimum Price range dropdown is opened
		  minPriceDropdown.click();
		  Thread.sleep(2000);
			
		  // According to size of the list random number is generated
		  //Note: xPath does not contain zero element and first element is not required to be selected to add a min. price
		  int minPriceRandomNumber = (int)(Math.random() * (minPriceElements.size() - 2)) + 1;
		  // Randomly selected dropdown list item is clicked
		  minPriceElements.get(minPriceRandomNumber).click();
		  Thread.sleep(2000);
		  Reporter.log("Min. price selected randomly", true);
	  }else{
		  Reporter.log("Min. price dropdown is not available", true);
	  }
  }
  
  @Test  (priority=7,testName="Maximum Price",description="Random maximum price selection",dependsOnMethods = { "advancedSearchPresent" })
  public void maxPrice() throws InterruptedException {
	  
	  //Maximum Price dropdown availability check
	  if (!maxPriceBoxCheck.isEmpty()){
		  //Maximum Price range dropdown is opened
		  maxPriceDropdown.click();
		  Thread.sleep(2000);

		  // According to size of the list random number is generated
		  //Note: xPath does not contain zero element and first element is not required to be selected to add a max. price
		  int maxPriceRandomNumber = (int)(Math.random() * (maxPriceElements.size() - 2)) + 1;
		  // Randomly selected dropdown list item is clicked
		  maxPriceElements.get(maxPriceRandomNumber).click();
		  Thread.sleep(2000);
		  Reporter.log("Max. price selected randomly", true);
	  }else {
		  Reporter.log("Max. price dropdown is not available", true);
	  }
  }
  
  @Test  (priority=8,testName="Minimum Bedroom",description="Random minimum bedroom selection",dependsOnMethods = { "advancedSearchPresent" })
  public void minBedroom() throws InterruptedException {
	  
	  //Minimum Bedroom dropdown availability check
	  if (!minBedDropdownCheck.isEmpty()){
		  //Minimum Bed range dropdown is opened
		  minBedDropdown.click();
		  Thread.sleep(2000);
				
		  // According to size of the list random number is generated
		  //Note: xPath does not contain zero element and first element is not required to be selected to add a min. bedroom
		  int minBedRandomNumber = (int)(Math.random() * (minBedElements.size() - 2)) + 1;
			
		  //selectedMinBedroom will be use for verification
		  selectedMinBedroom = minBedElements.get(minBedRandomNumber).getText();
		  String[] selectedMinBedroomNumberStringParts = selectedMinBedroom.split(" bed");
		  selectedMinBedroomNumber = Integer.parseInt(selectedMinBedroomNumberStringParts[0]);
		  
		  
		  
		  // Randomly selected dropdown list item is clicked
		  minBedElements.get(minBedRandomNumber).click();
		  Thread.sleep(2000);
			
		  Reporter.log("Min. bedroom selected randomly", true);
	  } else{
		  Reporter.log("Min. bedroom dropdown is not available", true);
	  }
	
  }
		  
  @Test (priority=9,testName="Maximum Bedroom",description="Random maximum bedroom selection",dependsOnMethods = { "advancedSearchPresent" })
  public void maxBedroom() throws InterruptedException {
	  
	  //Maximum Bedroom dropdown availability check
	  if (!maxBedDropdownCheck.isEmpty()){
		  //Maximum Bed range dropdown is opened
		  maxBedDropdown.click();
		  Thread.sleep(2000);
		  
		  // According to size of the list random number is generated
		  //Note: xPath does not contain zero element and first element is not required to be selected to add a max. bedroom
		  int maxBedRandomNumber = (int)(Math.random() * (maxBedElements.size() - 2)) + 1;
		  
		  // selectedMaxBedroom will be use for verification
		  selectedMaxBedroom = maxBedElements.get(maxBedRandomNumber).getText();
		  String[] selectedMaxBedroomNumberStringParts = selectedMaxBedroom.split(" bed");
		  selectedMaxBedroomNumber = Integer.parseInt(selectedMaxBedroomNumberStringParts[0]);
		  
		  // Randomly selected dropdown list item is clicked
		  maxBedElements.get(maxBedRandomNumber).click();
		  Thread.sleep(2000);
			
		  Reporter.log("Max. bedroom selected randomly", true);
	  }else{
		  Reporter.log("Max. bedroom dropdown is not available", true);
	  }
  }
  
  @Test (priority=10,testName="Minimum Bathroom",description="Random minimum bathroom selection",dependsOnMethods = { "advancedSearchPresent" })
  public void minBathroom() throws InterruptedException {
	  
	  //Minimum Bathroom dropdown availability check
	  if (!minBathDropdownCheck.isEmpty()){
		  //Minimum Bathroom range dropdown is opened
		  minBathDropdown.click();
		  Thread.sleep(2000);
			
		  // According to size of the list random number is generated
		  //Note: xPath does not contain zero element and first element is not required to be selected to add a min. bathroom
		  int minBathRandomNumber = (int)(Math.random() * (minBathElements.size() - 2)) + 1;
		  
		  // selectedMinBathroom will be use for verification
		  selectedMinBathroom = minBathElements.get(minBathRandomNumber).getText();
		  String[] selectedMinBathroomNumberStringParts = selectedMinBathroom.split(" bath");
		  selectedMinBathroomNumber = Integer.parseInt(selectedMinBathroomNumberStringParts[0]);
		  
		  // Randomly selected dropdown list item is clicked
		  minBathElements.get(minBathRandomNumber).click();
		  Thread.sleep(2000); 
		  
		  Reporter.log("Min. bathroom selected randomly", true);
	  }else {
		  Reporter.log("Min. bathroom selection is not available", true);
	  }
	
  }
		  
  @Test(priority=11,testName="Maximum Bathroom",description="Random maximum bathroom selection",dependsOnMethods = { "advancedSearchPresent" })
  public void maxBathroom() throws InterruptedException {
	  
	  //Maximum Bathroom dropdown availability check
	  if (!maxBathDropdownCheck.isEmpty()){
		  //Maximum Bed range dropdown is opened
		  maxBathDropdown.click();
		  Thread.sleep(2000);
			
		  // According to size of the list random number is generated
		  //Note: xPath does not contain zero element and first element is not required to be selected to add a max. bathroom
		  int maxBathRandomNumber = (int)(Math.random() * (maxBathElements.size() - 2)) + 1;
		  
		  // selectedMaxBathroom will be use for verification
		  selectedMaxBathroom = maxBathElements.get(maxBathRandomNumber).getText();
		  String[] selectedMaxBathroomNumberStringParts = selectedMaxBathroom.split(" bath");
		  selectedMaxBathroomNumber = Integer.parseInt(selectedMaxBathroomNumberStringParts[0]);
		  
		  
		  // Randomly selected dropdown list item is clicked
		  maxBathElements.get(maxBathRandomNumber).click();
		  Thread.sleep(2000);
		  
		  Reporter.log("Max. bathroom selected randomly", true);
	  }else{
		  Reporter.log("Max. bathroom dropdown is not available", true);
	  }
	
  }
  
  @Test(priority=12,testName="Property Type",description="Random property type selection",dependsOnMethods = { "advancedSearchPresent" })
  public void propertyType() throws InterruptedException {
	  
	  //Property type dropdown availability check
	  if (!propertyTypeDropdownCheck.isEmpty()){
		  //Property type dropdown is opened
		  propertyTypeDropdown.click();
		  Thread.sleep(2000);
						
		  // According to size of the list random number is generated
		  int propertyTypeRandomNumber = (int)(Math.random() * (propertyTypeElements.size()));
		  
		  // Randomly selected dropdown list item is clicked
		  propertyTypeElements.get(propertyTypeRandomNumber).click();
		  Thread.sleep(2000);
					
		  Reporter.log("Property type selected randomly", true);
	  }else {
		  Reporter.log("Property type dropdown is not available", true);
	  }
  }
  
  @Test(priority=13,testName="Advanced Search Results",description="Verification of the results after advanced search",
		dependsOnMethods = { "advancedSearchPresent" })
  
  public void advanceSearchResults() throws InterruptedException {
	  Thread.sleep(10000);
	  advancedTabSearchButton.click();
	  Thread.sleep(2000);
		
	  //Results check if any found or not
		if (!results.isEmpty()){
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// According to size of the results list random number is generated
			int resultsRandomNumber = (int)(Math.random() * (results.size()));
			  
			//Retrieving number of bedroom in results	 
			String bedroomNumberString = bedResultsList.get(resultsRandomNumber).getText();
			String[] bedroomNumberStringParts = bedroomNumberString.split(" Beds|");
			int bedroomNumber = Integer.parseInt(bedroomNumberStringParts[0]);
			
			//Retrieving number of bathroom in results
			String bathroomNumberString = bathResultsList.get(resultsRandomNumber).getText();
			String[] bathroomNumberStringParts = bathroomNumberString.split(" Bath");
			int bathroomNumber = Integer.parseInt(bathroomNumberStringParts[0]);
			
			System.out.println(bedroomNumber);
			System.out.println(selectedMinBedroomNumber);
			System.out.println(selectedMaxBedroomNumber);
			
			System.out.println(bathroomNumber);
			System.out.println(selectedMinBathroomNumber);
			System.out.println(selectedMaxBathroomNumber);
			
			//For selections from min.-max. bedroom and bathroom, conditions for min>max and max<min should be added. 
			//Otherwise, in these cases selected values are valid and re-selected values are not used. Therefore assertions can lead to failures.
			//Verification number of bedroom and bathroom in filters vs results
			Assert.assertEquals(((bedroomNumber<=selectedMaxBedroomNumber) && (bedroomNumber>=selectedMinBedroomNumber)), true);
			Assert.assertEquals(((bathroomNumber<=selectedMaxBathroomNumber) && (bathroomNumber>=selectedMinBathroomNumber)), true);
			
		}
		 else{ // Check for no result
			 Assert.assertEquals("No results",noResults.getText());
			 System.out.println("No results");
		} 		
		Reporter.log("Results are obtained and verified", true);	  
  }
  
  @BeforeSuite(alwaysRun=true)
  public void beforeTest() {
	  System.setProperty(browserName, browserExePath);
	  driver=new ChromeDriver();	  
	  PageFactory.initElements(driver, this);
	  driver.manage().window().maximize();
  }
	  
  @AfterSuite(alwaysRun=true)
  public void afterTest() {
	  driver.quit();
  }

}
