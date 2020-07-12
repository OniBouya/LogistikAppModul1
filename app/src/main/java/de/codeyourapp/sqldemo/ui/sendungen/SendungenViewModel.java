package de.codeyourapp.sqldemo.ui.sendungen;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SendungenViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SendungenViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Sendungen fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}