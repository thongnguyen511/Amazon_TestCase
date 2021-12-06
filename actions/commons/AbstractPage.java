package commons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
	private WebElement element;
	private List<WebElement> elements;
	private Select select;
	private JavascriptExecutor javascriptExecutor;
	private WebDriverWait waitExplicit;
	private Actions action;
	private By byLocator;
	private int longTimeout = Constants.LONG_TIMEOUT;

	/* Web Browser */

	public void openUrl(WebDriver driver, String value) {
		driver.get(value);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getCurrentPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void refreshToPage(WebDriver driver) {
		driver.navigate().refresh();
		;
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public void sendkeyToAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public void switchToFrame(WebDriver driver, String string) {
		driver.switchTo().frame(string);
	}

	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	/* Web Element */
	public void clickToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			clickToElementByJS(driver, locator);
			sleepInSecond(driver, 5000);
		} else {
			element.click();
		}
	}

	public void clickToElement(WebDriver driver, String locator, String... dymamicValues) {
		locator = String.format(locator, (Object[]) dymamicValues);
		element = driver.findElement(By.xpath(locator));
		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			clickToElementByJS(driver, locator);
			sleepInSecond(driver, 5000);
		} else {
			element.click();
		}
	}

	public void sendkeyToElement(WebDriver driver, String locator, String value) {
		element = driver.findElement(By.xpath(locator));
		element.sendKeys(value);
	}

	public void sendkeyToElement(WebDriver driver, String locator, String sendKeyValue, String... dynamicValues) {
		locator = String.format(locator, (Object[]) dynamicValues);
		element = driver.findElement(By.xpath(locator));
		element.sendKeys(sendKeyValue);
	}

	public void clearTextbox(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		element.clear();
	}

	public void selectElementInDropDown(WebDriver driver, String locator, String itemText) {
		element = driver.findElement(By.xpath(locator));
		select = new Select(element);
		select.selectByVisibleText(itemText);
	}

	public void selectElementInDropDown(WebDriver driver, String locator, String itemText, String... dynamicValues) {
		locator = String.format(locator, (Object[]) dynamicValues);
		element = driver.findElement(By.xpath(locator));
		select = new Select(element);
		select.selectByVisibleText(itemText);
	}

	public String getSelectedItemInDropDown(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	public void selectItemInDropdown(WebDriver driver, String parentXpath, String allItemXpath,
			String expectedValueItem) throws Exception {
		element = driver.findElement(By.xpath(parentXpath));

		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].click();", element);
		sleepInSecond(driver, Constants.SHORT_SECOND);

		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemXpath)));

		elements = driver.findElements(By.xpath(allItemXpath));

		for (WebElement childElement : elements) {
			if (childElement.getText().contains(expectedValueItem)) {
				if (childElement.isDisplayed()) {
					childElement.click();
				} else {
					javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", childElement);
					sleepInSecond(driver, Constants.SHORT_SECOND);
					javascriptExecutor.executeScript("arguments[0].click();", childElement);
				}
				sleepInSecond(driver, 1);
				break;
			}
		}
	}

	public String getAttributeValue(WebDriver driver, String locator, String attributeName) {
		element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attributeName);
	}

	public String getTextElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public String getTextInElement(WebDriver driver, String locator, String... dynamicValues) {
		locator = String.format(locator, (Object[]) dynamicValues);
		element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public int countElementsNumber(WebDriver driver, String locator) {
		elements = driver.findElements(By.xpath(locator));
		return elements.size();
	}

	public void checkToCheckbox(WebDriver driver, String locator) {
		elements = driver.findElements(By.xpath(locator));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void checkToCheckbox(WebDriver driver, String locator, String... dynamicValues) {
		locator = String.format(locator, (Object[]) dynamicValues);
		element = driver.findElement(By.xpath(locator));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToCheckbox(WebDriver driver, String locator) {
		elements = driver.findElements(By.xpath(locator));
		if (element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToCheckbox(WebDriver driver, String locator, String... dynamicValues) {
		locator = String.format(locator, (Object[]) dynamicValues);
		element = driver.findElement(By.xpath(locator));
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isControlDisplayed(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public boolean isControlUndisplayed(WebDriver driver, String locator) {
		overrideGlobalTimeout(driver, Constants.SHORT_TIMEOUT);
		List<WebElement> elements = driver.findElements(By.xpath(locator));

		if (elements.size() == 0) {
			overrideGlobalTimeout(driver, Constants.LONG_TIMEOUT);
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			overrideGlobalTimeout(driver, Constants.LONG_TIMEOUT);
			return true;
		} else {
			overrideGlobalTimeout(driver, Constants.LONG_TIMEOUT);
			return false;
		}
	}

	public void overrideGlobalTimeout(WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}

	public boolean isControlDisplayed(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public boolean isControlSelected(WebDriver driver, String locator) {
		elements = driver.findElements(By.xpath(locator));
		return element.isSelected();
	}

	public boolean isControlEnabled(WebDriver driver, String locator) {
		elements = driver.findElements(By.xpath(locator));
		return element.isEnabled();
	}

	public void switchToChildWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			driver.switchTo().window(runWindow);
			String currentWin = driver.getTitle();
			if (currentWin.equals(title)) {
				break;
			}
		}
	}

	public void closeAllWindowWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}

	public void hoverMouseToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	public void sendkeyToElement(WebDriver driver, String locator, Keys key) {
		element = driver.findElement(By.xpath(locator));
		action = new Actions(driver);
		action.sendKeys(element, key).perform();
	}

	public void sendkeyToElement(WebDriver driver, String locator, Keys key, String... dynamicValues) {
		locator = String.format(locator, (Object[]) dynamicValues);
		element = driver.findElement(By.xpath(locator));
		action = new Actions(driver);
		action.sendKeys(element, key).perform();
	}

	public void highlightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String originalStyle = element.getAttribute("style");
		js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 5px solid red; border-style: dashed;");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void executeForBrowser(WebDriver driver, String javaSript) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(javaSript);
	}

	public boolean verifyTextInInnerText(WebDriver driver, String textExpected) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String textActual = (String) js
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		System.out.println("Text actual = " + textActual);
		return textActual.equals(textExpected);
	}

	public boolean checkAnyImageLoaded(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		javascriptExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) javascriptExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				element);
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void clickToElementByJS(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		scrollToElement(driver, locator);
		element = driver.findElement(By.xpath(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void scrollToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		element = driver.findElement(By.xpath(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
	}

	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		element = driver.findElement(By.xpath(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.location = '" + url + "'");
	}

	public void waitForElementPresence(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, longTimeout);
		byLocator = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.presenceOfElementLocated(byLocator));
	}

	public void waitForElementClickable(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, longTimeout);
		byLocator = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(byLocator));
	}

	public void waitForElementClickable(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		waitExplicit = new WebDriverWait(driver, longTimeout);
		byLocator = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(byLocator));
	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, longTimeout);
		byLocator = By.xpath(locator);
		overrideGlobalTimeout(driver, Constants.SHORT_TIMEOUT);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
		overrideGlobalTimeout(driver, Constants.LONG_TIMEOUT);
	}

	public void waitForAllElementVisible(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, longTimeout);
		byLocator = By.xpath(locator);
		overrideGlobalTimeout(driver, Constants.LONG_TIMEOUT);
		waitExplicit.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byLocator));
		overrideGlobalTimeout(driver, Constants.LONG_TIMEOUT);
	}

	public void waitForElementVisible(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		waitExplicit = new WebDriverWait(driver, longTimeout);
		byLocator = By.xpath(locator);
		overrideGlobalTimeout(driver, Constants.SHORT_TIMEOUT);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
		overrideGlobalTimeout(driver, Constants.LONG_TIMEOUT);
	}

	public void waitForElementInvisible(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, longTimeout);
		byLocator = By.xpath(locator);
		overrideGlobalTimeout(driver, Constants.SHORT_TIMEOUT);
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
		overrideGlobalTimeout(driver, Constants.LONG_TIMEOUT);
	}

	public void waitForAlertPresence(WebDriver driver) {
		waitExplicit = new WebDriverWait(driver, longTimeout);
		waitExplicit.until(ExpectedConditions.alertIsPresent());
	}

//	public SignInPO openLogoutLink(WebDriver driver) {
//		acceptAlert(driver);
//		sleepInSecond(driver, 3);
//		return PageGeneratorManager.getLoginPage(driver);
//	}

	public void sleepInSecond(WebDriver driver, long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean isDataDateSortedDescending(WebDriver driver, String locator) {
		ArrayList<Date> arrayList = new ArrayList<>();

		List<WebElement> elementList = driver.findElements(By.xpath(locator));

		for (WebElement element : elementList) {
			arrayList.add(convertStringToDate(element.getText()));
		}

		System.out.println("------Data on UI:------");
		for (Date publicationDate : arrayList) {
			System.out.println(publicationDate);
		}

		ArrayList<Date> sortedList = new ArrayList<>();
		for (Date child : arrayList) {
			sortedList.add(child);
		}

		Collections.sort(sortedList);
		Collections.reverse(sortedList);

		System.out.println("------Data already sorted by Desc:------");
		for (Date name : sortedList) {
			System.out.println(name);
		}
		return sortedList.equals(arrayList);
	}

	public Date convertStringToDate(String dateInString) {
		dateInString = dateInString.replace(",", "");
		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd yyyy");
		Date date = null;
		try {
			date = formatter.parse(dateInString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;

	}

	public boolean is16BookImageDisplayedOnPage(WebDriver driver, String locator) {
		elements = driver.findElements(By.xpath(locator));
		if (elements.size() == 16) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isNextButtonDisplayed(WebDriver driver, String locator) {
		elements = driver.findElements(By.xpath(locator));
		if (elements.size() == 0) {
			return false;
		} else {
			return true;
		}
	}
}
