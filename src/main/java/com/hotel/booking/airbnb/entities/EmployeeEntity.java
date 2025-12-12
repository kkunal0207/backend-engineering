package com.hotel.booking.airbnb.entities;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;

    private String name;

    @JsonProperty("emailId")
    @JsonAlias({"email", "emailId"})
    private String emailId;
    private int age;
    private LocalDate doj;

    @JsonProperty("isActive")
    @JsonAlias({"isActive", "active"})
    private boolean active;

    private String role;
}
