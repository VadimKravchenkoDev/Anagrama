package com.kravchenkovadim.anagram;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AnagramViewModel extends ViewModel {
    private final MutableLiveData<AnagramData> anagramData =
            new MutableLiveData<>(new AnagramData());

    public LiveData<AnagramData> getAnagram() {
        return anagramData;
    }

    public void makeAnagram() {

    }
}
