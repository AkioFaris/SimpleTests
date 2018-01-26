package jdiTestSite.sikuli;

import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import jdiTestSite.JdiSiteInitializer;

public class ContactFormTest extends JdiSiteInitializer {
	final Logger logger = LoggerFactory.getLogger(this.getClass());

	@BeforeMethod
	public void testPreparation() {
		/* Open test site by URL */
		naigateToApiUrl(jdiTestSiteUrl);

		Assert.assertTrue(header.loginForm.caret.isDisplayed());

		/* Perform login */
		header.loginForm.login(userLogin, userPass);

		Assert.assertTrue(header.contactFormBtn.isDisplayed());

		/* Open Contact form */
		header.openContactFormPage();

		Assert.assertTrue(rightSect.logPanel.isDisplayed());
		Assert.assertTrue(rightSect.resultPanel.isDisplayed());
	}

	@Test
	public void verifyEvenOddSum() throws FindFailed {
		/*
		 * Select 6th radio button and click "submit" (1st radio is selected by default)
		 */
		Screen scr = new Screen();
		String className = this.getClass().getCanonicalName();
		logger.info(className);

		scr.setAutoWaitTimeout(Settings.FOREVER);
		ImagePath.add(className + "/sikuli_images");

		Region reg = scr.wait("summary_header.png").below(65);
		reg.wait("6th.png", Settings.FOREVER).click();
		scr.wait("submit_btn.png").click();

		/* Check the result */
		Assert.assertNotNull(scr.exists("res_sum7.png"));
	}
}
