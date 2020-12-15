package igameproject.mavenjava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By headingText = By.xpath("//*[@class='header-controls-heading']");
	By loginSubmitButton = By.xpath("(//button[@data-test-name='btn-login'])[1]");
	By emailInputField = By.xpath("(//input[@data-test-name='field-username'])[1]");
	By passwordInputField = By.xpath("(//input[@data-test-name='field-password'])[1]");
	
	public WebElement GetHeadingText() {
		return driver.findElement(headingText);
	}
	public WebElement GetEmailInputField() {
		return driver.findElement(emailInputField);
	}
	public WebElement GetPasswordInputField() {
		return driver.findElement(passwordInputField);
	}
	public WebElement GetLoginSubmitButton() {
		return driver.findElement(loginSubmitButton);
	}
}
