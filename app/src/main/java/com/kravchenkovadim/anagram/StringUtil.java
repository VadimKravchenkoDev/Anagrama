package com.kravchenkovadim.anagram;

import java.util.HashSet;
import java.util.Set;

public class StringUtil {

    public String makeAnagram(String inputSymbols, String filterString) {
        // We divide the input row into words
        String[] words = inputSymbols.split(" ");

        StringBuilder result = new StringBuilder();

        for (String word : words) {
            // Invertable skin word, use filter
            result.append(doReverse(new StringBuilder(word), filterString)).append(" ");
        }

        // delete last space
        if (result.length() > 0) {
            result.deleteCharAt(result.length() - 1);
        }

        return result.toString();
    }


    //do reverse and leave filter symbols on starting place
    public StringBuilder doReverse(StringBuilder word, String filter) {
        StringBuilder result = new StringBuilder();

        //initialize the row to save the position of filtering symbols
        StringBuilder filterString = new StringBuilder(" ".repeat(word.length()));

        outerLoop:
        for (int i = word.length() - 1; i >= 0; i--) {
            boolean isFiltered = false;
            // check the every symbols that is in the filter
            for (int j = 0; j < filter.length(); j++) {
                if (word.charAt(i) == filter.charAt(j)) {
                    filterString.setCharAt(i, word.charAt(i));
                    isFiltered = true;
                    break;
                }
            }
            // Symbols that are not filterable can be added
            if (!isFiltered) {
                result.append(word.charAt(i));
            }
        }

        // Add filtering symbols at the correct position
        for (int i = 0; i < filterString.length(); i++) {
            for (int j = 0; j < filter.length(); j++) {
                if (filterString.charAt(i) == filter.charAt(j)) {
                    result.insert(i, filterString.charAt(i));
                }
            }
        }
        return result;
    }
}
