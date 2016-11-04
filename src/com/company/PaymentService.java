package com.company;



import java.sql.ResultSet;

public class PaymentService {

    DatabaseConnection databaseConnection;
    Payment payment = new Payment();

    static double calculate;
    static double value;

    public PaymentService() {

    }

    public void insertPayment(int money){
        try{
            databaseConnection = new DatabaseConnection();
            payment = new Payment(money);

            String query = "INSERT into payment (room_no, advance) VALUES ('"+ payment.getRoomNo() +"', '"+ payment.getAdvance() +"')";
            databaseConnection.updateQuery(query);//inserting advance value
        }
        catch(Exception e){
        }
    }

    public void delete(){
        try{
            databaseConnection = new DatabaseConnection();
            String query = "DELETE FROM payment WHERE room_no = '" + payment.getRoomNo() + "'";
            databaseConnection.updateQuery(query);//after checkout delete the payment value
        }
        catch (Exception ex){

        }
    }

    public double getAdvance(){
        try{
            databaseConnection = new DatabaseConnection();
            String query = "select advance from payment where room_no = '"+ payment.getRoomNo() +"'";
            ResultSet rs = databaseConnection.selectQuery(query);
            while(rs.next()){
                value =rs.getDouble("advance");//collect the value and show advance money
            }

            return value;
        }
        catch (Exception ex){

        }
        return value;
    }

    public void setCalculateDue(double total){
        this.calculate = total - value;
    }//calculate the due value

    public double getCalculateDue(){
        return this.calculate;
    }//return the due to final payment class
}
