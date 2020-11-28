package com.nicordesigns.ws;

import com.nicordesigns.spring_ws_insurance.*;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Service
public class InsuranceServiceImpl implements InsuranceService {
    private static final SimpleDateFormat REQUESTED_DATE_FORMAT =
            new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public void writeInsuranceApplication(InsuranceRequest insuranceRequest) {
        System.out.println("Insurance Application : " + insuranceRequest);

        ApplicantType applicantType = insuranceRequest.getApplicant();
        System.out.printf("Insurance Applicant First Name %s%n",
                applicantType.getFirstName());
        System.out.printf("Insurance Applicant Last Name %s%n",
                applicantType.getLastName());
        System.out.printf("Insurance Applicant SSN %s%n",
                applicantType.getSSN());

        WidgetInfoType widgetInfoType = insuranceRequest.getWidgetInfo();
        System.out.printf("Widget Information Contract Number %s%n",
                widgetInfoType.getWgtContractNumber());
        System.out.printf("Widget Information Amount %s%n",
                widgetInfoType.getWgtAmount());

        InsuranceInfoType insuranceInfoType = insuranceRequest.getInsuranceInfo();
        System.out.printf("Insurance Information Coverage Option %s%n",
                insuranceInfoType.getCoverageOption());
        System.out.printf("Insurance Information Coverage Type %s%n",
                insuranceInfoType.getCoverageType());
        System.out.printf("Insurance Information Product %s%n",
                insuranceInfoType.getProduct());

    }

    @Override
    public InsuranceResponse processInsuranceApplication(InsuranceRequest insuranceRequest) {
        InsuranceResponse insuranceResponse = new InsuranceResponse();
        insuranceResponse.setOrderDate(InsuranceServiceImpl.getRequestDate());
        insuranceResponse.setConfirmationId("1");
        insuranceResponse.setAmount("500.00");

        return insuranceResponse;
    }

    private static String getRequestDate() {
        return InsuranceServiceImpl.REQUESTED_DATE_FORMAT.format(Calendar.getInstance().getTime());
    }
}
