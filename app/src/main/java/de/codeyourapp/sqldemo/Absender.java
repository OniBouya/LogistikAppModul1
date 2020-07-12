package de.codeyourapp.sqldemo;

public class Absender {

    //Variablen
    private int Absender_id;
    private int Adresse_id;
    private String Vorname;
    private String Nachname;
    private String Email;
    private String Telefon;
    private String Mobil;

    //Constructor

    public Absender(int Absender_id, int Adresse_id, String Vorname, String Nachname, String Email, String Telefon, String Mobil) {
        this.Absender_id = Absender_id;
        this.Adresse_id = Adresse_id;
        this.Vorname = Vorname;
        this.Nachname = Nachname;
        this.Email = Email;
        this.Telefon = Telefon;
        this.Mobil = Mobil;
    }
    public Absender() { }

    //toString für besseres handling
    @Override
    public String toString() {
        return "Absender{" +
                "Absender_id=" + Absender_id +
                ", Adresse_id=" + Adresse_id +
                ", Vorname='" + Vorname + '\'' +
                ", Nachname='" + Nachname + '\'' +
                ", Email='" + Email + '\'' +
                ", Telefon='" + Telefon + '\'' +
                ", Mobil='" + Mobil + '\'' +
                '}';
    }

    //Getters und Setters
    public int getAbsender_id() {
        return Absender_id;
    }

    public void setAbsender_id(int absender_id) {
        Absender_id = absender_id;
    }

    public int getAdresse_id() {
        return Adresse_id;
    }

    public void setAdresse_id(int adress_id) {
        Adresse_id = adress_id;
    }

    public String getVorname() {
        return Vorname;
    }

    public void setVorname(String vorname) {
        Vorname = vorname;
    }

    public String getNachname() {
        return Nachname;
    }

    public void setNachname(String nachname) {
        Nachname = nachname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
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
