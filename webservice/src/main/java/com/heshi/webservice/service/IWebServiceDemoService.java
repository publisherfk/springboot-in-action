package com.heshi.webservice.service;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface IWebServiceDemoService {
    String hello(@WebParam(name = "name") String name);
}
