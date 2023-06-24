package com.example.controleS;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class scene1controller {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
 @FXML
    protected void login() throws IOException {
     if (username.getText().equals("x") && password.getText().equals("x")) {
         Stage s= (Stage) username.getScene().getWindow();
         FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("scene2.fxml"));
         Scene scene = new Scene(fxmlLoader.load());
         s.setScene(scene);

     }
     else {
         Alert alert=new Alert(Alert.AlertType.ERROR);
         alert.setTitle("Authentification Error");
         alert.setHeaderText("username or password is incorrect!");
         alert.setContentText("you can retry by changing your information");
         alert.show();

     }

 }

}