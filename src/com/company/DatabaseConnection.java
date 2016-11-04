package com.company;


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {
    Statement stmt;
    private Connection con;
    private ResultSet result;

    public DatabaseConnection() {
        try {
            //load the driver class
            Class.forName("com.mysql.jdbc.Driver");
            //create  the connection object
            con = DriverManager.getConnection("jdbc:mysql://localhost/hotel_management", "root", "");
            stmt = con.createStatement();// create connection
        } catch (Exception ex) {
            ex.printStackTrace();
        }

		/*try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			stmt=con.createStatement();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}*/
    }

    public int updateQuery(String sql) throws SQLException {
        return stmt.executeUpdate(sql);// return 1== row count or set or 0 for nothing return
    }

    public ResultSet selectQuery(String sql) throws SQLException {
        return result = stmt.executeQuery(sql);// return result from database for the query
    }
}

