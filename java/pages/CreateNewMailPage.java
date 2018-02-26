package pages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utils;

public class CreateNewMailPage extends AbstractPage {
	
	private final String BASE_URL = "http://www.mail.ru";

	@FindBy(xpath = "//*[contains(@id,'composeForm')]/div[1]/div/div[3]/div[1]/div/div/div[2]/div/div/div/textarea[2]")
	private WebElement inputToName;

	@FindBy(name = "Subject")
	private WebElement inputSubjectName;
	
	@FindBy(xpath = "//iframe[contains(@id,'composeEditor_ifr')]")
	private WebElement frame;
	
	@FindBy(id = "tinymce")
	private WebElement messageBodyName;

	@FindBy(xpath = "//*[@id=\\\"b-toolbar__right\\\"]/div[3]/div/div[2]/div[1]/div")
	private WebElement butttonSend;

	public CreateNewMailPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public String createNewMail(String inputTo, String inputSubject, String messageBody)
	{
		String inputFullSubject = inputSubject + Utils.getRandomString(6);
		inputToName.sendKeys(inputTo);
		inputSubjectName.sendKeys(inputFullSubject);
		driver.switchTo().frame(frame);
		messageBodyName.sendKeys(messageBody);
		driver.switchTo().defaultContent();
		butttonSend.click();
		return inputFullSubject;
	}

	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
}

}
