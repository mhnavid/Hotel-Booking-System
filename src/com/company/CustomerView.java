package com.company;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CustomerView extends Application{

    private Group root;
    private Scene scene;
    private Stage stage;
    private Button submitButton, backButton;
    private Label customerNameLabel, mobileNoLabel, addressLabel, emailLabel, entryDateLabel, leaveDateLabel, roomNoLabel;
    private VBox vbox;
    private HBox hbox1, hbox2;
    private DatePicker entryDatePicker, leaveDatePicker;
    private TextField customerNameField, mobileNoField, addressField, emailField, roomNoField;
    private Separator firstSeparator, secondSeparator, thirdSeparator, fourthSeparator, fifthSeparator, sixthSeparator;
    private Text errorText;
    private Text errorText1;
    BookingService bookingService = new BookingService();
    Payment payment = new Payment();
    AdvancePaymentView advancePaymentView = new AdvancePaymentView();

    public void start(Stage stage) {
        Text mainText = new Text();
        mainText.setText("Customer Entry Form");
        mainText.setFill( Color.web( "#F1F2F6" ) );//white
        mainText.setFont( Font.font("", FontWeight.BOLD, 16));

        firstSeparator = new Separator();//underline after customer entery

        customerNameLabel = new Label("Customer Name:");
        customerNameLabel.setTextFill( Color.web( "#F1F2F6" ) );
        customerNameLabel.setFont( Font.font("", FontWeight.BOLD, 13));

        customerNameField = new TextField();

        secondSeparator = new Separator();

        mobileNoLabel = new Label("Mobile No:");
        mobileNoLabel.setTextFill( Color.web( "#F1F2F6" ) );
        mobileNoLabel.setFont( Font.font("", FontWeight.BOLD, 13));

        mobileNoField = new TextField();

        thirdSeparator = new Separator();

        addressLabel = new Label("Address:");
        addressLabel.setTextFill( Color.web( "#F1F2F6" ) );
        addressLabel.setFont( Font.font("", FontWeight.BOLD, 13));

        addressField = new TextField();

        fourthSeparator = new Separator();

        emailLabel = new Label("Email:");
        emailLabel.setTextFill( Color.web( "#F1F2F6" ) );
        emailLabel.setFont( Font.font("", FontWeight.BOLD, 13));

        emailField = new TextField();

        fifthSeparator = new Separator();

        entryDateLabel = new Label("Entry Date:");
        entryDateLabel.setTextFill( Color.web( "#F1F2F6" ) );
        entryDateLabel.setFont( Font.font("", FontWeight.BOLD, 13));

        entryDatePicker = new DatePicker();

        leaveDateLabel = new Label("Leave Date:");
        leaveDateLabel.setTextFill( Color.web( "#F1F2F6" ) );
        leaveDateLabel.setFont( Font.font("", FontWeight.BOLD, 13));

        leaveDatePicker = new DatePicker();

        roomNoLabel = new Label("Room No:");
        roomNoLabel.setTextFill( Color.web( "#F1F2F6" ) );
        roomNoLabel.setFont( Font.font("", FontWeight.BOLD, 13));

        roomNoField = new TextField();
        roomNoField.setPrefWidth( 165 );
        if(bookingService.getByRoomNo() == 0){
            roomNoField.setText("");
        }
        else{
            roomNoField.setText(String.valueOf(bookingService.getByRoomNo()));
        }

        sixthSeparator = new Separator();

        errorText = new Text(0,400,"Please fill every field!!");
        errorText.setFill(Color.RED);
        errorText.setVisible(false);

        errorText1 = new Text(0,400,"Please fill every field correctly!!");
        errorText1.setFill(Color.RED);
        errorText1.setVisible(false);

        submitButton = new Button("Submit");
        submitButton.setOnAction(e->{
            try {
                String name = customerNameField.getText();//value assign from user
                String address = addressField.getText();//value assign from user
                String mobileNo = mobileNoField.getText();//value assign from user
                String email = emailField.getText();//value assign from user
                String entryDate = String.valueOf(entryDatePicker.getValue());//value assign from user
                String leaveDate = String.valueOf(leaveDatePicker.getValue());//value assign from user
                String roomNo = roomNoField.getText();

                if(name.isEmpty() || address.isEmpty() || mobileNo.isEmpty() || email.isEmpty() || entryDate.isEmpty() || leaveDate.isEmpty() || roomNo.isEmpty()){
                    errorText.setVisible(true);

                }
                else{
                    payment.setRoomNo(Integer.parseInt(roomNoField.getText()));//after collecting all data it will set the advpayment in payment class
                    bookingService = new BookingService();
                    bookingService.addCustomer(customerNameField.getText(), addressField.getText(), Integer.parseInt(mobileNoField.getText()), emailField.getText() , entryDatePicker.getValue(), leaveDatePicker.getValue(), Integer.parseInt(roomNoField.getText()));
                    //set all the value in bookingservice using querry to database
                    advancePaymentView.start(stage);
                }
            }
            catch (Exception ex){
                errorText1.setVisible(true);
            }
        });

        backButton = new Button("Back");
        backButton.setOnAction(e->{
            try{
                stage.close();
            }
            catch (Exception ex){

            }
        });

        hbox2 = new HBox();
        hbox2.getChildren().addAll(roomNoLabel, roomNoField);
        hbox2.setSpacing(40);

        hbox1 = new HBox();
        hbox1.getChildren().addAll(submitButton, backButton);
        hbox1.setSpacing(173);;

        vbox = new VBox();
        vbox.getChildren().addAll(mainText, firstSeparator, customerNameLabel, customerNameField, secondSeparator, mobileNoLabel, mobileNoField, thirdSeparator, addressLabel, addressField, fourthSeparator, emailLabel, emailField, fifthSeparator, entryDateLabel, entryDatePicker, leaveDateLabel, leaveDatePicker, hbox2, sixthSeparator, hbox1, errorText);
        vbox.setSpacing(5);
        vbox.setPrefWidth(400);
        vbox.setPadding(new Insets(10,50,10,80));

        root  = new Group(vbox);
        scene = new Scene(root, 450,500, Color.web( "#3F5169" ));
        stage.setTitle("Booking Information");
        stage.setScene(scene);
        stage.show();

    }
}
