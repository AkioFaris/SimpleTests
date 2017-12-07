package frameworksCmp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.BeforeClass;

import frameworksCmp.pageObjects.Table;
import initClasses.TestInitializer;
import utils.HotFrameworksSiteTestsConfig;

@ContextConfiguration(classes = HotFrameworksSiteTestsConfig.class)
public class HotFrameworksSiteInitializer extends TestInitializer {
	@Autowired
	protected String HotFrameworksUrl;

	protected Table table;

	@BeforeClass
	public void beforeHotFrameworksSiteTest() {
		table = new Table(driver);
	}
}
