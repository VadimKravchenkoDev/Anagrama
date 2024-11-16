package com.kravchenkovadim.anagram;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

public class ViewModelTest {

    @Rule
    public InstantTaskExecutorRule rule = new InstantTaskExecutorRule();

    @Test
    public void testInsertAnagram_updatesLiveData() {
        // Arrange
        ViewModel viewModel = new ViewModel();
        String inputSymbols = "abcd";
        String filterString = "b";
        StringUtil mockStringUtil = Mockito.mock(StringUtil.class);
        Mockito.when(mockStringUtil.makeAnagram(inputSymbols, filterString))
                .thenReturn(new StringBuilder("dbca"));

        Observer<String> observer = Mockito.mock(Observer.class);
        viewModel.getAnagram().observeForever(observer);

        // Act
        viewModel.insertAnagram(inputSymbols, filterString);

        // Assert
        Mockito.verify(observer).onChanged("dbca");
    }
}
