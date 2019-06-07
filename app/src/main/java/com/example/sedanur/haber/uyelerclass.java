package com.example.sedanur.haber;

/**
 * Created by Sedanur on 29.05.2018.
 */

public class uyelerclass {
    private String Isım;
    private String Sifre;
    public uyelerclass()
    {

    }
    public uyelerclass(String kullaniciadi, String sifresi)
    {
        setIsım(kullaniciadi);
        setSıfre(sifresi);
    }

    public void setIsım(String isim)
    {
        Isım=isim;
    }

    public  String getIsım()
    {

        return Isım;
    }
    public void setSıfre(String sifre)
    {
        Sifre=sifre;
    }

    public  String getSifre()
    {
        return Sifre;
    }
}
