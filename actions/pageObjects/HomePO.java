package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.Constants;
import pageUIs.HomePUI;

public class HomePO extends AbstractPage {
	WebDriver driver;

	public HomePO(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public void clickSearchButton() {
		waitForElementVisible(driver, HomePUI.SEARCH_BUTTON);
		clickToElement(driver, HomePUI.SEARCH_BUTTON);
		sleepInSecond(driver, Constants.SHORT_SECOND);
	}

	public void selectDepartmentValue(String departmentName) {
		waitForElementPresence(driver, HomePUI.DEPARTMENT_DROPDOWN_BOX);
		selectElementInDropDown(driver, HomePUI.DEPARTMENT_DROPDOWN_BOX, departmentName);
		
	}

	public void enterSearchText(String searchValue) {
		waitForElementVisible(driver, HomePUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, HomePUI.SEARCH_TEXTBOX, searchValue);
		sleepInSecond(driver, Constants.SHORT_SECOND);
		
	}

	public void selectLanguage(String bookLanguage) {
		waitForElementVisible(driver, HomePUI.LANGUAGE_ICON_LINK);
		hoverMouseToElement(driver, HomePUI.LANGUAGE_ICON_LINK);
		waitForElementClickable(driver, HomePUI.LANGUAGE_RADIO_BUTTON, bookLanguage);;
		clickToElement(driver, HomePUI.LANGUAGE_RADIO_BUTTON, bookLanguage);
		sleepInSecond(driver, Constants.SHORT_SECOND);
	}

	public void clickSortByDropdown() {
		waitForElementPresence(driver, HomePUI.SORT_BY_DROPDOWN_BOX);
		clickToElementByJS(driver, HomePUI.SORT_BY_DROPDOWN_BOX);
		sleepInSecond(driver, Constants.SHORT_SECOND);
		
	}

	public void selectPublicationDateItem() {
		waitForElementVisible(driver, HomePUI.SORT_BY_PUBLICATION_DATE_ITEM);
		clickToElement(driver, HomePUI.SORT_BY_PUBLICATION_DATE_ITEM);
		sleepInSecond(driver, Constants.SHORT_SECOND);
		
	}

	public boolean isSortByPublicationDate() {
		waitForAllElementVisible(driver, HomePUI.BOOK_PUBLICATION_DATE);
		sleepInSecond(driver, Constants.SHORT_SECOND*3);
		return isDataDateSortedDescending(driver, HomePUI.BOOK_PUBLICATION_DATE);
	}

	public void logOut() {
		waitForElementVisible(driver, HomePUI.ACCOUNT_LIST_LINK);
		hoverMouseToElement(driver, HomePUI.ACCOUNT_LIST_LINK);
		waitForElementVisible(driver, HomePUI.SIGNOUT_LINK);
		clickToElement(driver, HomePUI.SIGNOUT_LINK);
		sleepInSecond(driver, Constants.SHORT_SECOND);
		
	}

	public boolean is16ItemDisplayedOnPage() {
		waitForAllElementVisible(driver, HomePUI.BOOK_IMAGE);
		return is16BookImageDisplayedOnPage(driver, HomePUI.BOOK_IMAGE);
	}

	public boolean nextButtonIsDisplayed() {
		return isNextButtonDisplayed(driver, HomePUI.PAGINATION_NEXT_BUTTON);
	}

	public void clickNextButton() {
		waitForElementClickable(driver, HomePUI.PAGINATION_NEXT_BUTTON);
		clickToElement(driver, HomePUI.PAGINATION_NEXT_BUTTON);
		sleepInSecond(driver, Constants.SHORT_SECOND);
	}


}