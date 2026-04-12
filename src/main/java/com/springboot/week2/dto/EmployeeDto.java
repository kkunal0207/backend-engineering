package com.springboot.week2.dto;

import java.time.LocalDate;

public class EmployeeDto {


    private Integer id;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String name;
    private Integer age;
    private LocalDate dateOfJoining;
    private Boolean isActive;
    private String emailId;

    public EmployeeDto(String emailId, Boolean isActive, LocalDate dateOfJoining, Integer age, String name, Integer id) {
        this.emailId = emailId;
        this.isActive = isActive;
        this.dateOfJoining = dateOfJoining;
        this.age = age;
        this.name = name;
        this.id = id;
    }

    public EmployeeDto(){

    }
}
