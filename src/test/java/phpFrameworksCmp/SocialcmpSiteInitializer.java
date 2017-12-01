package phpFrameworksCmp;

import org.testng.annotations.BeforeMethod;

import initClasses.TestInitializer;
import phpFrameworksCmp.beans.SocialcmpApi;

public class SocialcmpSiteInitializer extends TestInitializer {
	protected SocialcmpApi socialcmpApi;

	@BeforeMethod
	public void beforeJdiSiteTest() {
		socialcmpApi = (SocialcmpApi) appCon.getBean("socialcmpapi");
	}
}
