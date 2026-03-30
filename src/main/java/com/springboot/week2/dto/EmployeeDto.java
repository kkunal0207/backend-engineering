package com.springboot.week2.dto;


import java.time.LocalDate;

public class EmployeeDto {

    private Long id;
    private String name;
    private String emailId;

    private EmployeeDto(){

    }

    public EmployeeDto(Long id, String name, String emailId, LocalDate dateOfJoining, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.emailId = emailId;
        this.dateOfJoining = dateOfJoining;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    private LocalDate dateOfJoining;
    private Boolean isActive;
}