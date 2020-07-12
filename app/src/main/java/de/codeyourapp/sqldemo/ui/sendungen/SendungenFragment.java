package de.codeyourapp.sqldemo.ui.sendungen;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import de.codeyourapp.sqldemo.DataBaseHelper;
import de.codeyourapp.sqldemo.Main2Activity;
import de.codeyourapp.sqldemo.R;
import de.codeyourapp.sqldemo.Sendungen;

public class SendungenFragment extends Fragment {

    private SendungenViewModel sendungenViewModel;
    //Variablen
    private int ScreenHeight;
    //Klassen
    private Button btn_sendungsdaten;
    private ListView lv_sendungsdaten;
    private EditText filterSendungen;
    private DataBaseHelper dataBaseHelper;
    private ArrayAdapter SendungsArrayAdapter;
    //Funktionen
    //Funktion, um die Breite des Bildschirms des Endgerätes zu bekommen
    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }
    //Funktion, um die Höhe des Bildschrims des Endgerätes zu bekommen
    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }
    //View wird generiert
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sendungenViewModel =
                ViewModelProviders.of(this).get(SendungenViewModel.class);
        View root = inflater.inflate(R.layout.fragment_sendungen, container, false);
        //Referenzen
        btn_sendungsdaten = (Button) root.findViewById(R.id.btn_sendungsdaten);
        lv_sendungsdaten = (ListView) root.findViewById(R.id.lv_sendungsdaten);
        filterSendungen = (EditText) root.findViewById(R.id. filterSendungen);
        //DataBaseHelper
        dataBaseHelper = new DataBaseHelper(getActivity());
        //Speicher die Höhe des Bildschrims des Nutzergerätes
        ScreenHeight= getScreenHeight();
        //Setze die Position und größe des ListView in abhängigkeit von der Bildschirmgröße fest
        lv_sendungsdaten.setLayoutParams(new ConstraintLayout.LayoutParams(getScreenWidth(), (ScreenHeight-750)));
        lv_sendungsdaten.setY(358);
        //Filter wird deaktiviert bis eine Liste geladen wird, um zu vermeiden dass getFilter auf einem leeren adapter ausgeführt wird
        filterSendungen.setEnabled(false);
        //Button, um Sendungsdaten in den ListView zu laden
        btn_sendungsdaten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sendungen sendungen;
                ShowSendungenOnListView(dataBaseHelper);
                filterSendungen.setEnabled(true);
            }
            private void ShowSendungenOnListView(DataBaseHelper dataBaseHelper5) {
                SendungsArrayAdapter = new ArrayAdapter<Sendungen>(getActivity(), android.R.layout.simple_list_item_1, dataBaseHelper5.getAllSendungen());
                lv_sendungsdaten.setAdapter(SendungsArrayAdapter);
            }
        });
        //Suchfunktion nach Sendungs ID
        filterSendungen.setText("Sendungen{Sendungs_id=");
        Selection.setSelection(filterSendungen.getText(), filterSendungen.getText().length());

        filterSendungen.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                SendungsArrayAdapter.getFilter().filter(s);

            }

            @Override
            public void afterTextChanged(Editable s) {

                if(!s.toString().startsWith("Sendungen{Sendungs_id=")){
                    filterSendungen.setText("Sendungen{Sendungs_id=");
                    Selection.setSelection(filterSendungen.getText(), filterSendungen.getText().length());

                }


            }
        });

        return root;
    }
}
