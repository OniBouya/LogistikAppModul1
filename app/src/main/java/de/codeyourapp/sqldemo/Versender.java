package de.codeyourapp.sqldemo;

public class Versender {
    //Variablen
    private int Versender_id;
    private int Adresse_id;
    private String Vorname;
    private String Nachname;
    private String Email;
    private String Telefon;
    private String Mobil;

    //Constructor

    public Versender(int Versender_id, int Adresse_id, String Vorname, String Nachname, String Email, String Telefon, String Mobil) {
        this.Versender_id = Versender_id;
        this.Adresse_id = Adresse_id;
        this.Vorname = Vorname;
        this.Nachname = Nachname;
        this.Email = Email;
        this.Telefon = Telefon;
        this.Mobil = Mobil;
    }
    public Versender() { }

    //toString
    @Override
    public String toString() {
        return "Versender{" +
                "Versender_id=" + Versender_id +
                ", Adresse_id=" + Adresse_id +
                ", Vorname='" + Vorname + '\'' +
                ", Nachname='" + Nachname + '\'' +
                ", Email='" + Email + '\'' +
                ", Telefon='" + Telefon + '\'' +
                ", Mobil='" + Mobil + '\'' +
                '}';
    }

    //Getters und Setters
    public int getVersender_id() {
        return Versender_id;
    }

    public void setVersender_id(int versender_id) {
        Versender_id = versender_id;
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
