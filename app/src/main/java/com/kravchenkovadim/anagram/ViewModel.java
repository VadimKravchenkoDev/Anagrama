package com.kravchenkovadim.anagram;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class ViewModel extends androidx.lifecycle.ViewModel {
    private final MutableLiveData<String> Anagram =
            new MutableLiveData<>();

    public LiveData<String> getAnagram() {
        return Anagram;
    }

    public void insertAnagram(String inputSymbols, StringBuilder filterString) {
        StringUtil stringUtil = new StringUtil();
        if (inputSymbols.isEmpty()) {
            Anagram.setValue(StringConstants.INPUT_WORD);
        } else {
            if(filterString.length() == 0){

                    // add digit in filter
                    for (char ch = '0'; ch <= '9'; ch++) {
                        filterString.append(ch);
                    }
                // add special symbols in filter
                String specialChars = "!@#$%^&*()_+-=[]{}|;:'\",.<>?/\\`~";
                filterString.append(specialChars);
                Log.d("mylog", filterString.toString());
                Anagram.setValue(stringUtil.makeAnagram(inputSymbols, filterString).toString());
            }
            Anagram.setValue(stringUtil.makeAnagram(inputSymbols, filterString).toString());
        }
    }
}
