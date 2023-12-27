package com.abel.e_vote.controllers;

import com.abel.e_vote.models.Parti;
import com.abel.e_vote.services.ServerAccess;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PartiController implements Initializable {

    public Text message;
    public Button PartiAdd;
    public TextField partiField;
    public TableView<Parti> listeParti;
    public TableColumn<Parti,Integer> id_p_col;
    public TableColumn<Parti,String> nom_p;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillTable();
    }
    public void fillTable() {
        List<Parti> partis = ServerAccess.getAllPartis();
        id_p_col.setCellValueFactory(new PropertyValueFactory<>("id_parti"));
        nom_p.setCellValueFactory(new PropertyValueFactory<>("nom"));
        listeParti.getItems().clear();
        listeParti.getItems().addAll(partis);
    }
    public void logout(ActionEvent e) throws IOException {
        SwitchController.logout(e);
    }
    public void goHome(ActionEvent e) throws IOException{
        SwitchController.goHome(e);
    }
    public void goRegion(ActionEvent e) throws IOException{
        SwitchController.goRegion(e);
    }
    public void goParti(ActionEvent e) throws IOException{
        SwitchController.goParti(e);
    }
    public void goRep(ActionEvent e) throws IOException{
        SwitchController.goRep(e);
    }
    public void goVote(ActionEvent e) throws IOException{
        SwitchController.goVote(e);
    }
    public void goResult(ActionEvent e) throws IOException{
        SwitchController.goResult(e);
    }
    public void goAbout(ActionEvent e) throws IOException{
        SwitchController.goAbout(e);
    }
    public void addParti(ActionEvent event) throws InterruptedException {
        String parti = partiField.getText();
        if (parti.equals("")){
            message.setText("- Le champ est vide");
        } else {
            message.setText("");
            ServerAccess.addParti(parti);
            Thread.sleep(100);
            fillTable();
        }
        partiField.clear();
    }

}
