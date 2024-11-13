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
        MockitoAnnotations.initMocks(this);
        viewModel = new ViewModel();
        viewModel.getAnagram().observeForever(observer);
    }

    @Test
    public void testInsertAnagramEmptyInput() {
        // Given
        String inputSymbols = "";
        StringBuilder filter = new StringBuilder();

        // When
        viewModel.insertAnagram(inputSymbols, filter);

        // Then
        assertEquals("Expected error message", viewModel.getAnagram().getValue());
    }

    @Test
    public void testInsertAnagramValidInput() {
        // Given
        String inputSymbols = "sample text";
        StringBuilder filter = new StringBuilder("filter");

        // When
        viewModel.insertAnagram(inputSymbols, filter);

        // Then
        assertEquals("Expected anagram result", viewModel.getAnagram().getValue());
    }
}

