package de.codeyourapp.sqldemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    //Bezeichner um in der Lage zu sein die Tabellennamen noch zu verändern. Ist auch sehr hilfreich wenn die App in andere Sprachen übersetzt werden soll.
    //Für Tabelle Customer
    private static final String CUSTOMER_TABLE = "CUSTOMER_TABLE";
    private static final String COLUMN_CUSTOMER_NAME = "CUSTOMER_NAME";
    private static final String COLUMN_CUSTOMER_AGE = "CUSTOMER_AGE";
    private static final String COLUMN_ACTIVE_CUSTOMER = "ACTIVE_CUSTOMER";
    private static final String COLUMN_ID = "ID";
    //Für Tabelle Route
    private static final String ROUTE_TABLE = "ROUTE_TABLE";
    private static final String COLUMN_ROUTE_ID = "ROUTE_ID";
    private static final String COLUMN_GPS_STAMP = "ROUTE_GPS_STAMP";
    private static final String COLUMN_ZEITSTEMPEL = "ROUTE_ZEITSTEMPEL";
    //Für Tabelle Empfaenger
    private static final String EMPFAENGER_TABLE = "EMPFAENGER_TABLE";
    private static final String COLUMN_EMPFAENGER_ID = "COLUMN_EMPFAENGER_ID";
    private static final String COLUMN_VORNAME = "COLUMN_VORNAME";
    private static final String COLUMN_NACHNAME = "COLUMN_NACHNAME";
    private static final String COLUMN_EMAIL = "COLUMN_EMAIL";
    private static final String COLUMN_TELEFON = "COLUMN_TELEFON";
    private static final String COLUMN_MOBIL = "COLUMN_MOBIL";
    private static final String COLUMN_ADRESSE_ID = "COLUMN_ADRESSE_ID";
    //Für Tabelle Absender
    private static final String ABSENDER_TABLE = "ABSENDER_TABLE";
    private static final String COLUMN_ABSENDER_ID = "COLUMN_ABSENDER_ID";
    //Für Tabelle Versender
    private static final String VERSENDER_TABLE = "VERSENDER_TABLE";
    private static final String COLUMN_VERSENDER_ID = "COLUMN_VERSENDER_ID";
    //Für Tabelle Adresse
    private static final String ADRESSE_TABLE = "ADRESSE_TABLE";
    private static final String COLUMN_BEZIRK_ID = "COLUMN_BEZIRK_ID";
    private static final String COLUMN_POSTLEITZAHL = "COLUMN_POSTLEITZAHL";
    private static final String COLUMN_STADT = "COLUMN_STADT";
    private static final String COLUMN_STRASSE = "COLUMN_STRASSE";
    private static final String COLUMN_NR = "COLUMN_NR";
    private static final String COLUMN_ADRESSZUSATZ = "COLUMN_ADRESSZUSATZ";
    //Für Tabelle Bezirk
    private static final String BEZIRK_TABLE = "BEZIRK_TABLE";
    private static final String COLUMN_LIEFERANT_ID = "COLUMN_LIEFERANT_ID";
    private static final String COLUMN_ABGASNORM = "COLUMN_ABGASNORM";
    private static final String COLUMN_ANZAHL_KUNDEN = "COLUMN_ANZAHL_KUNDEN";
    //Für Tabelle Lieferanten
    private static final String LIEFERANT_TABLE = "LIEFERANT_TABLE";
    private static final String COLUMN_LKW_ID = "COLUMN_LKW_ID";
    private static final String COLUMN_ANSPRECHPARTNER = "COLUMN_ANSPRECHPARTNER";
    private static final String COLUMN_E_MAIL = "COLUMN_E_MAIL";
    //Für Tabelle Fahrzeug
    private static final String FAHRZEUG_TABLE = "FAHRZEUG_TABLE";
    private static final String COLUMN_FAHRZEUG_ID = "COLUMN_FAHRZEUG_ID";
    private static final String COLUMN_FAHRER_ID = "COLUMN_FAHRER_ID";
    private static final String COLUMN_FAHRZEUGTYP_ID = "COLUMN_FAHRZEUGTYP_ID";
    private static final String COLUMN_KENNZEICHEN = "COLUMN_KENNZEICHEN";
    //Für Tabelle Fahrzeugtyp
    private static final String FAHRZEUGTYP_TABLE = "FAHRZEUGTYP_TABLE";
    private static final String COLUMN_FAHRZEUG_BEZEICHNUNG = "COLUMN_FAHRZEUG_BEZEICHNUNG";
    private static final String COLUMN_ANZAHL_STELLPLAETZE = "COLUMN_ANZAHL_STELLPLAETZE";
    private static final String COLUMN_MAX_GEWICHT_GRAMM = "COLUMN_MAX_GEWICHT_GRAMM";
    private static final String COLUMN_MAX_VOLUMEN_CM3 = "COLUMN_MAX_VOLUMEN_CM3";
    private static final String COLUMN_UMWELTPLAKETTE = "COLUMN_UMWELTPLAKETTE";
    private static final String COLUMN_VOLUMENGEWICHTSINDEX = "COLUMN_VOLUMENGEWICHTSINDEX";
    private static final String COLUMN_FAHRZEUGHOEHE_CM = "COLUMN_FAHRZEUGHOEHE_CM";
    private static final String COLUMN_FAHRZEUGBREITE_CM = "COLUMN_FAHRZEUGBREITE_CM";
    //Für Tabelle Fahrer
    private static final String FAHRER_TABLE = "FAHRER_TABLE";
    private static final String COLUMN_FUEHRERSCHEINKLASSE = "COLUMN_FUEHRERSCHEINKLASSE";
    private static final String COLUMN_GEFAHRGUTSCHULUNG = "COLUMN_GEFAHRGUTSCHULUNG";
    //Für Tabelle Sendungen
    private static final String SENDUNGS_TABLE = "SENDUNGS_TABLE";
    private static final String COLUMN_SENDUNGS_ID = "COLUMN_SENDUNGS_ID";
    private static final String COLUMN_PAKET_ID = "COLUMN_PAKET_ID";
    private static final String COLUMN_ANZAHL_PAKETE = "COLUMN_ANZAHL_PAKETE";
    private static final String COLUMN_ENTGELD_CENT = "COLUMN_ENTGELD_CENT";
    private static final String COLUMN_WARENWERT_CENT = "COLUMN_WARENWERT_CENT";
    private static final String COLUMN_VERSICHERT = "COLUMN_VERSICHERT";
    private static final String COLUMN_ANONYM = "COLUMN_ANONYM";
    private static final String COLUMN_DISPONIERT = "COLUMN_DISPONIERT";
    private static final String COLUMN_ZUGESTELLT = "COLUMN_ZUGESTELLT";
    private static final String COLUMN_NACHNAHME = "COLUMN_NACHNAHME";
    //Für Tabelle Pakete
    private static final String PAKETE_TABLE = "PAKETE_TABLE";
    private static final String COLUMN_GEWICHT = "GEWICHT";
    private static final String COLUMN_LAENGE = "LAENGE";
    private static final String COLUMN_BREITE = "BREITE";
    private static final String COLUMN_HOEHE = "HOEHE";
    private static final String COLUMN_GEFAHRGUT = "GEFAHRGUT";
    private static final String COLUMN_STAPELBAR = "STAPELBAR";
    private static final String COLUMN_ZERBRECHLICH = "ZERBRECHLICH";
    private static final String COLUMN_RICHTUNG = "RICHTUNG";


    public DataBaseHelper(@Nullable Context context) {
        super(context, "Customer.db", null, 1);
    }


    //Funktion wird ausgeführt, wenn das erste mal auf die Datenbank zugegriffen wird. Alle Tabellen werden angelegt.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement1 = "CREATE TABLE " + CUSTOMER_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_CUSTOMER_NAME + " TEXT, " + COLUMN_CUSTOMER_AGE + " INT, " + COLUMN_ACTIVE_CUSTOMER + " BOOL)";
        db.execSQL(createTableStatement1);
        String createTableStatement2 = "CREATE TABLE " + ROUTE_TABLE + " (" + COLUMN_ROUTE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_GPS_STAMP + " TEXT, " + COLUMN_ZEITSTEMPEL + " TEXT )";
        db.execSQL(createTableStatement2);
        String createTableStatement3 = "CREATE TABLE " + EMPFAENGER_TABLE + " (" + COLUMN_EMPFAENGER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_ADRESSE_ID + " INT, " + COLUMN_VORNAME + " TEXT, " + COLUMN_NACHNAME + " TEXT, " + COLUMN_EMAIL + " TEXT, " + COLUMN_TELEFON + " TEXT, " + COLUMN_MOBIL + " TEXT )";
        db.execSQL(createTableStatement3);
        String createTableStatement4 = "CREATE TABLE " + ABSENDER_TABLE + " (" + COLUMN_ABSENDER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_ADRESSE_ID + " INT, " + COLUMN_VORNAME + " TEXT, " + COLUMN_NACHNAME + " TEXT, " + COLUMN_EMAIL + " TEXT, " + COLUMN_TELEFON + " TEXT, " + COLUMN_MOBIL + " TEXT )";
        db.execSQL(createTableStatement4);
        String createTableStatement5 = "CREATE TABLE " + VERSENDER_TABLE + " (" + COLUMN_VERSENDER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_ADRESSE_ID + " INT, " + COLUMN_VORNAME + " TEXT, " + COLUMN_NACHNAME + " TEXT, " + COLUMN_EMAIL + " TEXT, " + COLUMN_TELEFON + " TEXT, " + COLUMN_MOBIL + " TEXT )";
        db.execSQL(createTableStatement5);
        String createTableStatement6 = "CREATE TABLE " + ADRESSE_TABLE + " (" + COLUMN_ADRESSE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_BEZIRK_ID + " INT, " + COLUMN_POSTLEITZAHL + " TEXT, " + COLUMN_STADT + " TEXT, " + COLUMN_STRASSE + " TEXT, " + COLUMN_NR + " TEXT, " + COLUMN_ADRESSZUSATZ + " TEXT )";
        db.execSQL(createTableStatement6);
        String createTableStatement7 = "CREATE TABLE " + BEZIRK_TABLE + " (" + COLUMN_BEZIRK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_LIEFERANT_ID + " INT, " + COLUMN_ABGASNORM + " INT, " + COLUMN_ANZAHL_KUNDEN + " INT)";
        db.execSQL(createTableStatement7);
        String createTableStatement8 = "CREATE TABLE " + LIEFERANT_TABLE + " (" + COLUMN_LIEFERANT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_BEZIRK_ID + " INT, " + COLUMN_LKW_ID + " INT, " + COLUMN_ANSPRECHPARTNER + " TEXT, " + COLUMN_E_MAIL + " TEXT, " + COLUMN_TELEFON + " TEXT, " + COLUMN_MOBIL + " TEXT )";
        db.execSQL(createTableStatement8);
        String createTableStatement9 = "CREATE TABLE " + FAHRZEUG_TABLE + " (" + COLUMN_FAHRZEUG_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_FAHRER_ID + " INT, " + COLUMN_FAHRZEUGTYP_ID + " INT, " + COLUMN_KENNZEICHEN + " TEXT )";
        db.execSQL(createTableStatement9);
        String createTableStatement10 = "CREATE TABLE " + FAHRZEUGTYP_TABLE + " (" + COLUMN_FAHRZEUGTYP_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_FAHRZEUG_BEZEICHNUNG + " TEXT, " + COLUMN_ANZAHL_STELLPLAETZE + " INT, " + COLUMN_MAX_GEWICHT_GRAMM + " INT, " + COLUMN_MAX_VOLUMEN_CM3 + " INT, " + COLUMN_UMWELTPLAKETTE + " INT, " + COLUMN_VOLUMENGEWICHTSINDEX + " INT, " + COLUMN_FAHRZEUGHOEHE_CM + " INT, " + COLUMN_FAHRZEUGBREITE_CM + " INT)";
        db.execSQL(createTableStatement10);
        String createTableStatement11 = "CREATE TABLE " + FAHRER_TABLE + " (" + COLUMN_FAHRER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_MOBIL + " TEXT, " + COLUMN_FUEHRERSCHEINKLASSE + " TEXT, " + COLUMN_GEFAHRGUTSCHULUNG + " TEXT )";
        db.execSQL(createTableStatement11);
        String createTableStatement12 = "CREATE TABLE " + SENDUNGS_TABLE + " (" + COLUMN_SENDUNGS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_ABSENDER_ID + " INT, " + COLUMN_VERSENDER_ID + " INT, " + COLUMN_EMPFAENGER_ID + " INT, " + COLUMN_PAKET_ID + " INT, " + COLUMN_FAHRZEUG_ID + " INT, " + COLUMN_ANZAHL_PAKETE + " INT, " + COLUMN_ENTGELD_CENT + " INT, " + COLUMN_WARENWERT_CENT + " INT, " + COLUMN_VERSICHERT + " INT, " + COLUMN_ANONYM + " INT, " + COLUMN_DISPONIERT + " INT, " + COLUMN_ZUGESTELLT + " INT, " + COLUMN_NACHNAHME + " INT, " + COLUMN_BEZIRK_ID + " INT)";
        db.execSQL(createTableStatement12);
        String createTableStatement13 = "CREATE TABLE " + PAKETE_TABLE + " (" + COLUMN_PAKET_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_SENDUNGS_ID + " INT, " + COLUMN_GEWICHT + " INT, " + COLUMN_LAENGE + " INT, " + COLUMN_BREITE + " INT, " + COLUMN_HOEHE + " INT, " + COLUMN_GEFAHRGUT + " INT, " + COLUMN_STAPELBAR + " INT, " + COLUMN_ZERBRECHLICH + " INT, " + COLUMN_RICHTUNG + " TEXT)";
        db.execSQL(createTableStatement13);


    }

    //this is called when the version number of the DataBase is updated.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //Funktion, um zu überprüfen, ob die Datenbank breits erstellt wurde.
    public boolean isDbEmpty() {
        SQLiteDatabase db = this.getReadableDatabase();
        String queryString = "SELECT count(*) FROM " + ROUTE_TABLE;
        Cursor mcursor = db.rawQuery(queryString, null);
        mcursor.moveToFirst();
        int icount = mcursor.getInt(0);
        if (icount > 0) {
            mcursor.close();
            db.close();
            return false;
        } else {
            mcursor.close();
            db.close();
            return true;
        }
    }


    //Funktion, um die maximum Sendungs Id aus der Datenbank auszulesen
    public int GetMaxSendungsId() {
        int mx = -1;
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String queryString = "SELECT MAX(COLUMN_SENDUNGS_ID) FROM SENDUNGS_TABLE";
            Cursor cursor = db.rawQuery(queryString, null);
            if (cursor != null)
                if (cursor.moveToFirst()) {

                    mx = cursor.getInt(0);

                }
            cursor.close();
            db.close();
            return mx;
        } catch (Exception e) {

            return -1;
        }
    }


    //Funktion, um eine Sendung zu disponieren.
    public boolean dispoOne(Sendungen sendungen, String FahrzeugNumm) {
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "UPDATE " + SENDUNGS_TABLE + " SET " + COLUMN_DISPONIERT + " = 1, " + COLUMN_FAHRZEUG_ID + " = " + FahrzeugNumm + " WHERE " + COLUMN_SENDUNGS_ID + " = " + sendungen.getSendungs_id();
        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst()) {
            db.close();
            cursor.close();
            return true;
        } else {
            db.close();
            cursor.close();
            return false;
        }

    }

    //Funktion, um eine Sendung zu entdisponieren.
    public boolean dedispoOne(Sendungen sendungen) {
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "UPDATE " + SENDUNGS_TABLE + " SET " + COLUMN_DISPONIERT + " = 0, " + COLUMN_FAHRZEUG_ID + " = 0 WHERE " + COLUMN_SENDUNGS_ID + " = " + sendungen.getSendungs_id();
        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst()) {
            db.close();
            cursor.close();
            return true;
        } else {
            db.close();
            cursor.close();
            return false;
        }
    }

    //Funktion, um einen Kunden in Customer table hinzuzufügen
    public boolean addOneCustomer(CustomerModel customerModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_CUSTOMER_NAME, customerModel.getName());
        cv.put(COLUMN_CUSTOMER_AGE, customerModel.getAge());
        cv.put(COLUMN_ACTIVE_CUSTOMER, customerModel.isActive());

        long insert = db.insert(CUSTOMER_TABLE, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }

    //Funktion, um eine Route in Route table hinzuzufügen
    public boolean addOneRoute(Route route) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_GPS_STAMP, route.getGPS_stamp());
        cv.put(COLUMN_ZEITSTEMPEL, route.getZeitstempel());


        long insert = db.insert(ROUTE_TABLE, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }
//Funktion, um einen Empfaenger zu Empfaenger table hinzuzufügen

    public boolean addOneEmpfaenger(Empfaenger empfaenger) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ADRESSE_ID, empfaenger.getAdresse_id());
        cv.put(COLUMN_VORNAME, empfaenger.getVorname());
        cv.put(COLUMN_NACHNAME, empfaenger.getNachname());
        cv.put(COLUMN_EMAIL, empfaenger.getEmail());
        cv.put(COLUMN_TELEFON, empfaenger.getTelefon());
        cv.put(COLUMN_MOBIL, empfaenger.getMobil());


        long insert = db.insert(EMPFAENGER_TABLE, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }

    //Funktion, um einen Absender zu Absender table hinzuzufügen

    public boolean addOneAbsender(Absender absender) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ADRESSE_ID, absender.getAdresse_id());
        cv.put(COLUMN_VORNAME, absender.getVorname());
        cv.put(COLUMN_NACHNAME, absender.getNachname());
        cv.put(COLUMN_EMAIL, absender.getEmail());
        cv.put(COLUMN_TELEFON, absender.getTelefon());
        cv.put(COLUMN_MOBIL, absender.getMobil());


        long insert = db.insert(ABSENDER_TABLE, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }

    //Funktion, um einen Versender zu Versender table hinzuzufügen

    public boolean addOneVersender(Versender versender) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ADRESSE_ID, versender.getAdresse_id());
        cv.put(COLUMN_VORNAME, versender.getVorname());
        cv.put(COLUMN_NACHNAME, versender.getNachname());
        cv.put(COLUMN_EMAIL, versender.getEmail());
        cv.put(COLUMN_TELEFON, versender.getTelefon());
        cv.put(COLUMN_MOBIL, versender.getMobil());


        long insert = db.insert(VERSENDER_TABLE, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }

    //Funktion, um eine Adresse zu Adresse table hinzuzufügen
    public boolean addOneAdresse(Adresse adresse) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_BEZIRK_ID, adresse.getBezirk_id());
        cv.put(COLUMN_POSTLEITZAHL, adresse.getPostleitzahl());
        cv.put(COLUMN_STADT, adresse.getStadt());
        cv.put(COLUMN_STRASSE, adresse.getStrasse());
        cv.put(COLUMN_NR, adresse.getNr());
        cv.put(COLUMN_ADRESSZUSATZ, adresse.getAdresszusatz());


        long insert = db.insert(ADRESSE_TABLE, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }

    //Funktion, um eine Adresse zu Adresse table hinzuzufügen
    public boolean addOneBezirk(Bezirk bezirk) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_LIEFERANT_ID, bezirk.getLieferant_id());
        cv.put(COLUMN_ABGASNORM, bezirk.getAbgasnorm());
        cv.put(COLUMN_ANZAHL_KUNDEN, bezirk.getAnzahl_Kunden());


        long insert = db.insert(BEZIRK_TABLE, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }

    //Funktion, um einen Lieferanten zu Lieferanten table hinzuzufügen
    public boolean addOneLieferant(Lieferant lieferant) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_BEZIRK_ID, lieferant.getBezirk_id());
        cv.put(COLUMN_LKW_ID, lieferant.getLKW_id());
        cv.put(COLUMN_ANSPRECHPARTNER, lieferant.getAnsprechpartner());
        cv.put(COLUMN_E_MAIL, lieferant.getE_mail());
        cv.put(COLUMN_TELEFON, lieferant.getTelefon());
        cv.put(COLUMN_MOBIL, lieferant.getMobil());


        long insert = db.insert(LIEFERANT_TABLE, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }

    //Funktion, um ein Fahrzeug zu Fahrzeug table hinzuzufügen
    public boolean addOneFahrzeug(Fahrzeug fahrzeug) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_FAHRER_ID, fahrzeug.getFahrer_id());
        cv.put(COLUMN_FAHRZEUGTYP_ID, fahrzeug.getFahrzeugtyp_id());
        cv.put(COLUMN_KENNZEICHEN, fahrzeug.getKennzeichen());


        long insert = db.insert(FAHRZEUG_TABLE, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }

    //Funktion, um einen Fahrzeugtyp zu Fahrzeugtyp table hinzuzufügen
    public boolean addOneFahrzeugtyp(Fahrzeugtyp fahrzeugtyp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_FAHRZEUG_BEZEICHNUNG, fahrzeugtyp.getFahrzeug_Bezeichnung());
        cv.put(COLUMN_ANZAHL_STELLPLAETZE, fahrzeugtyp.getAnzahl_Stellplaetze());
        cv.put(COLUMN_MAX_GEWICHT_GRAMM, fahrzeugtyp.getMax_Gewicht_Gramm());
        cv.put(COLUMN_MAX_VOLUMEN_CM3, fahrzeugtyp.getMax_Volumen_Cm3());
        cv.put(COLUMN_UMWELTPLAKETTE, fahrzeugtyp.getUmweltplakette());
        cv.put(COLUMN_VOLUMENGEWICHTSINDEX, fahrzeugtyp.getVolumengewichtsindex());
        cv.put(COLUMN_FAHRZEUGHOEHE_CM, fahrzeugtyp.getFahrzeughoehe_Cm());
        cv.put(COLUMN_FAHRZEUGBREITE_CM, fahrzeugtyp.getFahrzeugbreite_Cm());


        long insert = db.insert(FAHRZEUGTYP_TABLE, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }

    //Funktion, um einen Fahrer zu Fahrer table hinzuzufügen
    public boolean addOneFahrer(Fahrer fahrer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_MOBIL, fahrer.getMobil());
        cv.put(COLUMN_FUEHRERSCHEINKLASSE, fahrer.getFuehrerscheinklasse());
        cv.put(COLUMN_GEFAHRGUTSCHULUNG, fahrer.getGefahrgutschulung());


        long insert = db.insert(FAHRER_TABLE, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }

    //Funktion, um eine Sendung zu Sendungen table hinzuzufügen
    public boolean addOneSendung(Sendungen sendungen) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ABSENDER_ID, sendungen.getAbsender_id());
        cv.put(COLUMN_VERSENDER_ID, sendungen.getVersender_id());
        cv.put(COLUMN_EMPFAENGER_ID, sendungen.getEmpfaenger_id());
        cv.put(COLUMN_PAKET_ID, sendungen.getPaket_id());
        cv.put(COLUMN_FAHRZEUG_ID, sendungen.getFahrzeug_id());
        cv.put(COLUMN_ANZAHL_PAKETE, sendungen.getAnzahl_Pakete());
        cv.put(COLUMN_ENTGELD_CENT, sendungen.getEntgeld_Cent());
        cv.put(COLUMN_WARENWERT_CENT, sendungen.getWarenwert_Cent());
        cv.put(COLUMN_VERSICHERT, sendungen.getVersichert());
        cv.put(COLUMN_ANONYM, sendungen.getAnonym());
        cv.put(COLUMN_DISPONIERT, sendungen.getDisponiert());
        cv.put(COLUMN_ZUGESTELLT, sendungen.getZugestellt());
        cv.put(COLUMN_NACHNAHME, sendungen.getNachnahme());
        cv.put(COLUMN_BEZIRK_ID, sendungen.getBezirks_id());


        long insert = db.insert(SENDUNGS_TABLE, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }

    //Funktion, um ein Paket zu Pakete table hinzuzufügen
    public boolean addOnePaket(Pakete pakete) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_SENDUNGS_ID, pakete.getSendungs_id());
        cv.put(COLUMN_GEWICHT, pakete.getGewicht());
        cv.put(COLUMN_LAENGE, pakete.getLaenge());
        cv.put(COLUMN_BREITE, pakete.getBreite());
        cv.put(COLUMN_HOEHE, pakete.getHoehe());
        cv.put(COLUMN_GEFAHRGUT, pakete.getGefahrgut());
        cv.put(COLUMN_STAPELBAR, pakete.getStapelbar());
        cv.put(COLUMN_ZERBRECHLICH, pakete.getZerbrechlich());
        cv.put(COLUMN_RICHTUNG, pakete.getRichtung());

        long insert = db.insert(PAKETE_TABLE, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }

    //Funktion, um einen Kunden aus Customer table zu löschen.
    public boolean deleteOne(CustomerModel customerModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + CUSTOMER_TABLE + " WHERE " + COLUMN_ID + " = " + customerModel.getId();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            db.close();
            cursor.close();
            return true;
        } else {
            db.close();
            cursor.close();
            return false;
        }
    }


    //Funktion, um alle Kunden aus customer table auszulesen.
    public List<CustomerModel> getEveryone() {
        List<CustomerModel> returnList = new ArrayList<>();
        // get Data from the DataBase
        String queryString = "SELECT * FROM " + CUSTOMER_TABLE;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst()) {
            // loop through the cursor results (cursor = Ergebnisse der SQL anfrage) and create new customer object. Insert them in the return List.
            do {
                int customerID = cursor.getInt(0);
                String customerName = cursor.getString(1);
                int customerAge = cursor.getInt(2);
                boolean customerActive = cursor.getInt(3) == 1 ? true : false;

                CustomerModel newCustomer = new CustomerModel(customerID, customerName, customerAge, customerActive);
                returnList.add(newCustomer);
            } while (cursor.moveToNext());
        } else {
            //failure, do not add anything to the list.
        }
        // close both the cursor and the Database when done
        cursor.close();
        db.close();

        return returnList;
    }

    //Funktion, um alle Routen aus route table auszulesen
    public List<Route> getAllRoute() {
        List<Route> returnList = new ArrayList<>();
        // get Data from the DataBase
        String queryString = "SELECT * FROM " + ROUTE_TABLE;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst()) {
            // loop through the cursor results (cursor = Ergebnisse der SQL anfrage) and create new customer object. Insert them in the return List.
            do {
                int routeId = cursor.getInt(0);
                String routeGPS_stamp = cursor.getString(1);
                String routeZeitstempel = cursor.getString(2);

                Route newRoute = new Route(routeId, routeGPS_stamp, routeZeitstempel);
                returnList.add(newRoute);
            } while (cursor.moveToNext());
        } else {
            //failure, do not add anything to the list.
        }
        // close both the cursor and the Database when done
        cursor.close();
        db.close();

        return returnList;
    }
    //Funktion, um alle Sendungen aus der Tabelle Sendungen auszulesen. --> Für Fragment Sendungspool

    public List<Sendungen> getAllSendungen() {
        List<Sendungen> returnList = new ArrayList<>();
        // get Data from the DataBase
        String queryString = "SELECT * FROM " + SENDUNGS_TABLE;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst()) {
            // loop through the cursor results (cursor = Ergebnisse der SQL anfrage) and create new Sendungsobject. Insert them in the return List.
            do {
                int sendungsId = cursor.getInt(0);
                int absenderId = cursor.getInt(1);
                int versenderId = cursor.getInt(2);
                int empfaengerId = cursor.getInt(3);
                int paketId = cursor.getInt(4);
                int fahrzeugId = cursor.getInt(5);
                int anzahlPakete = cursor.getInt(6);
                int entgeldCent = cursor.getInt(7);
                int warenwertCent = cursor.getInt(8);
                int verichert = cursor.getInt(9);
                int anonym = cursor.getInt(10);
                int disponiert = cursor.getInt(11);
                int zugestellt = cursor.getInt(12);
                int nachnahme = cursor.getInt(13);
                int bezirksId = cursor.getInt(14);

                Sendungen newSendungen = new Sendungen(sendungsId, absenderId, versenderId, empfaengerId, paketId, fahrzeugId, anzahlPakete, entgeldCent, warenwertCent, verichert, anonym, disponiert, zugestellt, nachnahme, bezirksId);
                returnList.add(newSendungen);
            } while (cursor.moveToNext());
        } else {
            //failure, do not add anything to the list.
        }
        // close both the cursor and the Database when done
        cursor.close();
        db.close();
        return returnList;
    }

    //Funktion, um alle nicht disponierten Sendungen aus der Tabelle Sendungen auszulesen abhängig vom Bezirk --> Für Fragment: Disposition

    public List<Sendungen> getNotDispoSendungen(String BezirksNr) {
        List<Sendungen> returnList = new ArrayList<>();
        // get Data from the DataBase
        String queryString = "SELECT * FROM " + SENDUNGS_TABLE + " WHERE " + COLUMN_BEZIRK_ID + " = " + BezirksNr + " AND " + COLUMN_DISPONIERT + " = 0";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst()) {
            // loop through the cursor results (cursor = Ergebnisse der SQL anfrage) and create new Sendungsobject. Insert them in the return List.
            do {
                int sendungsId = cursor.getInt(0);
                int absenderId = cursor.getInt(1);
                int versenderId = cursor.getInt(2);
                int empfaengerId = cursor.getInt(3);
                int paketId = cursor.getInt(4);
                int fahrzeugId = cursor.getInt(5);
                int anzahlPakete = cursor.getInt(6);
                int entgeldCent = cursor.getInt(7);
                int warenwertCent = cursor.getInt(8);
                int verichert = cursor.getInt(9);
                int anonym = cursor.getInt(10);
                int disponiert = cursor.getInt(11);
                int zugestellt = cursor.getInt(12);
                int nachnahme = cursor.getInt(13);
                int bezirksId = cursor.getInt(14);

                Sendungen newSendungen = new Sendungen(sendungsId, absenderId, versenderId, empfaengerId, paketId, fahrzeugId, anzahlPakete, entgeldCent, warenwertCent, verichert, anonym, disponiert, zugestellt, nachnahme, bezirksId);
                returnList.add(newSendungen);
            } while (cursor.moveToNext());
        } else {
            //failure, do not add anything to the list.
        }
        // close both the cursor and the Database when done
        cursor.close();
        db.close();

        return returnList;
    }

    //Funktion, um alle nicht disponierten Sendungen aus der Tabelle Sendungen auszulesen --> Für Fragment: Disposition

    public List<Sendungen> getAllNotDispoSendungen() {
        List<Sendungen> returnList = new ArrayList<>();
        // get Data from the DataBase
        String queryString = "SELECT * FROM " + SENDUNGS_TABLE + " WHERE " + COLUMN_DISPONIERT + " = 0";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst()) {
            // loop through the cursor results (cursor = Ergebnisse der SQL anfrage) and create new Sendungsobject. Insert them in the return List.
            do {
                int sendungsId = cursor.getInt(0);
                int absenderId = cursor.getInt(1);
                int versenderId = cursor.getInt(2);
                int empfaengerId = cursor.getInt(3);
                int paketId = cursor.getInt(4);
                int fahrzeugId = cursor.getInt(5);
                int anzahlPakete = cursor.getInt(6);
                int entgeldCent = cursor.getInt(7);
                int warenwertCent = cursor.getInt(8);
                int verichert = cursor.getInt(9);
                int anonym = cursor.getInt(10);
                int disponiert = cursor.getInt(11);
                int zugestellt = cursor.getInt(12);
                int nachnahme = cursor.getInt(13);
                int bezirksId = cursor.getInt(14);

                Sendungen newSendungen = new Sendungen(sendungsId, absenderId, versenderId, empfaengerId, paketId, fahrzeugId, anzahlPakete, entgeldCent, warenwertCent, verichert, anonym, disponiert, zugestellt, nachnahme, bezirksId);
                returnList.add(newSendungen);
            } while (cursor.moveToNext());
        } else {
            //failure, do not add anything to the list.
        }
        // close both the cursor and the Database when done
        cursor.close();
        db.close();

        return returnList;
    }

    public List<Sendungen> getDispoSendungen(String FahrzeugNr) {
        List<Sendungen> returnList = new ArrayList<>();
        // get Data from the DataBase
        String queryString = "SELECT * FROM " + SENDUNGS_TABLE + " WHERE " + COLUMN_FAHRZEUG_ID + " = " + FahrzeugNr + " AND " + COLUMN_DISPONIERT + " = 1";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst()) {
            // loop through the cursor results (cursor = Ergebnisse der SQL anfrage) and create new Sendungsobject. Insert them in the return List.
            do {
                int sendungsId = cursor.getInt(0);
                int absenderId = cursor.getInt(1);
                int versenderId = cursor.getInt(2);
                int empfaengerId = cursor.getInt(3);
                int paketId = cursor.getInt(4);
                int fahrzeugId = cursor.getInt(5);
                int anzahlPakete = cursor.getInt(6);
                int entgeldCent = cursor.getInt(7);
                int warenwertCent = cursor.getInt(8);
                int verichert = cursor.getInt(9);
                int anonym = cursor.getInt(10);
                int disponiert = cursor.getInt(11);
                int zugestellt = cursor.getInt(12);
                int nachnahme = cursor.getInt(13);
                int bezirksId = cursor.getInt(14);

                Sendungen newSendungen = new Sendungen(sendungsId, absenderId, versenderId, empfaengerId, paketId, fahrzeugId, anzahlPakete, entgeldCent, warenwertCent, verichert, anonym, disponiert, zugestellt, nachnahme, bezirksId);
                returnList.add(newSendungen);
            } while (cursor.moveToNext());
        } else {
            //failure, do not add anything to the list.
        }
        // close both the cursor and the Database when done
        cursor.close();
        db.close();

        return returnList;
    }

    //Funktion, um alle Fahrer aus der Datenbank auszulesen --> Für Fragment: Fahrerpool

    public List<Fahrer> getAllFahrer() {
        List<Fahrer> returnList = new ArrayList<>();
        // get Data from the DataBase
        String queryString = "SELECT * FROM FAHRER_TABLE"; //Mögliche Fehlerquelle ist die SQL Abfrage
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst()) {
            // loop through the cursor results (cursor = Ergebnisse der SQL anfrage) and create new Sendungsobject. Insert them in the return List.
            do {
                int fahrerId = cursor.getInt(0);
                String mobil = cursor.getString(1);
                String fuehrerscheinklasse = cursor.getString(2);
                String gefahrgutschulung = cursor.getString(3);


                Fahrer newFahrer = new Fahrer(fahrerId, mobil, fuehrerscheinklasse, gefahrgutschulung);
                returnList.add(newFahrer);
            } while (cursor.moveToNext());
        } else {
            //failure, do not add anything to the list.
        }
        // close both the cursor and the Database when done
        cursor.close();
        db.close();

        return returnList;
    }

    //Funktion, um alle Fahrzeuge aus der Tabelle Fahrzeuge auszulesen --> Für Fragment: Fahrzeugpool

    public List<Fahrzeug> getAllFahrzeuge() {
        List<Fahrzeug> returnList = new ArrayList<>();
        // get Data from the DataBase
        String queryString = "SELECT * FROM FAHRZEUG_TABLE"; //Mögliche Fehlerquelle ist die SQL Abfrage
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst()) {
            // loop through the cursor results (cursor = Ergebnisse der SQL anfrage) and create new Sendungsobject. Insert them in the return List.
            do {
                int fahrzeugId = cursor.getInt(0);
                int fahrerId = cursor.getInt(1);
                int fahrzeugtypId = cursor.getInt(2);
                String kennzeichen = cursor.getString(3);


                Fahrzeug newFahrzeug = new Fahrzeug(fahrzeugId, fahrerId, fahrzeugtypId, kennzeichen);
                returnList.add(newFahrzeug);
            } while (cursor.moveToNext());
        } else {
            //failure, do not add anything to the list.
        }
        // close both the cursor and the Database when done
        cursor.close();
        db.close();

        return returnList;
    }

}
