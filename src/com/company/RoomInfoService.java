package com.company;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoomInfoService{

    public DatabaseConnection databaseConnection = new DatabaseConnection();
    ArrayList<RoomInfo> roomList;//

    ResultSet rs;

    public RoomInfoService(){
        this.roomList = new ArrayList<>();
        try{
            String query = "SELECT room_no, type, status FROM room_info";
            rs = databaseConnection.selectQuery(query);
            while(rs.next())//collect data until the next number is null
            {
                roomList.add(new RoomInfo(rs.getInt("room_no"), rs.getString("type"), rs.getString("status")));
            }
        }
        catch(Exception ex){}
    }


    public List<RoomInfo> getAll(){
        return roomList;
    }
}
