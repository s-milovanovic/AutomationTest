package stepDefinitions;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Resources.BasePage;
import igameproject.mavenjava.LandingPage;
import igameproject.mavenjava.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//@RunWith(Cucumber.class)
public class StepDefinition extends BasePage {

	private WebDriver driver;
	@Before
	public void setup() throws Throwable {
		driver = initializeDriver();
		driver.manage().window().maximize();
	}
	
    @Given("^User opens \"([^\"]*)\" site$")
    public void user_opens_something_site(String url) throws Throwable {
    	driver.get(url);
    	LandingPage lp = new LandingPage(driver);
    	String logoText = lp.GetHeadingText().getText();
		Assert.assertEquals(logoText, "By Players, For Players");
    }

    @When("^User enters the following username and password$")
    public void user_enters_the_following_username_and_password(DataTable table) throws Throwable {
    	String username = null;
    	String password = null;
    	Map<String, String> dataList = table.asMap(String.class, String.class);
    	for(String key : dataList.keySet()) {
    		username = key;
    		password = dataList.get(key);
    	}
    	LandingPage lp = new LandingPage(driver);
    	if (!lp.GetEmailInputField().getAttribute("value").isEmpty() 
				|| !lp.GetPasswordInputField().getAttribute("value").isEmpty()) {
			lp.GetEmailInputField().clear();
			lp.GetEmailInputField().clear();
			}
    	lp.GetEmailInputField().sendKeys(username);
		lp.GetPasswordInputField().sendKeys(password);
    }
    
    @And("^Clicks on login submit button$")
    public void clicks_on_login_submit_button() throws Throwable {
    	LandingPage lp = new LandingPage(driver);
    	lp.GetLoginSubmitButton().click();
    }

    @Then("^Verify user is successfully logged in \"([^\"]*)\" and \"([^\"]*)\" is visible$")
    public void verify_user_is_successfully_logged_in_something_and_something_is_visible(String logged, String username_message) throws Throwable {
    	LoginPage lnPage = new LoginPage(driver);
    	
    	if (logged.equals("true")) {
			lnPage.GetVerifyButton().click();
			lnPage.GetAccountButton().click();
			String accountName = lnPage.GetAccountName().getText();
			Assert.assertEquals(accountName, username_message);
			//logout from the site
			lnPage.GetLogoutButton().click();
		}
		else if (logged.equals("false")) {
			String message = lnPage.GetwrongCredentialsMesageBar().getText();
			Assert.assertEquals(message, username_message);
		}

    }

	@After
	public void tearDown() {
		driver.close();
	}
}
