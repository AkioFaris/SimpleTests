package phpFrameworksCmp;

import org.testng.annotations.Test;

public class TableTest extends SocialcmpSiteInitializer {

	@Test
	public void verifyLoginAndContactSubmitting() {
		String apiUrl = "https://socialcompare.com/en/comparison/php-frameworks-comparison";

		/* Open test site by URL */
		naigateToApiUrl(socialcmpApi.url);
	}
}
