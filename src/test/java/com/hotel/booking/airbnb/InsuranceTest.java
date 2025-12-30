package com.hotel.booking.airbnb;

import com.hotel.booking.airbnb.entities.AppointmentEntity;
import com.hotel.booking.airbnb.entities.InsuranceEntity;
import com.hotel.booking.airbnb.services.AppointmentService;
import com.hotel.booking.airbnb.services.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void savePatientDetails(){
        InsuranceEntity entity = InsuranceEntity.builder()
            .provider("HDFC Ergo")
            .policyNumber("12356").validUntil(LocalDate.of(2030,11,11))
        .build();

        var savedInsurance = insuranceService.saveInsuranceForPatient(entity,3L);
        System.out.println(savedInsurance);
    }



    @Test
    public void saveAppointment(){
        AppointmentEntity entity = AppointmentEntity.builder()
            .appointmentTime(LocalDateTime.of(2023, 12, 3, 12, 30))
            .reason("Fever")
            .build();


        var updatedAppointment = appointmentService.saveAppointment(entity,2L,2L);
        System.out.println(updatedAppointment);

        insuranceService.deletePatienceInsurance(2L);
    }

}
