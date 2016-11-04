package com.company;



import java.time.LocalDate;

public class BookingService{

    DatabaseConnection databaseConnection = new DatabaseConnection();
    CustomerInfo customerInfo = new CustomerInfo();
    static int no;

    public BookingService(){

    }

    public void addCustomer(String name, String address, int mobileNo, String email, LocalDate entryDate, LocalDate leaveDate, int roomNo){
        // customerinfo value comes
        try{
            customerInfo = new CustomerInfo(name, address, mobileNo, email, entryDate, leaveDate, roomNo);
            String query1 = "INSERT INTO Customer_info (name, address, mobile_no, email, entry_date, leave_date,room_no) VALUES ('"+customerInfo.getName()+"','"+customerInfo.getAddress()+"','"+customerInfo.getMobileNo()+"','"+customerInfo.getEmail()+"','"+customerInfo.getEntryDate()+"','"+customerInfo.getLeaveDate()+"','"+customerInfo.getRoomNo()+"')";
            databaseConnection.updateQuery(query1);
            String query2 = "UPDATE room_info SET status = 'full' where room_no = '" + customerInfo.getRoomNo() + "'";
            databaseConnection.updateQuery(query2);
        }
        catch(Exception e){}
    }

    public void setByRoomNo(int no){
        this.no = no;
    }

    public int getByRoomNo(){
        return this.no;
    }
}
