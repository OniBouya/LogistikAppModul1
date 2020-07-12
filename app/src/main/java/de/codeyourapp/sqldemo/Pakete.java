package de.codeyourapp.sqldemo;

public class Pakete {
    //Variablen
    private int Paket_id;
    private int Sendungs_id;
    private int Gewicht;
    private int Laenge;
    private int Breite;
    private int Hoehe;
    private int Gefahrgut;
    private int Stapelbar;
    private int Zerbrechlich;
    private String Richtung;

    //Constructor
    public Pakete(int paket_id, int sendungs_id, int gewicht, int laenge, int breite, int hoehe, int gefahrgut, int stapelbar, int zerbrechlich, String richtung) {
        Paket_id = paket_id;
        Sendungs_id = sendungs_id;
        Gewicht = gewicht;
        Laenge = laenge;
        Breite = breite;
        Hoehe = hoehe;
        Gefahrgut = gefahrgut;
        Stapelbar = stapelbar;
        Zerbrechlich = zerbrechlich;
        Richtung = richtung;
    }
    public Pakete(){ }

    //toString
    @Override
    public String toString() {
        return "Pakete{" +
                "Paket_id=" + Paket_id +
                ", Sendungs_id=" + Sendungs_id +
                ", Gewicht=" + Gewicht +
                ", Laenge=" + Laenge +
                ", Breite=" + Breite +
                ", Hoehe=" + Hoehe +
                ", Gefahrgut=" + Gefahrgut +
                ", Stapelbar=" + Stapelbar +
                ", Zerbrechlich=" + Zerbrechlich +
                ", Richtung='" + Richtung + '\'' +
                '}';
    }

    //Getters und Setters
    public int getPaket_id() {
        return Paket_id;
    }

    public void setPaket_id(int paket_id) {
        Paket_id = paket_id;
    }

    public int getSendungs_id() {
        return Sendungs_id;
    }

    public void setSendungs_id(int sendungs_id) {
        Sendungs_id = sendungs_id;
    }

    public int getGewicht() {
        return Gewicht;
    }

    public void setGewicht(int gewicht) {
        Gewicht = gewicht;
    }

    public int getLaenge() {
        return Laenge;
    }

    public void setLaenge(int laenge) {
        Laenge = laenge;
    }

    public int getBreite() {
        return Breite;
    }

    public void setBreite(int breite) {
        Breite = breite;
    }

    public int getHoehe() {
        return Hoehe;
    }

    public void setHoehe(int hoehe) {
        Hoehe = hoehe;
    }

    public int getGefahrgut() {
        return Gefahrgut;
    }

    public void setGefahrgut(int gefahrgut) {
        Gefahrgut = gefahrgut;
    }

    public int getStapelbar() {
        return Stapelbar;
    }

    public void setStapelbar(int stapelbar) {
        Stapelbar = stapelbar;
    }

    public int getZerbrechlich() {
        return Zerbrechlich;
    }

    public void setZerbrechlich(int zerbrechlich) {
        Zerbrechlich = zerbrechlich;
    }

    public String getRichtung() {
        return Richtung;
    }

    public void setRichtung(String richtung) {
        Richtung = richtung;
    }
}
