package io.anbu.cxf.demo.ws;

import java.util.Arrays;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.ext.logging.LoggingFeature;
import org.apache.cxf.ext.logging.LoggingInInterceptor;
import org.apache.cxf.ext.logging.LoggingOutInterceptor;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.anbu.cxf.demo.ws.service.HelloPortImpl;

@Configuration
public class WebServiceConfig {

    @Autowired
    private Bus bus;

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new HelloPortImpl());
        endpoint.publish("/Hello");
        //endpoint.getInInterceptors().add(new LoggingInInterceptor());
        //endpoint.getOutInterceptors().add((new LoggingOutInterceptor()));
        //endpoint.setFeatures(Arrays.asList(new LoggingFeature()));
        return endpoint;
    }
}