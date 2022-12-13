package com.example.hellofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class HelloController {
    @FXML
    private Button terminal1;
    @FXML
    private Button sair;
    @FXML
    public void onTerminal1Action(ActionEvent e) {

    }
    @FXML
    public void onSairAction(){
        System.exit(0);
    }

}