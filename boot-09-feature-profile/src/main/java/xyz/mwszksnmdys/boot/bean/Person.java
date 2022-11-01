package xyz.mwszksnmdys.boot.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties("person")
public class Person {

    private String username;
    private String password;
}
