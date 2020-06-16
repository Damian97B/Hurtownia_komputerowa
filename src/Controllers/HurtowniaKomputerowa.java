/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.awt.Color;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Damian
 */
public class HurtowniaKomputerowa extends Application {
           
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));

        Scene scene = new Scene(root);
        stage.setOnCloseRequest((WindowEvent we) -> {
            Platform.exit();
            System.exit(0);
        });  
        stage.setScene(scene);
        stage.show();

        stage.setTitle("Hurtownia komputerowa");
    
    }

    
    
    public static void main(String[] args) {
    launch(args);
    }
    
}
