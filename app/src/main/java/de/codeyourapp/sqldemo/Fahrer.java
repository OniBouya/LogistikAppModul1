package de.codeyourapp.sqldemo;

public class Fahrer {

    //Variablen
    private int Fahrer_id;
    private String Mobil;
    private String Fuehrerscheinklasse;
    private String Gefahrgutschulung;

    //Constructor
    public Fahrer(int fahrer_id, String mobil, String fuehrerscheinklasse, String gefahrgutschulung) {
        Fahrer_id = fahrer_id;
        Mobil = mobil;
        Fuehrerscheinklasse = fuehrerscheinklasse;
        Gefahrgutschulung = gefahrgutschulung;
    }

    public Fahrer(){ }

    //toString für besseres handling
    @Override
    public String toString() {
        return "Fahrer{" +
                "Fahrer_id=" + Fahrer_id +
                ", Mobil='" + Mobil + '\'' +
                ", Fuehrerscheinklasse='" + Fuehrerscheinklasse + '\'' +
                ", Gefahrgutschulung='" + Gefahrgutschulung + '\'' +
                '}';
    }

    //Getters und Setters
    public int getFahrer_id() {
        return Fahrer_id;
    }

    public void setFahrer_id(int fahrer_id) {
        Fahrer_id = fahrer_id;
    }

    public String getMobil() {
        return Mobil;
    }

    public void setMobil(String mobil) {
        Mobil = mobil;
    }

    public String getFuehrerscheinklasse() {
        return Fuehrerscheinklasse;
    }

    public void setFuehrerscheinklasse(String fuehrerscheinklasse) {
        Fuehrerscheinklasse = fuehrerscheinklasse;
    }

    public String getGefahrgutschulung() {
        return Gefahrgutschulung;
    }

    public void setGefahrgutschulung(String gefahrgutschulung) {
        Gefahrgutschulung = gefahrgutschulung;
    }
}
