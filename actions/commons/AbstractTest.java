package commons;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.HomePO;
import pageObjects.LoginPO;

public class AbstractTest {
	WebDriver driver;
	protected final Log log;

	protected AbstractTest() {
		log = LogFactory.getLog(getClass());
	}

	public WebDriver openMultiBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().arch64().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("chromeheadless")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=" + Constants.HEADLESS_RESOLUTION);
			driver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("internetexplorer")) {
			WebDriverManager.iedriver().arch32().setup();
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("Please choose your browser name in TestNG xml file.");
		}

		driver.get(Constants.TEST_URL);
		if (driver.toString().contains("internetexplorer")) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		driver.manage().timeouts().implicitlyWait(Constants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	public HomePO loginToApp(WebDriver mappingDriver) {
		LoginPO loginPage = PageGeneratorManager.getLoginPage(mappingDriver);
		loginPage.clickLoginButton();
		loginPage.inputToUserNameTextbox(Constants.USERNAME);
		loginPage.inputToPasswordTextbox(Constants.PASS);
		return loginPage.clickDangnhapButton();
	}

	private boolean checkPassed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true)
				log.info("===PASSED==");
			else
				log.info("===FAILED==");
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;
			// Add error to ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkPassed(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false)
				log.info("===PASSED===");
			else
				log.info("===FAILED===");
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		boolean status;
		try {
			if (actual instanceof String && expected instanceof String) {
				actual = actual.toString().trim();
				log.info("Actual = " + actual);
				expected = expected.toString().trim();
				log.info("Expected = " + expected);
				status = (actual.equals(expected));
			} else {
				status = (actual == expected);
			}

			log.info("Compare value = " + status);
			if (status) {
				log.info("===PASSED===");
			} else {
				log.info("===FAILED===");
			}
			Assert.assertEquals(actual, expected, "Value is not matching!");
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}

	protected void closeBrowserAndDriver(WebDriver driver) {
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			String cmd = "";
			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}

			if (driver.toString().toLowerCase().contains("chrome")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill chromedriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				}
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}

			if (driver.toString().toLowerCase().contains("internetexplorer")) {
				if (osName.toLowerCase().contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
					Process process = Runtime.getRuntime().exec(cmd);
					process.waitFor();
				}
			}

			if (driver.toString().toLowerCase().contains("gecko")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill geckodriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
				}
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}
			log.info("---------- QUIT BROWSER SUCCESS ----------");
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}
	
	protected String getNextDate(int numberofDays) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, numberofDays);
		Date date = c.getTime();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = dateFormat.format(date);
		return strDate;
	}
	
	protected static int randomNumber(int min, int max) {
		Random generator = new Random();
		return generator.nextInt((max - min) + 1) + min;     
	}
    /**      * Random string with a-zA-Z0-9, not included special characters      */     
	protected String randomAlphaNumeric(int numberOfCharactor) {  
		final String alpha = "abcdefghijklmnopqrstuvwxyz"; 
		final String alphaUpperCase = alpha.toUpperCase(); 
		final String ALPHA_NUMERIC = alpha + alphaUpperCase;     
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numberOfCharactor; i++) { 
			int number = randomNumber(0, ALPHA_NUMERIC.length() - 1);            
			char ch = ALPHA_NUMERIC.charAt(number);             
			sb.append(ch);         
		}         
		return sb.toString();     
	}
	
	/**      * Random string with 0-9, not included special characters      */     
	protected String randomNumeric(int numberOfCharactor) {  
		final String STRING_NUMERIC = "0123456789"; 
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numberOfCharactor; i++) { 
			int number = randomNumber(0, STRING_NUMERIC.length() - 1);            
			char ch = STRING_NUMERIC.charAt(number);             
			sb.append(ch);         
		}         
		return sb.toString();     
	}
	 
}
