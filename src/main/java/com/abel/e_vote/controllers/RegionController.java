package com.abel.e_vote.controllers;

import com.abel.e_vote.models.Region;
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

public class RegionController implements Initializable {
    public Button RegionAdd;
    public TextField regionField;
    public TableView<Region> listeRegion;
    public TableColumn<Region,Integer> id_r_col;
    public TableColumn<Region,String> nom_r;
    public TableColumn<Region,Integer> nbr_ele;
    public Text message;

    public void addRegion() throws InterruptedException {
        String region = regionField.getText();
        if (region.equals("")){
            message.setText("- Le champ est vide");
        } else {
            message.setText("");
            ServerAccess.addRegion(region);
            Thread.sleep(100);
            fillTable();
        }
        regionField.clear();
    }

    public void fillTable(){
        List<Region> regions = ServerAccess.getAllRegions();
        id_r_col.setCellValueFactory(new PropertyValueFactory<>("id_region"));
        nom_r.setCellValueFactory(new PropertyValueFactory<>("nom"));
        nbr_ele.setCellValueFactory(new PropertyValueFactory<>("electeurs"));
        listeRegion.getItems().clear();
        listeRegion.getItems().addAll(regions);
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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillTable();
    }
}
