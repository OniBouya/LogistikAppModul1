package de.codeyourapp.sqldemo;

public class Fahrzeugtyp {
    //Variablen
    private int Fahrzeugtyp_id;
    private String Fahrzeug_Bezeichnung;
    private int Anzahl_Stellplaetze;
    private int Max_Gewicht_Gramm;
    private int Max_Volumen_Cm3;
    private int Umweltplakette;
    private int Volumengewichtsindex;
    private int Fahrzeughoehe_Cm;
    private int Fahrzeugbreite_Cm;

    //Constructor
    public Fahrzeugtyp(int fahrzeugtyp_id, String fahrzeug_Bezeichnung, int anzahl_Stellplaetze, int max_Gewicht_Gramm, int max_Volumen_Cm3, int umweltplakette, int volumengewichtsindex, int fahrzeughoehe_Cm, int fahrzeugbreite_Cm) {
        Fahrzeugtyp_id = fahrzeugtyp_id;
        Fahrzeug_Bezeichnung = fahrzeug_Bezeichnung;
        Anzahl_Stellplaetze = anzahl_Stellplaetze;
        Max_Gewicht_Gramm = max_Gewicht_Gramm;
        Max_Volumen_Cm3 = max_Volumen_Cm3;
        Umweltplakette = umweltplakette;
        Volumengewichtsindex = volumengewichtsindex;
        Fahrzeughoehe_Cm = fahrzeughoehe_Cm;
        Fahrzeugbreite_Cm = fahrzeugbreite_Cm;
    }
    public Fahrzeugtyp () { }

    //toString
    @Override
    public String toString() {
        return "Fahrzeugtyp{" +
                "Fahrzeugtyp_id=" + Fahrzeugtyp_id +
                ", Fahrzeug_Bezeichnung='" + Fahrzeug_Bezeichnung + '\'' +
                ", Anzahl_Stellplaetze=" + Anzahl_Stellplaetze +
                ", Max_Gewicht_Gramm=" + Max_Gewicht_Gramm +
                ", Max_Volumen_Cm3=" + Max_Volumen_Cm3 +
                ", Umweltplakette=" + Umweltplakette +
                ", Volumengewichtsindex=" + Volumengewichtsindex +
                ", Fahrzeughoehe_Cm=" + Fahrzeughoehe_Cm +
                ", Fahrzeugbreite_Cm=" + Fahrzeugbreite_Cm +
                '}';
    }

    //Getters und Setters
    public int getFahrzeugtyp_id() {
        return Fahrzeugtyp_id;
    }

    public void setFahrzeugtyp_id(int fahrzeugtyp_id) {
        Fahrzeugtyp_id = fahrzeugtyp_id;
    }

    public String getFahrzeug_Bezeichnung() {
        return Fahrzeug_Bezeichnung;
    }

    public void setFahrzeug_Bezeichnung(String fahrzeug_Bezeichnung) {
        Fahrzeug_Bezeichnung = fahrzeug_Bezeichnung;
    }

    public int getAnzahl_Stellplaetze() {
        return Anzahl_Stellplaetze;
    }

    public void setAnzahl_Stellplaetze(int anzahl_Stellplaetze) {
        Anzahl_Stellplaetze = anzahl_Stellplaetze;
    }

    public int getMax_Gewicht_Gramm() {
        return Max_Gewicht_Gramm;
    }

    public void setMax_Gewicht_Gramm(int max_Gewicht_Gramm) {
        Max_Gewicht_Gramm = max_Gewicht_Gramm;
    }

    public int getMax_Volumen_Cm3() {
        return Max_Volumen_Cm3;
    }

    public void setMax_Volumen_Cm3(int max_Volumen_Cm3) {
        Max_Volumen_Cm3 = max_Volumen_Cm3;
    }

    public int getUmweltplakette() {
        return Umweltplakette;
    }

    public void setUmweltplakette(int umweltplakette) {
        Umweltplakette = umweltplakette;
    }

    public int getVolumengewichtsindex() {
        return Volumengewichtsindex;
    }

    public void setVolumengewichtsindex(int volumengewichtsindex) {
        Volumengewichtsindex = volumengewichtsindex;
    }

    public int getFahrzeughoehe_Cm() {
        return Fahrzeughoehe_Cm;
    }

    public void setFahrzeughoehe_Cm(int fahrzeughoehe_Cm) {
        Fahrzeughoehe_Cm = fahrzeughoehe_Cm;
    }

    public int getFahrzeugbreite_Cm() {
        return Fahrzeugbreite_Cm;
    }

    public void setFahrzeugbreite_Cm(int fahrzeugbreite_Cm) {
        Fahrzeugbreite_Cm = fahrzeugbreite_Cm;
    }
}
