package com.example.projectapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class AppController {
    @FXML
    public TextField idRAL;
    @FXML
    public TextField idAddC;
    @FXML
    public ChoiceBox<String> idRegions;
    @FXML
    public Label idWI1;
    @FXML
    public Label idWI2;
    @FXML
    public Button idExit1;
    public Button idNext;

    int countErrorRAL = 0, countErrorAddC = 0;
    boolean valueNext = true;
    String[] italianRegions = {"Abruzzo","Basilicata","Calabria","Campania","Emilia-Romagna","Friuli-Venezia Giulia","Lazio","Liguria","Lombardia","Marche","Molise","Piemonte","Puglia","Sardegna","Sicilia","Toscana","Trentino-Alto Adige","Umbria","Valle d'Aosta","Veneto"};

    public void initialize(){
        idRegions.getItems().addAll(italianRegions);
    }
    public void setRALEditable(MouseEvent mouseEvent) {
        idRAL.setEditable(true);
    }
    public void setAddCEditable(MouseEvent mouseEvent) {
        idAddC.setEditable(true);
    }
    public void errorValues(){
        if(countErrorRAL == 1 && countErrorAddC == 1){
            idWI1.setVisible(true);
            idWI2.setVisible(true);
        } else if(countErrorRAL == 1){
            idWI1.setVisible(true);
        } else if(countErrorAddC == 1){
            idWI2.setVisible(true);
        }
    }
    public void checkInsertedValues(){
        try{
            double valueOfRAL = Double.parseDouble(idRAL.getText());
        } catch (NumberFormatException e){
            countErrorRAL++;
            errorValues();
        }
        try{
            double valueOfAddC = Double.parseDouble(idAddC.getText());
        } catch (NumberFormatException e){
            countErrorAddC++;
            errorValues();
        }
        if(idRegions.getValue() == null || idRegions.getValue().isEmpty()){
            idRegions.setStyle("-fx-border-color: red; -fx-background-radius: 20; -fx-background-color: white; -fx-border-radius: 20;");
        }
        valueNext = false;
    }


    public void onRegionsClicked(MouseEvent mouseEvent) {
        idRegions.setStyle("-fx-border-color: gray; -fx-background-radius: 20; -fx-background-color: white; -fx-border-radius: 20;");
    }

    public void onExitClicked(){
        try{
            FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = fxmlLoader2.load();
            Stage stage2 = (Stage) idExit1.getScene().getWindow();
            stage2.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onNextClicked(){
        try{
            FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("Deductions.fxml"));
            Parent root = fxmlLoader2.load();
            Stage stage2 = (Stage) idNext.getScene().getWindow();
            stage2.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}