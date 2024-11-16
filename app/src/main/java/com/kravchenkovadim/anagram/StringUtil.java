package com.kravchenkovadim.anagram;

import java.util.HashSet;
import java.util.Set;

public class StringUtil {

    public StringBuilder makeAnagram(String inputSymbols, String filterString) {
        StringBuilder result = new StringBuilder();
        StringBuilder currentWord = new StringBuilder();
        char space = ' ';
        
        // Loop through each character in inputSymbols
        for (int a = 0; a < inputSymbols.length(); a++) {
            currentWord.append(inputSymbols.charAt(a));
            // If we find a space, process the current word
            if (inputSymbols.charAt(a) == space) {
                // Remove the space from the end of the current word
                currentWord.deleteCharAt(currentWord.length() - 1);
                // Reverse current word with the filterString applied, and add to result
                result.append(doReverse(currentWord, filterString)).append(space);
                currentWord.setLength(0); // Clear for the next word
            }
        }
        // Process the last word, as it doesn't end with a space
        result.append(doReverse(currentWord, filterString));
        return result;
    }

    //do reverse and leave filter symbols on starting place
    public StringBuilder doReverse(StringBuilder word, String filter) {
        StringBuilder result = new StringBuilder();

        // Initialize filterString with spaces, same length as word
        StringBuilder filterString = new StringBuilder(" ".repeat(word.length()));

        outerLoop:
        for (int i = word.length() - 1; i >= 0; i--) {

            //Find filtering symbols and add them into filterString
            for (int j = 0; j < filter.length(); j++) {
                //find a filter symbol in word
                if (word.charAt(i) == filter.charAt(j)) {
                    filterString.setCharAt(i, word.charAt(i));
                    continue outerLoop;
                }
            }
            //add reverse symbol without filtering symbols
            result.append(word.charAt(i));
        }
        for (int i = 0; i < filterString.length(); i++) {
            for (int j = 0; j < filter.length(); j++) {
                if (filterString.charAt(i) == filter.charAt(j)) {

                    //add filtering symbols in correct place
                    result.insert(i, filterString.charAt(i));
                }
            }
        }
        return result;
    }
}
