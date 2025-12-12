package com.hotel.booking.airbnb.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hotel.booking.airbnb.annotations.CustomAnnotationValidation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
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

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, max = 10, message = "Name should be of length 3 to 10")
    String name;

    @JsonProperty("emailId")
    @JsonAlias({"email", "emailId"})
    @Email(message = "Email Id should be valid")
    String emailId;

    @Min(value = 18, message = "Minimum age should be 18")
    @Max(value = 75, message = "Maximim age should be 75")
    int age;
    LocalDate doj;
    @JsonProperty("isActive")
    @JsonAlias({"isActive", "active"})
    boolean active;

    @CustomAnnotationValidation
    String role;

}
