package com.kravchenkovadim.anagram;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

public class ViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantExecutorRule = new InstantTaskExecutorRule();

    @Test
    public void testInsertAnagramWithoutFilter() {
        // Mock StringUtil
        StringUtil mockStringUtil = Mockito.mock(StringUtil.class);
        String inputText = "Foxminded cool 24/7";
        String filterText = "";

        // Stub method call
        when(mockStringUtil.makeAnagram(inputText, filterText)).thenReturn("dednimxoF looc 24/7");

        // Inject mocked StringUtil into ViewModel
        ViewModel viewModel = new ViewModel(mockStringUtil);

        // Act
        viewModel.insertAnagram(inputText, filterText);

        // Assert
        assertEquals("dednimxoF looc 24/7", viewModel.getAnagram().getValue());

        // Verify interaction with mock
        verify(mockStringUtil).makeAnagram(inputText, filterText);
    }

    @Test
    public void testInsertAnagramWithFilter() {
        // Mock StringUtil
        StringUtil mockStringUtil = Mockito.mock(StringUtil.class);
        String inputText = "Foxminded cool 24/7";
        String filterText = "xl";

        // Stub method call
        when(mockStringUtil.makeAnagram(inputText, filterText)).thenReturn("dexdnimoF oocl 7/42");

        // Inject mocked StringUtil into ViewModel
        ViewModel viewModel = new ViewModel(mockStringUtil);

        // Act
        viewModel.insertAnagram(inputText, filterText);

        // Assert
        assertEquals("dexdnimoF oocl 7/42", viewModel.getAnagram().getValue());

        // Verify interaction with mock
        verify(mockStringUtil).makeAnagram(inputText, filterText);
    }

    @Test
    public void testInsertAnagramWithSpecialSymbols() {
        // Mock StringUtil
        StringUtil mockStringUtil = Mockito.mock(StringUtil.class);
        String inputText = "a1bcd efg!h";
        String filterText = "!";

        // Stub method call
        when(mockStringUtil.makeAnagram(inputText, filterText)).thenReturn("dcb1a hgf!e");

        // Inject mocked StringUtil into ViewModel
        ViewModel viewModel = new ViewModel(mockStringUtil);

        // Act
        viewModel.insertAnagram(inputText, filterText);

        // Assert
        assertEquals("dcb1a hgf!e", viewModel.getAnagram().getValue());

        // Verify interaction with mock
        verify(mockStringUtil).makeAnagram(inputText, filterText);
    }
}
