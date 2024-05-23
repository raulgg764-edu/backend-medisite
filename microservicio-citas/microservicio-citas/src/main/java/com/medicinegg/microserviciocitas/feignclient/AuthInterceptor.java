package com.medicinegg.microserviciocitas.feignclient;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthInterceptor implements RequestInterceptor {

    @Autowired HttpServletRequest request;
    @Override
    public void apply(RequestTemplate requestTemplate) {
        String reqAuthInput= request.getHeader("Authorization");
        if (reqAuthInput!= null) {
            requestTemplate.header("Authorization",reqAuthInput);
        }
        System.out.println("token:" + reqAuthInput);
    }

}