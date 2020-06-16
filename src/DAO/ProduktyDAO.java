/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Damian
 */
public class ProduktyDAO {
    
    
    String produkt_id, nazwa, ilosc, model, cena_za_sztuke;

    public ProduktyDAO(String produkt_id, String nazwa, String ilosc, String model, String cena_za_sztuke) {
        this.produkt_id = produkt_id;
        this.nazwa = nazwa;
        this.ilosc = ilosc;
        this.model = model;
        this.cena_za_sztuke = cena_za_sztuke;
    }

    public String getProdukt_id() {
        return produkt_id;
    }

    public void setProdukt_id(String produkt_id) {
        this.produkt_id = produkt_id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getIlosc() {
        return ilosc;
    }

    public void setIlosc(String ilosc) {
        this.ilosc = ilosc;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String Model) {
        this.model = Model;
    }

    public String getCena_za_sztuke() {
        return cena_za_sztuke;
    }

    public void setCena_za_sztuke(String cena_za_sztuke) {
        this.cena_za_sztuke = cena_za_sztuke;
    }
    
}
