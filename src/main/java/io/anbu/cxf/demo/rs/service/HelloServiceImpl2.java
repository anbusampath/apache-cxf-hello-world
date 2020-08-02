package io.anbu.cxf.demo.rs.service;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.anbu.cxf.demo.WelcomeComponent;
import io.anbu.cxf.demo.rs.api.HelloService;

@Path("/sayHello2")
@Component
public class HelloServiceImpl2 implements HelloService {
	
	@Autowired
	WelcomeComponent welcomeComponent;

    public String sayHello(String a) {
        return "Hello2 " + a + "," + welcomeComponent.welcomeMessage() ;
    }
    
}