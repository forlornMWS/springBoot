package xyz.mwszksnmdys.controller;

import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.mwszksnmdys.bean.Car;

//@Controller
//@ResponseBody
@RestController
@Slf4j
public class HelloController {
    @Autowired
    private Car car;

    @RequestMapping("/car")
    public Car car(){
        return car;
    }

    @RequestMapping("/hello2")
    public String handle01(){
        log.info("收到请求");
        return "hello, SpringBoot 2!!!";
    }
}
