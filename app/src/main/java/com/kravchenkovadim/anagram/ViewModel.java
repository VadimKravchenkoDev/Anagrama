package com.kravchenkovadim.anagram;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class ViewModel extends androidx.lifecycle.ViewModel {
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
        Anagram.setValue(stringUtil.makeAnagram(inputSymbols, filterString).toString());
    }
}
