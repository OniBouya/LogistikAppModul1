package de.codeyourapp.sqldemo;

public class Lieferant {
    //Variablen
    private int Lieferant_id;
    private int Bezirk_id;
    private int LKW_id;
    private String Ansprechpartner;
    private String E_mail;
    private String Telefon;
    private String Mobil;

    //Constructor
    public Lieferant(int lieferant_id, int bezirk_id, int LKW_id, String ansprechpartner, String e_mail, String telefon, String mobil) {
        Lieferant_id = lieferant_id;
        Bezirk_id = bezirk_id;
        this.LKW_id = LKW_id;
        Ansprechpartner = ansprechpartner;
        E_mail = e_mail;
        Telefon = telefon;
        Mobil = mobil;
    }

    public Lieferant(){ }

    //toString
    @Override
    public String toString() {
        return "Lieferant{" +
                "Lieferant_id=" + Lieferant_id +
                ", Bezirk_id=" + Bezirk_id +
                ", LKW_id=" + LKW_id +
                ", Ansprechpartner='" + Ansprechpartner + '\'' +
                ", E_mail='" + E_mail + '\'' +
                ", Telefon='" + Telefon + '\'' +
                ", Mobil='" + Mobil + '\'' +
                '}';
    }

    //Getters und Setters
    public int getLieferant_id() {
        return Lieferant_id;
    }

    public void setLieferant_id(int lieferant_id) {
        Lieferant_id = lieferant_id;
    }

    public int getBezirk_id() {
        return Bezirk_id;
    }

    public void setBezirk_id(int bezirk_id) {
        Bezirk_id = bezirk_id;
    }

    public int getLKW_id() {
        return LKW_id;
    }

    public void setLKW_id(int LKW_id) {
        this.LKW_id = LKW_id;
    }

    public String getAnsprechpartner() {
        return Ansprechpartner;
    }

    public void setAnsprechpartner(String ansprechpartner) {
        Ansprechpartner = ansprechpartner;
    }

    public String getE_mail() {
        return E_mail;
    }

    public void setE_mail(String e_mail) {
        E_mail = e_mail;
    }

    public String getTelefon() {
        return Telefon;
    }

    public void setTelefon(String telefon) {
        Telefon = telefon;
    }

    public String getMobil() {
        return Mobil;
    }

    public void setMobil(String mobil) {
        Mobil = mobil;
    }
}
