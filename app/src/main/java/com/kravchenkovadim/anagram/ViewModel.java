package com.kravchenkovadim.anagram;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class ViewModel extends androidx.lifecycle.ViewModel {
    private final MutableLiveData<String> Anagram =
            new MutableLiveData<>();

    public LiveData<String> getAnagram() {
        return Anagram;
    }

    public void insertAnagram(String inputSymbols, String filterSymbols) {
        StringUtil stringUtil = new StringUtil();
        if (inputSymbols.isEmpty() || filterSymbols.isEmpty()) {
            Anagram.setValue("Заповніть поля");
        } else {
            Anagram.setValue(stringUtil.makeAnagram(inputSymbols, filterSymbols).toString());
        }
    }
}
