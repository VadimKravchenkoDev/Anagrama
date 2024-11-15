package com.kravchenkovadim.anagram;

import java.util.HashSet;
import java.util.Set;

public class StringUtil {

    public StringBuilder makeAnagram(String inputSymbols, StringBuilder filter) {
        StringBuilder result = new StringBuilder();
        StringBuilder currentWord = new StringBuilder();
        char space = ' ';

        if (inputSymbols.isEmpty()) {
            return result.append(R.string.enter_your_text);
        } else {
            if (filter.length() == 0) {
                // add digit in filter
                for (char ch = '0'; ch <= '9'; ch++) {
                    filter.append(ch);
                }
                // add special symbols in filter
                String specialChars = "!@#$%^&*()_+-=[]{}|;:'\",.<>?/\\`~";
                filter.append(specialChars);
            }
        }
        if (hasDuplicateCharacters(filter.toString())) {
            result.append(R.string.filter);
            return result; // Return early if duplicates are found
        }
        // Loop through each character in inputSymbols
        for (int a = 0; a < inputSymbols.length(); a++) {
            currentWord.append(inputSymbols.charAt(a));
            // If we find a space, process the current word
            if (inputSymbols.charAt(a) == space) {
                // Remove the space from the end of the current word
                currentWord.deleteCharAt(currentWord.length() - 1);
                // Reverse current word with the filter applied, and add to result
                result.append(doReverse(currentWord, filter)).append(space);
                currentWord.setLength(0); // Clear for the next word
            }
        }
        // Process the last word, as it doesn't end with a space
        result.append(doReverse(currentWord, filter));
        return result;
    }

    private boolean hasDuplicateCharacters(String string) {
        Set<Character> seen = new HashSet<>();
        for (char ch : string.toCharArray()) {

            if (!seen.add(ch)) {
                return true;
            }
        }
        return false;
    }

    //do reverse and leave filter symbols on starting place
    public StringBuilder doReverse(StringBuilder word, StringBuilder filter) {
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
