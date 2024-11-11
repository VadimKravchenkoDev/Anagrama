package com.kravchenkovadim.anagram;

public class StringUtil {

  public StringBuilder  doReverse(String inputSymbols){
      StringBuilder result = new StringBuilder();
        for (int i = inputSymbols.length()-1; i >= 0; i--) {
            result.append(inputSymbols.charAt(i));
        }
        return result;
    }
}
