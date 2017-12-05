package initClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.beans.WebDriverBean;

public class TestInitializer {
	protected WebDriver driver;
	protected ClassPathXmlApplicationContext appCon;

	@BeforeMethod
	public void before() {
		appCon = new ClassPathXmlApplicationContext("applicationContext.xml");
		WebDriverBean driverFactory = (WebDriverBean) appCon.getBean("webdriverbean");
		driver = driverFactory.getWebDriver();
		System.setProperty(driverFactory.getSystemPropertyKey(), driverFactory.getSystemPropertyValue());

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void after() {
		appCon.close();
		driver.close();
	}

	protected void naigateToApiUrl(String apiUrl) {
		driver.navigate().to(apiUrl);
	}

	protected String getPageTitle() {
		return driver.getTitle();
	}
}
