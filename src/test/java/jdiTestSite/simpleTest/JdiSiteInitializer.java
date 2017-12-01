package jdiTestSite.simpleTest;

import org.testng.annotations.BeforeMethod;

import initClasses.TestInitializer;
import jdiTestSite.beans.JdiApi;
import jdiTestSite.beans.UserBean;
import jdiTestSite.beans.pageObjects.ContactFormPageBean;
import jdiTestSite.beans.pageObjects.HomePageBean;
import jdiTestSite.pageObjects.ContactForm;
import jdiTestSite.pageObjects.Header;
import jdiTestSite.pageObjects.Log;

public class JdiSiteInitializer extends TestInitializer {
	protected JdiApi jdiApi;
	protected HomePageBean homePage;
	protected ContactFormPageBean contactFormPage;
	protected UserBean user;
	protected Header header;
	protected ContactForm contactForm;
	protected Log log;

	@BeforeMethod
	public void beforeJdiSiteTest() {
		jdiApi = (JdiApi) appCon.getBean("jdiapi");
		homePage = (HomePageBean) appCon.getBean("homepage");
		contactFormPage = (ContactFormPageBean) appCon.getBean("contformpage");
		user = (UserBean) appCon.getBean("user");

		header = new Header(driver);
		contactForm = new ContactForm(driver);
		log = new Log(driver);
	}
}
