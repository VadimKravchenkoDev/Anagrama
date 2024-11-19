package com.kravchenkovadim.anagram;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringUtil {

    public String makeAnagram(String inputSymbols, String filterString) {
        // We divide the input row into words
        String[] words = inputSymbols.split("\\s+");

        return String.join(" ",
                Arrays.stream(words)
                        .map(word -> doReverse(word, filterString).toString())
                        .toArray(String[]::new)
        );
    }

    //do reverse and leave filter symbols on starting place
    public StringBuilder doReverse(String word, String filter) {
        StringBuilder result = new StringBuilder();

        //initialize the row to save the position of filtering symbols
        StringBuilder filterString = new StringBuilder(" ".repeat(word.length()));

        for (int i = word.length() - 1; i >= 0; i--) {
            boolean isFiltered = false;
            // check the every symbols that is in the filter
            Set<Character> filterSet = new HashSet<>();
            for (char c : filter.toCharArray()) {
                filterSet.add(c);
            }
            if (filterSet.contains(word.charAt(i))) {
                filterString.setCharAt(i, word.charAt(i));
                isFiltered = true;
            }
            // Symbols that are not filterable can be added
            if (!isFiltered) {
                result.append(word.charAt(i));
            }
        }

// Add filtering symbols at the correct position
        for (int i = 0; i < filterString.length(); i++) {
            char currentChar = filterString.charAt(i);
            if (currentChar != ' ' && filter.indexOf(filterString.charAt(i)) != -1) {
                result.insert(i, filterString.charAt(i));
            }
        }

        return result;
    }
}
