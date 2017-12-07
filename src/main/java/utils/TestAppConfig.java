package utils;

import org.openqa.selenium.WebDriver;

//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan({"com.my.package.first","com.my.package.second"})
@Configuration
public class TestAppConfig {
	@Bean
	    public WebDriver driver() {
//			return new InternetExplorerDriver();
			return new FirefoxDriver();
//	        return new ChromeDriver();
	    }
	
	@Bean
    public String systemPropertyKey() {
//		return "webdriver.ie.driver";
		return "webdriver.gecko.driver";
//		return "webdriver.chrome.driver";

    }
	
	@Bean
    public String systemPropertyValue() {
//		return "iedriverserver.exe";
		return "geckodriver.exe";
//		return "chromedriver.exe";
    }
}
