package jdiTestSite.simpleTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.BeforeClass;

import initClasses.TestInitializer;
import jdiTestSite.User;
import jdiTestSite.pageObjects.ContactForm;
import jdiTestSite.pageObjects.Header;
import jdiTestSite.pageObjects.Log;
import utils.JdiTestSiteTestsConfig;

@ContextConfiguration(classes = JdiTestSiteTestsConfig.class)
public class JdiSiteInitializer extends TestInitializer {
	@Autowired
	protected String jdiTestSiteUrl;

	@Autowired
	protected String homePageTitle;

	@Autowired
	protected String contactFormPageTitle;

	@Autowired
	protected User user;

	protected Header header;
	protected ContactForm contactForm;
	protected Log log;

	@BeforeClass
	public void beforeJdiSiteTest() {
		header = new Header(driver);
		contactForm = new ContactForm(driver);
		log = new Log(driver);
	}
}
