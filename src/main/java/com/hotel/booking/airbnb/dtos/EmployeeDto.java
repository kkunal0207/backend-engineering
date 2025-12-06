package com.hotel.booking.airbnb.dtos;

import java.time.LocalDate;

public class EmployeeDto {

    Long employeeId;
    String name;
    String emailId;
    int age;
    LocalDate doj;
    boolean isActive;

    public EmployeeDto(){

    }

    public EmployeeDto(Long employeeId, String name, String emailId, int age, LocalDate doj, boolean isActive) {
        this.employeeId = employeeId;
        this.name = name;
        this.emailId = emailId;
        this.age = age;
        this.doj = doj;
        this.isActive = isActive;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDoj() {
        return doj;
    }

    public void setDoj(LocalDate doj) {
        this.doj = doj;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
