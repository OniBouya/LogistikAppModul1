package de.codeyourapp.sqldemo;

public class Sendungen {
    //Variablen
    private int Sendungs_id;
    private int Absender_id;
    private int Versender_id;
    private int Empfaenger_id;
    private int Paket_id;
    private int Fahrzeug_id;

    private int Anzahl_Pakete;
    private int Entgeld_Cent;
    private int Warenwert_Cent;
    private int Versichert;
    private int Anonym;
    private int Disponiert;
    private int Zugestellt;
    private int Nachnahme;
    private int Bezirks_id;

    //Constructor
    public Sendungen(int sendungs_id, int absender_id, int versender_id, int empfaenger_id, int paket_id, int fahrzeug_id, int anzahl_Pakete, int entgeld_Cent, int warenwert_Cent, int versichert, int anonym, int disponiert, int zugestellt, int nachnahme, int bezirks_id) {
        Sendungs_id = sendungs_id;
        Absender_id = absender_id;
        Versender_id = versender_id;
        Empfaenger_id = empfaenger_id;
        Paket_id = paket_id;
        Fahrzeug_id = fahrzeug_id;
        Anzahl_Pakete = anzahl_Pakete;
        Entgeld_Cent = entgeld_Cent;
        Warenwert_Cent = warenwert_Cent;
        Versichert = versichert;
        Anonym = anonym;
        Disponiert = disponiert;
        Zugestellt = zugestellt;
        Nachnahme = nachnahme;
        Bezirks_id = bezirks_id;
    }

    public Sendungen() {}

    //toString

    @Override
    public String toString() {
        return "Sendungen{" +
                "Sendungs_id=" + Sendungs_id +
                ", Absender_id=" + Absender_id +
                ", Versender_id=" + Versender_id +
                ", Empfaenger_id=" + Empfaenger_id +
                ", Paket_id=" + Paket_id +
                ", Fahrzeug_id=" + Fahrzeug_id +
                ", Anzahl_Pakete=" + Anzahl_Pakete +
                ", Entgeld_Cent=" + Entgeld_Cent +
                ", Warenwert_Cent=" + Warenwert_Cent +
                ", Versichert=" + Versichert +
                ", Anonym=" + Anonym +
                ", Disponiert=" + Disponiert +
                ", Zugestellt=" + Zugestellt +
                ", Nachnahme=" + Nachnahme +
                ", Bezirks_id=" + Bezirks_id +
                '}';
    }

    //Getters and Setters

    public int getSendungs_id() {
        return Sendungs_id;
    }

    public void setSendungs_id(int sendungs_id) {
        Sendungs_id = sendungs_id;
    }

    public int getAbsender_id() {
        return Absender_id;
    }

    public void setAbsender_id(int absender_id) {
        Absender_id = absender_id;
    }

    public int getVersender_id() {
        return Versender_id;
    }

    public void setVersender_id(int versender_id) {
        Versender_id = versender_id;
    }

    public int getEmpfaenger_id() {
        return Empfaenger_id;
    }

    public void setEmpfaenger_id(int empfaenger_id) {
        Empfaenger_id = empfaenger_id;
    }

    public int getPaket_id() {
        return Paket_id;
    }

    public void setPaket_id(int paket_id) {
        Paket_id = paket_id;
    }

    public int getFahrzeug_id() {
        return Fahrzeug_id;
    }

    public void setFahrzeug_id(int fahrzeug_id) {
        Fahrzeug_id = fahrzeug_id;
    }

    public int getAnzahl_Pakete() {
        return Anzahl_Pakete;
    }

    public void setAnzahl_Pakete(int anzahl_Pakete) {
        Anzahl_Pakete = anzahl_Pakete;
    }

    public int getEntgeld_Cent() {
        return Entgeld_Cent;
    }

    public void setEntgeld_Cent(int entgeld_Cent) {
        Entgeld_Cent = entgeld_Cent;
    }

    public int getWarenwert_Cent() {
        return Warenwert_Cent;
    }

    public void setWarenwert_Cent(int warenwert_Cent) {
        Warenwert_Cent = warenwert_Cent;
    }

    public int getVersichert() {
        return Versichert;
    }

    public void setVersichert(int versichert) {
        Versichert = versichert;
    }

    public int getAnonym() {
        return Anonym;
    }

    public void setAnonym(int anonym) {
        Anonym = anonym;
    }

    public int getDisponiert() {
        return Disponiert;
    }

    public void setDisponiert(int disponiert) {
        Disponiert = disponiert;
    }

    public int getZugestellt() {
        return Zugestellt;
    }

    public void setZugestellt(int zugestellt) {
        Zugestellt = zugestellt;
    }

    public int getNachnahme() {
        return Nachnahme;
    }

    public void setNachnahme(int nachnahme) {
        Nachnahme = nachnahme;
    }

    public int getBezirks_id() {
        return Bezirks_id;
    }

    public void setBezirks_id(int bezirks_id) {
        Bezirks_id = bezirks_id;
    }
}


