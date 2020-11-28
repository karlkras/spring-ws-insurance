package com.nicordesigns.ws;

import com.nicordesigns.spring_ws_insurance.InsuranceRequest;
import com.nicordesigns.spring_ws_insurance.InsuranceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class InsuranceWSEndpoint {
    private static final String NAMESPACE_URI =
            "http://www.nicordesigns.com/spring-ws-insurance";

    private final InsuranceService insuranceService;

    @Autowired
    public InsuranceWSEndpoint(InsuranceService insuranceService){
        this.insuranceService = insuranceService;
    }

    @SuppressWarnings("unused")
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "InsuranceRequest")
    @ResponsePayload
    public InsuranceResponse InsuranceApplication(
            @RequestPayload InsuranceRequest insuranceApplicationRequest) {
        if(insuranceApplicationRequest != null) {
            insuranceService.writeInsuranceApplication(insuranceApplicationRequest);
        }
        return insuranceService.processInsuranceApplication(insuranceApplicationRequest);
    }
}
