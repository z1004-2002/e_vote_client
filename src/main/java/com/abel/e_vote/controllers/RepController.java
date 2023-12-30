package com.abel.e_vote.controllers;

import com.abel.e_vote.HelloApplication;
import com.abel.e_vote.models.Region;
import com.abel.e_vote.services.ServerAccess;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class RepController implements Initializable {
    public TableView<Region> listeRegion;
    public TableColumn<Region,Integer> id_r_col;
    public TableColumn<Region,String> nom_r;
    public TableColumn<Region,Integer> nbr_ele;
    public Text message;
    public Pane pane;
    public String nom_region;
    public Integer id_region;
    private Button addRep = new Button("Ajouter");

    public void fillTable(){
        List<Region> regions = ServerAccess.getAllRegions();
        id_r_col.setCellValueFactory(new PropertyValueFactory<>("id_region"));
        nom_r.setCellValueFactory(new PropertyValueFactory<>("nom"));
        nbr_ele.setCellValueFactory(new PropertyValueFactory<>("electeurs"));
        listeRegion.getItems().clear();
        listeRegion.getItems().addAll(regions);
    }

    public void genererElecteur() throws InterruptedException {
        ServerAccess.addElecteur();
        Thread.sleep(200);
        fillTable();
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
        message.textProperty().bind(
                Bindings.createStringBinding(()->{
                    if (listeRegion.getSelectionModel().getSelectedItem()==null){
                        pane.getChildren().clear();
                        return "Sélectionner une region";
                    }
                    id_region = listeRegion.getSelectionModel().getSelectedItem().getId_region();
                    nom_region = listeRegion.getSelectionModel().getSelectedItem().getNom();
                    Font font = Font.font("Arial", FontWeight.BOLD, 14);
                    addRep.setStyle("-fx-background-color: #159c00;-fx-text-fill:white;");
                    addRep.setFont(font);
                    pane.getChildren().clear();
                    pane.getChildren().add(addRep);

                    addRep.setOnAction(event -> {
                        Stage stage = new Stage();
                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("addRepParRegion.fxml"));
                        Scene scene;
                        try {
                            scene = new Scene(fxmlLoader.load(),600,500);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        stage.setTitle("Region "+id_region);
                        stage.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("evote.png")));
                        stage.setScene(scene);
                        AddRepController add = fxmlLoader.getController();
                        stage.initModality(Modality.APPLICATION_MODAL);
                        add.setId_r(id_region);
                        stage.setResizable(false);
                        add.setNom_r(nom_region);
                        stage.show();
                    });
                    return "Ajouter les represantants dans la region "+nom_region;
                },listeRegion.getSelectionModel().selectedItemProperty())
        );
    }
}
