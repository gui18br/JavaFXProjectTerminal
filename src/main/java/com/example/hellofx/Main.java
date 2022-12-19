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
    public void terminalMenuFX(ActionEvent e){ // FUNÇÃO PRA CHAMAR AS FUNÇÕES DO MENU TERMINAL
        final Node source = (Node) e.getSource();
        String id = source.getId();
        System.out.println(id);

        terminalMenu(id);
    }

    public static void terminalMenu(String opcao) { // MENU TERMINAL
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        switch(opcao) {
            //TERMINAL 1
            case "btStatusParado1":
                composicaoR1.setStatus("Parado no terminal");
                System.out.println("Status do terminal: " + composicaoR1.getStatus());
                alert.setTitle("Informação");
                alert.setHeaderText("Status do terminal: " + composicaoR1.getStatus());
                alert.showAndWait();
                break;
            case "btStatusMovimento1":
                composicaoR1.setStatus("Em movimento");
                System.out.println("Status do terminal: " + composicaoR1.getStatus());
                alert.setTitle("Informação");
                alert.setHeaderText("Status do terminal: " + composicaoR1.getStatus());
                alert.showAndWait();
                break;
            case "btStatusPonto1":
                composicaoR1.setStatus("No ponto de interconexão");
                System.out.println("Status do terminal: " + composicaoR1.getStatus());
                alert.setHeaderText("Status do terminal: " + composicaoR1.getStatus());
                alert.showAndWait();
                break;
            case "btConsultar1":
                System.out.println(
                        "Neste terminal foram feitos  desembarque(s) de "+ composicaoR1.listarDesembarques() +
                                " totalizando " + composicaoR1.getQtdDesembarques() + ", desembarque(s)");
                alert.setTitle("Informação");
                alert.setHeaderText("Neste terminal foram feitos  desembarque(s) de "+ composicaoR1.listarDesembarques() +
                        " totalizando " + composicaoR1.getQtdDesembarques() + ", desembarque(s)");
                alert.showAndWait();
                break;
            case "btListar1":
                System.out.println(composicaoR1.getVagoesPilha());
                alert.setTitle("Informação");
                alert.setHeaderText("Lista dos vagões");
                alert.setContentText(composicaoR1.getVagoesPilha().toString());
                alert.showAndWait();
                break;

            //TERMINAL 2
            case "btStatusParado2":
                composicaoR2.setStatus("Parado no terminal");
                System.out.println("Status do terminal: " + composicaoR2.getStatus());
                alert.setTitle("Informação");
                alert.setHeaderText("Status do terminal: " + composicaoR2.getStatus());
                alert.showAndWait();
                break;
            case "btStatusMovimento2":
                composicaoR2.setStatus("Em movimento");
                System.out.println("Status do terminal: " + composicaoR2.getStatus());
                alert.setTitle("Informação");
                alert.setHeaderText("Status do terminal: " + composicaoR2.getStatus());
                alert.showAndWait();
                break;
            case "btStatusPonto2":
                composicaoR2.setStatus("No ponto de interconexão");
                System.out.println("Status do terminal: " + composicaoR2.getStatus());
                alert.setTitle("Informação");
                alert.setHeaderText("Status do terminal: " + composicaoR2.getStatus());
                alert.showAndWait();
                break;
            case "btConsultar2":
                System.out.println(
                        "Neste terminal foram feitos  desembarque(s) de "+ composicaoR2.listarDesembarques() +
                        ", totalizando " + composicaoR2.getQtdDesembarques() + " desembarque(s)");
                alert.setTitle("Informação");
                alert.setHeaderText("Neste terminal foram feitos  desembarque(s) de "+ composicaoR2.listarDesembarques() +
                        " totalizando " + composicaoR2.getQtdDesembarques() + ", desembarque(s)");
                alert.showAndWait();
                break;
            case "btListar2":
                System.out.println(composicaoR2.getVagoesPilha());
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
        System.out.println(id);

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
            System.out.println("O identificador não se encontra na ponta de nenhum dos terminais");
            System.out.println("Voltar para o menu");
            alert.setTitle("Atenção!");
            alert.setHeaderText("O identificador não se encontra na ponta de nenhum dos terminais");
            alert.showAndWait();
        }
    }

    public static void removerVagao(int indexTerminal) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if (indexTerminal == 1) {
            if (composicaoR1.getStatus() == "Parado no terminal") {
                if (composicaoR1.getVagoesPilha().isEmpty() == false) {
                    System.out
                            .println("O vagÃ£o de identificador '" + composicaoR1.getVagoesPilha().peek().getIndexVagao() +
                                    "' foi removido da ponta do terminal "+ indexTerminal);
                    alert.setTitle("Parabens!");
                    alert.setHeaderText("O vagão de identificador '"+composicaoR1.getVagoesPilha().peek().getIndexVagao() +
                            "' foi removido da ponta do terminal " +indexTerminal);
                    alert.showAndWait();
                    composicaoR1.addDesembarques(composicaoR1.getVagoesPilha().peek().getNomeCarga());
                    composicaoR1.getVagoesPilha().pop();
                    composicaoR1.setQtdDesembarques(composicaoR1.getQtdDesembarques()+1);

                } else {
                    System.out.println("A locomotiva nÃ£o tem vagÃµes com produtos");
                    System.out.println("Voltar para o menu");
                    alert.setTitle("Atenção!");
                    alert.setHeaderText("A locomotiva nÃ£o tem vagÃµes com produtos");
                    alert.showAndWait();
                }
            } else {
                System.out.println("A locomotiva nÃ£o se encontra parada no terminal.");
                System.out.println("Voltar para o menu");
                alert.setTitle("Atenção!");
                alert.setHeaderText("A locomotiva nÃ£o se encontra parada no terminal.");
                alert.showAndWait();
            }

        }

        if (indexTerminal == 2) {
            if (composicaoR2.getStatus() == "Parado no terminal") {
                if (composicaoR2.getVagoesPilha().isEmpty() == false) {
                    System.out
                            .println("O vagÃ£o de identificador '" + composicaoR2.getVagoesPilha().peek().getIndexVagao() +
                                    "' foi removido do terminal "+indexTerminal);
                    composicaoR2.addDesembarques(composicaoR2.getVagoesPilha().peek().getNomeCarga());
                    composicaoR2.getVagoesPilha().pop();
                    composicaoR2.setQtdDesembarques(composicaoR2.getQtdDesembarques()+1);
                } else {
                    System.out.println("A locomotiva nÃ£o tem vagÃµes com produtos");
                    System.out.println("Voltar para o menu");
                }
            } else {
                System.out.println("A locomotiva nÃ£o se encontra parada no terminal.");
                System.out.println("Voltar para o menu");
            }

        }
        System.out.println("Voltar para o menu");
    }

    public static void transferVagao(int indexTerminal) {
        if(!(composicaoR1.getVagoesPilha().isEmpty()) || !(composicaoR2.getVagoesPilha().isEmpty())){

            if ((composicaoR1.getStatus() == "No ponto de interconexÃ£o")
                    && (composicaoR2.getStatus() == "No ponto de interconexÃ£o")) {
                if (indexTerminal == 1) {
                    char indexVagao = composicaoR1.getVagoesPilha().peek().getIndexVagao();
                    String nomeCarga = composicaoR1.getVagoesPilha().peek().getNomeCarga();
                    double qtd = composicaoR1.getVagoesPilha().peek().getQtd();

                    Vagao v = new Vagao(indexVagao, nomeCarga, qtd);
                    v.setTipoCarga(1);

                    composicaoR2.getVagoesPilha().push(v);
                    composicaoR1.getVagoesPilha().pop();

                    composicaoR1.setStatus("Parado no terminal");
                    composicaoR2.setStatus("Parado no terminal");
                    System.out.println("Foi transferido um vagÃ£o da locomotiva R1 para a locomotiva R2 e a locomotiva agora estÃ¡ parada no terminal");
                }

                if (indexTerminal == 2) {
                    char indexVagao = composicaoR2.getVagoesPilha().peek().getIndexVagao();
                    String nomeCarga = composicaoR2.getVagoesPilha().peek().getNomeCarga();
                    double qtd = composicaoR2.getVagoesPilha().peek().getQtd();

                    Vagao v = new Vagao(indexVagao, nomeCarga, qtd);
                    v.setTipoCarga(2);

                    composicaoR1.getVagoesPilha().push(v);
                    composicaoR2.getVagoesPilha().pop();

                    composicaoR1.setStatus("Parado no terminal");
                    composicaoR2.setStatus("Parado no terminal");
                    System.out.println("Foi transferido um vagÃ£o da locomotiva R2 para a locomotiva R1 e a locomotiva agora estÃ¡ parada no terminal");
                }
            } else {
                System.out.println("Uma ou mais locomotivas nÃ£o se encontram no ponto de interconexÃ£o");
            }
            System.out.println("Voltar para o menu");
        } else {
            System.out.println("Uma ou mais locomotivas nÃ£o possuem vagÃµes");
            System.out.println("Voltar para o menu");
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
    }

    public static void addVagao(int indexTerminal, char inputText, String nomeText, Double pesoText) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        char indexVagao = inputText;
        char indexVagaoUpperCase = Character.toUpperCase(indexVagao);
        String nomeCarga  = nomeText;
        double qtd = pesoText;

        Vagao v = new Vagao(indexVagaoUpperCase, nomeCarga, qtd);

        if (indexTerminal == 1) {
            System.out.println("Adicionado com sucesso na composição 1");
            v.setTipoCarga(1);
            for (int i = 0; i < composicaoR1.getVagoesPilha().size(); i++) {
                if (composicaoR1.getVagoesPilha().get(i).getIndexVagao() == indexVagaoUpperCase) {
                    System.out.println("Este identificador jÃ¡ foi utilizado");
                    System.out.println("Voltar para o menu");
                    alert.setTitle("Atenção!");
                    alert.setHeaderText("Este identificador já foi utilizado");
                    alert.showAndWait();
                }
            }
            if (composicaoR1.getStatus() == "Parado no terminal") {
                if (composicaoR1.isEmpilhavel() == true) {
                    composicaoR1.getVagoesPilha().push(v);
                } else {
                    System.out.println(
                            "Essa locomotiva nÃ£o pode receber um vagÃ£o no momento pois sua posiÃ§Ã£o Ã©: "
                                    + composicaoR1.getStatus());
                    System.out.println("Voltar para o menu");
                    alert.setTitle("Atenção!");
                    alert.setHeaderText("Essa locomotiva não pode receber um vagão no momento, pois sua possição é: " +
                            composicaoR1.getStatus());
                    alert.showAndWait();
                }
            } else {
                System.out.println("A locomotiva nÃ£o se encontra parada no terminal.");
                System.out.println("Voltar para o menu");
                alert.setTitle("Atenção!");
                alert.setHeaderText("A locomotiva não se encontra parada no terminal.");
                alert.showAndWait();
            }

        }

        if (indexTerminal == 2) {
            v.setTipoCarga(2);
            System.out.println("Adicionado com sucesso na composição 2");
            for (int i = 0; i < composicaoR2.getVagoesPilha().size(); i++) {
                if (composicaoR2.getVagoesPilha().get(i).getIndexVagao() == indexVagaoUpperCase) {
                    System.out.println("Este identificador jÃ¡ foi utilizado");
                    System.out.println("Voltar para o menu");
                    alert.setTitle("Atenção!");
                    alert.setHeaderText("Este identificador já foi utilizado");
                    alert.showAndWait();
                }
            }
            if (composicaoR2.getStatus() == "Parado no terminal") {
                if (composicaoR2.isEmpilhavel() == true) {
                    composicaoR2.getVagoesPilha().push(v);
                } else {
                    System.out.println(
                            "Essa locomotiva nÃ£o pode receber um vagÃ£o no momento pois sua posiÃ§Ã£o Ã©: "
                                    + composicaoR2.getStatus());
                    System.out.println("Voltar para o menu");
                    alert.setTitle("Atenção!");
                    alert.setHeaderText("Essa locomotiva não pode receber um vagão no momento, pois sua possição é: " +
                            composicaoR1.getStatus());
                    alert.showAndWait();
                }
            } else {
                System.out.println("A locomotiva nÃ£o se encontra parada no terminal.");
                System.out.println("Voltar para o menu");
                alert.setTitle("Atenção!");
                alert.setHeaderText("A locomotiva não se encontra parada no terminal.");
                alert.showAndWait();
            }

        }
        System.out.println("Voltar para o menu");
        changeScreen("main");
    }







}