package com.example.sedanur.haber;

/**
 * Created by Sedanur on 29.05.2018.
 */

public class haber {
    int id;
    String baslik;
    String tur;
    String icerik;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public haber(int id, String baslik, String tur, String icerik) {
        this.id = id;
        this.baslik = baslik;
        this.tur = tur;
        this.icerik = icerik;
    }
}
