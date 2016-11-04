package com.company;

/**
 * Created by Rabbinoor on 25/08/2016.
 */
import java.time.LocalDate;

public class CustomerInfo{
    private String name, address, email;
    private LocalDate entryDate, leaveDate;
    private int roomNo,mobileNo;

    public CustomerInfo(){

    }

    public CustomerInfo(String name, String address, int mobileNo, String email, LocalDate entryDate, LocalDate leaveDate, int roomNo) {
        setName(name);
        setAddress(address);
        setMobileNo(mobileNo);
        setEmail(email);
        setEntryDate(entryDate);
        setLeaveDate(leaveDate);
        setRoomNo(roomNo);
    }

    public void setName(String name){ this.name = name; }
    public void setAddress(String address){ this.address = address; }
    public void setMobileNo(int mobileNo){ this.mobileNo = mobileNo; }
    public void setEmail(String email){ this.email = email; }
    public void setEntryDate(LocalDate entryDate){ this.entryDate = entryDate; }
    public void setLeaveDate(LocalDate leaveDate){ this.leaveDate = leaveDate; }
    public void setRoomNo(int roomNo){ this.roomNo = roomNo; }

    public String getName(){ return this.name; }
    public String getAddress(){ return this.address; }
    public int getMobileNo(){ return this.mobileNo; }
    public String getEmail(){ return this.email; }
    public LocalDate getEntryDate(){ return this.entryDate; }
    public LocalDate getLeaveDate(){ return this.leaveDate; }
    public int getRoomNo(){ return this.roomNo; }
}