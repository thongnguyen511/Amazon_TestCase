package amazon.webportal;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.HomePO;
import pageObjects.SignInPO;

public class NVG_AutomationTask extends AbstractTest {
	WebDriver driver;
	SignInPO signInPage;
	HomePO homePage;
	HomePO userHomePage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		homePage = loginToApp(driver);
	}

	@Test
	public void TC_01_VerifySearchResult() {
		// Test data
		String departmentName = "Books";
		String searchValue = "apple";
		String bookLanguage = "English - EN";
		int pageNumber = 1;

		log.info("TC_01_VerifySearchResult - Step 1: Select " + departmentName + " from Department dropdown box");
		homePage.selectDepartmentValue(departmentName);

		log.info("TC_01_VerifySearchResult - Step 2: Enter search value = " + searchValue + " in search textbox");
		homePage.enterSearchText(searchValue);

		log.info("TC_01_VerifySearchResult - Step 3: Select " + bookLanguage + " from Change language dropdown");
		homePage.selectLanguage(bookLanguage);

		log.info("TC_01_VerifySearchResult - Step 4: Click Search button");
		homePage.clickSearchButton();

		do {
			log.info("TC_01_VerifySearchResult - Step 5: Verify that there are 16 books items displayed on page"
					+ pageNumber);
			verifyTrue(homePage.is16ItemDisplayedOnPage());
			
			log.info("TC_01_VerifySearchResult - Step 6: Click next button to go to next page");
			homePage.clickNextButton();
			
			pageNumber = pageNumber + 1;
		}
		while (homePage.nextButtonIsDisplayed());
		
	}

	@Test
	public void TC_02_VerifyResultSortByPublicationDate() {

		log.info("TC_02_VerifyResultSortedByPublicationDate - Step 1: Click Sort By");
		homePage.clickSortByDropdown();

		log.info("TC_02_VerifyResultSortedByPublicationDate - Step 2: Select Publication Date item");
		homePage.selectPublicationDateItem();

		log.info("TC_02_VerifyResultSortedByPublicationDate - Step 3: Verify if the search result is sorted by Publication Date in descending");
		verifyTrue(homePage.isSortByPublicationDate());
	}

	@AfterClass
	public void afterClass() {

		log.info("Log Out");
		homePage.logOut();

		log.info("Close browser");
		closeBrowserAndDriver(driver);
	}
}
