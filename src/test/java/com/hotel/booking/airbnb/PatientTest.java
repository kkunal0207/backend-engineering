package com.hotel.booking.airbnb;

import com.hotel.booking.airbnb.dtos.BloodGroupStats;
import com.hotel.booking.airbnb.dtos.CPatientInfo;
import com.hotel.booking.airbnb.dtos.IPatientInfo;
import com.hotel.booking.airbnb.entities.PatientEntity;
import com.hotel.booking.airbnb.entities.type.BloodGroupType;
import com.hotel.booking.airbnb.repositories.IPatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTest {

    @Autowired
    private IPatientRepository patientRepository;

    @Test
    void findAllPatient() {
        List<PatientEntity> patientsList = patientRepository.findAll();

        for (PatientEntity p : patientsList) {
            System.out.println(p);
        }
    }

    @Test
    void findPatientInfo(){
        List<IPatientInfo> patientInfo = patientRepository.findByPatientInfo();

        for(IPatientInfo p : patientInfo){
            System.out.println(p);
        }
    }

    @Test
    void findPatientsByConcreteClass(){
        List<CPatientInfo> patientInfo = patientRepository.findByPatiendInfoConcrete();

        for(CPatientInfo p : patientInfo){
            System.out.println(p);
        }
    }

    @Test
    void findPatientsBloodGroupStats(){
        List<BloodGroupStats> bloodGroupStats = patientRepository.findCountsByBloodGroup();

        for(BloodGroupStats bgs : bloodGroupStats){
            System.out.println(bgs);
        }
    }

    @Test
    void updatePatientName(){
        int updateName = patientRepository.updatePatientsName("Shivam",1L);
        System.out.println(updateName);
    }
}
