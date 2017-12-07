package jdiTestSite.simpleTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleTest extends JdiSiteInitializer {

	@Test
	public void verifyLoginAndContactSubmitting() {
		String firstName = "Stefani";
		String lastName = "Nkodia";

		/* Open test site by URL */
		naigateToApiUrl(jdiTestSiteUrl);

		/* Assert Browser title */
		Assert.assertEquals(getPageTitle(), homePageTitle);

		/* Perform login */
		header.loginForm.login(user.login, user.password);

		/* Assert User name in the left-top side of screen that user is logged in */
		header.loginForm.verifyUserName(user.name);

		/* Open Contact form */
		header.openContactFormPage();

		/* Assert Browser title */
		Assert.assertEquals(getPageTitle(), contactFormPageTitle);

		/* Input first and last name in text fields and click submit button */
		contactForm.submitFullName(firstName, lastName);

		/*
		 * Assert that in the log section a new raw has displayed which contains text
		 * "submit"
		 */
		log.verigyLogContains("submit");
	}
}
