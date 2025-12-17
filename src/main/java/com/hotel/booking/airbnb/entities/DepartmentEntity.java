package com.hotel.booking.airbnb.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.print.Doc;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String departmentName;

    @OneToOne
    @JoinColumn(name = "headDoctor",nullable = false)
    private DoctorEntity headDoctor;

    @ManyToMany
    private Set<DoctorEntity> doctorEntities = new HashSet<>();
}
