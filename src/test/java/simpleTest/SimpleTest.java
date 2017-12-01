package simpleTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import beans.UserBean;
import beans.WebDriverBean;
import beans.pageObjects.ContactFormPageBean;
import beans.pageObjects.HomePageBean;
import pageObjects.ContactForm;
import pageObjects.Header;
import pageObjects.Log;

public class SimpleTest {
	private WebDriver driver;
	private ClassPathXmlApplicationContext appCon;

	@BeforeMethod
	public void before() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		appCon = new ClassPathXmlApplicationContext("applicationContext.xml");
		WebDriverBean driverFactory = (WebDriverBean) appCon.getBean("webdriverbean");
		driver = driverFactory.getWebDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void after() {
		appCon.close();
		driver.close();
	}

	@Test
	public void verifyLoginAndContactSubmitting() {
		String apiUrl = "https://jdi-framework.github.io/tests";
		String firstName = "Stefani";
		String lastName = "Nkodia";

		HomePageBean homePage = (HomePageBean) appCon.getBean("homepage");
		ContactFormPageBean contactFormPage = (ContactFormPageBean) appCon.getBean("contformpage");
		UserBean user = (UserBean) appCon.getBean("user");

		Header header = new Header(driver);
		ContactForm contactForm = new ContactForm(driver);
		Log log = new Log(driver);

		/* Open test site by URL */
		driver.navigate().to(apiUrl);

		/* Assert Browser title */
		Assert.assertEquals(driver.getTitle(), homePage.title);

		/* Perform login */
		header.loginForm.login(user.login, user.password);

		/* Assert User name in the left-top side of screen that user is logged in */
		header.loginForm.verifyUserName(user.name);

		/* Open Contact form */
		header.openContactFormPage();

		/* Assert Browser title */
		Assert.assertEquals(driver.getTitle(), contactFormPage.title);

		/* Input first and last name in text fields and click submit button */
		contactForm.submitFullName(firstName, lastName);

		/*
		 * Assert that in the log section a new raw has displayed which contains text
		 * "submit"
		 */
		log.verigyLogContains(("submit"));
	}
}
