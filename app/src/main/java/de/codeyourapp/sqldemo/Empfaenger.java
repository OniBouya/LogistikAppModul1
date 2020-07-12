package de.codeyourapp.sqldemo;

public class Empfaenger {

    //Variablen
    private int Empfaenger_id;
    private int Adresse_id;
    private String Vorname;
    private String Nachname;
    private String Email;
    private String Telefon;
    private String Mobil;

    //Constructor

    public Empfaenger(int Empfaenger_id, int Adress_id, String Vorname, String Nachname, String Email, String Telefon, String Mobil) {
        this.Empfaenger_id = Empfaenger_id;
        this.Adresse_id = Adress_id;
        this.Vorname = Vorname;
        this.Nachname = Nachname;
        this.Email = Email;
        this.Telefon = Telefon;
        this.Mobil = Mobil;
    }

    public Empfaenger() { }

    //toString für besseres handling
    @Override
    public String toString() {
        return "Empfaenger{" +
                "Empfaenger_id=" + Empfaenger_id +
                ", Adresse_id=" + Adresse_id +
                ", Vorname='" + Vorname + '\'' +
                ", Nachname='" + Nachname + '\'' +
                ", Email='" + Email + '\'' +
                ", Telefon='" + Telefon + '\'' +
                ", Mobil='" + Mobil + '\'' +
                '}';
    }

    //Getters und Setters
    public int getEmpfaenger_id() {
        return Empfaenger_id;
    }

    public void setEmpfaenger_id(int empfaenger_id) {
        Empfaenger_id = empfaenger_id;
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
