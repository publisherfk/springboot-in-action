package com.heshi.webservice.config;

import com.heshi.webservice.service.IWebServiceDemoService;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class WebServiceConfig {
    @Autowired
    private IWebServiceDemoService iWebServiceDemoService;

    @Bean
    public ServletRegistrationBean cxfServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/webservice/*");
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public Endpoint sweptEndpoint() {
        EndpointImpl endpointImpl = new EndpointImpl(springBus(), iWebServiceDemoService);
        endpointImpl.publish("/webservice");
        return endpointImpl;
    }
}
