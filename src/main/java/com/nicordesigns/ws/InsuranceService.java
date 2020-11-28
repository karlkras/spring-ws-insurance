package com.nicordesigns.ws;

import com.nicordesigns.spring_ws_insurance.InsuranceRequest;
import com.nicordesigns.spring_ws_insurance.InsuranceResponse;

public interface InsuranceService {
    void writeInsuranceApplication(InsuranceRequest insuranceRequest);

    InsuranceResponse processInsuranceApplication(InsuranceRequest insuranceRequest);
}
