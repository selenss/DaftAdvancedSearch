package daft.advanced.search;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DaftPageObjects {
	
	public String browserName = "webdriver.chrome.driver";
	public String browserExePath = "C:/Users/Samsung/Desktop/drivers/chromedriver.exe";
	
	
	@FindBy (xpath="//ul//a[@class='no-select']")
	public List <WebElement> categories;
	
	@FindBy (xpath="//a[@class='no-select last' and contains(text(),'More')]")
	public WebElement categoryMoreSelection;
	
	@FindBy (xpath=".//span[contains(@class,'jcf-list-content')]/ul/li")
	public List <WebElement> cityCountyDropdownElements;
	
	@FindBy (className="select-holder")
	public WebElement countyCityDropdown;
	
	@FindBy (xpath="//div[@id='choose-an-area']")
	public WebElement allAreasDropdown;
	
	@FindBy (xpath=".//div[@id='choose-an-area']//div[@class='checkbox-holder ng-scope']//input")
	public List <WebElement> areaElements;
	
	@FindBy (xpath="//button[@class='btn btn-primary btn-search']")
	public WebElement searchButton; 
	
	@FindBy (xpath="//a[@class='alignright' and contains(text(),'Advanced')]")
	public WebElement advancedSearchTextLink;
	
	@FindBy (xpath=".//div[@id='advanced-container']//input[@value='Search']")
	public WebElement advancedTabSearchButton;	
	
	@FindBy (id="min_price") 
	public WebElement minPriceDropdown;
	
	@FindBy (id="min_price")
	public List <WebElement> minPriceBoxCheck;
	
	@FindBy (xpath=".//dl[@id='min_price']//li")
	public List <WebElement> minPriceElements;
	
	@FindBy (id="max_price")
	public WebElement maxPriceDropdown;	
	
	@FindBy (id="max_price")
	public List <WebElement> maxPriceBoxCheck;
	
	@FindBy (xpath=".//dl[@id='max_price']//li")
	public List <WebElement> maxPriceElements;
	
	@FindBy (id="min_bed")
	public WebElement minBedDropdown;	
	
	@FindBy (id="min_bed")
	public List <WebElement> minBedDropdownCheck;
	
	@FindBy (xpath=".//dl[@id='min_bed']//li")
	public List <WebElement> minBedElements;
	
	@FindBy (id="max_bed")
	public WebElement maxBedDropdown;	
	
	@FindBy (id="max_bed")
	public List <WebElement> maxBedDropdownCheck;
	
	@FindBy (xpath=".//dl[@id='max_bed']//li")
	public List <WebElement> maxBedElements;
	
	@FindBy (id="min_bath")
	public WebElement minBathDropdown;	
	
	@FindBy (id="min_bath")
	public List <WebElement> minBathDropdownCheck;
	
	@FindBy (xpath=".//dl[@id='min_bath']//li")
	public List <WebElement> minBathElements;
	
	@FindBy (id="max_bath")
	public WebElement maxBathDropdown;	
	
	@FindBy (id="max_bath")
	public List <WebElement> maxBathDropdownCheck;
	
	@FindBy (xpath=".//dl[@id='max_bath']//li")
	public List <WebElement> maxBathElements;
	
	@FindBy (id="ptId_select")
	public WebElement propertyTypeDropdown;	
	
	@FindBy (id="ptId_select")
	public List <WebElement> propertyTypeDropdownCheck;
	
	@FindBy (xpath=".//ul[@id='ptId_ul']/li")
	public List <WebElement> propertyTypeElements;
		
	@FindBy (xpath=".//table[@id='sr_content']//div[@class='search_result_title_box']")
	public List <WebElement> results;
	
	@FindBy (xpath=".//table[@id='sr_content']//div[@class='box']//ul[@class='info']//li[2]")
	public List <WebElement> bedResultsList;
	
	@FindBy (xpath=".//table[@id='sr_content']//div[@class='box']//ul[@class='info']//li[3]")
	public List <WebElement> bathResultsList;
	
	@FindBy (xpath=".//div[@id='gc_content']/h1")
	public WebElement noResults;	
	
}
