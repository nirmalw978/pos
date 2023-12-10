package com.devstack.pos.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class UserRolesAndAuthoritiesFormController {
    public AnchorPane userRoleAndAuthorityContext;

    public void backToHome(ActionEvent actionEvent) throws IOException {
        setUi("UserManagementView");
    }

    public void manageUserRoleOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("ManageUserRoleForm");
    }

    public void manageAccessPointOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("ManageAccessPointForm");
    }

    public void managePrivilegesOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("ManagePrivilegesForm");
    }

    public void authoritiesOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("AuthoritiesForm");
    }

    private void setUi (String location) throws IOException {
        Stage stage = (Stage)userRoleAndAuthorityContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().
                getResource("../view/"+location+".fxml"))));
        stage.centerOnScreen();
    }
}
