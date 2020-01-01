package com.heshi.webservice.service.impl;

import com.heshi.webservice.service.IWebServiceDemoService;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service
@WebService(serviceName = "iWebServiceDemoService", targetNamespace = "https://github.com/publisherfk",
        endpointInterface = "com.heshi.webservice.service.IWebServiceDemoService")
public class WebServiceDemoServiceImpl implements IWebServiceDemoService {
    @Override
    public String hello(String name) {
        return "hello" + name;
    }
}
