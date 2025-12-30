package com.hotel.booking.airbnb.services;

import com.hotel.booking.airbnb.entities.InsuranceEntity;
import com.hotel.booking.airbnb.entities.PatientEntity;
import com.hotel.booking.airbnb.repositories.IInusranceRepository;
import com.hotel.booking.airbnb.repositories.IPatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    @Autowired
    private IInusranceRepository inusranceRepository;
    @Autowired
    private IPatientRepository patientRepository;

    InsuranceService(IPatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    @Transactional
    public InsuranceEntity saveInsuranceForPatient(InsuranceEntity insurance, Long patientId){
        PatientEntity patientDetails = patientRepository.findById(patientId).orElseThrow();
        patientDetails.setInsurance(insurance);
        insurance.setPatient(patientDetails);
        return insurance;
    }

    public void deletePatienceInsurance(Long patienceId){
        patientRepository.findById(patienceId).orElseThrow();
        patientRepository.deleteById(patienceId);
    }
}
