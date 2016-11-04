package com.company;



import java.sql.ResultSet;
import java.util.ArrayList;

public class CustomerInformationService {

    DatabaseConnection databaseConnection;
    CustomerInformation customerInformation;

    public ArrayList<CustomerInformation> CustomerList;
    ResultSet rs;

    public CustomerInformationService(){
        CustomerList = new ArrayList<>();
        try{
            databaseConnection = new DatabaseConnection();
            String query = "select name, address, mobile_no, email, entry_date, leave_date from customer_info";
            rs = databaseConnection.selectQuery(query);
            while(rs.next())//work until customerlsit next data null
            {
                CustomerList.add(new CustomerInformation(rs.getString("name"), rs.getString("address"), rs.getInt("mobile_no"), rs.getString("email"), rs.getDate("entry_date").toLocalDate(), rs.getDate("leave_date").toLocalDate()));
            }
        }
        catch(Exception ex){}
    }

    public ArrayList<CustomerInformation> getAll(){
        return CustomerList;
    }
}
