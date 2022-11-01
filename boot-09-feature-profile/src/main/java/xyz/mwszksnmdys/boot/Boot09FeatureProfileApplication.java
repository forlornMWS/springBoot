package xyz.mwszksnmdys.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

@SpringBootApplication
public class Boot09FeatureProfileApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Boot09FeatureProfileApplication.class, args);
        ConfigurableEnvironment environment = run.getEnvironment();
        Map<String, Object> systemProperties = environment.getSystemProperties();
        Map<String, Object> systemEnvironment = environment.getSystemEnvironment();
        System.out.println(systemProperties);
        System.out.println(systemEnvironment);
    }

}
