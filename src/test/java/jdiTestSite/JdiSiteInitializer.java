package jdiTestSite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.BeforeMethod;

import initClasses.TestInitializer;
import jdiTestSite.pageObjects.EvenOddForm;
import jdiTestSite.pageObjects.Header;
import jdiTestSite.pageObjects.PersonalInfoForm;
import jdiTestSite.pageObjects.RightSection;
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
	protected PersonalInfoForm persInfoForm;
	protected RightSection rightSect;
	protected EvenOddForm evenOddForm;

	@BeforeMethod
	public void beforeJdiSiteTest() {
		header = new Header(driver);
		persInfoForm = new PersonalInfoForm(driver);
		rightSect = new RightSection(driver);
		evenOddForm = new EvenOddForm(driver);
	}
}
