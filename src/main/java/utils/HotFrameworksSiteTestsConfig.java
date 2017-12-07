package utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan({"com.my.package.first","com.my.package.second"})
@Configuration
public class HotFrameworksSiteTestsConfig {
	@Bean
    public String HotFrameworksUrl() {
		return "https://hotframeworks.com/";
    }
}
