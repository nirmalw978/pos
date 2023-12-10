package com.devstack.pos.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class UserManagementViewController {

    public AnchorPane userManagementContext;

    public void backToHome(ActionEvent actionEvent) throws IOException {
        setUi("AdminPortalForm");

    }

    public void manageSystemUserOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("NewSystemUserForm");
    }

    public void newUserRoleOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("UserRolesAndAuthoritiesForm");
    }

    private void setUi (String location) throws IOException {
        Stage stage = (Stage)userManagementContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().
                getResource("../view/"+location+".fxml"))));
        stage.centerOnScreen();
    }
}
