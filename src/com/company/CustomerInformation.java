package com.company;


import java.time.LocalDate;

public class CustomerInformation {
    private String name;
    private String address;
    private int mobileNo;
    private String email;
    LocalDate entryDate;
    LocalDate leaveDate;

    public CustomerInformation() {
    }

    public CustomerInformation(String name, String address, int mobileNo, String email, LocalDate entryDate, LocalDate leaveDate) {
        this.name = name;
        this.address = address;
        this.mobileNo = mobileNo;
        this.email = email;
        this.entryDate = entryDate;
        this.leaveDate = leaveDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public LocalDate getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(LocalDate leaveDate) {
        this.leaveDate = leaveDate;
    }
}

