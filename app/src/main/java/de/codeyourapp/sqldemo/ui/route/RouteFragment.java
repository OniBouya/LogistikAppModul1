package de.codeyourapp.sqldemo.ui.route;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.MarkerOptions;

import de.codeyourapp.sqldemo.DataBaseHelper;
import de.codeyourapp.sqldemo.R;




//implements OnMapReadyCallback
public class RouteFragment extends Fragment {
    private RouteViewModel routeViewModel;
    //Klassen
    private Button btn_Route;
    private ImageView iv_map1, iv_map2, iv_map3;
    private EditText et_fahrzeugRoute;
    private DataBaseHelper dataBaseHelper;
    //Variablen
    String FzgNummer = "0";




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        routeViewModel =
                ViewModelProviders.of(this).get(RouteViewModel.class);
        View root = inflater.inflate(R.layout.fragment_route, container, false);

        //Referenzen
        btn_Route = (Button) root.findViewById(R.id.btn_Route);
        iv_map1 = (ImageView) root.findViewById(R.id.iv_map1);
        iv_map2 = (ImageView) root.findViewById(R.id.iv_map2);
        iv_map3 = (ImageView) root.findViewById(R.id.iv_map3);
        et_fahrzeugRoute = (EditText) root.findViewById(R.id.et_fahrzeugRoute);
        //DatadBaseHelper
        dataBaseHelper = new DataBaseHelper(getActivity());
        //Image wird am anfang versteckt
        iv_map1.setVisibility(View.GONE);
        iv_map2.setVisibility(View.GONE);
        iv_map3.setVisibility(View.GONE);



        btn_Route.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String z = String.valueOf(et_fahrzeugRoute.getText());
                if (z.equals("1")) {
                    hideMaps();
                    iv_map1.setVisibility(View.VISIBLE);
                } else if (z.equals("2")) {
                    hideMaps();
                    iv_map2.setVisibility(View.VISIBLE);
                } else if (z.equals("3")) {
                    hideMaps();
                    iv_map3.setVisibility(View.VISIBLE);
                } else {
                    hideMaps();
                    Toast.makeText(getActivity(), "Bitte geben Sie eine Fahrzeug ID an", Toast.LENGTH_LONG).show();

                }

            }
        });




        return root;

    }
    //Funktion, um die drei Image Views mit den Karten drauf zu verstecken
    public void hideMaps(){
        iv_map1.setVisibility(View.GONE);
        iv_map2.setVisibility(View.GONE);
        iv_map3.setVisibility(View.GONE);
    }
}
