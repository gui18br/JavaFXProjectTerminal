package com.example.hellofx;

import com.example.hellofx.models.Composicao;
import com.example.hellofx.models.Vagao;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main extends Application {

    private static Stage stage;
    private static Scene mainScene;
    private static Scene terminal1Scene;
    private static Scene terminal2Scene;
    private static Scene vagoesScene;

    private static Composicao composicaoR1;
    private static Composicao composicaoR2;

    public static void main(String[] args) {
        composicaoR1 = new Composicao(1, "Parado no terminal", new LinkedList<Vagao>(), 0, new ArrayList<String>());
        composicaoR2 = new Composicao(2, "Parado no terminal", new LinkedList<Vagao>(), 0, new ArrayList<String>());
        launch(args);
    }

    // MÉTODOS JAVAFX

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;

        stage.setTitle("Pilha de vagões");
        Parent fxmlMain = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        mainScene = new Scene(fxmlMain);
        Parent fxmlTerminal1 = FXMLLoader.load(getClass().getResource("TerminalMenu1.fxml"));
        terminal1Scene = new Scene(fxmlTerminal1);
        Parent fxmlTerminal2 = FXMLLoader.load(getClass().getResource("TerminalMenu2.fxml"));
        terminal2Scene = new Scene(fxmlTerminal2);
        Parent fxmlVagoes = FXMLLoader.load(getClass().getResource("MenuVagoes.fxml"));
        vagoesScene = new Scene(fxmlVagoes);

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
                break;
            case "terminal2":
                stage.setScene(terminal2Scene);
                break;
            case "vagoes":
                stage.setScene(vagoesScene);
                break;
        }
    }

    @FXML
    protected void switchMenu(ActionEvent e){
        final Node source = (Node) e.getSource();
        String id = source.getId();
        System.out.println(id);

        changeScreen(id);
    }

    @FXML
    protected void backToMainMenu(ActionEvent e){
        changeScreen("main");
    }

    @FXML
    public void exit(){
        System.exit(0);
    }





    @FXML
    public void terminalMenuFX(){
        terminalMenu(1, 4);
    }


    public static void terminalMenu(int terminal, int opcao) {
        System.out.println("1 - Alterar status para: Parado no terminal ");
        System.out.println("2 - Alterar status para: Em movimento ");
        System.out.println("3 - Alterar status para: No ponto de interconexÃ£o");
        System.out.println("4 - Consultar quantidade de desembarques");
        System.out.println("5 - Listar vagÃµes");
        System.out.println("6 - Retornar");
        if (terminal == 1) {
            switch (opcao) {
                case 1:
                    composicaoR1.setStatus("Parado no terminal");
                    break;
                case 2:
                    composicaoR1.setStatus("Em movimento");
                    break;
                case 3:
                    composicaoR1.setStatus("No ponto de interconexÃ£o");
                    break;
                case 4:
                    System.out.println(
                            "Neste terminal foram feitos  desembarque(s) de "+ composicaoR1.listarDesembarques() +
                                    " totalizando " + composicaoR1.getQtdDesembarques() + ", desembarque(s)");
                    break;
                case 5:
                    System.out.println(composicaoR1.getVagoesPilha());
                    break;
                case 6:
                    System.out.println("sair");
                    break;
            }
        }

        if (terminal == 2) {
            switch (opcao) {
                case 1:
                    composicaoR2.setStatus("Parado no terminal");
                    break;
                case 2:
                    composicaoR2.setStatus("Em movimento");
                    break;
                case 3:
                    composicaoR2.setStatus("No ponto de interconexÃ£o");
                    break;
                case 4:
                    System.out.println(
                            "Neste terminal foram feitos  desembarque(s) de "+ composicaoR2.listarDesembarques() +
                                    ", totalizando " + composicaoR2.getQtdDesembarques() + " desembarque(s)");
                    break;
                case 5:
                    System.out.println(composicaoR2.getVagoesPilha());
                    break;
                case 6:
                    System.out.println("sair");
                    break;
            }
        }
    }
}