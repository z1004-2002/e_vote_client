package com.abel.e_vote.controllers;

import com.abel.e_vote.models.Region;
import com.abel.e_vote.models.RegionParti;
import com.abel.e_vote.models.Result;
import com.abel.e_vote.services.ServerAccess;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ResultController implements Initializable {
    public TableView<Result> table_vote;
    public TableColumn<Result,Integer> id_r;
    public TableColumn<Result,String> nom_r;
    public TableColumn<Result,String> part_g;
    public TableColumn<Result,Integer> nbr_v;
    public TableColumn<Result,Float> percent;
    public Text message;
    public TableView<RegionParti> table_r;
    public TableColumn<RegionParti,Integer> id_p;
    public TableColumn<RegionParti,String> nom_p;
    public TableColumn<RegionParti,String> rep;
    public TableColumn<RegionParti,Integer> voi;
    public TableColumn<RegionParti,Float> per;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id_r.setCellValueFactory(new PropertyValueFactory<>("id_region"));
        nom_r.setCellValueFactory(new PropertyValueFactory<>("nom_region"));
        part_g.setCellValueFactory(new PropertyValueFactory<>("parti_gagnant"));
        nbr_v.setCellValueFactory(new PropertyValueFactory<>("nombre_voie"));
        percent.setCellValueFactory(new PropertyValueFactory<>("percent_result"));

        id_p.setCellValueFactory(new PropertyValueFactory<>("id_parti"));
        nom_p.setCellValueFactory(new PropertyValueFactory<>("nom_parti"));
        rep.setCellValueFactory(new PropertyValueFactory<>("nom_representant"));
        voi.setCellValueFactory(new PropertyValueFactory<>("vote"));
        per.setCellValueFactory(new PropertyValueFactory<>("percent"));
        try {
            filltable();
            table_vote.getSelectionModel().select(0);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        message.textProperty().bind(Bindings.createStringBinding(()->{
            if (table_vote.getSelectionModel().getSelectedItem()==null){
                return "Sélectionner une region pour avoir ses résultats";
            }
            Result result = table_vote.getSelectionModel().getSelectedItem();
            filltable(result);
            return "Resultat dans la région "+result.getNom_region();
        },table_vote.getSelectionModel().selectedItemProperty()));
    }
    public void filltable() throws InterruptedException {
        List<Result> results = new ArrayList<>();
        float percent_result;
        List<Region> regions = ServerAccess.getAllRegions();
        for (Region region:regions){
            List<RegionParti> regionPartis = ServerAccess.getVoteByRegion(region.getId_region());
            RegionParti regionParti = regionPartis.get(0);
            for (RegionParti r:regionPartis){
                if (r.getVote()>regionParti.getVote()){
                    regionParti = r;
                }
            }
            percent_result = (float) (((float)regionParti.getVote())/((float)region.getElecteurs())*100.0);
            results.add(new Result(
                    region.getId_region(),
                    region.getNom(),
                    regionParti.getNom_parti(),
                    regionParti.getVote(),
                    (float) Math.round(percent_result*100)/100,
                    region.getElecteurs()
            ));
        }
        table_vote.getItems().clear();
        table_vote.getItems().addAll(results);
    }
    public void filltable(Result r){
        List<RegionParti> regionPartis = ServerAccess.getVoteByRegion(r.getId_region());
        float percent_result;
        for (RegionParti regionParti:regionPartis){
            percent_result = (float) (((float)regionParti.getVote())/((float)r.getElecteurs())*100.0);
            regionParti.setPercent(
                    (float) Math.round(percent_result * 100) /100
            );
        }
        table_r.getItems().clear();
        table_r.getItems().addAll(regionPartis);
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
}
