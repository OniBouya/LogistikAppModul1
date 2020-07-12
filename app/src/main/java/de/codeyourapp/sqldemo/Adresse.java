package de.codeyourapp.sqldemo;

public class Adresse {

    //Variablen
    private int Adresse_id;
    private int Bezirk_id;
    private String Postleitzahl;
    private String Stadt;
    private String Strasse;
    private String Nr;
    private String Adresszusatz;

    //Constructor
    public Adresse(int adresse_id, int bezirk_id, String postleitzahl, String stadt, String strasse, String nr, String adresszusatz) {
        Adresse_id = adresse_id;
        Bezirk_id = bezirk_id;
        Postleitzahl = postleitzahl;
        Stadt = stadt;
        Strasse = strasse;
        Nr = nr;
        Adresszusatz = adresszusatz;
    }
    public Adresse() { }

    //toString für besseres handling
    @Override
    public String toString() {
        return "Adresse{" +
                "Adresse_id=" + Adresse_id +
                ", Bezirk_id=" + Bezirk_id +
                ", Postleitzahl='" + Postleitzahl + '\'' +
                ", Stadt='" + Stadt + '\'' +
                ", Strasse='" + Strasse + '\'' +
                ", Nr='" + Nr + '\'' +
                ", Adresszusatz='" + Adresszusatz + '\'' +
                '}';
    }

    //Getters und Setters
    public int getAdresse_id() {
        return Adresse_id;
    }

    public void setAdresse_id(int adresse_id) {
        Adresse_id = adresse_id;
    }

    public int getBezirk_id() {
        return Bezirk_id;
    }

    public void setBezirk_id(int bezirk_id) {
        Bezirk_id = bezirk_id;
    }

    public String getPostleitzahl() {
        return Postleitzahl;
    }

    public void setPostleitzahl(String postleitzahl) {
        Postleitzahl = postleitzahl;
    }

    public String getStadt() {
        return Stadt;
    }

    public void setStadt(String stadt) {
        Stadt = stadt;
    }

    public String getStrasse() {
        return Strasse;
    }

    public void setStrasse(String strasse) {
        Strasse = strasse;
    }

    public String getNr() {
        return Nr;
    }

    public void setNr(String nr) {
        Nr = nr;
    }

    public String getAdresszusatz() {
        return Adresszusatz;
    }

    public void setAdresszusatz(String adresszusatz) {
        Adresszusatz = adresszusatz;
    }
}