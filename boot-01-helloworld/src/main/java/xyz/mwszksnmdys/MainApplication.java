package xyz.mwszksnmdys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import xyz.mwszksnmdys.bean.User;
import xyz.mwszksnmdys.config.MyConfig;


// 这是一个SpringBoot应用，主程序类
//@SpringBootApplication(scanBasePackages={"xyz.mwszksnmdys.controller"})
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(value = {"xyz.mwszksnmdys.controller", "xyz.mwszksnmdys.config", "xyz.mwszksnmdys.bean"})
public class MainApplication {
    public static void main(String[] args) {
        // 返回Ioc容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        // 查看容器内的组件
//        String[] names = run.getBeanDefinitionNames();
//        for (String name : names) {
//            System.out.println(name);
//        }
//        // 从容器中获取组件
//        User user = (User)run.getBean("user01", User.class);
//        System.out.println(user);
//
//        MyConfig bean = run.getBean(MyConfig.class);
//        System.out.println(bean);
//
////        如果@Configuration(proxyBeanMethods = true)代理对象调用方法，SpringBoot总会在容器中检查是否存在该组件，保持组件的单实例
//        User user1 = bean.user01();
//        User user2 = bean.user01();
//        System.out.println(user1 == user2);
//
//        System.out.println("-------------------");
////        获取组件
//        String[] beanNames = run.getBeanNamesForType(User.class);
//        for(String beanName : beanNames)
//            System.out.println(beanName);
        boolean pet = run.containsBean("tomcatPet");
        System.out.println(pet);

        boolean user01 = run.containsBean("user01");
        System.out.println(user01);

        boolean userxml = run.containsBean("userxml");
        boolean petxml = run.containsBean("petxml");
        System.out.println("userxml: " + userxml);
        System.out.println("petxml: " + petxml);
    }
}
