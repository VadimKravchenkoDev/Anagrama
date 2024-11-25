package com.kravchenkovadim.anagram;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    public static final String symbols = "!@#$%^&*()_+-=[]{}|;:\"',.<>?/\\`~0123456789";

    public String makeAnagram(String inputSymbols, String filterString) {
        // Regular expression to separate text into words and spaces
        Pattern pattern = Pattern.compile("\\S+|\\s+");
        Matcher matcher = pattern.matcher(inputSymbols);

        StringBuilder result = new StringBuilder();

        while (matcher.find()) {
            String part = matcher.group();
            if (part.trim().isEmpty()) {
                result.append(part);
            } else {
                result.append(doReverse(part, filterString).toString());
            }
        }

        return result.toString();
    }

    //do reverse and leave filter symbols on starting place
    public StringBuilder doReverse(String word, String filter) {
        StringBuilder result = new StringBuilder();
        String cleanedFilter = filter.replaceAll("\\s", "");
        //initialize the row to save the position of filtering symbols
        StringBuilder filterString = new StringBuilder(" ".repeat(word.length()));
        Set<Character> filterSet = new HashSet<>();

        if (filter.isEmpty()) {
            cleanedFilter = symbols;
        }
        for (char c : cleanedFilter.toCharArray()) {
            filterSet.add(c);
        }

        for (int i = word.length() - 1; i >= 0; i--) {
            boolean isFiltered = false;

            // check the every symbols that is in the filter
            if (filterSet.contains(word.charAt(i))) {
                filterString.setCharAt(i, word.charAt(i));
            } else {
                result.append(word.charAt(i));
            }
        }

        // Add filtering symbols at the correct position
        for (int i = 0; i < filterString.length(); i++) {
            char currentChar = filterString.charAt(i);
            if (currentChar != ' ') {
                result.insert(i, currentChar);
            }
        }

        return result;
    }
}
