package de.codeyourapp.sqldemo.ui.fahrer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FahrerViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FahrerViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is fahrer fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
