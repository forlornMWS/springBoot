package xyz.mwszksnmdys.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import xyz.mwszksnmdys.hello.HelloProperties;

public class HelloService {

    @Autowired
    HelloProperties helloProperties;

    public String sayHello(String userName){
        return helloProperties.getPrefix() + ": " + userName + helloProperties.getSuffix();
    }
}
