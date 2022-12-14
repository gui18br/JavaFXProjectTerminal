package com.example.hellofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void onTerminal1Action(ActionEvent e) {
        final Node source = (Node) e.getSource();
        String id = source.getId();

        System.out.println(id);
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }

    @FXML
    public void onSairAction(){
        System.exit(0);
    }













    @FXML
    public static void terminalMenu(int terminal) {

    }

}