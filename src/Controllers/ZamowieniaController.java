
package Controllers;

import DAO.ZamowieniaDAO;
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


public class ZamowieniaController implements Initializable {
   
    public static String przekazanie;  //dla produkty
    public static String przekazanie2; //dla klient
    
    
    @FXML
    private TableView zamowienia;
    @FXML
    private TableView szczegoly;
    @FXML
    private TableView szczegoly_klient;
    @FXML
    private TextField searchfield;
    @FXML
    private TextField searchfieldmiesiac;
    @FXML
    private TextField searchfieldpracownik;
    @FXML
    private Button filtrujbutton;
    
    @FXML
    private TableColumn<ZamowieniaDAO, String> col_id;
    @FXML
    private TableColumn<ZamowieniaDAO, String> col_dzien;
    @FXML
    private TableColumn<ZamowieniaDAO, String> col_miesiac;
    @FXML
    private TableColumn<ZamowieniaDAO, String> col_rok;
    @FXML
    private TableColumn<ZamowieniaDAO, String> col_klient;
    @FXML
    private TableColumn<ZamowieniaDAO, String> col_pracownik;
    @FXML
    private TableColumn<ZamowieniaDAO, String> col_kwota;
    
    @FXML
    private TableColumn<ZamowieniaDAO, String> col_nazwa;
    @FXML
    private TableColumn<ZamowieniaDAO, Integer> col_ilosc;
    @FXML
    private TableColumn<ZamowieniaDAO, Integer> col_cena;
    
    @FXML
    private TableColumn<ZamowieniaDAO, String> col_imie;
    @FXML
    private TableColumn<ZamowieniaDAO, String> col_nazwisko;
    @FXML
    private TableColumn<ZamowieniaDAO, String> col_ulica;
    @FXML
    private TableColumn<ZamowieniaDAO, String> col_miejscowosc;
    @FXML
    private TableColumn<ZamowieniaDAO, String> col_telefon;
    
    
    ObservableList<ZamowieniaDAO> oblist = FXCollections.observableArrayList();
    
    ObservableList<ZamowieniaDAO> oblist1 = FXCollections.observableArrayList();
    
    ObservableList<ZamowieniaDAO> oblist2 = FXCollections.observableArrayList(); //do szczegolow - produkty
    
    ObservableList<ZamowieniaDAO> oblist3 = FXCollections.observableArrayList(); //do szczegolow - klient
    
    ObservableList<ZamowieniaDAO> filteredData = FXCollections.observableArrayList(); //filtrowanie
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                
        
        //zamowienia tabelka
        col_id.setCellValueFactory(new PropertyValueFactory<>("zamowienie_id"));
        col_dzien.setCellValueFactory(new PropertyValueFactory<>("dzien"));
        col_miesiac.setCellValueFactory(new PropertyValueFactory<>("miesiac"));
        col_rok.setCellValueFactory(new PropertyValueFactory<>("rok"));
        col_klient.setCellValueFactory(new PropertyValueFactory<>("klient_id"));
        col_pracownik.setCellValueFactory(new PropertyValueFactory<>("pracownik_id"));
        col_kwota.setCellValueFactory(new PropertyValueFactory<>("kwota_calkowita"));

        
            try {
            Connection con = DBConnector.getConnection();
            System.out.println("udalo sie ---------------------------------------------------------------------------------------------");
            filtrujbutton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                
                if ((searchfield.getText() != null && !searchfield.getText().isEmpty() && searchfieldmiesiac.getText() != null && !searchfieldmiesiac.getText().isEmpty() && searchfieldpracownik.getText() != null && !searchfieldpracownik.getText().isEmpty())) { //rok + miesiac + pracownik
                try {
                    
                    int szukaj = Integer.parseInt(searchfield.getText());//rok
                    int szukajmiesiac = Integer.parseInt(searchfieldmiesiac.getText());
                    int szukajpracownik = Integer.parseInt(searchfieldpracownik.getText());
                    ResultSet rs = con.createStatement().executeQuery("select * from zamówienia where rok = " + szukaj + " and miesiac = " + szukajmiesiac + " and pracownik_id = " + szukajpracownik);
                    zamowienia.refresh();
                    zamowienia.getItems().clear();
                    while(rs.next()){
                         

                        oblist.add(new ZamowieniaDAO(rs.getString("zamowienie_id"), rs.getString("dzien"), rs.getString("miesiac"), rs.getString("rok"), rs.getString("klient_id"), rs.getString("pracownik_id"), rs.getString("kwota_calkowita")));
     
                        zamowienia.setItems(oblist);
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(ZamowieniaController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } else if ((searchfieldpracownik.getText() != null && !searchfieldpracownik.getText().isEmpty() && searchfieldmiesiac.getText() != null && !searchfieldmiesiac.getText().isEmpty())) { //pracownik + miesiac
                try {
                    
                    int szukajpracownik = Integer.parseInt(searchfieldpracownik.getText());//rok
                    int szukajmiesiac = Integer.parseInt(searchfieldmiesiac.getText());
                    ResultSet rs = con.createStatement().executeQuery("select * from zamówienia where rok = " + szukajpracownik + " and miesiac = " + szukajmiesiac);
                    zamowienia.refresh();
                    zamowienia.getItems().clear();
                    while(rs.next()){
                         

                        oblist.add(new ZamowieniaDAO(rs.getString("zamowienie_id"), rs.getString("dzien"), rs.getString("miesiac"), rs.getString("rok"), rs.getString("klient_id"), rs.getString("pracownik_id"), rs.getString("kwota_calkowita")));
     
                        zamowienia.setItems(oblist);
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(ZamowieniaController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } else if ((searchfield.getText() != null && !searchfield.getText().isEmpty() && searchfieldpracownik.getText() != null && !searchfieldpracownik.getText().isEmpty())) { //rok + pracownik
                try {
                    
                    int szukaj = Integer.parseInt(searchfield.getText());//rok
                    int szukajpracownik = Integer.parseInt(searchfieldpracownik.getText());
                    ResultSet rs = con.createStatement().executeQuery("select * from zamówienia where rok = " + szukaj + " and miesiac = " + szukajpracownik);
                    zamowienia.refresh();
                    zamowienia.getItems().clear();
                    while(rs.next()){
                         

                        oblist.add(new ZamowieniaDAO(rs.getString("zamowienie_id"), rs.getString("dzien"), rs.getString("miesiac"), rs.getString("rok"), rs.getString("klient_id"), rs.getString("pracownik_id"), rs.getString("kwota_calkowita")));
     
                        zamowienia.setItems(oblist);
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(ZamowieniaController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } else if ((searchfield.getText() != null && !searchfield.getText().isEmpty() && searchfieldmiesiac.getText() != null && !searchfieldmiesiac.getText().isEmpty())) { //rok + miesiac
                try {
                    
                    int szukaj = Integer.parseInt(searchfield.getText());//rok
                    int szukajmiesiac = Integer.parseInt(searchfieldmiesiac.getText());
                    ResultSet rs = con.createStatement().executeQuery("select * from zamówienia where rok = " + szukaj + " and miesiac = " + szukajmiesiac);
                    zamowienia.refresh();
                    zamowienia.getItems().clear();
                    while(rs.next()){
                         

                        oblist.add(new ZamowieniaDAO(rs.getString("zamowienie_id"), rs.getString("dzien"), rs.getString("miesiac"), rs.getString("rok"), rs.getString("klient_id"), rs.getString("pracownik_id"), rs.getString("kwota_calkowita")));
     
                        zamowienia.setItems(oblist);
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(ZamowieniaController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }  else if ((searchfield.getText() != null && !searchfield.getText().isEmpty() )) { //sam rok
                try {
                    
                    int szukaj = Integer.parseInt(searchfield.getText());//dolna wartosc przedzialu roku
                    ResultSet rs = con.createStatement().executeQuery("select * from zamówienia where rok = " + szukaj);
                    zamowienia.refresh();
                    zamowienia.getItems().clear();
                    while(rs.next()){
                         

                        oblist.add(new ZamowieniaDAO(rs.getString("zamowienie_id"), rs.getString("dzien"), rs.getString("miesiac"), rs.getString("rok"), rs.getString("klient_id"), rs.getString("pracownik_id"), rs.getString("kwota_calkowita")));
     
                        zamowienia.setItems(oblist);
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(ZamowieniaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            } else if ((searchfieldpracownik.getText() != null && !searchfieldpracownik.getText().isEmpty() )) { // sam pracownik
                try {
                    
                    int szukajpracownik = Integer.parseInt(searchfieldpracownik.getText());
                    ResultSet rs = con.createStatement().executeQuery("select * from zamówienia where pracownik_id = " + szukajpracownik);
                    zamowienia.refresh();
                    zamowienia.getItems().clear();
                    while(rs.next()){
                         

                        oblist.add(new ZamowieniaDAO(rs.getString("zamowienie_id"), rs.getString("dzien"), rs.getString("miesiac"), rs.getString("rok"), rs.getString("klient_id"), rs.getString("pracownik_id"), rs.getString("kwota_calkowita")));
     
                        zamowienia.setItems(oblist);
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(ZamowieniaController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } else if ((searchfieldmiesiac.getText() != null && !searchfieldmiesiac.getText().isEmpty() )) { // sam miesiac
                try {
                    
                    int szukajmiesiac = Integer.parseInt(searchfieldmiesiac.getText());
                    ResultSet rs = con.createStatement().executeQuery("select * from zamówienia where miesiac = " + szukajmiesiac);
                    zamowienia.refresh();
                    zamowienia.getItems().clear();
                    while(rs.next()){
                         

                        oblist.add(new ZamowieniaDAO(rs.getString("zamowienie_id"), rs.getString("dzien"), rs.getString("miesiac"), rs.getString("rok"), rs.getString("klient_id"), rs.getString("pracownik_id"), rs.getString("kwota_calkowita")));
     
                        zamowienia.setItems(oblist);
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(ZamowieniaController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } else  { //bez filtra
                try {
                    ResultSet rs = con.createStatement().executeQuery("select * from zamówienia");
                    zamowienia.refresh();
                    zamowienia.getItems().clear();
                    while(rs.next()){

                        oblist.add(new ZamowieniaDAO(rs.getString("zamowienie_id"), rs.getString("dzien"), rs.getString("miesiac"), rs.getString("rok"), rs.getString("klient_id"), rs.getString("pracownik_id"), rs.getString("kwota_calkowita")));
        
                         
                    }
                    zamowienia.setItems(oblist);
                } catch (SQLException ex) {
                    Logger.getLogger(ZamowieniaController.class.getName()).log(Level.SEVERE, null, ex);
                }
                    }
            }
        });
            ResultSet rs = con.createStatement().executeQuery("select * from zamówienia");
            
            while(rs.next()){
                oblist.add(new ZamowieniaDAO(rs.getString("zamowienie_id"), rs.getString("dzien"), rs.getString("miesiac"), rs.getString("rok"), rs.getString("klient_id"), rs.getString("pracownik_id"), rs.getString("kwota_calkowita")));
            }
        } catch (SQLException ex) {

        }
            zamowienia.setItems(oblist);
            
            
        //szczegoly zamowienia - produkt
            
        col_nazwa.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        col_ilosc.setCellValueFactory(new PropertyValueFactory<>("ilosc"));
        col_cena.setCellValueFactory(new PropertyValueFactory<>("cena_za_sztuke"));
        
        
        
        
        //szczegoly zamowienia - klient
        
        col_imie.setCellValueFactory(new PropertyValueFactory<>("imie"));
        col_nazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
        col_ulica.setCellValueFactory(new PropertyValueFactory<>("ulica"));
        col_miejscowosc.setCellValueFactory(new PropertyValueFactory<>("miejscowość"));
        col_telefon.setCellValueFactory(new PropertyValueFactory<>("telefon"));
        
        
        
            
            zamowienia.setRowFactory(tv -> {   
            TableRow<ZamowieniaDAO> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (!row.isEmpty())) {
                    try {
                        ZamowieniaDAO rowData = row.getItem();
                        System.out.println(row);
                        szczegoly.getItems().clear();
                        szczegoly.refresh();
                        szczegoly_klient.getItems().clear();
                        szczegoly_klient.refresh();
                        
                        
                        System.out.println(rowData);

                        
                        przekazanie = rowData.getZamowienie_id();
                        
                        Connection con = DBConnector.getConnection();                      
                        ResultSet rs2 = con.createStatement().executeQuery("select * from produkty where zamowienie_id = '" + przekazanie + "'");
                        
                        
                        przekazanie2 = rowData.getKlient_id();                  
                        ResultSet rs3 = con.createStatement().executeQuery("select * from klienci where klient_id = '" + przekazanie2 + "'");
                        
                        while(rs2.next()){
                oblist2.add(new ZamowieniaDAO(rs2.getString("nazwa"), rs2.getString("ilosc"), rs2.getString("cena_za_sztuke")));
            }
                        while(rs3.next()){
                oblist3.add(new ZamowieniaDAO(rs3.getString("imie"), rs3.getString("nazwisko"), rs3.getString("ulica"), rs3.getString("miejscowość"), rs3.getString("telefon")));
            }

                    } catch (SQLException ex) {
                        Logger.getLogger(ZamowieniaController.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        if (event.getClickCount() == 3 && (!row.isEmpty())) {
                            System.out.println("zakonczono wybieranie, zrestartuj aplikacje");
                        }
                    }
                }
            });
            return row;

        });
            
        szczegoly.setItems(oblist2);
        szczegoly_klient.setItems(oblist3);

    }
   
    
}

