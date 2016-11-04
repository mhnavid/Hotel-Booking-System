package com.company;

import javafx.stage.Stage;
import javafx.application.Application;

public class Main extends Application{

    Stage stage;

    public void start(Stage stage){
        try{
            LoginView loginView = new LoginView();
            stage = new Stage();
            loginView.start(stage);
        }catch(Exception e){}
    }

    public static void main(String[] args) {

        Application.launch(args);
    }
}