package xyz.mwszksnmdys.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import sun.plugin.dom.DOMObjectHelper;
import xyz.mwszksnmdys.bean.Car;
import xyz.mwszksnmdys.bean.Pet;
import xyz.mwszksnmdys.bean.User;

// 告诉SpringBoot这是一个配置类
// 配置类本身也是一个组件
@Configuration(proxyBeanMethods = true)
@Import({User.class, DOMObjectHelper.class}) // 在容器中自动创建指定类型的组件,默认组件的名字就是全类名
@ImportResource("classpath:bean.xml")  // 导入Spring的配置文件
@EnableConfigurationProperties(Car.class) // 开启指定类的配置绑定功能，并把组件注册到容器中
public class MyConfig {

// 外部无论对配置类中的组件注册方法调用多少次，获取到的都是之前容器中注册的单实例对象
    @Bean   // 给容器中添加组件， 以方法名作为组件的id， 默认是单实例的
//    @ConditionalOnBean(name = {"tomcatPet"})
    @ConditionalOnMissingBean(name = {"tomcatPet"})
    public User user01(){
        return new User("李四", 23);
    }

//    @Bean
    public Pet tomcatPet(){
        return new Pet("tomcat");
    }
}
