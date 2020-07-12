package de.codeyourapp.sqldemo.ui.fahrer;

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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import de.codeyourapp.sqldemo.DataBaseHelper;
import de.codeyourapp.sqldemo.Fahrer;
import de.codeyourapp.sqldemo.R;

public class FahrerFragment extends Fragment {

    private FahrerViewModel fahrerViewModel;
    //Klassen
    private Button btn_fahrerdaten;
    private ListView lv_fahrerdaten;
    private DataBaseHelper dataBaseHelper;
    private ArrayAdapter FahrerArrayAdapter;
    private ImageView iv_Einsatzplan;
    private EditText filterFahrer;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        fahrerViewModel =
                ViewModelProviders.of(this).get(FahrerViewModel.class);
        View root = inflater.inflate(R.layout.fragment_fahrer, container, false);
        //Referenzen
        btn_fahrerdaten = (Button) root.findViewById(R.id.btn_fahrerdaten);
        lv_fahrerdaten = (ListView) root.findViewById(R.id.lv_fahrerdaten);
        iv_Einsatzplan = (ImageView) root.findViewById(R.id.imageView4);
        filterFahrer = (EditText) root.findViewById(R.id.filterFahrer);
        //DatadBaseHelper
        dataBaseHelper = new DataBaseHelper(getActivity());
        //Image wird am anfang versteckt
        iv_Einsatzplan.setVisibility(View.GONE);
        //Filter wird deaktiviert bis eine Liste geladen wird, um zu vermeiden dass getFilter auf einem leeren adapter ausgeführt wird
        filterFahrer.setEnabled(false);

        //Funktion um die Fahrerdaten in den ListView zu laden
        btn_fahrerdaten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fahrer fahrer;
                ShowFahrerOnListView(dataBaseHelper);
                filterFahrer.setEnabled(true);

            }

            private void ShowFahrerOnListView(DataBaseHelper dataBaseHelper5) {
                FahrerArrayAdapter = new ArrayAdapter<Fahrer>(getActivity(), android.R.layout.simple_list_item_1, dataBaseHelper5.getAllFahrer());
                lv_fahrerdaten.setAdapter(FahrerArrayAdapter);
                iv_Einsatzplan.setVisibility(View.VISIBLE);
            }
        });
        //Filter um Fahrer zu filtern
        filterFahrer.setText("Fahrer{Fahrer_id=");


            Selection.setSelection(filterFahrer.getText(), filterFahrer.getText().length());

            filterFahrer.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    FahrerArrayAdapter.getFilter().filter(s);
                }

                @Override
                public void afterTextChanged(Editable s) {
                    if (!s.toString().startsWith("Fahrer{Fahrer_id=")) {
                        filterFahrer.setText("Fahrer{Fahrer_id=");
                        Selection.setSelection(filterFahrer.getText(), filterFahrer.getText().length());

                    }

                }
            });



        //final TextView textView = root.findViewById(R.id.text_fahrzeuge);
        fahrerViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });
        return root;
    }
}