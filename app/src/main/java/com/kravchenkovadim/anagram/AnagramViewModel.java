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
    StringUtil reverse = new StringUtil();
    public void makeAnagram(String inputSymbols, String filterSymbols) {
        StringBuilder result = new StringBuilder();
        if (inputSymbols.isEmpty() || filterSymbols.isEmpty()) {
            Anagram.setValue("Заповніть поля");
        } else {

            result = reverse.doReverse(inputSymbols);
            

            Anagram.setValue(result.toString());
        }
    }
}
