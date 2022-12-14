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

    public void switchToTerminalMenu(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TerminalMenu.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
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
    public void onSairAction(){
        System.exit(0);
    }













    @FXML
    public static void terminalMenu(int terminal) {

    }

}