package xyz.mwszksnmdys.admin.actuator.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@Component
@Endpoint(id = "myservice")
public class MyServiceEndpoint {

    @ReadOperation
    public Map getDockerInfo(){
        return Collections.singletonMap("dockinfo", "docker started .... ");
    }

    @WriteOperation
    public void stopDocker(){
        System.out.println("docker stopped");
    }
}
