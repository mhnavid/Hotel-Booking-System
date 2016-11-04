package com.company;



import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.Label;

public class CheckoutView extends Application{

    private Group root;
    private Scene scene;
    private Stage stage;
    private Label roomNoLabel;
    private Button checkoutButton, backButton;
    private TextField roomNoField;
    private VBox vbox1, vbox2;
    private HBox hbox;
    private TableView table;
    private Text errorText;
    TableColumn customerNameColumn, roomNoColumn;
    CheckoutService checkoutService;
    Payment payment = new Payment();
    FinalPaymentView finalPaymentView;

    public void start(Stage stage){

        roomNoLabel = new Label("Enter room no");
        roomNoLabel.setTextFill( Color.web( "#F1F2F6" ) );
        roomNoLabel.setFont( Font.font("", FontWeight.BOLD, 14));

        roomNoField = new TextField();
        roomNoField.setPrefWidth( 200 );

        errorText = new Text(0,50,"Please fill the room no to checkout!!");
        errorText.setFill(Color.RED);
        errorText.setVisible(false);

        checkoutButton = new Button("Checkout");
        checkoutButton.setOnAction(e->{
            try{
                if(roomNoField.getText().toString().isEmpty()){
                    errorText.setVisible(true);
                }
                else{
                    payment.setRoomNo(Integer.parseInt(roomNoField.getText().toString()));//collect the due amount
                    CheckoutService service = new CheckoutService();
                    service.checkoutByRoom(Integer.parseInt(roomNoField.getText().toString()));
                    finalPaymentView = new FinalPaymentView();
                    finalPaymentView.start(stage);
                }
            }
            catch(Exception ex){

            }
        });



        hbox = new HBox();
        hbox.getChildren().addAll(roomNoField, checkoutButton);
        hbox.setSpacing( 50 );

        vbox1 = new VBox();
        vbox1.getChildren().addAll(roomNoLabel, hbox, errorText);
        vbox1.setSpacing(10);

        table = new TableView();

        roomNoColumn = new TableColumn("Room No");
        roomNoColumn.setPrefWidth( 208.5 );
        customerNameColumn = new TableColumn("Customer Name");
        customerNameColumn.setPrefWidth( 208.5 );// columb  width
        roomNoColumn.setCellValueFactory(new PropertyValueFactory<Checkout, Integer>("roomNo"));
        customerNameColumn.setCellValueFactory(new PropertyValueFactory<Checkout, String>("name"));
        table.getColumns().addAll(roomNoColumn, customerNameColumn);
        table.setPrefSize( 420, 300 );


        checkoutService = new CheckoutService();
        table.setItems(FXCollections.observableArrayList(checkoutService.getAll()));//collect roomlist set in obserable array

        table.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Checkout>() {
                    public void changed(ObservableValue observable, Checkout oldValue, Checkout newValue)
                            //change the room last checkout details and set new checkout date
                    {
                        roomNoField.setText(String.valueOf(newValue.getRoomNo()));
                    }
                }
        );

        backButton = new Button("Back");
        backButton.setOnAction(e->{
            try{
                stage.close();
            }
            catch (Exception ex){

            }
        });

        vbox2 = new VBox();
        vbox2.getChildren().addAll(vbox1, table, backButton);
        vbox2.setPadding(new Insets(10));
        vbox2.setSpacing( 10 );

        root  = new Group(vbox2);
        scene = new Scene(root, 450,500, Color.web( "#3F5169" ));//root,height,width
        stage.setTitle("Checkout Information");
        stage.setScene(scene);
        stage.show();
    }
}
