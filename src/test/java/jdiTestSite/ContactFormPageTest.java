package jdiTestSite;

import static jdiTestSite.enums.ContFormElem.DESCRIPT;
import static jdiTestSite.enums.ContFormElem.LASTNAME_LOG;
import static jdiTestSite.enums.ContFormElem.LASTNAME_RES;
import static jdiTestSite.enums.ContFormElem.NAME;
import static jdiTestSite.enums.ContFormElem.SUBMIT_LOG;
import static jdiTestSite.enums.ContFormElem.SUMMARY;
import static jdiTestSite.enums.EvenNumb.EIGHT;
import static jdiTestSite.enums.EvenNumb.TWO;
import static jdiTestSite.enums.OddNumb.FIVE;
import static jdiTestSite.enums.OddNumb.THREE;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import jdiTestSite.enums.EvenNumb;
import jdiTestSite.enums.OddNumb;

public class ContactFormPageTest extends JdiSiteInitializer {

	@BeforeMethod
	public void testPreparation() {
		/* Open test site by URL */
		naigateToApiUrl(jdiTestSiteUrl);

		Assert.assertTrue(header.loginForm.caretIsVisible());

		/* Perform login */
		header.loginForm.login(user.login, user.password);

		Assert.assertTrue(header.elementsAreVisible());

		/* Open Contact form */
		header.openContactFormPage();

		Assert.assertTrue(persInfoForm.elementsAreVisible());
	}

	@AfterMethod
	public void afterTest() {
		header.loginForm.logout();
	}

	@Test
	public void verifyPersonalInfoSubmitting() {
		String firstName = "Mahoko";
		String lastName = "Yoshimoto";
		String descr = "Also known as Banana Yoshimoto";

		Assert.assertTrue(persInfoForm.elementsAreVisible());

		/*
		 * Input first, last name and description in text fields without clicking the
		 * submit button
		 */
		persInfoForm.fill(firstName, lastName, descr);

		Assert.assertTrue(rightSect.logContains(NAME, firstName));
		Assert.assertTrue(rightSect.logContains(LASTNAME_LOG, lastName));
		Assert.assertTrue(rightSect.logContains(driver, DESCRIPT, descr));

		/* Input first, last name and description in text fields and click "submit" */
		persInfoForm.submit(firstName, lastName, descr);

		Assert.assertTrue(rightSect.logContains(SUBMIT_LOG, "clicked"));
		Assert.assertTrue(rightSect.resultContains(driver, NAME, firstName));
		Assert.assertTrue(rightSect.resultContains(LASTNAME_RES, lastName));
		Assert.assertTrue(rightSect.resultContains(DESCRIPT, descr));
	}

	@Test
	public void verifyEvenOddSum() {
		EvenNumb even = EIGHT;
		OddNumb odd = THREE;
		Integer sum = even.addOdd(odd);

		/* Select even and odd numbers radio buttons */
		evenOddForm.fill(TWO, FIVE);

		Assert.assertTrue(rightSect.logContains(driver, SUMMARY, TWO.number));
		Assert.assertTrue(rightSect.logContains(SUMMARY, FIVE.number));

		/* Select even and odd numbers radio buttons and click "calculate" */
		evenOddForm.submit(even, odd);

		Assert.assertTrue(rightSect.logContains(SUBMIT_LOG, "clicked"));
		Assert.assertTrue(rightSect.resultContains(SUMMARY, sum.toString()));
	}
}
