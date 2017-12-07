package initClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utils.TestAppConfig;
@ContextConfiguration(classes = {TestAppConfig.class})
public class TestInitializer extends AbstractTestNGSpringContextTests {
	@Autowired
	protected WebDriver driver;
	
	@Autowired
	private String systemPropertyKey;
	
	@Autowired
	private String systemPropertyValue;

	@BeforeClass
	public void before() {
		System.setProperty(systemPropertyKey, systemPropertyValue);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void after() {
		driver.close();
	}

	protected void naigateToApiUrl(String apiUrl) {
		driver.navigate().to(apiUrl);
	}

	protected String getPageTitle() {
		return driver.getTitle();
	}
}
