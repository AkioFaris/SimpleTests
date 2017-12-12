package jdiTestSite;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SimpleTest extends JdiSiteInitializer {

	@Test
	public void verifyLoginAndContactSubmitting() {
		SoftAssert soft = new SoftAssert();
		String firstName = "Stefani";
		String lastName = "Nkodia";

		/* Open test site by URL */
		naigateToApiUrl(jdiTestSiteUrl);

		/* Assert Browser title */
		soft.assertEquals(getPageTitle(), homePageTitle);

		/* Perform login */
		header.loginForm.login(userLogin, userPass);

		/* Assert User name in the left-top side of screen that user is logged in */
		soft.assertTrue(header.loginForm.profile.isDisplayed());

        header.loginForm.verifyUserName(userName);

		/* Open Contact form */
		header.openContactFormPage();

		/* Assert Browser title */
		soft.assertEquals(getPageTitle(), contactFormPageTitle);

		/* Input first and last name in text fields and click submit button */
		persInfoForm.submitFullName(firstName, lastName);

		/*
		 * Assert that in the log section a new raw has displayed which contains text
		 * "submit"
		 */
		Assert.assertTrue(rightSect.logContains(contFormPage.submitLog, "clicked"));
		soft.assertAll();
	}
}
