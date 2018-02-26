package steps;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import driver.DriverSingleton;
import pages.CheckSentMailPage;
import pages.CreateNewMailPage;
import pages.LoginPage;
import pages.MainPage;

public class Steps {
	
	private WebDriver driver;

	//private final Logger logger = LogManager.getRootLogger();

	public void initBrowser()
	{
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver()
	{
		DriverSingleton.closeDriver();
	}

	public void loginMailru(String username, String password)
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.login(username, password);
	}

	public boolean isLoggedIn(String username)
	{
		LoginPage loginPage = new LoginPage(driver);
		String actualUsername = loginPage.getLoggedInUserName().trim().toLowerCase();
		System.out.println("Actual username: " + actualUsername);	
		return actualUsername.equals(username);
	}

	public boolean createNewMail(String inputTo, String inputSubject, String messageBody)
	{
		MainPage mainPage = new MainPage(driver);
		mainPage.clickOnCreateNewMailButton();
		CreateNewMailPage createNewMailPage = new CreateNewMailPage(driver);
		CheckSentMailPage checkSentMailPage = new CheckSentMailPage(driver);
		String expectedSubject = createNewMailPage.createNewMail(inputTo, inputSubject, messageBody);
		return expectedSubject.equals(checkSentMailPage.checkSentMail());
	}

}
