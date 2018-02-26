package pages;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage{

	private final String BASE_URL = "https://mail.ru";

	@FindBy(id = "mailbox:login")
	private WebElement inputLogin;

	@FindBy(id = "mailbox:password")
	private WebElement inputPassword;

	@FindBy(id = "mailbox:submit")
	private WebElement buttonSubmit;

	@FindBy(id = "PH_user-email")
	private WebElement linkLoggedInUser;

	public LoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
		System.out.println("Login page opened");
	//	logger.info("Login page opened");
	}

	public void login(String username, String password)
	{
		inputLogin.sendKeys(username);
		inputPassword.sendKeys(password);
		buttonSubmit.click();
		System.out.println("Login performed");
	}

	public String getLoggedInUserName()
	{
		return linkLoggedInUser.getAttribute("content");
}
}
