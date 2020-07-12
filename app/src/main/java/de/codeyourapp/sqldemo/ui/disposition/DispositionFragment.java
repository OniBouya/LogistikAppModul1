//Disposition
package de.codeyourapp.sqldemo.ui.disposition;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import de.codeyourapp.sqldemo.DataBaseHelper;
import de.codeyourapp.sqldemo.R;
import de.codeyourapp.sqldemo.Sendungen;

public class DispositionFragment extends Fragment {

    private DispositionViewModel dispositionViewModel;

    //Klassenobjekte
    private ListView lv_BezirkSendungenDispo, lv_FahrzeugSendungenDispo;
    private EditText et_bezirk, et_fahrzeug;
    private Button btn_loadNdList, btn_loadDList, btn_Dispo, btn_dedispo;
    private DataBaseHelper dataBaseHelper;
    private ArrayAdapter DispositionArrayAdapter;
    private Sendungen clickedSendungenDispo;
    private Sendungen clickedSendungenDedispo;
    // Variablen
    private String BezirksNummer = "0";
    private String FahrzeugNummer = "0";
    private int ItemPosition1; //Position der Auswahl in ListView oben
    private int ItemPosition2; //Position der Auswahl in ListView unten
    private int SendungsDispoId; //Id der für die Disposition ausgewählten Sendung
    private int SendungsDedispoId; //Id der für die Dedisposition ausgewählten Sendung
    private int MaxSendungsId; //Speicher für die Höchste SendungsId



    //View wird erzeugt
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dispositionViewModel =
                ViewModelProviders.of(this).get(DispositionViewModel.class);
        View root = inflater.inflate(R.layout.fragment_disposition, container, false);

        //Referenzen anhand der Id. --> ermöglicht einfache Übersetzung und Umbennung von Bezeichnungen
        et_bezirk = (EditText) root.findViewById(R.id.et_bezirk);
        et_fahrzeug = (EditText) root.findViewById(R.id.et_fahrzeug);
        lv_BezirkSendungenDispo = (ListView) root.findViewById(R.id.lv_BezirkSendungenDispo);
        lv_FahrzeugSendungenDispo = (ListView) root.findViewById(R.id.lv_FahrzeugSendungenDispo);
        btn_loadNdList = (Button) root.findViewById(R.id.btn_loadNdList);
        btn_loadDList = (Button) root.findViewById(R.id.btn_LadeDListe);
        btn_Dispo = (Button) root.findViewById(R.id.btn_Dispo);
        btn_dedispo = (Button) root.findViewById(R.id.btn_dedispo);
        //Objekt DataBaseHelper wird erzeugt
        dataBaseHelper = new DataBaseHelper(getActivity());



        //Button loadNdList wird mit dem oberen ListView und EditText verknüpft, um die noch nicht disponierten Sendungen anzuzueigen. Ist noch nicht so schön, könnte cleaner sein
        btn_loadNdList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String x = String.valueOf(et_bezirk.getText());
                if (x.equals("1")) {
                    BezirksNummer = "1";
                    ShowNDSendungenOnListView(dataBaseHelper);



                } else if (x.equals("2")) {
                    BezirksNummer = "2";
                    ShowNDSendungenOnListView(dataBaseHelper);



                } else if (x.equals("3")) {
                    BezirksNummer = "3";
                    ShowNDSendungenOnListView(dataBaseHelper);


                } else if(x.equals("")){
                    BezirksNummer = "0";
                    ShowAllNDSendungenOnListView(dataBaseHelper);
                } else {
                    BezirksNummer = "NA";
                    Toast.makeText(getActivity(), "Auswahl außerhalb des gültigen Bereichs "  + " " + BezirksNummer, Toast.LENGTH_SHORT).show();

                }

            }

            //Funktion, um die nicht disponierten Sendungen eines Bezirkes im oberen ListView anzuzeigen
            private void ShowNDSendungenOnListView(DataBaseHelper dataBaseHelper6)
            {
                DispositionArrayAdapter = new ArrayAdapter<Sendungen>(getActivity(), android.R.layout.simple_list_item_1, dataBaseHelper6.getNotDispoSendungen(BezirksNummer));
                lv_BezirkSendungenDispo.setAdapter(DispositionArrayAdapter);
            }


            //Funktion, um die nicht disponierten Sendungen im oberen ListView anzuzeigen (unabhängig vom Bezirk)
            private void ShowAllNDSendungenOnListView(DataBaseHelper dataBaseHelper6)
            {
               DispositionArrayAdapter = new ArrayAdapter<Sendungen>(getActivity(), android.R.layout.simple_list_item_1, dataBaseHelper6.getAllNotDispoSendungen());
               lv_BezirkSendungenDispo.setAdapter(DispositionArrayAdapter);
            }
        });

        //Button loadDList wird mit dem unteren ListView verknüpft um dort die disponierten Sendugnen abhängig vom gewählten Fahrzeug anzuzeigen
        btn_loadDList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String y = String.valueOf(et_fahrzeug.getText());
                if (y.equals("1")) {
                    FahrzeugNummer = "1";
                    ShowDSendungenOnListView(dataBaseHelper);



                } else if (y.equals("2")) {
                    FahrzeugNummer = "2";
                    ShowDSendungenOnListView(dataBaseHelper);



                } else if (y.equals("3")) {
                    FahrzeugNummer = "3";
                    ShowDSendungenOnListView(dataBaseHelper);


                } else if(y.equals("")){
                    FahrzeugNummer = "0";

                } else {
                    FahrzeugNummer = "NA";
                    Toast.makeText(getActivity(), "Auswahl außerhalb des gültigen Bereichs "  + " " + FahrzeugNummer, Toast.LENGTH_SHORT).show();

                }

            }
            //Funktion, um die disponierten Sendungen im oberen LV anzuzeigen
            private void ShowDSendungenOnListView(DataBaseHelper dataBaseHelper7) {
                DispositionArrayAdapter = new ArrayAdapter<Sendungen>(getActivity(), android.R.layout.simple_list_item_1, dataBaseHelper7.getDispoSendungen(FahrzeugNummer));
                lv_FahrzeugSendungenDispo.setAdapter(DispositionArrayAdapter);
            }
        });

        //Auswahl auf dem oberen ListView für die Dispo wird ermöglicht
        lv_BezirkSendungenDispo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                clickedSendungenDispo = (Sendungen) parent.getItemAtPosition(position);
                SendungsDispoId = clickedSendungenDispo.getSendungs_id();


                ItemPosition1 = position;
                btn_Dispo.setText("Dispo(Id): " + SendungsDispoId);

            }
        });
        //Auswahl auf dem unteren ListView für die Dedispo wird ermöglicht. Sendungs ID der ausgewäglten Sendung wird im Button Dispo dargestellt
        lv_FahrzeugSendungenDispo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                clickedSendungenDedispo = (Sendungen) parent.getItemAtPosition(position);
                SendungsDedispoId = clickedSendungenDedispo.getSendungs_id();


                ItemPosition2 = position;
                btn_dedispo.setText("Dedispo(Id): " + SendungsDedispoId);

            }
        });
        //Button Dispo wird mit den gespeicherten Zwischenvariablen mit den DataHelper Funktionen verknüpft die Änderungen an der Datenbank vornehmen
        btn_Dispo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaxSendungsId = dataBaseHelper.GetMaxSendungsId();//überprüft ob Daten in der Datenbank vorhanden sind, wenn ja setzt MaxSendungsdId auf den höchsten Wert in der Tabelle Sendungs-Id
                if (MaxSendungsId >= 1) {
                    if (SendungsDispoId <= MaxSendungsId && SendungsDispoId >= 1) {
                        if (!FahrzeugNummer.equals("") && !FahrzeugNummer.equals("0") && !FahrzeugNummer.equals("NA")) {
                            dataBaseHelper.dispoOne(clickedSendungenDispo, FahrzeugNummer);
                            Toast.makeText(getActivity(), "Info: KEINE PANIK. Alle Restriktionen wurden eingehalten.", Toast.LENGTH_LONG).show();
                            if (BezirksNummer.equals("0") || BezirksNummer.equals("NA")) {
                                ShowAllNDSendungenOnListView(dataBaseHelper);
                                ShowDispoSendungenOnListView(dataBaseHelper);

                            } else if (BezirksNummer.equals("")) {
                                Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_SHORT).show();
                            } else if (BezirksNummer.equals("1") || BezirksNummer.equals("2") || BezirksNummer.equals("3")) {
                                ShowNDSendungenOnListView(dataBaseHelper);
                                ShowDispoSendungenOnListView(dataBaseHelper);
                            } else {
                                Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_SHORT).show();
                            }


                        } else {
                            Toast.makeText(getActivity(), "Bitte geben Sie eine Fahrzeug Id an und Bestätigen Sie ihre Auswahl.", Toast.LENGTH_LONG).show();
                        }


                    } else {
                        Toast.makeText(getActivity(), "Bitte wählen Sie eine Sendungung aus der oberen Liste aus, die Sie disponieren möchten. " +
                                "TIPP: Sie können eine Sendung auswählen, indem Sie auf den entsprechenden Eintrag in der Liste klicken.", Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(getActivity(), "Datenbank leer. Bitte laden Sie die Sendungsdaten im Home Bildschirm", Toast.LENGTH_LONG).show();
                }
            }
            //Funktion, um nichtdisponierte Sendungen eines Bezirkes im oberen ListView darzustellen
            private void ShowNDSendungenOnListView(DataBaseHelper dataBaseHelper9) {
                DispositionArrayAdapter = new ArrayAdapter<Sendungen>(getActivity(), android.R.layout.simple_list_item_1, dataBaseHelper9.getNotDispoSendungen(BezirksNummer));
                lv_BezirkSendungenDispo.setAdapter(DispositionArrayAdapter);

            }
            //Funktion, um alle nicht disponierten Sendungen im oberen ListView darzustellen
            private void ShowAllNDSendungenOnListView(DataBaseHelper dataBaseHelper10) {
                DispositionArrayAdapter = new ArrayAdapter<Sendungen>(getActivity(), android.R.layout.simple_list_item_1, dataBaseHelper10.getAllNotDispoSendungen());
                lv_BezirkSendungenDispo.setAdapter(DispositionArrayAdapter);

            }
            //Funktion, um die disponierten Sendungen eines LKW im unteren ListView anzuzeigen
            private void ShowDispoSendungenOnListView(DataBaseHelper dataBaseHelper11) {
                DispositionArrayAdapter = new ArrayAdapter<Sendungen>(getActivity(), android.R.layout.simple_list_item_1, dataBaseHelper11.getDispoSendungen(FahrzeugNummer));
                lv_FahrzeugSendungenDispo.setAdapter(DispositionArrayAdapter);
            }

        });
        //Funktion um Sendungen wieder zu entdisponieren
        btn_dedispo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaxSendungsId = dataBaseHelper.GetMaxSendungsId();//überprüft ob Daten in der Datenbank vorhanden sind, wenn ja setzt MaxSendungsdId auf den höchsten Wert in der Tabelle Sendungs-Id
                if (MaxSendungsId >= 1) {
                    if (SendungsDedispoId <= MaxSendungsId && SendungsDedispoId >= 1) {
                        dataBaseHelper.dedispoOne(clickedSendungenDedispo);
                        if (!FahrzeugNummer.equals("") && !FahrzeugNummer.equals("0") && !FahrzeugNummer.equals("NA")) {
                            ShowDispoSendungenOnListView(dataBaseHelper);
                        }


                    }

                }else{
                    Toast.makeText(getActivity(), "Datenbank leer. Bitte laden Sie die Sendungsdaten im Home Bildschirm", Toast.LENGTH_LONG).show();
                }
            }
            //Funktion, um die disponierten Sendungen eines LKW im unteren ListView anzuzeigen
            private void ShowDispoSendungenOnListView(DataBaseHelper dataBaseHelper11) {
                DispositionArrayAdapter = new ArrayAdapter<Sendungen>(getActivity(), android.R.layout.simple_list_item_1, dataBaseHelper11.getDispoSendungen(FahrzeugNummer));
                lv_FahrzeugSendungenDispo.setAdapter(DispositionArrayAdapter);
            }
        });



        return root;
    }
}