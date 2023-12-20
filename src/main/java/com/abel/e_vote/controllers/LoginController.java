package com.abel.e_vote.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class LoginController {
    @FXML
    private Button login;
    @FXML
    private Button cancel;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Text message;
    public void loginAction(ActionEvent e) throws IOException {
        if (username.getText().equals("") || password.getText().equals("")){
            message.setText("Veuillez remplir tous les champs");
        }else if (username.getText().equals("abel") && password.getText().equals("1234")){
            SwitchController.goHome(e);
        }else {
            message.setText("Erreur de nom d'utilisateur ou de mot de passe");
        }
    }
    public void cancelAction(ActionEvent e){
        username.setText("");
        password.setText("");
    }
}
