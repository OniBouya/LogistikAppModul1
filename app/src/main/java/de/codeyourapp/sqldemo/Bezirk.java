package de.codeyourapp.sqldemo;

public class Bezirk {
    //Variablen
    private int Bezirk_id;
    private int Lieferant_id;
    private int Abgasnorm;
    private int Anzahl_Kunden;
    //Constructor
    public Bezirk(int bezirk_id, int lieferant_id, int abgasnorm, int anzahl_Kunden) {
        Bezirk_id = bezirk_id;
        Lieferant_id = lieferant_id;
        Abgasnorm = abgasnorm;
        Anzahl_Kunden = anzahl_Kunden;
    }
    public Bezirk() { }

    // toString für besseres handling
    @Override
    public String toString() {
        return "Bezirk{" +
                "Bezirk_id=" + Bezirk_id +
                ", Lieferant_id=" + Lieferant_id +
                ", Abgasnorm=" + Abgasnorm +
                ", Anzahl_Kunden=" + Anzahl_Kunden +
                '}';
    }
    //Getters und Setters
    public int getBezirk_id() {
        return Bezirk_id;
    }
    public void setBezirk_id(int bezirk_id) {
        Bezirk_id = bezirk_id;
    }
    public int getLieferant_id() {
        return Lieferant_id;
    }
    public void setLieferant_id(int lieferant_id) {
        Lieferant_id = lieferant_id;
    }
    public int getAbgasnorm() {
        return Abgasnorm;
    }
    public void setAbgasnorm(int abgasnorm) {
        Abgasnorm = abgasnorm;
    }
    public double getAnzahl_Kunden() {
        return Anzahl_Kunden;
    }
    public void setAnzahl_Kunden(int anzahl_Kunden) {
        Anzahl_Kunden = anzahl_Kunden;
    }
}
