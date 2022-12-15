package com.example.hellofx.controllers;
import com.example.hellofx.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class TerminalController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    private Label nameLabel;

    @FXML
    protected void btVoltarAction(ActionEvent e){
        Main.changeScreen("main");
    }

    public void switchToMainMenu(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

//    public void displayName() {
//        nameLabel.setText("aaaaa");
//    }
}
