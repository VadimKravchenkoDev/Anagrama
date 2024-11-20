package com.kravchenkovadim.anagram;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringUtil {
    public static final String symbols = "!@#$%^&*()_+-=[]{}|;:\"',.<>?/\\`~0123456789";

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
        Set<Character> filterSet = new HashSet<>();
        filter = filter.replaceAll("\\s", "");
        if (filter.isEmpty()) {
            // Use default symbols if filter is empty
            for (char c : symbols.toCharArray()) {
                filterSet.add(c);
            }
        } else {
            // Add characters from the provided filter
            for (char c : filter.toCharArray()) {
                filterSet.add(c);
            }
        }

        for (int i = word.length() - 1; i >= 0; i--) {
            boolean isFiltered = false;
            // check the every symbols that is in the filter

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
            if (currentChar != ' ') {
                result.insert(i, filterString.charAt(i));
            }
        }

        return result;
    }
}
