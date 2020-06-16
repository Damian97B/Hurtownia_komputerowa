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
public class PrzychodDAO {
    
    
    String miesiac, rok, kwota_calkowita;

    public PrzychodDAO(String miesiac, String rok, String kwota_calkowita) {
        this.miesiac = miesiac;
        this.rok = rok;
        this.kwota_calkowita = kwota_calkowita;
    }

    public PrzychodDAO(String rok, String kwota_calkowita) {
        this.rok = rok;
        this.kwota_calkowita = kwota_calkowita;
    }

    public String getMiesiac() {
        return miesiac;
    }

    public void setMiesiac(String miesiac) {
        this.miesiac = miesiac;
    }

    public String getRok() {
        return rok;
    }

    public void setRok(String rok) {
        this.rok = rok;
    }

    public String getKwota_calkowita() {
        return kwota_calkowita;
    }

    public void setKwota_calkowita(String kwota_calkowita) {
        this.kwota_calkowita = kwota_calkowita;
    }
    

   
    
}
