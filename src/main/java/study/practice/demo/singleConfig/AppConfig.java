package study.practice.demo.singleConfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    @ConfigurationProperties(prefix = "config")
    public MyConfig myConfig() {
        return new MyConfig();
    }
}

