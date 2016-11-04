package com.company;



import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CheckoutService{

    Checkout checkout;
    DatabaseConnection databaseConnection;
    public ArrayList<Checkout> RoomList;//java default arraylist


    ResultSet rs;

    public CheckoutService(){
        RoomList = new ArrayList<>();
        try{
            databaseConnection = new DatabaseConnection();
            String query = "select room_no, name from customer_info where room_no <> 0";
            rs = databaseConnection.selectQuery(query);
            while(rs.next()){
                RoomList.add(new Checkout(rs.getInt("room_no"), rs.getString("name")));
            }// room listei new checkout add
        }
        catch(Exception ex){}
    }

    public void checkoutByRoom(int no){
        try{
            databaseConnection = new DatabaseConnection();
            String query1 = "UPDATE room_info SET status = 'empty' where room_no = '" + no + "'";
            String query2 = "UPDATE customer_info SET room_no = 0 where room_no = '" + no + "'";
            databaseConnection.updateQuery(query1);
            databaseConnection.updateQuery(query2);
        }
        catch(Exception e){
        }
    }

    public ArrayList<Checkout> getAll(){
        return RoomList;
    }
}
