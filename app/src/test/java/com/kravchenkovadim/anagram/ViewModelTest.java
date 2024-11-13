package com.kravchenkovadim.anagram;

import static org.junit.Assert.assertEquals;


import androidx.lifecycle.Observer;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class ViewModelTest {

    @Rule
    public InstantTaskExecutorRule rule = new InstantTaskExecutorRule();

    private ViewModel viewModel;

    @Mock
    private Observer<String> observer;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        viewModel = new ViewModel();
        viewModel.getAnagram().observeForever(observer);
    }


    @Test
    public void testInsertAnagramEmptyInput() {
        viewModel.insertAnagram("", new StringBuilder());
        assertEquals("Введіть текст", viewModel.getAnagram().getValue());
    }

    @Test
    public void testInsertAnagramValidInput() {
        StringBuilder filter = new StringBuilder();
        viewModel.insertAnagram("sample", filter);
        assertEquals("elpmas", viewModel.getAnagram().getValue());
    }

}

