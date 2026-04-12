package com.springboot.week2.dto;


import com.springboot.week2.validation.RoleValidator;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {


    private Integer id;

    @NotBlank(message = "Employee name cannot be blank")
    @Size(min = 3, max = 12,message = "Name size must be atleast 3 or at max 12")
    private String name;

    @NotNull
    @Min(value = 18,message = "Age must be greater or equal to 18")
    @Max(value = 80, message = "Age must be less then equal to 80")
    private Integer age;

    @NotBlank
//    @Pattern(regexp = "^(USER|ADMIN)$", flags = Pattern.Flag.CASE_INSENSITIVE)
    @RoleValidator
    private String username;
    private LocalDate dateOfJoining;
    private Boolean isActive;

    @Email
    private String emailId;

}
