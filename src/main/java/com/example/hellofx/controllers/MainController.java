package com.example.hellofx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void switchToTerminalMenu(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TerminalMenu.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();

        final Node source = (Node) e.getSource();
        String id = source.getId();
        System.out.println(id);

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onTerminal1Action(ActionEvent e) {
        final Node source = (Node) e.getSource();
        String id = source.getId();

        System.out.println(id);
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }

    @FXML
    public void exit(){
        System.exit(0);
    }













    @FXML
    public static void terminalMenu(int terminal) {

    }

}