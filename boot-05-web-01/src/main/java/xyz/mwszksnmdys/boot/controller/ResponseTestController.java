package xyz.mwszksnmdys.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.mwszksnmdys.boot.bean.Person;
import xyz.mwszksnmdys.boot.bean.Pet;

import java.util.Date;

@Controller
public class ResponseTestController {

    @GetMapping("/test/person")
    @ResponseBody
    public Person getPerson(){
        Person person = new Person();
        person.setAge(12);
        person.setBirth(new Date());
        person.setUserName("名字");
        person.setPet(new Pet("小黑", 2));
        return person;
    }
}
