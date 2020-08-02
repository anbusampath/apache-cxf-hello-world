package io.anbu.cxf.demo.rs.client;

import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.client.spring.EnableJaxRsProxyClient;
import org.apache.cxf.jaxrs.client.spring.EnableJaxRsWebClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import io.anbu.cxf.demo.rs.api.HelloService;


//@SpringBootApplication
//@EnableJaxRsWebClient
//@EnableJaxRsProxyClient
public class SampleRestClientApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SampleRestClientApplication.class)
            .web(WebApplicationType.NONE)
            .run(args);
    }
    @Bean
    CommandLineRunner initWebClientRunner(final WebClient webClient) {

        return new CommandLineRunner() {

            @Override
            public void run(String... runArgs) throws Exception {
                System.out.println(webClient.path("sayHello/ApacheCxfWebClientUser").get(String.class));
            }
        };
    }
    @Bean
    CommandLineRunner initProxyClientRunner(final HelloService client) {

        return new CommandLineRunner() {

            @Override
            public void run(String... runArgs) throws Exception {
                System.out.println(client.sayHello("ApacheCxfProxyUser"));
            }
        };
    }
}
