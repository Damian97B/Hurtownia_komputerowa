
package Controllers;

import DAO.PrzychodDAO;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Damian
 */


public class PrzychodController implements Initializable {
   
    public static String przekazanie;  //dla produkty
    public static String przekazanie2; //dla klient
    
    
    @FXML
    private TableView przychod;
    @FXML
    private TableView przychodrok;
    @FXML
    private TextField searchfield;
    @FXML
    private TextField searchfieldmiesiac;
    @FXML
    private Button filtrujbutton;
    
//    @FXML
//    private TableColumn<PrzychodDAO, String> col_id;
    @FXML
    private TableColumn<PrzychodDAO, String> col_miesiac;
    @FXML
    private TableColumn<PrzychodDAO, String> col_rok;
    @FXML
    private TableColumn<PrzychodDAO, String> col_zarobek;
    
    @FXML
    private TableColumn<PrzychodDAO, String> col_rok1;
    @FXML
    private TableColumn<PrzychodDAO, String> col_zarobek1;

    
    
    
    ObservableList<PrzychodDAO> oblist = FXCollections.observableArrayList();
    
    ObservableList<PrzychodDAO> oblist1 = FXCollections.observableArrayList();
    
//    ObservableList<ZamowieniaDAO> oblist2 = FXCollections.observableArrayList(); //do szczegolow - produkty
//    
//    ObservableList<ZamowieniaDAO> oblist3 = FXCollections.observableArrayList(); //do szczegolow - klient
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                
        
        //przychod
//        col_id.setCellValueFactory(new PropertyValueFactory<>("zamowienie_id"));
        col_miesiac.setCellValueFactory(new PropertyValueFactory<>("miesiac"));
        col_rok.setCellValueFactory(new PropertyValueFactory<>("rok"));
        col_zarobek.setCellValueFactory(new PropertyValueFactory<>("kwota_calkowita"));

        //przychod za rok
        col_rok1.setCellValueFactory(new PropertyValueFactory<>("rok"));
        col_zarobek1.setCellValueFactory(new PropertyValueFactory<>("kwota_calkowita"));
        
            try {
            Connection con = DBConnector.getConnection();
            System.out.println("udalo sie ---------------------------------------------------------------------------------------------");
            filtrujbutton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {


                if ((searchfield.getText() != null && !searchfield.getText().isEmpty() && searchfieldmiesiac.getText() != null && !searchfieldmiesiac.getText().isEmpty())) { //rok + miesiac
                try {
                    
                    int szukaj = Integer.parseInt(searchfield.getText());
                    int szukajmiesiac = Integer.parseInt(searchfieldmiesiac.getText());
                    ResultSet rs = con.createStatement().executeQuery("select sum(kwota_calkowita) as zarobek, miesiac, rok from zamówienia  where miesiac = " + szukajmiesiac + " and rok = " + szukaj + " group by rok, miesiac order by rok");
                    przychod.refresh();
                    przychod.getItems().clear();
                    while(rs.next()){
                         

                        oblist.add(new PrzychodDAO(rs.getString("miesiac"), rs.getString("rok"),rs.getString("zarobek")));
     
                        przychod.setItems(oblist);
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(PrzychodController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }  else if ((searchfield.getText() != null && !searchfield.getText().isEmpty() )) { //sam rok
                try {
                    
                    int szukaj = Integer.parseInt(searchfield.getText());//dolna wartosc przedzialu roku
                    ResultSet rs = con.createStatement().executeQuery("select sum(kwota_calkowita) as zarobek, miesiac, rok from zamówienia  where rok = " + szukaj + " group by rok, miesiac order by rok");
                    przychod.refresh();
                    przychod.getItems().clear();
                    while(rs.next()){
                         

                        oblist.add(new PrzychodDAO(rs.getString("miesiac"), rs.getString("rok"), rs.getString("zarobek")));
     
                        przychod.setItems(oblist);
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(PrzychodController.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            } else if ((searchfieldmiesiac.getText() != null && !searchfieldmiesiac.getText().isEmpty() )) { // sam miesiac
                try {
                    
                    int szukajmiesiac = Integer.parseInt(searchfieldmiesiac.getText());
                    ResultSet rs = con.createStatement().executeQuery("select sum(kwota_calkowita) as zarobek, miesiac, rok from zamówienia  where miesiac = " + szukajmiesiac + " group by rok, miesiac order by rok");
                    przychod.refresh();
                    przychod.getItems().clear();
                    while(rs.next()){
                         

                        oblist.add(new PrzychodDAO(rs.getString("miesiac"), rs.getString("rok"),rs.getString("zarobek")));
     
                        przychod.setItems(oblist);
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(PrzychodController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } else  { //bez filtra
                try {
                    ResultSet rs = con.createStatement().executeQuery("select sum(kwota_calkowita) as zarobek, miesiac, rok from zamówienia group by rok, miesiac order by rok");
                    przychod.refresh();
                    przychod.getItems().clear();
                    while(rs.next()){

                        oblist.add(new PrzychodDAO(rs.getString("miesiac"), rs.getString("rok"),rs.getString("zarobek")));
        
                         
                    }
                    przychod.setItems(oblist);
                } catch (SQLException ex) {
                    Logger.getLogger(PrzychodController.class.getName()).log(Level.SEVERE, null, ex);
                }
                    }
            }
        });
//            ResultSet rs = con.createStatement().executeQuery("select * from zamówienia");
              ResultSet rs = con.createStatement().executeQuery("select sum(kwota_calkowita) as zarobek, miesiac, rok from zamówienia group by rok, miesiac order by rok");
            while(rs.next()){
                oblist.add(new PrzychodDAO(rs.getString("miesiac"), rs.getString("rok"), rs.getString("zarobek")));
            }
              ResultSet rs1 = con.createStatement().executeQuery("select sum(kwota_calkowita) as zarobek, rok from zamówienia group by rok order by rok");
            while(rs1.next()){
                oblist1.add(new PrzychodDAO(rs1.getString("rok"), rs1.getString("zarobek")));
            }
        } catch (SQLException ex) {

        }
            przychod.setItems(oblist);
            przychodrok.setItems(oblist1);
            
            
        //przychod za tylko rok
        
        
        
        
        

    }
   
    
}

