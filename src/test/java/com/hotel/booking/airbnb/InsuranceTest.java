package com.hotel.booking.airbnb;

import com.hotel.booking.airbnb.entities.InsuranceEntity;
import com.hotel.booking.airbnb.services.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Test
    public void savePatientDetails(){
        InsuranceEntity entity = InsuranceEntity.builder()
            .provider("HDFC Ergo")
            .policyNumber("12356").validUntil(LocalDate.of(2030,11,11))
        .build();

        var savedInsurance = insuranceService.saveInsuranceForPatient(entity,3L);
        System.out.println(savedInsurance);

    }
}
