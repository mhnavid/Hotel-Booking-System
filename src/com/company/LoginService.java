package com.company;




import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService{

    private DatabaseConnection databaseConnection;
    AdminInfo admin;
    ResultSet rs;

    public LoginService() {
        databaseConnection = new DatabaseConnection();
    }

    public int loginCheck(String u, String p){
        admin = new AdminInfo(u, p);
        String query = "SELECT bool from admin where username = '"+admin.getUsername()+"' AND password = '"+admin.getPassword()+"'";
        try {
            ResultSet rs = databaseConnection.selectQuery(query);
            if (rs.next()) {
                int a = rs.getInt("bool");
                if (a == 1) {
                    return 1;// these value goes to database admin table and match for admin
                }
                else if(a == 2){
                    return 2;//admin1
                }
                else {
                    return 0;//not match
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
