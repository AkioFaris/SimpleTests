package initClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.TestAppConfig;

@ContextConfiguration(classes = { TestAppConfig.class })
//@Configuration
//@PropertySource("classpath:application.properties")
public class TestInitializer extends AbstractTestNGSpringContextTests {

	protected WebDriver driver;

	@Autowired
	private String systemPropertyKey;

	@Autowired
	private String systemPropertyValue;

	@Autowired
	private String driverClassName;

	@BeforeMethod
	public void before() {
		if (driverClassName != null) {
			Class<?> driverClass;
			try {
				driverClass = Class.forName(driverClassName);
				driver = (WebDriver) driverClass.newInstance();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		System.setProperty(systemPropertyKey, systemPropertyValue);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void after() {
		driver.quit();
	}

	protected void naigateToApiUrl(String apiUrl) {
		driver.navigate().to(apiUrl);
	}

	protected String getPageTitle() {
		return driver.getTitle();
	}
}
