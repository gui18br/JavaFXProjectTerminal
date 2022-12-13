package com.example.hellofx;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TerminalController {

    @FXML
    private Button alterStatusStop;

    @FXML
    public void statusStop(){
        System.out.println("Status = parado");
    }
}
