package com.hotel.booking.airbnb.entities;


import com.hotel.booking.airbnb.entities.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String gender;
    private LocalDate dateOfBirth;
    private String email;
    @Enumerated(value = EnumType.STRING)
    private BloodGroupType bloodGroup;
    @CreationTimestamp
    private LocalDateTime createdAt;
}
