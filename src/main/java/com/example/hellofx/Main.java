package com.example.hellofx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Stage stage;

    private static Scene mainScene;
    private static Scene terminal1Scene;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;

        stage.setTitle("Pilha de vagões");

        Parent fxmlMain = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        mainScene = new Scene(fxmlMain);

        Parent fxmlTerminal1 = FXMLLoader.load(getClass().getResource("TerminalMenu1.fxml"));
        terminal1Scene = new Scene(fxmlTerminal1);

        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static void changeScreen(String src){
        switch (src){
            case "main":
                stage.setScene(mainScene);
                break;
            case "terminal1":
                stage.setScene(terminal1Scene);
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}