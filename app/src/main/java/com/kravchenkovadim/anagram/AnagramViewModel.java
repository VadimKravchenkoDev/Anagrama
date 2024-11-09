package com.kravchenkovadim.anagram;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AnagramViewModel extends ViewModel {
    private final MutableLiveData<String> Anagram =
            new MutableLiveData<>();

    public LiveData<String> getAnagram() {
        return Anagram;
    }

    public void makeAnagram(String inputSymbols, String filterSymbols) {
        String result = "";
        if (inputSymbols.isEmpty() || filterSymbols.isEmpty()) {
            Anagram.setValue("Заповніть поля");
        } else {

            for (int i = inputSymbols.length()-1; i >= 0; i--) {
                result += inputSymbols.charAt(i);
            }
            Anagram.setValue(result);
        }
    }
}
