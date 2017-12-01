package jdiTestSite.simpleTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import jdiTestSite.beans.UserBean;
import jdiTestSite.beans.WebDriverBean;
import jdiTestSite.beans.pageObjects.ContactFormPageBean;
import jdiTestSite.beans.pageObjects.HomePageBean;
import jdiTestSite.pageObjects.ContactForm;
import jdiTestSite.pageObjects.Header;
import jdiTestSite.pageObjects.Log;

public class TestInitializer {
	protected HomePageBean homePage;
	protected ContactFormPageBean contactFormPage;
	protected UserBean user;
	protected Header header;
	protected ContactForm contactForm;
	protected Log log;

	private WebDriver driver;
	private ClassPathXmlApplicationContext appCon;

	@BeforeMethod
	public void before() {
		appCon = new ClassPathXmlApplicationContext("jdiTestSite/applicationContext.xml");
		WebDriverBean driverFactory = (WebDriverBean) appCon.getBean("webdriverbean");
		driver = driverFactory.getWebDriver();
		System.setProperty(driverFactory.getSystemPropertyKey(), driverFactory.getSystemPropertyValue());

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		homePage = (HomePageBean) appCon.getBean("homepage");
		contactFormPage = (ContactFormPageBean) appCon.getBean("contformpage");
		user = (UserBean) appCon.getBean("user");

		header = new Header(driver);
		contactForm = new ContactForm(driver);
		log = new Log(driver);
	}

	@AfterMethod
	public void after() {
		appCon.close();
		driver.close();
	}

	protected void naigateToApiUrl(String apiUrl) {
		driver.navigate().to(apiUrl);
	}

	protected String getPageTitle() {
		return driver.getTitle();
	}
}
