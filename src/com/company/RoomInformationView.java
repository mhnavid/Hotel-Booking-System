package com.company;


import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RoomInformationView extends Application{

    private VBox vbox;
    private Group root;
    private Scene scene;
    private Stage stage;
    private TableColumn roomNoColumn, typeColumn, statusColumn;
    private Button bookingButton, backButton;
    private TextField roomNoField;
    private HBox roomNoHBox, hbox1;
    private Text errorText;
    CustomerView customerView;
    BookingService bookingService = new BookingService();

    public void start(Stage stage) {

        errorText = new Text(0,50,"Please fill this field for booking!!");
        errorText.setFill(Color.RED);
        errorText.setVisible(false);

        Label roomNolabel = new Label("Room No:");
        roomNolabel.setTextFill( Color.web( "#F1F2F6" ) );
        roomNolabel.setFont( Font.font("", FontWeight.BOLD, 16));

        roomNoField = new TextField();
        roomNoField.setPrefWidth( 250 );
        roomNoHBox = new HBox(30, roomNolabel, roomNoField);//(30=horizontal space between child,set lable room no,field)

        bookingButton = new Button("New Booking");
        bookingButton.setOnAction(e->{
            if(roomNoField.getText().isEmpty()){
                errorText.setVisible(true);
            }
            else{
                bookingService.setByRoomNo(Integer.parseInt(roomNoField.getText()));
                customerView = new CustomerView();
                customerView.start(stage);
            }
        });

        TableView table = new TableView();

        roomNoColumn = new TableColumn("Room No");
        roomNoColumn.setPrefWidth( 143 );
        typeColumn = new TableColumn("Room Type");
        typeColumn.setPrefWidth( 143 );
        statusColumn = new TableColumn("Status");
        statusColumn.setPrefWidth( 142 );

        roomNoColumn.setCellValueFactory(new PropertyValueFactory<RoomInfo, Integer>("roomNo"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<RoomInfo, String>("roomType"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<RoomInfo, String>("status"));

        table.getColumns().addAll(roomNoColumn, typeColumn, statusColumn);//column adding into table

        RoomInfoService roomInfoService = new RoomInfoService();
        table.setItems(FXCollections.observableArrayList(roomInfoService.getAll()));//collect roomlist obserable array from roominfoservice
        table.setPrefSize( 430,380 );

        table.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<RoomInfo>()// room info updating old value changed with new value bz obserable array
                {
                    public void changed(ObservableValue observable, RoomInfo oldValue, RoomInfo newValue) {
                        roomNoField.setText(String.valueOf(newValue.getRoomNo()));
                    }
                }
        );

        vbox = new VBox(5);
        vbox.setPadding(new Insets(10));

        backButton = new Button("Back");
        backButton.setOnAction(e->{
                    stage.close();
                }
        );

        hbox1 = new HBox();
        hbox1.getChildren().addAll(bookingButton, backButton);
        hbox1.setSpacing(300);

        vbox.getChildren().addAll(roomNoHBox, errorText, table, hbox1);
        vbox.setSpacing( 10 );

        root  = new Group(vbox );
        scene = new Scene(root, 450,500, Color.web( "#3F5169" ));
        stage.setTitle("Room Information");
        stage.setScene(scene);
        stage.show();
    }
}