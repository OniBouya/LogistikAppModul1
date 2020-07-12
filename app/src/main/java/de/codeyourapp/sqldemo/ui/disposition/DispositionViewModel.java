package de.codeyourapp.sqldemo.ui.disposition;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DispositionViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DispositionViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Disposition fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}