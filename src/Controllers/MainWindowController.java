
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;


public class MainWindowController implements Initializable {

    @FXML
    public ListView optionList;
    @FXML
    public Pane mainPane;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        String[] optlist = null;

        optlist = TabLists.getPracownik();
        this.optionList.getItems().addAll(optlist);
    }
    //This funcion is for testing fxmls's
    @FXML
    private void changeView() {
        Pane pane = null;
        try {
            int index = optionList.getItems().indexOf(optionList.getSelectionModel().getSelectedItem());
            FXMLLoader load = null;
            switch (index) {
                   
                        case 0: 
                            load = new FXMLLoader(getClass().getResource("/fxml/zamowienia.fxml"));
                            pane = load.load();
                            break;
                        case 1: 
                            load = new FXMLLoader(getClass().getResource("/fxml/przychod.fxml"));
                            pane = load.load();
                            break;
                        case 2: 
                            load = new FXMLLoader(getClass().getResource("/fxml/grupy.fxml"));
                            pane = load.load();
                            break;
            }
            if (load == null) {
                throw new Exception();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("ERROR: error load fxml during change view");
            return;
        }
        mainPane.getChildren().clear();
        mainPane.getChildren().add(pane);
    }
    
}




