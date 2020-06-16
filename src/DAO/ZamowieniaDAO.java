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
public class ZamowieniaDAO {
    
    
    String nazwa, imie, nazwisko, telefon, zamowienie_id, klient_id, pracownik_id, kwota_calkowita, ilosc, cena_za_sztuke, ulica, miejscowość, dzien, miesiac, rok;

    public ZamowieniaDAO(String zamowienie_id, String dzien, String miesiac, String rok, String klient_id, String pracownik_id, String kwota_calkowita) {
        this.zamowienie_id = zamowienie_id;
        this.dzien = dzien;
        this.miesiac = miesiac;
        this. rok = rok;
        this.klient_id = klient_id;
        this.pracownik_id = pracownik_id;
        this.kwota_calkowita = kwota_calkowita;
    }

    public ZamowieniaDAO(String imie, String nazwisko, String ulica, String miejscowość, String telefon) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.ulica = ulica;
        this.miejscowość = miejscowość;
        this.telefon = telefon;
    }

    public ZamowieniaDAO(String nazwa, String ilosc, String cena_za_sztuke) {
        this.nazwa = nazwa;
        this.ilosc = ilosc;
        this.cena_za_sztuke = cena_za_sztuke;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getZamowienie_id() {
        return zamowienie_id;
    }

    public void setZamowienie_id(String zamowienie_id) {
        this.zamowienie_id = zamowienie_id;
    }

    public String getKlient_id() {
        return klient_id;
    }

    public void setKlient_id(String klient_id) {
        this.klient_id = klient_id;
    }

    public String getPracownik_id() {
        return pracownik_id;
    }

    public void setPracownik_id(String pracownik_id) {
        this.pracownik_id = pracownik_id;
    }

    public String getKwota_calkowita() {
        return kwota_calkowita;
    }

    public void setKwota_calkowita(String kwota_calkowita) {
        this.kwota_calkowita = kwota_calkowita;
    }

    public String getIlosc() {
        return ilosc;
    }

    public void setIlosc(String ilosc) {
        this.ilosc = ilosc;
    }

    public String getCena_za_sztuke() {
        return cena_za_sztuke;
    }

    public void setCena_za_sztuke(String cena_za_sztuke) {
        this.cena_za_sztuke = cena_za_sztuke;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getMiejscowość() {
        return miejscowość;
    }

    public void setMiejscowość(String miejscowość) {
        this.miejscowość = miejscowość;
    }

    public String getDzien() {
        return dzien;
    }

    public void setDzien(String dzien) {
        this.dzien = dzien;
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

    
}
