package io.anbu.cxf.demo.ws.api;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import org.apache.cxf.feature.Features;

@WebService(targetNamespace = "http://service.ws.sample/", name = "Hello")
@Features(features = "org.apache.cxf.ext.logging.LoggingFeature")
public interface Hello {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "sayHello",
                    targetNamespace = "http://service.ws.sample/",
                    className = "sample.ws.service.SayHello")
    @WebMethod(action = "urn:SayHello")
    @ResponseWrapper(localName = "sayHelloResponse",
                     targetNamespace = "http://service.ws.sample/",
                     className = "sample.ws.service.SayHelloResponse")
    String sayHello(@WebParam(name = "myname", targetNamespace = "") String myname);
}