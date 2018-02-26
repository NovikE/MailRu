package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckSentMailPage extends AbstractPage{
	
	private final String BASE_URL = "https://mail.ru/";
	
	@FindBy(xpath = "//div[@id='b-letters']/div/div[2]/div/div[2]/div/div/a/div[4]/div[3]/div/div")
	private WebElement buttonSent;
	
	@FindBy(className = "b-letter__head__addrs__from")
	private WebElement messageFromName;

	@FindBy(className = "b-letter__head__subj__text")
	private WebElement subjectName;

	public CheckSentMailPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	public String checkSentMail() {
		
		String fullSubject = subjectName.getText();
		return fullSubject;
	}
	
	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
}

}
