package igameproject.mavenjava;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.BasePage;
import Resources.ReadDataFromExcel;

public class HomePageTest extends BasePage {

	public WebDriver driver;

	@BeforeTest
	public void initialize() throws IOException {
		// Initialize driver
		driver = initializeDriver();
		// Go to Web site
		driver.manage().window().maximize();
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password) throws IOException {
		
		// Go to Web site
		driver.get(props.getProperty("url"));

		LandingPage lp = new LandingPage(driver);
		// Assert heading message is loaded
		System.out.println("Verifying if the heading message is loaded");
		String logoText = lp.GetHeadingText().getText();
		Assert.assertEquals(logoText, "By Players, For Players");

		// clear values from username and password fields is any;
		if (!lp.GetEmailInputField().getAttribute("value").isEmpty()
				|| !lp.GetPasswordInputField().getAttribute("value").isEmpty()) {
			lp.GetEmailInputField().clear();
			lp.GetEmailInputField().clear();
		}

		System.out.println("inserting username");
		System.out.println(String.format(
				"Inserting respective values for the fields \"Username\": \"%s\" and for \"Password\": \"%s\"",
				username, password));
		lp.GetEmailInputField().sendKeys(username);
		lp.GetPasswordInputField().sendKeys(password);
		// click on login button
		System.out.println("Clicking on login submit button");
		lp.GetLoginSubmitButton().click();
		// Assert user is logged in successfully
		System.out.println("Verifying if the user is successfully logged in");
		LoginPage lnPage = new LoginPage(driver);
		lnPage.GetVerifyButton().click();
		lnPage.GetAccountButton().click();
		String accountName = lnPage.GetAccountName().getText();
		Assert.assertEquals(accountName, "john doe");
		// logout from the site
		lnPage.GetLogoutButton().click();
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		/*
		 * return new Object[][] {{"Srdjan", "pass" , "some dummy text"},
		 * {"john.doe.igame@gmail.com", "pass", "some other dummy text"}};
		 */
		String file = System.getProperty("user.dir") + "//src//main//java//resources//Book.xlsx";
		ReadDataFromExcel rd = new ReadDataFromExcel();
		String[][] userData = rd.ReadExcelFile(file);
		// ArrayList<String> userData2 = rd.ReadExcelFile("User2");

		/*
		 * Object[][] data = new Object[2][2]; // 0th row data[0][0] =
		 * "srdjan";//userData1.get(1); data[0][1] = "pass";//userData1.get(2);
		 * 
		 * // 1st row data[1][0] = "john";//userData2.get(1); data[1][1] =
		 * "pass";//userData2.get(2);
		 * 
		 * return data;
		 */

		/*
		 * ReadDataFromExcel rd = new ReadDataFromExcel(); Object[][] data = new
		 * Object[2][2]; return data;
		 */

		return userData;
	}
}
