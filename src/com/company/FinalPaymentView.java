package com.company;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

public class FinalPaymentView extends Application {

    private Text roomNoText, advancePaymentText, duePaymentText1, duePaymentText2;
    private Button calculateButton, cancelButton;
    private Label totalPaymentLabel;
    private Separator firstSeparator;
    private TextField totalPaymentField;
    private VBox vbox;
    private HBox hbox;

    private Group root;
    private Scene scene;
    private Stage stage;

    PaymentService paymentService = new PaymentService();
    Payment payment = new Payment();

    public void start(Stage stage){

        roomNoText = new Text();
        roomNoText.setText("Room No   :   " + payment.getRoomNo());//collect the room no from payment class and show
        roomNoText.setFill( Color.web( "#F1F2F6" ) );
        roomNoText.setFont( Font.font("", FontWeight.BOLD, 14));

        advancePaymentText = new Text();
        advancePaymentText.setText("Advance Paid  :  " + paymentService.getAdvance());//collect the adv payment from database and show
        advancePaymentText.setFill( Color.web( "#F1F2F6" ) );
        advancePaymentText.setFont( Font.font("", FontWeight.BOLD, 14));

        totalPaymentLabel = new Label("Total Payment");
        totalPaymentLabel.setTextFill( Color.web( "#F1F2F6" ) );
        totalPaymentLabel.setFont( Font.font("", FontWeight.BOLD, 14));

        totalPaymentField = new TextField();

        duePaymentText1 = new Text();
        duePaymentText1.setText("Due Payment  :  0.0");
        duePaymentText1.setFill( Color.web( "#F1F2F6" ) );
        duePaymentText1.setFont( Font.font("", FontWeight.BOLD, 14));
        duePaymentText1.setVisible(true);

        duePaymentText2 = new Text();
        duePaymentText2.setFill( Color.web( "#F1F2F6" ) );
        duePaymentText2.setFont( Font.font("", FontWeight.BOLD, 14));
        duePaymentText2.setVisible(false);

        firstSeparator = new Separator();

        calculateButton = new Button("Calculate");
        calculateButton.setOnAction(e->{
            try{
                duePaymentText1.setVisible(false);
                paymentService.setCalculateDue(Double.parseDouble(totalPaymentField.getText()));// calculate korai due
                duePaymentText2.setText("Due Payment  :  " + paymentService.getCalculateDue()); // if due then show
                duePaymentText2.setVisible(true);
            }
            catch (Exception ex){

            }
        });



        cancelButton = new Button("Checkout completed");
        cancelButton.setOnAction(e->{  //delete room details
            try{
                stage.close();
                paymentService.delete();
            }
            catch (Exception ex){

            }
        });

        hbox = new HBox();
        hbox.getChildren().addAll(calculateButton, cancelButton);// hbox use system
        hbox.setSpacing(100);

        vbox = new VBox();
        vbox.setPadding(new Insets(100,100,100,100));
        vbox.setSpacing(30);
        vbox.getChildren().addAll(roomNoText, advancePaymentText, totalPaymentLabel, totalPaymentField, duePaymentText1, duePaymentText2, firstSeparator, hbox);
        vbox.setVisible(true);


        root  = new Group(vbox); //assigning root value  and root is needed for scene function
        scene = new Scene(root, 450,600, Color.web( "#3F5169" ));
        stage.setTitle("Booking Information");
        stage.setScene(scene);
        stage.show();
    }

}

