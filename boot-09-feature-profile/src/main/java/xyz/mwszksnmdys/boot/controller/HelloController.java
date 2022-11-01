package xyz.mwszksnmdys.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.mwszksnmdys.boot.bean.Person;

@RestController
public class HelloController {

    @Value("${person.name:李四}")
    private String name;

    @Autowired
    private Person person;

    @GetMapping("/")
    public Person hello(){
        return person;
    }
}
