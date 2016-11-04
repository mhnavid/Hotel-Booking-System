package com.company;




import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AdvancePaymentView extends Application {

    private Group root;
    private Scene scene;
    private Button confirmButton;
    private Label advancePaymentLabel;
    private Separator firstSeparator;
    private TextField advancePaymentField;
    private VBox vbox;

    Payment payment = new Payment();
    PaymentService paymentService = new PaymentService();

    public void start(Stage stage){

        Text roomNoText = new Text();
        roomNoText.setText("Room No  :  " + payment.getRoomNo());
        roomNoText.setFill( Color.web( "#F1F2F6" ) );
        roomNoText.setFont( Font.font("", FontWeight.BOLD, 14));

        advancePaymentLabel = new Label("Advance Payment");
        advancePaymentLabel.setTextFill( Color.web( "#F1F2F6" ) );
        advancePaymentLabel.setFont( Font.font("", FontWeight.BOLD, 14));

        advancePaymentField = new TextField();

        firstSeparator = new Separator();

        confirmButton = new Button("Confirm");
        confirmButton.setOnAction(e->{
            try{
                if(advancePaymentField.getText().isEmpty()){
                    paymentService.insertPayment(0);//set default adv payment 0
                    stage.close();
                }
                else {
                    paymentService.insertPayment(Integer.parseInt(advancePaymentField.getText()));
                    //set the payment value in database from paymentservice insertpayment method
                    stage.close();
                }
            }
            catch (Exception ex) {

            }
        });

        vbox = new VBox();
        vbox.getChildren().addAll(roomNoText, advancePaymentLabel, advancePaymentField, firstSeparator, confirmButton);
        vbox.setPadding(new Insets(100,100,100,100));
        vbox.setSpacing(30);
        vbox.setPrefWidth( 400 );

        root = new Group(vbox);
        scene = new Scene(root, 450, 500, Color.web( "#3F5169" ));
        stage.setTitle("Options");
        stage.setScene(scene);
        stage.show();
    }

}

