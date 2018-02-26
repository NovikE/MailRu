package by.htp.mailru;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import steps.Steps;

public class MailRuAutomationTest {
	
	private Steps steps;
	private final String USERNAME = "tathtp";
	private final String PASSWORD = "Klopik123";

	@BeforeMethod(description = "Init browser")
	public void setUp()
	{
		steps = new Steps();
		steps.initBrowser();
	}

	@Test
	public void oneCanCreateProject()
	{
		steps.loginMailru(USERNAME, PASSWORD);
		Assert.assertTrue(steps.createNewMail("tathtp@mail.ru", "mail from Elena", "Hello, wolrd!"));
			
	}

	@Test(description = "Login to Mail.ru")
	public void oneCanLoginGithub()
	{
		steps.loginMailru(USERNAME, PASSWORD);
		Assert.assertTrue(steps.isLoggedIn(USERNAME));
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser()
	{
		steps.closeDriver();
}

}
