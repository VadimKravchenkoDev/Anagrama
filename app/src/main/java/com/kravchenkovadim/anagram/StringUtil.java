package com.kravchenkovadim.anagram;

public class StringUtil {

    public StringBuilder makeAnagram(String inputSymbols, String filter) {
        StringBuilder result = new StringBuilder();

        //currentWord is temporary bank for symbols before empty space
        StringBuilder currentWord = new StringBuilder();
        char space = ' ';

        // Create a StringBuilder with a length equal to inputSymbols to store filter symbols
        StringBuilder filterString = new StringBuilder();
        for (int i = 0; i < inputSymbols.length(); i++) {
            filterString.append(' ');
        }

        //Find a word before space and add into currentWord for reverse
        for (int a = 0; a < inputSymbols.length(); a++) {
            currentWord.insert(a, inputSymbols.charAt(a));
            if (inputSymbols.charAt(a) == space) {
                currentWord.deleteCharAt(a);
                result = doReverse(currentWord, filterString, filter);
                currentWord.setLength(0);
                result.append(space);
            } else {
                result = doReverse(currentWord, filterString, filter);
                currentWord.setLength(0);
            }
        }
        return result;
    }

    public StringBuilder doReverse(StringBuilder word, StringBuilder filterString, String filter) {
        StringBuilder result = new StringBuilder();
        outerLoop:
        for (int i = word.length() - 1; i >= 0; i--) {

            //Find filtering symbols and add them into filterSymbols
            for (int j = 0; j < filter.length(); j++) {
                //find a filter symbol in input
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
