package com.kravchenkovadim.anagram;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class ViewModel extends androidx.lifecycle.ViewModel {
    private final StringUtil stringUtil = new StringUtil();
    private final MutableLiveData<String> Anagram =
            new MutableLiveData<>();

    public LiveData<String> getAnagram() {
        return Anagram;
    }

    public void insertAnagram(String inputSymbols, String filterString) {
        Anagram.setValue(stringUtil.makeAnagram(inputSymbols, filterString).toString());
    }
}
