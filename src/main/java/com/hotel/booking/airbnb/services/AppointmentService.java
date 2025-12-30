package com.hotel.booking.airbnb.services;

import com.hotel.booking.airbnb.entities.AppointmentEntity;
import com.hotel.booking.airbnb.entities.DoctorEntity;
import com.hotel.booking.airbnb.entities.PatientEntity;
import com.hotel.booking.airbnb.repositories.IAppointmentRepository;
import com.hotel.booking.airbnb.repositories.IDoctorRepository;
import com.hotel.booking.airbnb.repositories.IInusranceRepository;
import com.hotel.booking.airbnb.repositories.IPatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    @Autowired
    private IPatientRepository patientRepository;

    @Autowired
    private IAppointmentRepository appointmentRepository;

    @Autowired
    private IDoctorRepository doctorRepository;

    @Transactional
    public AppointmentEntity saveAppointment(AppointmentEntity appointment,Long patientId, Long doctorId){
        PatientEntity patientDetails = patientRepository.findById(patientId).orElseThrow();
        DoctorEntity doctorDetails=  doctorRepository.findById(doctorId).orElseThrow();

        appointment.setPatient(patientDetails);
        appointment.setDoctor(doctorDetails);
        return appointmentRepository.save(appointment);
    }

}
