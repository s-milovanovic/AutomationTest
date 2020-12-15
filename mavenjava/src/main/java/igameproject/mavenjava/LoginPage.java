package igameproject.mavenjava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
//using page factory class
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "(//a[@data-testid=\"linkButtonExternal\"])[2]")
	WebElement verifyButton;
	@FindBy(xpath = "(//i[contains(@class, 'account')])[1]")
	WebElement accountButton;
	@FindBy(xpath = "(//div[@data-test-name='userInfoName'])[1]")
	WebElement accountName;
	@FindBy(xpath = "(//a[@data-track-category='Logout'])[1]")
	WebElement logoutSubmitButton;
	@FindBy(xpath = "//div[contains(@class, 'ServiceAdviceMessagestyle__Body-sc-15nyki1-6')]")
	WebElement wrongCredentialsMesageBar;
	

	public WebElement GetVerifyButton() {
		// TODO Auto-generated method stub
		return verifyButton;
	}

	public WebElement GetAccountButton() {
		// TODO Auto-generated method stub
		return accountButton;
	}

	public WebElement GetAccountName() {
		// TODO Auto-generated method stub
		return accountName;
	}
	public WebElement GetLogoutButton() {
		// TODO Auto-generated method stub
		return logoutSubmitButton;
	}
	public WebElement GetwrongCredentialsMesageBar() {
		// TODO Auto-generated method stub
		return wrongCredentialsMesageBar;
	}
	
}
