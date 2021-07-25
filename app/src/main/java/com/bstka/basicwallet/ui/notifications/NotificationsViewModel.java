package com.bstka.basicwallet.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NotificationsViewModel extends ViewModel {

    private String[][] MockupData = new String[][]{ { "SUCCESS", "17 November 2020", "PLN Bill" }, { "FAILED", "17 December 2020", "Credit Card Bill" }, { "SUCCESS", "17 November 2021", "PLN Bill" }, { "SUCCESS", "30 January 2021", "Kartu Halo Bill" }, { "SUCCESS", "17 January 2021", "PLN Bill" } };
    private MutableLiveData<String[][]> mText;

    public NotificationsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(MockupData);
    }

    public LiveData<String[][]> getText() {
        return mText;
    }
}