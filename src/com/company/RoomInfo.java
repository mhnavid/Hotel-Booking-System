package com.company;


public class RoomInfo {
    private int roomNo;
    private String roomType;
    private String status;

    public RoomInfo() {
    }

    public RoomInfo(int roomNo, String roomType, String status) {
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.status = status;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = this.status;
    }
}

