module com.abel.e_vote {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.abel.e_vote to javafx.fxml;
    exports com.abel.e_vote;
    exports com.abel.e_vote.services;
    opens com.abel.e_vote.services to javafx.fxml;
    exports com.abel.e_vote.controllers;
    opens com.abel.e_vote.controllers to javafx.fxml;
}