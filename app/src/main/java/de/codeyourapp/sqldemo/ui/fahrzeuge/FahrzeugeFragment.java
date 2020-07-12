package de.codeyourapp.sqldemo.ui.fahrzeuge;

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
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import de.codeyourapp.sqldemo.DataBaseHelper;
import de.codeyourapp.sqldemo.Fahrzeug;
import de.codeyourapp.sqldemo.R;

public class FahrzeugeFragment extends Fragment {

    private FahrzeugeViewModel fahrzeugeViewModel;
    //Klassen
    private Button btn_fahrzeugdaten;
    private ListView lv_fahrzeugdaten;
    private DataBaseHelper dataBaseHelper;
    private ArrayAdapter FahrzeugArrayAdapter;
    private EditText filterFahrzeuge;
    //Variablen
    private boolean ListActive = false;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        fahrzeugeViewModel =
                ViewModelProviders.of(this).get(FahrzeugeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_fahrzeuge, container, false);
        //Referenzen
        btn_fahrzeugdaten = (Button) root.findViewById(R.id.btn_fahrzeugdaten);
        lv_fahrzeugdaten = (ListView) root.findViewById(R.id.lv_fahrzeugdaten);
        filterFahrzeuge = (EditText) root.findViewById(R.id. filterFahrzeuge);
        //DataBaseHelper
        dataBaseHelper = new DataBaseHelper(getActivity());
        //Filter wird deaktiviert bis eine Liste geladen wird, um zu vermeiden dass getFilter auf einem leeren adapter ausgeführt wird
        filterFahrzeuge.setEnabled(false);

        //Button um Fahrzeugdaten im Fahrzeugpool darzustellen
        btn_fahrzeugdaten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fahrzeug fahrzeug;
                ShowFahrzeugeOnListView(dataBaseHelper);
                filterFahrzeuge.setEnabled(true);

            }
            private void ShowFahrzeugeOnListView(DataBaseHelper dataBaseHelper4) {
                FahrzeugArrayAdapter = new ArrayAdapter<Fahrzeug>(getActivity(), android.R.layout.simple_list_item_1, dataBaseHelper4.getAllFahrzeuge());
                lv_fahrzeugdaten.setAdapter(FahrzeugArrayAdapter);
            }
        });
        filterFahrzeuge.setText("Fahrzeug{Fahrzeug_id=");
        Selection.setSelection(filterFahrzeuge.getText(), filterFahrzeuge.getText().length());

            //Suchfunktion, um Fahrzeuge anhand ihrer ID zu suchen
            filterFahrzeuge.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    FahrzeugArrayAdapter.getFilter().filter(s);
                }

                @Override
                public void afterTextChanged(Editable s) {
                    if (!s.toString().startsWith("Fahrzeug{Fahrzeug_id=")) {
                        filterFahrzeuge.setText("Fahrzeug{Fahrzeug_id=");
                        Selection.setSelection(filterFahrzeuge.getText(), filterFahrzeuge.getText().length());

                    }

                }
            });

        //Artefact, keine funktion?
        //final TextView textView = root.findViewById(R.id.text_fahrzeuge);
        fahrzeugeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });
        return root;
    }
}
