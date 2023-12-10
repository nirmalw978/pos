package com.devstack.pos.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageUserRoleFormController {
    public AnchorPane manageUserRoleContext;

    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        setUi("UserRolesAndAuthoritiesForm");
    }


    private void setUi (String location) throws IOException {
        Stage stage = (Stage)manageUserRoleContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().
                getResource("../view/"+location+".fxml"))));
        stage.centerOnScreen();
    }
}
