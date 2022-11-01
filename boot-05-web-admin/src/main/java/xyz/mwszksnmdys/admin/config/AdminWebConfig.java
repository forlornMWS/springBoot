package xyz.mwszksnmdys.admin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import xyz.mwszksnmdys.admin.interceptor.LoginInterceptor;
import xyz.mwszksnmdys.admin.interceptor.RedisUrlCountInterceptor;

@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    @Autowired
    RedisUrlCountInterceptor redisUrlCountInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/", "/login","/css/**", "/js/**", "/fonts/**","/images/**", "/actuator/**");
        registry.addInterceptor(redisUrlCountInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/css/**", "/js/**", "/fonts/**","/images/**");
    }
}
