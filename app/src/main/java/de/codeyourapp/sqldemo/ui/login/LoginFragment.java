package de.codeyourapp.sqldemo.ui.login;

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

import de.codeyourapp.sqldemo.DataBaseHelper;
import de.codeyourapp.sqldemo.R;

public class LoginFragment extends Fragment {

    private LoginViewModel loginViewModel;
    //Klassen
    private Button btn_Login, btn_Logout;
    private DataBaseHelper dataBaseHelper;
    private ImageView iv_bHeart, iv_Heart;
    private EditText et_User, et_Password;
    //Variablen
    private int Anmeldeversuche = 0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        loginViewModel =
                ViewModelProviders.of(this).get(LoginViewModel.class);
        View root = inflater.inflate(R.layout.fragment_login, container, false);
        //Referenzen
        btn_Login = (Button) root.findViewById(R.id.btn_Login);
        btn_Logout = (Button) root.findViewById(R.id.btn_Logout);
        iv_bHeart = (ImageView) root.findViewById(R.id.iv_bHeart);
        iv_Heart = (ImageView) root.findViewById(R.id.iv_Heart);
        et_User= (EditText) root.findViewById(R.id.et_User);
        et_Password= (EditText) root.findViewById(R.id.et_Password);
        //DatadBaseHelper
        dataBaseHelper = new DataBaseHelper(getActivity());
        //Image wird am anfang versteckt
        hideHearts();
        //Klick listener für den Button Login. Nach 3 Versuchen wird der Account gesperrt. Naja nicht wirklich, keine Sorge ;D
        //Für die Zukunft vll. den Login mit Globaler Variable und eigener Klasse realisieren, wenn noch Zeit da ist.
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u = String.valueOf(et_User.getText());
                String p = String.valueOf(et_Password.getText());
                if (u.equals("Klaus.Schmitz@city-hub.de") && p.equals("Bello2009")){
                    hideHearts();
                    Anmeldeversuche = 0;
                    iv_Heart.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "Willkommen in Ihrer Logistik App Herr Schmitz", Toast.LENGTH_LONG).show();
                }else if(Anmeldeversuche == 0){
                    hideHearts();
                    Toast.makeText(getActivity(), "Ihre Anmeldedaten sind nicht korrekt", Toast.LENGTH_LONG).show();
                    iv_bHeart.setVisibility(View.VISIBLE);
                    Anmeldeversuche = Anmeldeversuche+1;
                }
                else if(Anmeldeversuche == 1){
                    hideHearts();
                    Toast.makeText(getActivity(), "Sie haben noch 2 Versuche", Toast.LENGTH_LONG).show();
                    iv_bHeart.setVisibility(View.VISIBLE);
                    Anmeldeversuche = Anmeldeversuche+1;
                } else if(Anmeldeversuche == 2){
                    hideHearts();
                    Toast.makeText(getActivity(), "Sie haben noch 1 Versuch", Toast.LENGTH_LONG).show();
                    iv_bHeart.setVisibility(View.VISIBLE);
                    Anmeldeversuche = Anmeldeversuche+1;
                }else if (Anmeldeversuche == 3){
                    hideHearts();
                    Toast.makeText(getActivity(), "Ihr Konto wurde gesperrt, bitte kontaktieren Sie ihren Admin. Er wird sich freuen.", Toast.LENGTH_LONG).show();
                    iv_bHeart.setVisibility(View.VISIBLE);
                    Anmeldeversuche = 0;
                }

            }
        });
        //Klick Listener für den Logout Button
        btn_Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideHearts();
                Toast.makeText(getActivity(), "Auf Wiedersehen und schönen Feierabend", Toast.LENGTH_LONG).show();
                iv_Heart.setVisibility(View.VISIBLE);


            }
        });


        return root;
    }
    public void hideHearts(){
        iv_bHeart.setVisibility(View.GONE);
        iv_Heart.setVisibility(View.GONE);
    }
}
