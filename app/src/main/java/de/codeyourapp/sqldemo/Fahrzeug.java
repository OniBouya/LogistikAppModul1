package de.codeyourapp.sqldemo;

public class Fahrzeug {
    //Variablen
    private int Fahrzeug_id;
    private int Fahrer_id;
    private int Fahrzeugtyp_id;
    private String Kennzeichen;

    //Constructor
    public Fahrzeug(int fahrzeug_id, int fahrer_id, int fahrzeugtyp_id, String kennzeichen) {
        Fahrzeug_id = fahrzeug_id;
        Fahrer_id = fahrer_id;
        Fahrzeugtyp_id = fahrzeugtyp_id;
        Kennzeichen = kennzeichen;
    }
    public Fahrzeug() { }

    //toString für besseres handling
    @Override
    public String toString() {
        return "Fahrzeug{" +
                "Fahrzeug_id=" + Fahrzeug_id +
                ", Fahrer_id=" + Fahrer_id +
                ", Fahrzeugtyp_id=" + Fahrzeugtyp_id +
                ", Kennzeichen='" + Kennzeichen + '\'' +
                '}';
    }

    //Getters and Setters
    public int getFahrzeug_id() {
        return Fahrzeug_id;
    }

    public void setFahrzeug_id(int fahrzeug_id) {
        Fahrzeug_id = fahrzeug_id;
    }

    public int getFahrer_id() {
        return Fahrer_id;
    }

    public void setFahrer_id(int fahrer_id) {
        Fahrer_id = fahrer_id;
    }

    public int getFahrzeugtyp_id() {
        return Fahrzeugtyp_id;
    }

    public void setFahrzeugtyp_id(int fahrzeugtyp_id) {
        Fahrzeugtyp_id = fahrzeugtyp_id;
    }

    public String getKennzeichen() {
        return Kennzeichen;
    }

    public void setKennzeichen(String kennzeichen) {
        Kennzeichen = kennzeichen;
    }
}
