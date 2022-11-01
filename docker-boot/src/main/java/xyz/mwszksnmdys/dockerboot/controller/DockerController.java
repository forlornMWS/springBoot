package xyz.mwszksnmdys.dockerboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class DockerController {

    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/docker/msg")
    public String message1(){
        return "hello, server port = " + serverPort + " " + UUID.randomUUID().toString();
    }
}
