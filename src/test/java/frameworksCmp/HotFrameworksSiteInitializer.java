package frameworksCmp;

import org.testng.annotations.BeforeMethod;

import frameworksCmp.beans.HotFrameworksApi;
import frameworksCmp.pageObjects.Table;
import initClasses.TestInitializer;

public class HotFrameworksSiteInitializer extends TestInitializer {
	protected HotFrameworksApi hotFrameworksApi;
	
	protected Table table;


	@BeforeMethod
	public void beforeJdiSiteTest() {
		hotFrameworksApi = (HotFrameworksApi) appCon.getBean("hotframeworskapi");
		table = new Table(driver);
	}
}
