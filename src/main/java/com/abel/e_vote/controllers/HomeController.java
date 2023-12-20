package com.abel.e_vote.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class HomeController {
    @FXML
    private Button logoutButton;

    public void logout(ActionEvent e) throws IOException {
        SwitchController.logout(e);
    }
}
