package xyz.mwszksnmdys.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.mwszksnmdys.boot.bean.Person;

@RestController
public class HelloController {
    @Autowired
    Person person;

    @RequestMapping("/hello")
    public Person hello(){
        return person;
    }
}
