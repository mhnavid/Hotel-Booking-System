package com.company;




import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class OptionView extends Application{

    private Button informationButton, bookingButton, checkoutButton, logoutButton;
    private Group root;
    private Scene scene;
    private Stage stage1;
    private VBox vbox;

    BookingService bookingService = new BookingService();

    public void start(Stage stage){
        informationButton = new Button("Room Information");;
        informationButton.setFont(Font.font(18));
        informationButton.setPrefSize( 220,60 );
        informationButton.setOnAction(e->{
                    try{
                        stage1 = new Stage();//stage use korsi ei class stage send korar jnnu na holai login stage cholai jaito
                        RoomInformationView roomInformationView = new RoomInformationView();
                        roomInformationView.start(stage1);
                    }
                    catch(Exception ex){

                    }
                }
        );

        bookingButton = new Button("New Booking");
        bookingButton.setFont(Font.font(18));
        bookingButton.setPrefSize( 220,60 );
        bookingButton.setOnAction(e->{
            try{
                bookingService.setByRoomNo(0);
                stage1 = new Stage();
                CustomerView customerView = new CustomerView();
                customerView.start(stage1);
            }
            catch (Exception ex){

            }
        });

        checkoutButton = new Button("Checkout");
        checkoutButton.setFont(Font.font(18));
        checkoutButton.setPrefSize( 220,60 );
        checkoutButton.setOnAction(e->{
            try{
                stage1 = new Stage();
                CheckoutView checkoutView = new CheckoutView();
                checkoutView.start(stage1);
            }
            catch (Exception ex){

            }
        });

        logoutButton = new Button("Log Out");
        logoutButton.setFont(Font.font(18));
        logoutButton.setPrefSize( 220,60 );
        logoutButton.setOnAction(e->{
            try{
                LoginView loginView = new LoginView();
                loginView.start(stage);
            }
            catch (Exception ex){

            }
        });

        vbox = new VBox();
        vbox.getChildren().addAll( informationButton, bookingButton,checkoutButton, logoutButton );
        vbox.setSpacing( 50 );
        vbox.setPadding(new Insets(50,120,50,120));

        root  = new Group(vbox);
        scene = new Scene(root, 450, 500, Color.web( "#3F5169" ));
        stage.setTitle("Options");
        stage.setScene(scene);
        stage.show();
    }

}
