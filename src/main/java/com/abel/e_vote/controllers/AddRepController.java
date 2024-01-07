package com.abel.e_vote.controllers;

import com.abel.e_vote.HelloApplication;
import com.abel.e_vote.models.Parti;
import com.abel.e_vote.models.RegionParti;
import com.abel.e_vote.services.ServerAccess;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AddRepController implements Initializable {

    public TableView<Parti> table_p;
    public TableColumn<Parti,Integer> id_p;
    public TableColumn<Parti,String> nom_p;
    public Text mes;
    public Button addRep;
    public TextField rep;
    public Integer id_r;
    public String nom_r;
    public Button button;
    public TextField field;
    public Text message;
    public Integer id_parti;
    public String nom_parti;

    public TableView<RegionParti> table_part;
    public TableColumn<RegionParti,String> nom_rep;
    public TableColumn<RegionParti,String> nom_part;
    public TableColumn<RegionParti,String> id_part;
    public Text titre;

    public void fillTable() {
        List<Parti> partis = ServerAccess.getAllPartis();
        id_p.setCellValueFactory(new PropertyValueFactory<>("id_parti"));
        nom_p.setCellValueFactory(new PropertyValueFactory<>("nom"));
        table_p.getItems().clear();
        table_p.getItems().addAll(partis);
    }
    public void fillTable2(){
        titre.setText("REPRESANTANTS DANS LA REGION "+getNom_r());
        List<RegionParti> regionPartis = ServerAccess.getVoteByRegion(id_r);
        id_part.setCellValueFactory(new PropertyValueFactory<>("id_parti"));
        nom_part.setCellValueFactory(new PropertyValueFactory<>("nom_parti"));
        nom_rep.setCellValueFactory(new PropertyValueFactory<>("nom_representant"));
        table_part.getItems().clear();
        table_part.getItems().addAll(regionPartis);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillTable();

        mes.textProperty().bind(
                Bindings.createStringBinding(()->{
                    if (table_p.getSelectionModel().getSelectedItem()==null){
                        message.setText("Sélectionner un parti et entrer son represantant");
                        return "";
                    }
                    id_parti = table_p.getSelectionModel().getSelectedItem().getId_parti();
                    nom_parti = table_p.getSelectionModel().getSelectedItem().getNom();
                    message.setText("Ajouter le represantant du parti "+nom_parti+" dans la region "+nom_r);
                    return "";
                },table_p.getSelectionModel().selectedItemProperty())
        );
        Platform.runLater(this::fillTable2);
    }

    public void ajouterRepresantat() throws InterruptedException {
        if (table_p.getSelectionModel().getSelectedItem()==null){
            message.setText("Sélectionner un parti dans la première et entrer son represantant");
            message.setStyle("-fx-text-fill:red");
        }else {
            if (field.getText().equals("")){
                message.setText("Le champ est vide");
            }else {
                ServerAccess.addRepresantant(id_r,id_parti,field.getText());
                Thread.sleep(500);
                message.setText("Represantant Ajouté");
                fillTable2();
                message.setStyle("-fx-text-fill:green");
                field.clear();
            }
        }
    }

    public Integer getId_r() {
        return id_r;
    }

    public void setId_r(Integer id_r) {
        this.id_r = id_r;
    }

    public String getNom_r() {
        return nom_r;
    }

    public void setNom_r(String nom_r) {
        this.nom_r = nom_r;
    }
}
