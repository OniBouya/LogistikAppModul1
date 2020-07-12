package de.codeyourapp.sqldemo.ui.fahrzeuge;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FahrzeugeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FahrzeugeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is fahrzeuge fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}