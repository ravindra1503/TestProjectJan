package TestClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.Browser;
import POM.Arrivals;
import POM.BookBasket;
import POM.CheckoutPage;
import POM.Home;
import POM.MasteringJavaScript;
import POM.MenuPage;
import POM.SeleniumRuby;
import POM.Shop;
import POM.Sliders;
import POM.ThinkingInHTML;
import utils.Utility;

public class TestClassWithTestNG extends Browser
{
	private WebDriver driver;
	private SoftAssert softAssert;
	private Shop shop;
	private Home home;
	private Sliders sliders;
	private Arrivals arrivals;
	private SeleniumRuby seleniumRuby;
	private ThinkingInHTML thinkingInHTML;
	private MasteringJavaScript masteringJavaScript;
	private MenuPage menu;
	private BookBasket baskettab;
	private CheckoutPage checkoutPage;
	private int TestId;
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver = lanuchChormeBrowser();
			
		}
		if(browser.equalsIgnoreCase("Firefox"))
		{
			driver = lanuchFirefoxBrowser();
			
		}
			
	}
	
	
	@BeforeClass
	public void objectOfPOM()
	{
		shop=new Shop(driver);
		home=new Home(driver);
		menu=new MenuPage(driver);
		sliders= new Sliders(driver);
		arrivals=new Arrivals(driver);
		seleniumRuby=new SeleniumRuby(driver);
		thinkingInHTML=new ThinkingInHTML(driver);
		masteringJavaScript= new MasteringJavaScript(driver);
		baskettab=new BookBasket(driver);
		checkoutPage=new CheckoutPage(driver);
	}
	
	
	
	@BeforeMethod
	public void beforeMethod()
	{
				
		driver.get("http://practice.automationtesting.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		menu.clickOnShop();
		menu.clickOnHome();

		
	}
	
	//Test Case 1
	@Test (priority=1)
	public void verifySliders()
	{
		TestId=101;
		softAssert=new SoftAssert();
		
		int slidersSize=sliders.sliderSize();
		softAssert.assertEquals(slidersSize, 3);
			
		softAssert.assertAll();
	}
	
	//Test case 2
	@Test (priority=2)
	public void verifyArrivals()
	{
		TestId=102;
		softAssert=new SoftAssert();
		
		int arrivalssize=arrivals.arrivalSize();
		softAssert.assertEquals(arrivalssize, 3);
			
		softAssert.assertAll();
	}
	
	//Test case 3
	@Test (priority=3)
	public void seleniumRuby()
	{
		TestId=103;
		softAssert=new SoftAssert();
		
		
		int arrivalssize=arrivals.arrivalSize();
		softAssert.assertEquals(arrivalssize, 3);
		
		
		seleniumRuby.clickOnSeleniumRubyImage();
		driver.navigate().back();
		
		
		thinkingInHTML.clickOnThinkingInHTMLImage();
		driver.navigate().back();
		
		
		masteringJavaScript.clickOnMasteringJavaScriptImage();
		driver.navigate().back();
		softAssert.assertAll();
		
	}
	
	//Test Case 4
	@Test (priority=4)
	public void imagesDiscription()
	{
		TestId=104;
		softAssert=new SoftAssert();
		
		int arrivalssize=arrivals.arrivalSize();
		softAssert.assertEquals(arrivalssize, 3);
		
		
		seleniumRuby.clickOnSeleniumRubyImage();
		String DescriptionSeleneiumRubyPage =seleniumRuby.verifySeleniumRubyDescription();
		boolean descriptionOfSeleniumRubyPage=DescriptionSeleneiumRubyPage.contains("Selenium WebDriver Recipes book is a quick problem-solving guide");
		softAssert.assertTrue(descriptionOfSeleniumRubyPage);
		
		driver.navigate().back();
		
		thinkingInHTML.clickOnThinkingInHTMLImage();
		thinkingInHTML.clickOnThinkingInHTMLImage();
		String DescriptionThinkingInHTMLPage=thinkingInHTML.verifyThinkingInHTMLDescription();
		boolean descriptionOfThinkingHTMLPage= DescriptionThinkingInHTMLPage.contains("This book provides you with an intermediate knowledge of HTML");
		softAssert.assertTrue(descriptionOfThinkingHTMLPage);
		
		driver.navigate().back();
		
		masteringJavaScript.clickOnMasteringJavaScriptImage();
		String DescriptionMasteringJavaScriptPage =masteringJavaScript.verifyMasteringJavaScriptDescription();
		boolean descriptionOfMasteringJavaScriptPage = DescriptionMasteringJavaScriptPage.contains("it is difficult to find a topic related to JavaScript that has not been discussed");
		softAssert.assertTrue(descriptionOfMasteringJavaScriptPage);
			
		driver.navigate().back();
		
		softAssert.assertAll();
		
	}
	
	//Test case 5
	@Test (priority=5)
	public void imageReview()
	{
		TestId=105;
		softAssert=new SoftAssert();
		
		int arrivalssize=arrivals.arrivalSize();
		softAssert.assertEquals(arrivalssize, 3);
		seleniumRuby.clickOnSeleniumRubyImage();
		seleniumRuby.verifySeleniumRubyReviews();
		
		driver.navigate().back();
		
		thinkingInHTML.clickOnThinkingInHTMLImage();
		thinkingInHTML.verifyThinkingHTMLReviews();
		
		driver.navigate().back();

		masteringJavaScript.clickOnMasteringJavaScriptImage();
		masteringJavaScript.verifyMasteringJavascriptReviews();
		
		softAssert.assertAll();
		
	}

	
	//Test case 6
	@Test (priority=6)
	public void addBookToBasket()
	{
		TestId=106;
		
		int arrivalssize=arrivals.arrivalSize();
		softAssert.assertEquals(arrivalssize, 3);
		
		masteringJavaScript.clickOnMasteringJavaScriptImage();
		masteringJavaScript.addMasteringJavascriptBookToBasket("1");
		
		
		softAssert.assertAll();
	}
	
	
	// Test Case 7
	@Test (priority=7)
	public void verifyHighestQuantityError()
	{
		TestId=107;
		
		int arrivalssize=arrivals.arrivalSize();
		softAssert.assertEquals(arrivalssize, 3);
		
		masteringJavaScript.clickOnMasteringJavaScriptImage();
		masteringJavaScript.addMasteringJavascriptBookToBasket("7934");
		
		
		
		softAssert.assertAll();
	}
	
	
	
	//Test Case 8
	@Test (priority=8)
	public void checkBasketPage()
	{
		TestId=108;
		
		int arrivalssize=arrivals.arrivalSize();
		softAssert.assertEquals(arrivalssize, 3);
		
		masteringJavaScript.clickOnMasteringJavaScriptImage();
		masteringJavaScript.addMasteringJavascriptBookToBasket("2");
		menu.clickMenuBasket();
		softAssert.assertEquals(driver.getTitle(), "Basket � Automation Practice Site");
	
		softAssert.assertAll();
	}
	
	
	//Test Case 9
		@Test (priority=9)
		public void ApplyCoupon()
		{
			TestId=109;
			
			int arrivalssize=arrivals.arrivalSize();
			softAssert.assertEquals(arrivalssize, 3);
			
			masteringJavaScript.clickOnMasteringJavaScriptImage();
			masteringJavaScript.addMasteringJavascriptBookToBasket("1");
			menu.clickMenuBasket();
			softAssert.assertEquals(driver.getTitle(), "Basket � Automation Practice Site");
			
			baskettab.enterCouponCodeAndClickApply();
		
			softAssert.assertAll();
		}
	
		
		//Test Case 10
		@Test (priority=10)
		public void unableToApplyCouponCode()
		{
					TestId=110;
					
					int arrivalssize=arrivals.arrivalSize();
					softAssert.assertEquals(arrivalssize, 3);
					
					masteringJavaScript.clickOnMasteringJavaScriptImage();
					masteringJavaScript.addMasteringJavascriptBookToBasket("1");
					menu.clickMenuBasket();
					softAssert.assertEquals(driver.getTitle(), "Basket � Automation Practice Site");
					baskettab.enterCouponCodeAndClickApply();
					
					softAssert.assertAll();
		}	
		
	
		
	// Test Case 11
	@Test (priority=11)
	public void removeBook()
	{
				TestId=111;
				
				int arrivalssize=arrivals.arrivalSize();
				softAssert.assertEquals(arrivalssize, 3);
				
				masteringJavaScript.clickOnMasteringJavaScriptImage();
				masteringJavaScript.addMasteringJavascriptBookToBasket("1");
				menu.clickMenuBasket();
				softAssert.assertEquals(driver.getTitle(), "Basket � Automation Practice Site");
				String bookRemoveMessage =baskettab.clickRemoveThisBookIcon();
				softAssert.assertEquals(bookRemoveMessage, "Your basket is currently empty.");
				softAssert.assertAll();
				
	}	
		
	
	//Test 12
	@Test (priority=12)
	public void updateBook()
	{
		TestId=112;
				
		int arrivalssize=arrivals.arrivalSize();
		softAssert.assertEquals(arrivalssize, 3);
				
		masteringJavaScript.clickOnMasteringJavaScriptImage();
		masteringJavaScript.addMasteringJavascriptBookToBasket("1");
		menu.clickMenuBasket();
		softAssert.assertEquals(driver.getTitle(), "Basket � Automation Practice Site");
		
		baskettab.addQuantity();
		baskettab.clickUpdateBasket();
			
		softAssert.assertAll();
				
	}	
	
	
	
	//Test Case 13
	@Test (priority=13)
	public void totalPriceOfBook()
	{
		TestId=113;
				
		int arrivalssize=arrivals.arrivalSize();
		softAssert.assertEquals(arrivalssize, 3);
				
		masteringJavaScript.clickOnMasteringJavaScriptImage();
		masteringJavaScript.addMasteringJavascriptBookToBasket("1");
		menu.clickMenuBasket();
		softAssert.assertEquals(driver.getTitle(), "Basket � Automation Practice Site");
		
		baskettab.addQuantity();
		baskettab.clickUpdateBasket();
		baskettab.checkTotalPriceOfBook();
		
		softAssert.assertAll();
				
	}	
	
	//Test Case 14
		@Test (priority=14)
		public void updateBasketBook()
		{
			TestId=114;
					
			int arrivalssize=arrivals.arrivalSize();
			softAssert.assertEquals(arrivalssize, 3);
					
			masteringJavaScript.clickOnMasteringJavaScriptImage();
			masteringJavaScript.addMasteringJavascriptBookToBasket("1");
			menu.clickMenuBasket();
			softAssert.assertEquals(driver.getTitle(), "Basket � Automation Practice Site");
			
			baskettab.addQuantity();
			baskettab.clickUpdateBasket();
			
			softAssert.assertAll();
					
		}	
		
		//Test Case 15
		@Test (priority=15)
		public void totalAndSubTotalPriceOfBook()
		{
			TestId=115;
							
			int arrivalssize=arrivals.arrivalSize();
			softAssert.assertEquals(arrivalssize, 3);
							
			masteringJavaScript.clickOnMasteringJavaScriptImage();
			masteringJavaScript.addMasteringJavascriptBookToBasket("1");
			menu.clickMenuBasket();
			softAssert.assertEquals(driver.getTitle(), "Basket � Automation Practice Site");
			
			baskettab.addQuantity();
			baskettab.clickUpdateBasket();
			boolean ComparisionOfTotalAndSubTotal =baskettab.compareTotalSubTotalPrice();
			softAssert.assertTrue(ComparisionOfTotalAndSubTotal);

			softAssert.assertAll();
							
		}		
		
		//Test Case 16
		@Test (priority=16)
		public void checkOutFunctionalityFromBasketTab()
		{
			TestId=116;
									
			int arrivalssize=arrivals.arrivalSize();
			softAssert.assertEquals(arrivalssize, 3);
									
			masteringJavaScript.clickOnMasteringJavaScriptImage();
			masteringJavaScript.addMasteringJavascriptBookToBasket("1");
			menu.clickMenuBasket();
			softAssert.assertEquals(driver.getTitle(), "Basket � Automation Practice Site");
					
			baskettab.addQuantity();
			baskettab.clickUpdateBasket();
			boolean ComparisionOfTotalAndSubTotal =baskettab.compareTotalSubTotalPrice();
			softAssert.assertTrue(ComparisionOfTotalAndSubTotal);
			
			baskettab.clickOnCheckoutButton();
			
			softAssert.assertEquals(driver.getTitle(), "Checkout � Automation Practice Site");
			
			softAssert.assertAll();
									
		}		
		
		
	//Test Case 17
	@Test (priority=17)
	public void checkOutPaymentGatewayFillDetails()
	{
		TestId=117;
											
		int arrivalssize=arrivals.arrivalSize();
		softAssert.assertEquals(arrivalssize, 3);
											
		masteringJavaScript.clickOnMasteringJavaScriptImage();
		masteringJavaScript.addMasteringJavascriptBookToBasket("2");
		menu.clickMenuBasket();
		softAssert.assertEquals(driver.getTitle(), "Basket � Automation Practice Site");
							
		baskettab.addQuantity();
		baskettab.clickUpdateBasket();
		boolean ComparisionOfTotalAndSubTotal =baskettab.compareTotalSubTotalPrice();
		softAssert.assertTrue(ComparisionOfTotalAndSubTotal);
		
		baskettab.clickOnCheckoutButton();
					
		softAssert.assertEquals(driver.getTitle(), "Checkout � Automation Practice Site");
		
		checkoutPage.fillCheckoutBillingDetails();
		
			
		softAssert.assertAll();
											
	}		
		
	
	//Test Case 18
	@Test (priority=18)
	public void checkOutPaymentGatewayPlaceOrder()
	{
		TestId=118;
											
		int arrivalssize=arrivals.arrivalSize();
		softAssert.assertEquals(arrivalssize, 3);
											
		masteringJavaScript.clickOnMasteringJavaScriptImage();
		masteringJavaScript.addMasteringJavascriptBookToBasket("2");
		menu.clickMenuBasket();
		softAssert.assertEquals(driver.getTitle(), "Basket � Automation Practice Site");
							
		baskettab.addQuantity();
		baskettab.clickUpdateBasket();
		boolean ComparisionOfTotalAndSubTotal =baskettab.compareTotalSubTotalPrice();
		softAssert.assertTrue(ComparisionOfTotalAndSubTotal);
		
		baskettab.clickOnCheckoutButton();
					
		softAssert.assertEquals(driver.getTitle(), "Checkout � Automation Practice Site");
		
		checkoutPage.fillCheckoutBillingDetails();
		
		softAssert.assertEquals(driver.getTitle(), "Checkout � Automation Practice Site");
		
		
		softAssert.assertAll();
											
	}		
		
		
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE == result.getStatus())
		{
			Utility.takeScreenshotOfFailedTC(driver, TestId);
		}
		
		driver.navigate().refresh();
	}
	
	@AfterClass
	public void closePOMObject()
	{
		shop=null;
		home=null;
		sliders= null;
		arrivals=null;
		seleniumRuby=null;
		thinkingInHTML=null;
		masteringJavaScript= null;
	}

	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
		driver=null;
		System.gc();
	}
	
	
	
	
}
