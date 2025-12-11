package com.hotel.booking.airbnb.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    Long employeeId;

    @NotNull(message = "Name cannot be null")
    String name;

    @JsonProperty("emailId")
    @JsonAlias({"email", "emailId"})
    String emailId;
    int age;
    LocalDate doj;
    @JsonProperty("isActive")
    @JsonAlias({"isActive", "active"})
    boolean active;

}
