
package Controllers;

import DAO.ProduktyDAO;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Damian
 */


public class DostepnetowaryController implements Initializable {
   
    @FXML
    private TableView review;
    
    @FXML
    private TableColumn<ProduktyDAO, String> col_id;
    @FXML
    private TableColumn<ProduktyDAO, String> col_nazwa;
    @FXML
    private TableColumn<ProduktyDAO, String> col_ilosc;
    @FXML
    private TableColumn<ProduktyDAO, String> col_model;
    @FXML
    private TableColumn<ProduktyDAO, String> col_cena;
    
    
//        private void LoadData(){
//        try {
//            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/hurtowniakomputerowa", "postgres", "root");
//            System.out.println("Connected to the PostgreSQL server successfully.-------------------------------------------------");
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
    ObservableList<ProduktyDAO> oblist = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                
        
        
        col_id.setCellValueFactory(new PropertyValueFactory<>("produkt_id"));
        col_nazwa.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        col_ilosc.setCellValueFactory(new PropertyValueFactory<>("ilosc"));
        col_model.setCellValueFactory(new PropertyValueFactory<>("model"));
        col_cena.setCellValueFactory(new PropertyValueFactory<>("cena_za_sztuke"));
//        LoadData();
                        
//        TableColumn id = new TableColumn("ID");
//        TableColumn person = new TableColumn("Zamawiający");
//        TableColumn cost = new TableColumn("Cena");
//        TableColumn ordering_employee = new TableColumn("Id pr. zam.");
//        TableColumn implementing_employee = new TableColumn("Id pr. real.");
//        TableColumn status = new TableColumn("Status");
//        TableColumn CLIENTORDERID = new TableColumn("CLIENT_ORDER_ID");
//        
//        this.review.getColumns().addAll(id, person, cost, ordering_employee, implementing_employee, status, CLIENTORDERID);

        
            try {
            Connection con = DBConnector.getConnection();
            System.out.println("udalo sie ---------------------------------------------------------------------------------------------");
            ResultSet rs = con.createStatement().executeQuery("select * from produkty");
            
            while(rs.next()){
                oblist.add(new ProduktyDAO(rs.getString("produkt_id"), rs.getString("nazwa"), rs.getString("ilosc"), rs.getString("model"), rs.getString("cena_za_sztuke")));
            }
        } catch (SQLException ex) {

        }
        

//      id.setCellValueFactory(new PropertyValueFactory<klienci, Integer>("id"));
    review.setItems(oblist);
    }
    

    
    
}
