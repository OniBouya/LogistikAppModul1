package de.codeyourapp.sqldemo.ui.home;

import android.content.res.Resources;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import de.codeyourapp.sqldemo.Absender;
import de.codeyourapp.sqldemo.Adresse;
import de.codeyourapp.sqldemo.Bezirk;
import de.codeyourapp.sqldemo.DataBaseHelper;
import de.codeyourapp.sqldemo.Empfaenger;
import de.codeyourapp.sqldemo.Fahrer;
import de.codeyourapp.sqldemo.Fahrzeug;
import de.codeyourapp.sqldemo.Fahrzeugtyp;
import de.codeyourapp.sqldemo.Lieferant;
import de.codeyourapp.sqldemo.Pakete;
import de.codeyourapp.sqldemo.R;
import de.codeyourapp.sqldemo.Route;
import de.codeyourapp.sqldemo.Sendungen;
import de.codeyourapp.sqldemo.Versender;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    //Variablen
    private int ScreenHeight;
    //Klassen
    private Button btn_sendungen;
    private ListView lv_Test;
    private DataBaseHelper dataBaseHelper;
    private ArrayAdapter SendungsArrayAdapter;
    //Funktionen
    //Funktion, um die Breite des Bildschirms des Endgerätes zu bekommen
    private static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }
    //Funktion, um die Höhe des Bildschrims des Endgerätes zu bekommen
    private static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }



    //View gets created
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        //Referenzen
        btn_sendungen = (Button) root.findViewById(R.id.btn_sendungen);
        lv_Test = (ListView) root.findViewById(R.id.lv_Test);
        //DataBaseHelper
        dataBaseHelper = new DataBaseHelper(getActivity());
        //Speicher die Höhe des Bildschrims des Nutzergerätes
        ScreenHeight= getScreenHeight();
        //Setze die Position und größe des ListView in abhängigkeit von der Bildschirmgröße fest
        lv_Test.setLayoutParams(new ConstraintLayout.LayoutParams(getScreenWidth(), (ScreenHeight-1000)));
        lv_Test.setY(758);


        //Button, um die Sendungsdaten in die Datenbank zu laden


        btn_sendungen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                //Datensätze werden in die Tabelle Route geladen

                if (dataBaseHelper.isDbEmpty() == true) {

                    Route route;
                    try {
                        //create table for Route

                        route = new Route(-1, "51.472817, 7.439465", "16.52.13"); //Tannenstr. 34, 44225 Dortmund
                        dataBaseHelper.addOneRoute(route);
                        route = new Route(-1, "51.474712, 7.444393", "17.12.11");//Carlsbader Str.20, 44225 Dortmund
                        dataBaseHelper.addOneRoute(route);
                        route = new Route(-1, "51.474542, 7.434337", "17.43.11");//Leostraße 26, 44225 Dortmund
                        dataBaseHelper.addOneRoute(route);
                        route = new Route(-1, "51.480643, 7.442099", "18.12.11");//Egerstr. 8, 44225 Dortmund
                        dataBaseHelper.addOneRoute(route);
                        route = new Route(-1, "51.466365, 7.457034", "18.33.09");//Schneiderstr. 6, 44229 Dortmund
                        dataBaseHelper.addOneRoute(route);
                        route = new Route(-1, "51.553365, 7.478034", "15.53.21");
                        dataBaseHelper.addOneRoute(route);
                        route = new Route(-1, "51.465650, 7.443803", "16.32.48");
                        dataBaseHelper.addOneRoute(route);
                        route = new Route(-1, "51.489365, 7.469034", "17.01.09");
                        dataBaseHelper.addOneRoute(route);
                        route = new Route(-1, "51.463895, 7.469021", "17.31.26");
                        dataBaseHelper.addOneRoute(route);
                        route = new Route(-1, "51.475665, 7.489022", "17.59.53");
                        dataBaseHelper.addOneRoute(route);
                        route = new Route(-1, "51.489221, 7.478099", "18.23.05");
                        dataBaseHelper.addOneRoute(route);

                    } catch (Exception e) {
                        Toast.makeText(getActivity(), "Error creating route", Toast.LENGTH_SHORT).show();
                        route = new Route(-1, "error", "error");
                    }

                    //Datensätze werden in die Tabelle Empfaenger geladen

                    Empfaenger empfaenger;
                    try {
                        //create table for Route

                        empfaenger = new Empfaenger(-1, 1, "Felix", "Theobald", "felix.theobald@tu-dortmund.de", "02333-4844", "0151 266 488 14"); //Adress_id = 1
                        dataBaseHelper.addOneEmpfaenger(empfaenger);
                        empfaenger = new Empfaenger(-1, 2, "Mehmet", "Kocak", "Mehmet.Kocak@tu-dortmund.de", "02331-6969", "0152 368 419 12"); //Adress_id = 2
                        dataBaseHelper.addOneEmpfaenger(empfaenger);
                        empfaenger = new Empfaenger(-1, 3, "Ilka", "Jussen", "Ilka.Jussen@tu-dortmund.de", "02333-5280", "0152 519 568 09"); //Adress_id = 3
                        dataBaseHelper.addOneEmpfaenger(empfaenger);
                        empfaenger = new Empfaenger(-1, 4, "Lena", "Zerle", "Lena.Zerle@tu-dortmund.de", "0231-56452", "0151 288 114 45"); //Adress_id = 4
                        dataBaseHelper.addOneEmpfaenger(empfaenger);
                        empfaenger = new Empfaenger(-1, 5, "Anne Antonia", "Scheidler", "Antonia.Scheidler@tu-dortmund.de", "0231-5639", "0153 474 069 27"); //Adress_id = 5
                        dataBaseHelper.addOneEmpfaenger(empfaenger);
                        empfaenger = new Empfaenger(-1, 12, "Kilian", "Hilpert", "Kilian.Hilpert@cgi.de", "0231-56262", "0153 669 052 67"); //Adress_id = 6
                        dataBaseHelper.addOneEmpfaenger(empfaenger);
                        empfaenger = new Empfaenger(-1, 13, "Max", "Mustermann", "Max.Musterman@0815.de", "555-0815", "0153 470 815"); //Adress_id = 7
                        dataBaseHelper.addOneEmpfaenger(empfaenger);
                        empfaenger = new Empfaenger(-1, 14, "Flora", "Formfrau", "Flora.Formfrau@standard.de", "0231-5463", "0157 554 069 33");
                        dataBaseHelper.addOneEmpfaenger(empfaenger);
                        empfaenger = new Empfaenger(-1, 15, "Klaus", "Schmitz", "Klaus.Schmitz@stolzeDackelbesitzer.de", "0231-5883", "0157 477 033 66");
                        dataBaseHelper.addOneEmpfaenger(empfaenger);
                        empfaenger = new Empfaenger(-1, 16, "Erkan", "Alles", "Erkan.Alles@Alleskönner.de", "0231-2263", "0157 526 360 73");
                        dataBaseHelper.addOneEmpfaenger(empfaenger);
                        empfaenger = new Empfaenger(-1, 22, "Siekan", "Alles", "Siekan.Alles@Alleskönner.de", "0231-2264", "0157 526 360 74");
                        dataBaseHelper.addOneEmpfaenger(empfaenger);




                    } catch (Exception e) {
                        Toast.makeText(getActivity(), "Error creating route", Toast.LENGTH_SHORT).show();
                        empfaenger = new Empfaenger(-1, 0, "error", "error", "error", "error", "error");
                    }

                    //Datensätze werden in die Tabelle Absender geladen

                    Absender absender;
                    try {
                        //create table for Route

                        absender = new Absender(-1, 6, "Nicola", "Tesla", "verkanntes.Genie@physics.com", "555-9001", "0151 388 588 01"); //Adress_id = 6
                        dataBaseHelper.addOneAbsender(absender);
                        absender = new Absender(-1, 7, "Isaac", "Newton", "SteinDerWeisen@voodoo.en", "555-6569", "0152 368 378 55"); //Adress_id = 7
                        dataBaseHelper.addOneAbsender(absender);
                        absender = new Absender(-1, 8, "Albert", "Einstein", "AlbertRelativ@Lichtgeschwindigkeit.com", "555-55980", "0151 555 888 12"); //Adress_id = 8
                        dataBaseHelper.addOneAbsender(absender);
                        absender = new Absender(-1, 9, "Marie", "Curie", "Marie.Curie@radioaktiv.com", "0231-8352", "0151 568 144 35"); //Adress_id = 9
                        dataBaseHelper.addOneAbsender(absender);
                        absender = new Absender(-1, 10, "Erwin", "Schrödinger", "Erwin.Schrödinger@Katzenfreunde.com", "02333-7229", "0151 333 069 96"); //Adress_id = 10
                        dataBaseHelper.addOneAbsender(absender);
                        absender = new Absender(-1, 17, "Werner", "Heisenberg", "Werner.Heisenberg@Quantum.de", "02333-3569", "0151 321 532 96"); //Adress_id = 10
                        dataBaseHelper.addOneAbsender(absender);
                        absender = new Absender(-1, 18, "Enrico", "Fermi", "Enrico.Fermi@KernderSache.com", "555-88293", "0177 523 339 47"); //Adress_id = 10
                        dataBaseHelper.addOneAbsender(absender);
                        absender = new Absender(-1, 19, "Daniel", "Bernulli", "Daniel.Bernulli@Hydrodynamica.com", "0555-4459", "0171 223 033 91"); //Adress_id = 10
                        dataBaseHelper.addOneAbsender(absender);
                        absender = new Absender(-1, 20, "Emmy", "Noether", "Emmy.Noether@Algebra.de", "0256-4759", "0171 255 033 97"); //Adress_id = 10
                        dataBaseHelper.addOneAbsender(absender);
                        absender = new Absender(-1, 21, "Rosalind", "Franklin", "Rosalind.Franklin@kp.de", "02226-46959", "0171 414 083 56"); //Adress_id = 10
                        dataBaseHelper.addOneAbsender(absender);
                        absender = new Absender(-1, 23, "Hertha", "Sponer", "Hertha.Sponer@kp.de", "02556-4699", "0177 469 333 56"); //Adress_id = 10
                        dataBaseHelper.addOneAbsender(absender);






                    } catch (Exception e) {
                        Toast.makeText(getActivity(), "Error creating route", Toast.LENGTH_SHORT).show();
                        absender = new Absender(-1, 0, "error", "error", "error", "error", "error");
                    }

                    //Datensätze werden in die Tabelle Versender geladen

                    Versender versender;
                    try {
                        //create table for Route

                        versender = new Versender(-1, 6, "Nicola", "Tesla", "verkanntes.Genie@physics.com", "555-9001", "0151 388 588 01"); //Adress_id = 6
                        dataBaseHelper.addOneVersender(versender);
                        versender = new Versender(-1, 7, "Isaac", "Newton", "SteinDerWeisen@voodoo.en", "555-6569", "0151 388 588 01"); //Adress_id = 7
                        dataBaseHelper.addOneVersender(versender);
                        versender = new Versender(-1, 8, "Albert", "Einstein", "AlbertRelativ@Lichtgeschwindigkeit.com", "555-55980", "0151 555 888 12"); //Adress_id = 8
                        dataBaseHelper.addOneVersender(versender);
                        versender = new Versender(-1, 11, "Pierre", "Curie", "Pierre.Curie@radioaktiv.com", "0231-8351", "0151 555 888 11"); //Adress_id = 11 unterschied zwischen absender und versender
                        dataBaseHelper.addOneVersender(versender);
                        versender = new Versender(-1, 10, "Erwin", "Schrödinger", "Erwin.Schrödinger@Katzenfreunde.com", "02333-7229", "0151 333 069 96"); //Adress_id = 10
                        dataBaseHelper.addOneVersender(versender);
                        versender = new Versender(-1, 17, "Werner", "Heisenberg", "Werner.Heisenberg@Quantum.de", "02333-3569", "0151 321 532 96"); //Adress_id = 10
                        dataBaseHelper.addOneVersender(versender);
                        versender = new Versender(-1, 18, "Enrico", "Fermi", "Enrico.Fermi@KernderSache.com", "555-88293", "0177 523 339 47"); //Adress_id = 10
                        dataBaseHelper.addOneVersender(versender);
                        versender = new Versender(-1, 19, "Daniel", "Bernulli", "Daniel.Bernulli@Hydrodynamica.com", "0555-4459", "0171 223 033 91"); //Adress_id = 10
                        dataBaseHelper.addOneVersender(versender);
                        versender = new Versender(-1, 20, "Emmy", "Noether", "Emmy.Noether@Algebra.de", "0256-4759", "0171 255 033 97"); //Adress_id = 10
                        dataBaseHelper.addOneVersender(versender);
                        versender = new Versender(-1, 21, "Rosalind", "Franklin", "Rosalind.Franklin@kp.de", "02226-46959", "0171 414 083 56"); //Adress_id = 10
                        dataBaseHelper.addOneVersender(versender);
                        versender = new Versender(-1, 23, "Hertha", "Sponer", "Hertha.Sponer@kp.de", "02556-4699", "0177 469 333 56"); //Adress_id = 10
                        dataBaseHelper.addOneVersender(versender);



                    } catch (Exception e) {
                        Toast.makeText(getActivity(), "Error creating route", Toast.LENGTH_SHORT).show();
                        versender = new Versender(-1, 0, "error", "error", "error", "error", "error");
                    }

                    //Datensätze werden in die Tabelle Adresse geladen
                    Adresse adresse;

                    try {
                        //create table for Adresse

                        adresse = new Adresse(-1, 1, "44225", "Dortmund", "Tannenstr.", "34", ""); //Adress_id = 1 = Empfänger 1
                        dataBaseHelper.addOneAdresse(adresse);
                        adresse = new Adresse(-1, 1, "44225", "Dortmund", "Karlsbader Str.", "20", "b"); //Adress_id = 2 = Empfänger 2
                        dataBaseHelper.addOneAdresse(adresse);
                        adresse = new Adresse(-1, 1, "44225", "Dortmund", "Leostraße", "26", "2te Stock, links"); //Adress_id = 3 = Empfänger 3
                        dataBaseHelper.addOneAdresse(adresse);
                        adresse = new Adresse(-1, 2, "44225", "Dortmund", "Egerstraße", "8", "Erdgeschoss"); //Adress_id = 4 = Empfänger 4
                        dataBaseHelper.addOneAdresse(adresse);
                        adresse = new Adresse(-1, 2, "44229", "Dortmund", "Schneiderstraße", "6", "a"); //Adress_id = 5 = Empfänger 5
                        dataBaseHelper.addOneAdresse(adresse);
                        adresse = new Adresse(-1, 5, "58256", "Ennepetal", "Gasstr.", "15", ""); //Adress_id = 6 = Absender 1 = Versender 1
                        dataBaseHelper.addOneAdresse(adresse);
                        adresse = new Adresse(-1, 6, "28359", "Bremen", "Bibliothekstraße", "1", ""); //Adress_id = 7 = Absender 2 = Versender 2
                        dataBaseHelper.addOneAdresse(adresse);
                        adresse = new Adresse(-1, 1, "54296", "Trier", "Universitätsring", "15", ""); //Adress_id = 8 = Absender 3 = Versender 3
                        dataBaseHelper.addOneAdresse(adresse);
                        adresse = new Adresse(-1, 3, "44801", "Bochum", "Universitätsstraße", "150", "Zwei Treppen links, dann drei Treppen rechts"); //Adress_id = 9 = Absender 4
                        dataBaseHelper.addOneAdresse(adresse);
                        adresse = new Adresse(-1, 2, "80539", "München", "Geschwister-Scholl-Platz", "1", ""); //Adress_id = 10 = Absender 5 = Versender 5
                        dataBaseHelper.addOneAdresse(adresse);
                        adresse = new Adresse(-1, 4, "10099", "Berlin", "Unter den Linden", "6", ""); //Adress_id = 11 = Versender 4
                        dataBaseHelper.addOneAdresse(adresse);
                        adresse = new Adresse(-1, 2, "44225", "Dortmund", "Baumstr", "17", "b");
                        dataBaseHelper.addOneAdresse(adresse);
                        adresse = new Adresse(-1, 2, "44225", "Dortmund", "Lessingstr.", "109", "");
                        dataBaseHelper.addOneAdresse(adresse);
                        adresse = new Adresse(-1, 3, "44225", "Dortmund", "Rabenstr.", "35", "");
                        dataBaseHelper.addOneAdresse(adresse);
                        adresse = new Adresse(-1, 3, "44225", "Dortmund", "Hochstr.", "2", "");
                        dataBaseHelper.addOneAdresse(adresse);
                        adresse = new Adresse(-1, 3, "44225", "Dortmund", "Grünestr.", "56", "");
                        dataBaseHelper.addOneAdresse(adresse);
                        adresse = new Adresse(-1, 2, "54296", "Trier", "Bergstr.", "44", "c");
                        dataBaseHelper.addOneAdresse(adresse);
                        adresse = new Adresse(-1, 2, "58135", "Hagen", "Schmiedestr.", "36", "");
                        dataBaseHelper.addOneAdresse(adresse);
                        adresse = new Adresse(-1, 2, "44425", "Dortmund", "Lochstr.", "23", "");
                        dataBaseHelper.addOneAdresse(adresse);
                        adresse = new Adresse(-1, 2, "73984", "Lauthal", "Regenbucht", "3", "");
                        dataBaseHelper.addOneAdresse(adresse);
                        adresse = new Adresse(-1, 2, "56982", "Lippe", "Zaunweg", "69", "");
                        dataBaseHelper.addOneAdresse(adresse);
                        adresse = new Adresse(-1, 3, "44225", "Dortmund", "Laue.", "72", "");
                        dataBaseHelper.addOneAdresse(adresse);
                        adresse = new Adresse(-1, 3, "55569", "Brücke", "Talstr.", "63", "");
                        dataBaseHelper.addOneAdresse(adresse);



                    } catch (Exception e) {
                        Toast.makeText(getActivity(), "Error creating Adresse", Toast.LENGTH_SHORT).show();
                        adresse = new Adresse(-1, 0, "error", "error", "error", "error", "error");
                    }

                    //Datensätze werden in die Tabelle Bezirk geladen
                    Bezirk bezirk;

                    try {
                        //create table for Bezirk

                        bezirk = new Bezirk(-1, 1, 1, 56234); //Adress_id = 1 = Empfänger 1
                        dataBaseHelper.addOneBezirk(bezirk);
                        bezirk = new Bezirk(-1, 1, 1, 49856); //Adress_id = 1 = Empfänger 1
                        dataBaseHelper.addOneBezirk(bezirk);
                        bezirk = new Bezirk(-1, 1, 1, 61253); //Adress_id = 1 = Empfänger 1
                        dataBaseHelper.addOneBezirk(bezirk);


                    } catch (Exception e) {
                        Toast.makeText(getActivity(), "Error creating Bezirk", Toast.LENGTH_SHORT).show();
                        bezirk = new Bezirk(-1, 0, 0, 0);
                    }

                    //Datensätze werden in die Tabelle Lieferant geladen
                    Lieferant lieferant;

                    try {
                        //create table for Lieferant

                        lieferant = new Lieferant(-1, 1, 1, "Pipi Langstrumpf", "PippilottaViktualiaRollgardinaPfefferminzEfraimstochter.Langstrumpf@Kunterbunttransporte.de", "02222-4567", "0151 411 500 79");
                        dataBaseHelper.addOneLieferant(lieferant);


                    } catch (Exception e) {
                        Toast.makeText(getActivity(), "Error creating Bezirk", Toast.LENGTH_SHORT).show();
                        bezirk = new Bezirk(-1, 0, 0, 0);
                    }

                    //Datensätze werden in die Tabelle Fahrzeug geladen
                    Fahrzeug fahrzeug;

                    try {
                        //create table for Fahrzeug

                        fahrzeug = new Fahrzeug(-1, 1, 1, "DO-BS 2020");
                        dataBaseHelper.addOneFahrzeug(fahrzeug);
                        fahrzeug = new Fahrzeug(-1, 2, 2, "DO-BS 2015");
                        dataBaseHelper.addOneFahrzeug(fahrzeug);
                        fahrzeug = new Fahrzeug(-1, 3, 2, "DO-BS 2016");
                        dataBaseHelper.addOneFahrzeug(fahrzeug);
                        fahrzeug = new Fahrzeug(-1, 4, 1, "DO-BS 2019");
                        dataBaseHelper.addOneFahrzeug(fahrzeug);
                        fahrzeug = new Fahrzeug(-1, 5, 1, "DO-BS 2018");
                        dataBaseHelper.addOneFahrzeug(fahrzeug);





                    } catch (Exception e) {
                        Toast.makeText(getActivity(), "Error creating Fahrzeug", Toast.LENGTH_SHORT).show();
                        fahrzeug = new Fahrzeug(-1, 0, 0, "error");
                    }

                    //Datensätze werden in die Tabelle Fahrzeugtyp geladen
                    Fahrzeugtyp fahrzeugtyp;

                    try {
                        //create table for Fahrzeugtyp

                        fahrzeugtyp = new Fahrzeugtyp(-1, "Transporter", 50, 1000000, 16000000, 4, 16, 250, 220);
                        dataBaseHelper.addOneFahrzeugtyp(fahrzeugtyp);
                        fahrzeugtyp = new Fahrzeugtyp(-1, "Sprinter", 25, 500000, 80000000, 4, 16, 180, 150);
                        dataBaseHelper.addOneFahrzeugtyp(fahrzeugtyp);


                    } catch (Exception e) {
                        Toast.makeText(getActivity(), "Error creating Fahrzeugtyp", Toast.LENGTH_SHORT).show();
                        fahrzeugtyp = new Fahrzeugtyp(-1, "error", 0, 0, 0, 0, 0, 0, 0);
                    }

                    //Datensätze werden in die Tabelle Fahrer geladen
                    Fahrer fahrer;

                    try {
                        //create table for Fahrer

                        fahrer = new Fahrer(-1, "0151 322 589 44", "C", "Ja");
                        dataBaseHelper.addOneFahrer(fahrer);
                        fahrer = new Fahrer(-1, "0151 356 283 93", "C", "Ja");
                        dataBaseHelper.addOneFahrer(fahrer);
                        fahrer = new Fahrer(-1, "0152 772 229 15", "C", "Ja");
                        dataBaseHelper.addOneFahrer(fahrer);
                        fahrer = new Fahrer(-1, "0157 302 549 12", "C", "Ja");
                        dataBaseHelper.addOneFahrer(fahrer);
                        fahrer = new Fahrer(-1, "0153 889 875 77", "C", "Ja");
                        dataBaseHelper.addOneFahrer(fahrer);


                    } catch (Exception e) {
                        Toast.makeText(getActivity(), "Error creating Fahrer", Toast.LENGTH_SHORT).show();
                        fahrer = new Fahrer(-1, "error", "error", "error");
                    }

                    //Datensätze werden in die Tabelle Sendungen geladen
                    Sendungen sendungen;

                    try {
                        //create table for Sendungen

                        sendungen = new Sendungen(-1, 1, 1, 1, 0, 0, 2, 360, 0, 0, 0, 0, 0, 0,1);
                        dataBaseHelper.addOneSendung(sendungen);
                        sendungen = new Sendungen(-1, 2, 2, 2, 0, 0, 1, 240, 0, 0, 0, 0, 0, 0,1);
                        dataBaseHelper.addOneSendung(sendungen);
                        sendungen = new Sendungen(-1, 3, 3, 3, 0, 0, 1, 240, 0, 0, 0, 0, 0, 0,1);
                        dataBaseHelper.addOneSendung(sendungen);
                        sendungen = new Sendungen(-1, 4, 4, 4, 0, 0, 1, 560, 19900, 1, 0, 0, 0, 0,2);
                        dataBaseHelper.addOneSendung(sendungen);
                        sendungen = new Sendungen(-1, 5, 5, 5, 0, 0, 1, 560, 0, 0, 0, 0, 0, 1,2);
                        dataBaseHelper.addOneSendung(sendungen);
                        sendungen = new Sendungen(-1, 6, 6, 6, 0, 0, 1, 480, 0, 0, 0, 0, 0, 0,2);
                        dataBaseHelper.addOneSendung(sendungen);
                        sendungen = new Sendungen(-1, 7, 7, 7, 0, 0, 1, 560, 0, 0, 1, 0, 0, 0,2);
                        dataBaseHelper.addOneSendung(sendungen);
                        sendungen = new Sendungen(-1, 8, 8, 8, 0, 0,1 , 360, 0, 0, 0, 0, 0, 0,3);
                        dataBaseHelper.addOneSendung(sendungen);
                        sendungen = new Sendungen(-1, 9, 9, 9, 0, 0, 1, 760, 29900, 1, 0, 0, 0, 0,3);
                        dataBaseHelper.addOneSendung(sendungen);
                        sendungen = new Sendungen(-1, 10, 10, 10, 0, 0, 1, 480, 0, 0, 0, 0, 0, 1,3);
                        dataBaseHelper.addOneSendung(sendungen);
                        sendungen = new Sendungen(-1, 11, 11, 11, 0, 0, 1, 480, 0, 0, 0, 0, 0, 0,3);
                        dataBaseHelper.addOneSendung(sendungen);





                    } catch (Exception e) {
                        Toast.makeText(getActivity(), "Error creating Sendung", Toast.LENGTH_SHORT).show();
                        sendungen = new Sendungen(-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0);
                    }

                    //Datensätze werden in die Tabelle Pakete geladen
                    Pakete pakete;

                    try {
                        //create table for Pakete

                        pakete = new Pakete(-1, 1, 500, 200, 300, 250, 0, 0, 1, "keine");
                        dataBaseHelper.addOnePaket(pakete);
                        pakete = new Pakete(-1, 1, 800, 400, 300, 180, 0, 0, 1, "keine");
                        dataBaseHelper.addOnePaket(pakete);
                        pakete = new Pakete(-1, 2, 1000, 500, 100, 200, 0, 1, 0, "keine");
                        dataBaseHelper.addOnePaket(pakete);
                        pakete = new Pakete(-1, 3, 400, 100, 200, 150, 0, 0, 1, "oben");
                        dataBaseHelper.addOnePaket(pakete);
                        pakete = new Pakete(-1, 4, 2500, 650, 250, 250, 0, 1, 0, "keine");
                        dataBaseHelper.addOnePaket(pakete);
                        pakete = new Pakete(-1, 5, 2500, 750, 400, 200, 0, 1, 0, "keine");
                        dataBaseHelper.addOnePaket(pakete);
                        pakete = new Pakete(-1, 6, 10500, 800, 450, 300, 0, 1, 0, "keine");
                        dataBaseHelper.addOnePaket(pakete);
                        pakete = new Pakete(-1, 7, 4500, 1000, 400, 100, 0, 0, 0, "keine");
                        dataBaseHelper.addOnePaket(pakete);
                        pakete = new Pakete(-1, 8, 500, 400, 400, 100, 0, 0, 0, "keine");
                        dataBaseHelper.addOnePaket(pakete);
                        pakete = new Pakete(-1, 9, 900, 600, 200, 600, 0, 0, 0, "keine");
                        dataBaseHelper.addOnePaket(pakete);
                        pakete = new Pakete(-1, 10, 3100, 1000, 400, 1000, 0, 1, 0, "keine");
                        dataBaseHelper.addOnePaket(pakete);
                        pakete = new Pakete(-1, 11, 1900, 800, 300, 200, 0, 0, 0, "keine");
                        dataBaseHelper.addOnePaket(pakete);


                    } catch (Exception e) {
                        Toast.makeText(getActivity(), "Error creating Sendung", Toast.LENGTH_SHORT).show();
                        sendungen = new Sendungen(-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0);
                    }
                    Toast.makeText(getActivity(), "Daten erfolgreich übermittelt", Toast.LENGTH_SHORT).show();
                    ShowCustomersOnListView(dataBaseHelper);
                } else{
                    Toast.makeText(getActivity(), "Daten sind aktuell. Keine Änderungen", Toast.LENGTH_SHORT).show();
                    ShowCustomersOnListView(dataBaseHelper);
                }
            }
            private void ShowCustomersOnListView(DataBaseHelper dataBaseHelper2) {
                SendungsArrayAdapter = new ArrayAdapter<Sendungen>(getActivity(), android.R.layout.simple_list_item_1, dataBaseHelper2.getAllSendungen());
                lv_Test.setAdapter(SendungsArrayAdapter);
            }
        });


        return root;
    }

}

