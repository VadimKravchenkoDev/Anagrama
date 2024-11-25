package com.kravchenkovadim.anagram;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class ViewModel extends androidx.lifecycle.ViewModel {
    public static final String message = "Enter your text!!!";
    private final StringUtil stringUtil;
    private final MutableLiveData<String> Anagram = new MutableLiveData<>();

    public ViewModel() {
        this.stringUtil = new StringUtil();
    }

    // Constructor for injecting StringUtil
    public ViewModel(StringUtil stringUtil) {
        this.stringUtil = stringUtil;
    }

    public LiveData<String> getAnagram() {
        return Anagram;
    }

    public void insertAnagram(String inputSymbols, String filterString) {
        String result = stringUtil.makeAnagram(inputSymbols, filterString);
        if(result.trim().isEmpty()){
            Anagram.setValue(message);
        } else {
            Anagram.setValue(result);
        }

    }
}
