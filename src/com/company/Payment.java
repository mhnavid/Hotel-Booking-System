package com.company;



public class Payment {
    static int roomNo;
    private int advance;

    public Payment() {
    }

    public Payment(int advance) {
        this.advance = advance;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getAdvance() {
        return advance;
    }

    public void setAdvance(int advance) {
        this.advance = advance;
    }
}
