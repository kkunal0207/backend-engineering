package com.hotel.booking.airbnb.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import javax.print.Doc;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String reason;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "patient_appointment", nullable = false)
    private PatientEntity patient;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "doctor_appointment",nullable = false)
    private DoctorEntity doctor;
}
