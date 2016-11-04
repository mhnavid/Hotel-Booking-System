package com.company;



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AdminOptionView extends Application {

    private Button customerInformationButton, roomInformationButton, bookingButton, logoutButton;
    private Group root;
    private Scene scene;
    private Stage stage1;
    private VBox vbox;

    BookingService bookingService = new BookingService();

    public void start(Stage stage) {
        customerInformationButton = new Button("Customer Information");
        customerInformationButton.setFont(Font.font(18));
        customerInformationButton.setPrefSize( 220,60 );
        customerInformationButton.setOnAction(e -> {
            try {
                stage1 = new Stage();
                CustomerInformationView customerInformationView = new CustomerInformationView();
                customerInformationView.start(stage1);
            } catch (Exception ex) {

            }
        });

        roomInformationButton = new Button("Room Information");
        roomInformationButton.setFont(Font.font(18));
        roomInformationButton.setPrefSize( 220,60 );
        roomInformationButton.setOnAction(e -> {
            try{
                stage1 = new Stage();
                RoomInformationView roomInformationView = new RoomInformationView();
                roomInformationView.start(stage1);
            }
            catch (Exception ex){

            }
        });

        bookingButton = new Button("New Booking");
        bookingButton.setFont(Font.font(18));
        bookingButton.setPrefSize( 220,60 );
        bookingButton.setOnAction(e -> {
            try{
                bookingService.setByRoomNo(0);
                stage1 = new Stage();
                CustomerView customerView = new CustomerView();
                customerView.start(stage1);
            }
            catch (Exception ex){

            }
        });

        logoutButton = new Button("Log Out");
        logoutButton.setFont(Font.font(18));
        logoutButton.setPrefSize( 220,60 );
        logoutButton.setOnAction(e -> {
            try{
                LoginView loginView = new LoginView();
                loginView.start(stage);
            }
            catch (Exception ex){

            }
        });

        vbox = new VBox();
        vbox.getChildren().addAll( customerInformationButton, roomInformationButton, bookingButton, logoutButton );
        vbox.setSpacing( 50 );
        vbox.setPadding(new Insets(50,120,50,120));

        root = new Group(vbox);
        scene = new Scene(root, 450, 500, Color.web( "#3F5169" ));//blue back ground#B8860B
        stage.setTitle("Options");
        stage.setScene(scene);
        stage.show();
    }
}

