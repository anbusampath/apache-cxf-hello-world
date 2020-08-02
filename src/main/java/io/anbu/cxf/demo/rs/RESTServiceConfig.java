package io.anbu.cxf.demo.rs;

import java.util.Arrays;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.ext.logging.LoggingFeature;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.openapi.OpenApiFeature;
import org.apache.cxf.jaxrs.swagger.ui.SwaggerUiConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.anbu.cxf.demo.rs.service.HelloServiceImpl1;
import io.anbu.cxf.demo.rs.service.HelloServiceImpl2;

@Configuration
public class RESTServiceConfig {
	
	@Autowired
	private Bus bus;
	
	@Autowired
	HelloServiceImpl2 helloServiceImpl2; 
	 
	@Bean
    public Server rsServer() {
        JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
        endpoint.setBus(bus);
        //endpoint.setServiceBeans(Arrays.<Object>asList(new HelloServiceImpl1(), new HelloServiceImpl2()));
        endpoint.setServiceBeans(Arrays.<Object>asList(new HelloServiceImpl1(), helloServiceImpl2));
        endpoint.setAddress("/rest");
        endpoint.setFeatures(Arrays.asList(createOpenApiFeature(), new LoggingFeature()));
        return endpoint.create();
    }

    @Bean
    public OpenApiFeature createOpenApiFeature() {
        final OpenApiFeature openApiFeature = new OpenApiFeature();
        openApiFeature.setPrettyPrint(true);
        openApiFeature.setTitle("Spring Boot CXF REST Application");
        openApiFeature.setContactName("The Apache CXF team");
        openApiFeature.setDescription("This sample project demonstrates how to use CXF JAX-RS services"
                + " with Spring Boot. This demo has two JAX-RS class resources being"
                + " deployed in a single JAX-RS endpoint.");
        openApiFeature.setVersion("1.0.0");
        openApiFeature.setSwaggerUiConfig(
            new SwaggerUiConfig());
                //.url("/services/helloservice/openapi.json"));
        return openApiFeature;
    }

}
