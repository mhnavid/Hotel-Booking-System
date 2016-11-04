package com.company;




import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginView extends Application{
    private Group root;
    private Scene scene;
    private Stage stage;
    private Button loginButton, cancelButton;
    private TextField usernameField;
    private PasswordField passwordField;//paswordfield use korlai number ***daikai
    private HBox hbox1;
    private VBox vbox1;
    private LoginService loginService;

    private int loginReturn;

    public void start(Stage stage) {
        Text username = new Text();
        username.setText("Username");
        username.setFill( Color.web( "#F1F2F6" ) );
        username.setFont(Font.font("", FontWeight.BOLD, 16));

        usernameField = new TextField();
        usernameField.setText("admin");

        Text password = new Text();
        password.setText("Password");
        password.setFill( Color.web( "#F1F2F6" ) );
        password.setFont(Font.font("", FontWeight.BOLD, 16));

        passwordField = new PasswordField();
        passwordField.setText("admin");

        Text errorText = new Text(0,400,"Invalid Username or Password!!");
        errorText.setFill(Color.RED);
        errorText.setVisible(false);

        loginButton = new Button("Log In");

        cancelButton = new Button("Exit");
        cancelButton.setOnAction(
                e->{
                    try{
                        System.exit(0);
                    }catch(Exception ex){}
                }
        );

        hbox1 = new HBox();
        hbox1.getChildren().addAll(loginButton, cancelButton);
        hbox1.setSpacing(60);
        hbox1.setPadding(new Insets(20,0,0,0));

        loginButton.setOnAction(e->{
                    loginService = new LoginService();
                    loginReturn = loginService.loginCheck(usernameField.getText().toString(),passwordField.getText().toString());//database login checking
                    try{
                        if(loginReturn == 1){
                            AdminOptionView adminOptionView = new AdminOptionView();
                            adminOptionView.start(stage);
                        }
                        if(loginReturn == 2){
                            OptionView options = new OptionView();
                            options.start(stage);
                        }
                        else {
                            errorText.setVisible(true);
                        }
                    }
                    catch(Exception ex){}

                }
        );
        vbox1 = new VBox();
        vbox1.getChildren().addAll(username, usernameField, password, passwordField, hbox1, errorText);
        vbox1.setSpacing(30);
        vbox1.setPadding(new Insets(80,130,100,130));

        root  = new Group(vbox1);
        scene = new Scene(root, 450,500, Color.web( "#3F5169" ));

        stage.setTitle("Log In");//stage name (see top of the window)
        stage.setScene(scene);
        stage.show();
    }
}

