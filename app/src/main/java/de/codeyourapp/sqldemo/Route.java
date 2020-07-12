package de.codeyourapp.sqldemo;

public class Route {
    //Variablen
    private int route_id;
    private String GPS_stamp;
    private String Zeitstempel;

    //constructors
    public Route(int route_id, String GPS_stamp, String Zeitstempel) {
        this.route_id = route_id;
        this.GPS_stamp = GPS_stamp;
        this.Zeitstempel = Zeitstempel;
    }
    public Route() {}

    //toString


    @Override
    public String toString() {
        return "Route{" +
                "route_id=" + route_id +
                ", GPS_stamp='" + GPS_stamp + '\'' +
                ", Zeitstempel=" + Zeitstempel +

                '}';
    }

    // Getters und Setters

    public int getRoute_id() {
        return route_id;
    }

    public void setRoute_id(int route_id) {
        this.route_id = route_id;
    }

    public String getGPS_stamp() {
        return GPS_stamp;
    }

    public void setGPS_stamp(String GPS_stamp) {
        this.GPS_stamp = GPS_stamp;
    }

    public String getZeitstempel() {
        return Zeitstempel;
    }

    public void setZeitstempel(String zeitstempel) {
        Zeitstempel = zeitstempel;
    }
}

