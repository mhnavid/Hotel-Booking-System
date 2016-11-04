package com.company;




import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.time.LocalDate;

public class CustomerInformationView extends Application {

    Group root;
    Scene scene;

    private Button newBookingButton, backButton;
    private TableView table;
    TableColumn customerNameColumn, addressColumn, mobileNoColumn, emailColumn, entryDateColumn, leaveDateColumn;
    private VBox vbox;
    private HBox hbox;

    CustomerInformation customerInformation = new CustomerInformation();
    CustomerInformationService customerInformationService;
    RoomInformationView roomInformationView;

    public void start(Stage stage){

        table = new TableView();

        customerNameColumn = new TableColumn("C. Name");//columb title
        addressColumn = new TableColumn("Address");//columb title
        mobileNoColumn = new TableColumn("Mobile No");//columb title
        emailColumn = new TableColumn("Email");//columb title
        entryDateColumn = new TableColumn("Entry Date");//columb title
        leaveDateColumn = new TableColumn("Leave Date");//columb title

        customerNameColumn.setPrefWidth( 70.5 );//columb width
        addressColumn.setPrefWidth( 70.5 );//columb width
        mobileNoColumn.setPrefWidth( 70.5 );//columb width
        emailColumn.setPrefWidth( 70.5 );//columb width
        entryDateColumn.setPrefWidth( 70.5 );//columb width
        leaveDateColumn.setPrefWidth( 70.5 );//columb width

        customerNameColumn.setCellValueFactory(new PropertyValueFactory<CustomerInformation, String>("Name"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<CustomerInformation, String>("Address"));
        mobileNoColumn.setCellValueFactory(new PropertyValueFactory<CustomerInformation, Integer>("MobileNo"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<CustomerInformation, String>("Email"));
        entryDateColumn.setCellValueFactory(new PropertyValueFactory<CustomerInformation, LocalDate>("EntryDate"));
        leaveDateColumn.setCellValueFactory(new PropertyValueFactory<CustomerInformation, LocalDate>("LeaveDate"));
        table.getColumns().addAll(customerNameColumn, addressColumn, mobileNoColumn, emailColumn, entryDateColumn, leaveDateColumn);


        customerInformationService = new CustomerInformationService();
        table.setItems(FXCollections.observableArrayList(customerInformationService.getAll()));//customerlist
        table.setPrefSize( 410, 400 );//table total height and weidth


        newBookingButton = new Button("New Booking");
        newBookingButton.setOnAction(e->{
            try{
                roomInformationView  = new RoomInformationView();
                roomInformationView.start(stage);
            }
            catch (Exception ex){

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

        hbox = new HBox();
        hbox.getChildren().addAll(newBookingButton, backButton);
        hbox.setSpacing(300);

        vbox = new VBox();
        vbox.getChildren().addAll( table, hbox);
        vbox.setPadding(new Insets(10));
        vbox.setSpacing( 20 );

        root  = new Group(vbox);
        scene = new Scene(root, 450,500, Color.web( "#3F5169" ));//blue colour and size
        stage.setTitle("Customer Information");
        stage.setScene(scene);
        stage.show();
    }
}

