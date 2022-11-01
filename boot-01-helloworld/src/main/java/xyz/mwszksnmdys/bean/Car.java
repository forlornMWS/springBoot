package xyz.mwszksnmdys.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@Component
@Data  // get, set
@ToString // tostring
@AllArgsConstructor // 有参构造
@NoArgsConstructor // 无参构造
@ConfigurationProperties("mycar")
public class Car {
    private String brand;
    private Integer price;
}
