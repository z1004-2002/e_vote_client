package com.abel.e_vote.controllers;

import com.abel.e_vote.models.Region;
import com.abel.e_vote.models.Represantant;
import com.abel.e_vote.models.Result;
import com.abel.e_vote.services.ServerAccess;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class ResultController implements Initializable {
    public TableView<Result> table_vote;
    public TableColumn<Result,String> nom_r;
    public TableColumn<Result,String> part_g;
    public TableColumn<Result,Integer> nbr_v;
    public TableColumn<Result,String> rep;
    public TableColumn<Result,Float> percent;
    public Text message;
    public ListView<String> region_plus;
    public ListView<String> region_tous;
    public Text per;
    public Text id_w;
    public Text nom_w;
    public Text rep_w;
    public Text rep_n;
    public Text nom_n;
    public Text id_n;
    public TableView<Represantant> table_r;
    public TableColumn<Represantant,String> par;
    public TableColumn<Represantant,String> repre;
    public TableColumn<Represantant,Float> per_v;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nom_r.setCellValueFactory(new PropertyValueFactory<>("nom_region"));
        part_g.setCellValueFactory(new PropertyValueFactory<>("parti_gagnant"));
        nbr_v.setCellValueFactory(new PropertyValueFactory<>("nombre_votants"));
        percent.setCellValueFactory(new PropertyValueFactory<>("percent_result"));
        rep.setCellValueFactory(new PropertyValueFactory<>("represantant"));

        par.setCellValueFactory(new PropertyValueFactory<>("nom_parti"));
        repre.setCellValueFactory(new PropertyValueFactory<>("nom_representant"));
        per_v.setCellValueFactory(new PropertyValueFactory<>("percent"));

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
            id_w.setText(String.valueOf(result.getId_parti_gagnant()));
            id_n.setText(String.valueOf(result.getId_parti_perdant()));
            nom_w.setText(result.getParti_gagnant());
            nom_n.setText(result.getParti_perdant());
            rep_w.setText(result.getRepresantant());
            rep_n.setText(result.getRepresantant_perdant());
            filltable(result);
            table_r.getSortOrder().add(per_v);
            per_v.setSortType(TableColumn.SortType.DESCENDING);
            table_r.sort();
            return "Resultat dans la région "+result.getNom_region();
        },table_vote.getSelectionModel().selectedItemProperty()));

        table_vote.setStyle("-fx-border-color: green;");
    }
    public void filltable() throws InterruptedException {
        region_plus.getItems().clear();
        region_tous.getItems().clear();
        List<Result> results = new ArrayList<>();
        float percent_result;
        List<Region> regions = ServerAccess.getAllRegions();
        int elect=0;
        int vot=0;
        for (Region region:regions){
            List<Represantant> represantants = ServerAccess.getVoteByRegion(region.getId_region());
            Represantant represantant = represantants.get(0);
            Represantant perdant = represantants.get(0);
            for (Represantant r: represantants){
                if (r.getVote()> represantant.getVote()){
                    represantant = r;
                }
                if (r.getVote()<perdant.getVote()){
                    perdant = r;
                }
                if (Objects.equals(region.getElecteurs(), region.getVotants()) && Objects.equals(region.getElecteurs(),r.getVote())){
                    region_tous.getItems().add(region.getId_region()+" : "+region.getNom());
                }

            }
            percent_result = (float) (((float)region.getVotants())/((float)region.getElecteurs())*100.0);
            results.add(new Result(
                    region.getId_region(),
                    region.getNom(),
                    represantant.getNom_parti(),
                    region.getVotants(),
                    (float) Math.round(percent_result*100)/100,
                    region.getElecteurs(),
                    region.getVotants(),
                    represantant.getNom_representant(),
                    represantant.getId_parti(),
                    perdant.getId_parti(),
                    perdant.getNom_parti(),
                    perdant.getNom_representant()
            ));
            if ((Math.round(percent_result*100)/100)>50){
                region_plus.getItems().add(region.getId_region()+" : "+region.getNom());
            }
            elect+=region.getElecteurs();
            vot+=region.getVotants();
        }
        if (elect!=0){
            float p = ((float) vot )/((float) elect)*100;
            p = (float) (Math.round(p * 100)/100);
            per.setText(p+"%");
        }else{
            per.setText("calcul...");
        }
        table_vote.getItems().clear();
        table_vote.getItems().addAll(results);
    }
    public void filltable(Result r){
        List<Represantant> represantants = ServerAccess.getVoteByRegion(r.getId_region());
        float percent_result;
        for (Represantant represantant : represantants){
            percent_result = (float) (((float) represantant.getVote())/((float)r.getVotants())*100.0);
            represantant.setPercent(
                    (float) Math.round(percent_result * 100) /100
            );
        }
        table_r.getItems().clear();
        table_r.getItems().addAll(represantants);
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
