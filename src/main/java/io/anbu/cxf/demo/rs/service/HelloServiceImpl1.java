package io.anbu.cxf.demo.rs.service;

import io.anbu.cxf.demo.rs.api.HelloService;

public class HelloServiceImpl1 implements HelloService {

    public String sayHello(String a) {
        return "Hello " + a + ", Welcome to CXF RS Spring Boot World!!!";
    }
}