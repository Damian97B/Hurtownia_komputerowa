/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;


import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.WindowEvent;
/**
 * FXML Controller class
 *
 * @author Damian
 */
public class LoginController implements Initializable {
    
    
    @FXML
    private TextField login;
    @FXML
    private PasswordField password;
    @FXML
    private Button ButtonLogin;
    
    
   
    @FXML
    private void addScene(ActionEvent event)throws IOException{
        
                    if(login.getText().equals("damian") && password.getText().equals("1234")) 
            {
                try 
                {
        Parent view2 = FXMLLoader.load(getClass().getResource("/fxml/MainWindow.fxml"));

        Scene scene2 = new Scene(view2);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    
            
                                    }
                catch (Exception e) 
                {
                    e.printStackTrace();
                }
            }  else {
                        System.out.println("nie udalo sie zalogowac");
                        }
    }
        
//            if(login.getText().equals("damian") && password.getText().equals("1234")) 
//            {
//                try 
//                {
//                    System.out.println("nie udalo sie zalogowac");
//                    Stage primaryStage = new Stage();
//                    Parent root = FXMLLoader.load(getClass().getResource("/fxml/MainWindow.fxml"));

//                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/FXML.fxml"));
//                    Parent parent = fxmlLoader.load();
//
//                    Scene scene = new Scene(parent);
//                    Stage stage = new Stage();
//                    stage.initModality(Modality.APPLICATION_MODAL);
//                    stage.setTitle("hurtownia komputerowa");
//
//                    stage.setScene(scene);
//                    stage.showAndWait();

//    @FXML
//    private void addScene(ActionEvent event)throws IOException{
//        try{
//        if(login.getText().equals("damian") && password.getText().equals("1234")){
//        Parent view2 = FXMLLoader.load(getClass().getResource("/fxml/zamowienia.fxml"));
//
//        Scene scene2 = new Scene(view2);
//
//        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//        window.setScene(scene2);
//        window.show();
//        }
//
//        }
//                                catch (Exception e) 
//                {
//                    e.printStackTrace();
//                }
//    }

    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

       
    } 
    
    
}

