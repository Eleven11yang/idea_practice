package study.practice.demo.complexConfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    @ConfigurationProperties(prefix = "complex-config")
    public ComplexConfig complexConfig() {
        return new ComplexConfig();
    }
}
