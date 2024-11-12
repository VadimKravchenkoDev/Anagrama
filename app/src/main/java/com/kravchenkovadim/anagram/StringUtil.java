package com.kravchenkovadim.anagram;

public class StringUtil {

    public StringBuilder makeAnagram(String inputSymbols, String filter) {
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
                // Reverse current word with the filter applied, and add to result
                result.append(doReverse(currentWord, filter)).append(space);
                currentWord.setLength(0); // Clear for the next word
            }
        }
        // Process the last word, as it doesn't end with a space
        result.append(doReverse(currentWord, filter));
        return result;
    }

    public StringBuilder doReverse(StringBuilder word, String filter) {
        // Initialize result with spaces, same length as word
        StringBuilder result = new StringBuilder(" ".repeat(word.length()));

        // Index to keep track of position for non-filter characters in reverse order
        int reverseIndex = word.length() - 1;

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);

            // If current character is in the filter, keep it in the original position
            if (filter.indexOf(currentChar) != -1) {
                result.setCharAt(i, currentChar);
            } else {
                // Otherwise, add the character in reverse order
                result.setCharAt(reverseIndex--, currentChar);
            }
        }

        return result;
    }
}
