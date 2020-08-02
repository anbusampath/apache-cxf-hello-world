package io.anbu.cxf.demo.ws.service;

import java.util.logging.Logger;

import io.anbu.cxf.demo.ws.api.Hello;

@javax.jws.WebService(serviceName = "HelloService", portName = "HelloPort",
                    targetNamespace = "http://service.ws.sample/",
                    endpointInterface = "io.anbu.cxf.demo.ws.api.Hello")
public class HelloPortImpl implements Hello {

    private static final Logger log = Logger.getLogger(HelloPortImpl.class.getName());

    public java.lang.String sayHello(java.lang.String myname) {
        log.info("Executing operation sayHello : "+ myname);
        try {
            return "Hello " + myname + "!!!" + ", Welcome to CXF Spring boot ";

        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}

