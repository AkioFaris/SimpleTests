package utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan({ "com.my.package.first", "com.my.package.second" })
@Configuration
public class TestAppConfig {

	@Bean
	public String driverClassName() {
		// return "org.openqa.selenium.ie.InternetExplorerDriver";
		// return "org.openqa.selenium.firefox.FirefoxDriver";
		return "org.openqa.selenium.chrome.ChromeDriver";
	}

	@Bean
	public String systemPropertyKey() {
		// return "webdriver.ie.driver";
		// return "webdriver.gecko.driver";
		return "webdriver.chrome.driver";

	}

	@Bean
	public String systemPropertyValue() {
		// return "iedriverserver.exe";
		// return "geckodriver.exe";
		return "chromedriver.exe";
	}
}
