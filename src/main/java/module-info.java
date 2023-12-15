module com.abel.e_vote {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.abel.e_vote to javafx.fxml;
    exports com.abel.e_vote;
}