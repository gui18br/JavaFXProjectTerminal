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
import javafx.scene.control.*;
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
    private static Scene desembarcarScene;
    private static Scene addVagaoScene;

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
        Parent fxmlAddVagao = FXMLLoader.load(getClass().getResource("AdicionarVagao.fxml"));
        addVagaoScene = new Scene(fxmlAddVagao);
        Parent fxmlDesembarcar = FXMLLoader.load(getClass().getResource("DesembarcarMenu.fxml"));
        desembarcarScene = new Scene(fxmlDesembarcar);

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
            case "desembarcar":
                stage.setScene(desembarcarScene);
                break;
            case "addVagao":
                stage.setScene(addVagaoScene);
                break;
        }
    }

    @FXML
    protected void switchMenu(ActionEvent e){
        final Node source = (Node) e.getSource();
        String id = source.getId();

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
    public void terminalMenuFX(ActionEvent e){ // FUNÇÃO PRA CHAMAR AS FUNÇÕES DO MENU TERMINAL
        final Node source = (Node) e.getSource();
        String id = source.getId();

        terminalMenu(id);
    }

    public static void terminalMenu(String opcao) { // MENU TERMINAL
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        switch(opcao) {
            //TERMINAL 1
            case "btStatusParado1":
                composicaoR1.setStatus("Parado no terminal");
                alert.setTitle("Informação");
                alert.setHeaderText("Status do terminal: " + composicaoR1.getStatus());
                alert.showAndWait();
                break;
            case "btStatusMovimento1":
                composicaoR1.setStatus("Em movimento");
                alert.setTitle("Informação");
                alert.setHeaderText("Status do terminal: " + composicaoR1.getStatus());
                alert.showAndWait();
                break;
            case "btStatusPonto1":
                composicaoR1.setStatus("No ponto de interconexão");
                alert.setHeaderText("Status do terminal: " + composicaoR1.getStatus());
                alert.showAndWait();
                break;
            case "btConsultar1":
                alert.setTitle("Informação");
                alert.setHeaderText("Neste terminal foram feitos  desembarque(s) de " + composicaoR1.listarDesembarques() + " totalizando " + composicaoR1.getQtdDesembarques() + ", desembarque(s)");
                alert.showAndWait();
                break;
            case "btListar1":
                alert.setTitle("Informação");
                alert.setHeaderText("Lista dos vagões");
                alert.setContentText(composicaoR1.getVagoesPilha().toString());
                alert.showAndWait();
                break;

            //TERMINAL 2
            case "btStatusParado2":
                composicaoR2.setStatus("Parado no terminal");
                alert.setTitle("Informação");
                alert.setHeaderText("Status do terminal: " + composicaoR2.getStatus());
                alert.showAndWait();
                break;
            case "btStatusMovimento2":
                composicaoR2.setStatus("Em movimento");
                alert.setTitle("Informação");
                alert.setHeaderText("Status do terminal: " + composicaoR2.getStatus());
                alert.showAndWait();
                break;
            case "btStatusPonto2":
                composicaoR2.setStatus("No ponto de interconexão");
                alert.setTitle("Informação");
                alert.setHeaderText("Status do terminal: " + composicaoR2.getStatus());
                alert.showAndWait();
                break;
            case "btConsultar2":
                alert.setTitle("Informação");
                alert.setHeaderText("Neste terminal foram feitos  desembarque(s) de " + composicaoR2.listarDesembarques() + " totalizando " + composicaoR2.getQtdDesembarques() + ", desembarque(s)");
                alert.showAndWait();
                break;
            case "btListar2":
                alert.setTitle("Informação");
                alert.setHeaderText("Lista de vagões");
                alert.setContentText(composicaoR2.getVagoesPilha().toString());
                alert.showAndWait();
                break;
        }
    }


    @FXML
    public void vagoesMenuFX(ActionEvent e){ // FUNÇÃO PRA CHAMAR AS FUNÇÕES DO MENU VAGÕES
        final Node source = (Node) e.getSource();
        String id = source.getId();

        vagoesMenu(id);
    }

    public void vagoesMenu(String opcao) { // MENU VAGOES
        switch (opcao) {
            case "btEmbarcar":
                changeScreen("addVagao");
                break;
            case "btDesembarcar":
                changeScreen("desembarcar");
                break;
            case "btTransferir1to2":
                 transferVagao(1);
            case "btTransferir2to1":
                 transferVagao(2);
                break;
        }
    }


    @FXML private TextField indexVagaoDesembarcar;

    @FXML
    public void desembarcarFX(ActionEvent e) {
        char inputText = indexVagaoDesembarcar.getText().charAt(0);
        desembarcar(inputText);
        indexVagaoDesembarcar.clear();
    }

    public void desembarcar(char inputText) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        char indexVagaoUpperCase = Character.toUpperCase(inputText);

        if (!(composicaoR1.getVagoesPilha().isEmpty()) &&
                composicaoR1.getVagoesPilha().peek().getIndexVagao() == indexVagaoUpperCase) {
            removerVagao(composicaoR1.getVia());
        } else if(!(composicaoR2.getVagoesPilha().isEmpty() )&&
                composicaoR2.getVagoesPilha().peek().getIndexVagao() == indexVagaoUpperCase){
            removerVagao(composicaoR2.getVia());
        } else {
            alert.setTitle("Atenção!");
            alert.setHeaderText("O identificador não se encontra na ponta de nenhum dos terminais");
            alert.showAndWait();
        }
    }

    public static void removerVagao(int indexTerminal) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if (indexTerminal == 1) {
            if (composicaoR1.getStatus() == "Parado no terminal") {
                if (!composicaoR1.getVagoesPilha().isEmpty()) {
                    alert.setTitle("Parabens!");
                    alert.setHeaderText("O vagão de identificador '"+composicaoR1.getVagoesPilha().peek().getIndexVagao() +
                            "' foi removido da ponta do terminal " +indexTerminal);
                    alert.showAndWait();
                    composicaoR1.addDesembarques(composicaoR1.getVagoesPilha().peek().getNomeCarga());
                    composicaoR1.getVagoesPilha().pop();
                    composicaoR1.setQtdDesembarques(composicaoR1.getQtdDesembarques()+1);

                } else {
                    alert.setTitle("Atenção!");
                    alert.setHeaderText("A locomotiva nÃ£o tem vagÃµes com produtos");
                    alert.showAndWait();
                }
            } else {
                alert.setTitle("Atenção!");
                alert.setHeaderText("A locomotiva nÃ£o se encontra parada no terminal.");
                alert.showAndWait();
            }

        }

        if (indexTerminal == 2) {
            if (composicaoR2.getStatus() == "Parado no terminal") {
                if (!composicaoR2.getVagoesPilha().isEmpty()) {
                    alert.setTitle("Parabens!");
                    alert.setHeaderText("O vagÃ£o de identificador '" + composicaoR2.getVagoesPilha().peek().getIndexVagao() +
                            "' foi removido do terminal "+ indexTerminal);
                    alert.showAndWait();
                    composicaoR2.addDesembarques(composicaoR2.getVagoesPilha().peek().getNomeCarga());
                    composicaoR2.getVagoesPilha().pop();
                    composicaoR2.setQtdDesembarques(composicaoR2.getQtdDesembarques()+1);
                } else {
                    alert.setTitle("Atenção!");
                    alert.setHeaderText("A locomotiva nÃo tem vagões com produtos");
                    alert.showAndWait();
                    changeScreen("main");
                }
            } else {
                alert.setTitle("Atenção!");
                alert.setHeaderText("A locomotiva não se encontra parada no terminal");
                alert.showAndWait();
                changeScreen("main");
            }

        }
        changeScreen("main");
    }

    public static void transferVagao(int indexTerminal) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

            if ((composicaoR1.getStatus() == "No ponto de interconexão") && (composicaoR2.getStatus() == "No ponto de interconexão")) {

                if (indexTerminal == 1) {
                    if(!(composicaoR1.getVagoesPilha().isEmpty())) {
                        composicaoR2.getVagoesPilha().push(composicaoR1.getVagoesPilha().pop());
                        alert.setTitle("Sucesso!");
                        alert.setHeaderText("Foi transferido um vagão da locomotiva R1 para a locomotiva R2");
                        alert.showAndWait();
                    } else {
                        alert.setTitle("Atenção!");
                        alert.setHeaderText("Uma ou mais locomotivas não possuem vagões");
                        alert.showAndWait();
                    }
                }

                if (indexTerminal == 2) {
                    if(!(composicaoR2.getVagoesPilha().isEmpty())) {
                        composicaoR1.getVagoesPilha().push(composicaoR2.getVagoesPilha().pop());
                        alert.setTitle("Sucesso!");
                        alert.setHeaderText("Foi transferido um vagão da locomotiva R2 para a locomotiva R1");
                        alert.showAndWait();
                    } else {
                        alert.setTitle("Atenção!");
                        alert.setHeaderText("Uma ou mais locomotivas não possuem vagões");
                        alert.showAndWait();
                    }
                }
            } else {
                alert.setTitle("Atenção!");
                alert.setHeaderText("Uma ou mais locomotivas não se encontram no ponto de interconexão");
                alert.showAndWait();
            }
    }


    @FXML private RadioButton composicaoIndex1, composicaoIndex2;
    @FXML private TextField indexVagaoAdd;
    @FXML private TextField nomeVagaoAdd;
    @FXML private TextField pesoVagaoAdd;

    @FXML
    public void addVagaoFX(ActionEvent e) {
        int composicaoIndex = 0;
        if(composicaoIndex1.isSelected()) {
            composicaoIndex = 1;
        }
        if(composicaoIndex2.isSelected()) {
            composicaoIndex = 2;
        }

        char inputText = indexVagaoAdd.getText().charAt(0);
        String nomeText = nomeVagaoAdd.getText();
        Double pesoText = Double.parseDouble(pesoVagaoAdd.getText());
        addVagao(composicaoIndex, inputText, nomeText, pesoText);
        indexVagaoAdd.clear();
        nomeVagaoAdd.clear();
        pesoVagaoAdd.clear();
    }

    public static void addVagao(int indexTerminal, char inputText, String nomeText, Double pesoText) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        char indexVagao = inputText;
        char indexVagaoUpperCase = Character.toUpperCase(indexVagao);
        String nomeCarga  = nomeText;
        double qtd = pesoText;

        Vagao v = new Vagao(indexVagaoUpperCase, nomeCarga, qtd);

        boolean validIndex = true;

        if (indexTerminal == 1) {
            validIndex = true;
            int tam = composicaoR1.getVagoesPilha().size();

            v.setTipoCarga(1);
            if (composicaoR1.isEmpilhavel()) {
                for (int i = 0; i < composicaoR1.getVagoesPilha().size(); i++) {
                    if (composicaoR1.getVagoesPilha().get(i).getIndexVagao() == indexVagaoUpperCase) {
                        alert.setTitle("Atenção!");
                        alert.setHeaderText("Este identificador já foi utilizado");
                        alert.showAndWait();
                        validIndex = false;
                    }
                }
                if (validIndex) {
                    composicaoR1.getVagoesPilha().push(v);
                    alert.setTitle("Sucesso!");
                    alert.setHeaderText("Adicionado com sucesso na composição 1");
                    alert.showAndWait();
                }
            } else {
                alert.setTitle("Atenção!");
                alert.setHeaderText("Essa locomotiva não pode receber um vagão no momento, pois sua possição é: " + composicaoR2.getStatus());
                alert.showAndWait();
            }
        }

        if (indexTerminal == 2) {
            validIndex = true;
            int tam = composicaoR2.getVagoesPilha().size();

            v.setTipoCarga(2);
            if (composicaoR2.isEmpilhavel()) {
                for (int i = 0; i < composicaoR2.getVagoesPilha().size(); i++) {
                    if (composicaoR2.getVagoesPilha().get(i).getIndexVagao() == indexVagaoUpperCase) {
                        alert.setTitle("Atenção!");
                        alert.setHeaderText("Este identificador já foi utilizado");
                        alert.showAndWait();
                        validIndex = false;
                    }
                }
                if (validIndex) {
                    composicaoR2.getVagoesPilha().push(v);
                    alert.setTitle("Sucesso!");
                    alert.setHeaderText("Adicionado com sucesso na composição 2");
                    alert.showAndWait();
                }
            } else {
                alert.setTitle("Atenção!");
                alert.setHeaderText("Essa locomotiva não pode receber um vagão no momento, pois sua possição é: " + composicaoR2.getStatus());
                alert.showAndWait();
            }

        }
        changeScreen("main");
    }







}