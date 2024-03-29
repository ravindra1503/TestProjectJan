package POM;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


//Test case 3 - Home page-images in arrivals should navigate
	/*	1) Open the browser
		2) Enter the URL �http://practice.automationtesting.in/�
		3) Click on Shop Menu
		4) Now click on Home menu button
		5) Test whether the Home page has Three Arrivals only
		6) The Home page must contains only three Arrivals
		7) Now click the image in the Arrivals
		8) Test whether it is navigating to next page where the user can add that book into his basket.
		9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
		10-Home page-Arrival Images Discription  
		*/


public class SeleniumRuby 
{
	@FindBy (xpath="//img[@title='Selenium Ruby']")
	private WebElement seleniumRubyImage;
	
	@FindBy (xpath="//a[text()='Description']")
	private WebElement clickOnSeleniumRubyDescription;
	
	@FindBy (xpath="(//div[@id='tab-description'])//p")
	private WebElement descriptionOfSeleniumRuby;
	
	@FindBy (xpath="//a[text()='Reviews (0)']")
	private WebElement reviewsOfSeleniumRuby;
	
	public SeleniumRuby(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickOnSeleniumRubyImage()
	{
		seleniumRubyImage.click();
	}
	
	
	
	public String verifySeleniumRubyDescription()
	{
		clickOnSeleniumRubyDescription.click();
		
		String DescriptionSeleneiumRubyPage=descriptionOfSeleniumRuby.getText();
		return DescriptionSeleneiumRubyPage;
	}
	
	
	public void verifySeleniumRubyReviews()
	{
		
		reviewsOfSeleniumRuby.click();
		
		
	}
	
}
