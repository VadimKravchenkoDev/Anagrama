package com.kravchenkovadim.anagram;

import android.util.Log;

public class StringUtil {

  public StringBuilder  doReverse(String inputSymbols, String filterSymbols){
      StringBuilder result = new StringBuilder();

      //currentWord is temporary bank for symbols before empty space
      StringBuilder currentWord = new StringBuilder();
      char space = ' ';

      // Create a StringBuilder with a length equal to inputSymbols to store filter symbols
      StringBuilder filterString = new StringBuilder();
      for (int i = 0; i < inputSymbols.length(); i++) {
          filterString.append(' ');
      }
      for (int a = 0; a < inputSymbols.length(); a++) {
          currentWord.insert(a, inputSymbols.charAt(a));
          if(inputSymbols.charAt(a)==space){
//////////////////////////////////////////////////////////////////////////////////////////////
          }
      }
      outerLoop:
          for (int i = inputSymbols.length()-1; i >= 0; i--) {
              for(int j = 0; j<filterSymbols.length(); j++){
                  //find a filter symbol in input
                  if(inputSymbols.charAt(i)==filterSymbols.charAt(j)){
                      filterString.setCharAt(i,inputSymbols.charAt(i));
                      continue outerLoop;
                  }
              }
              result.append(inputSymbols.charAt(i));
          }

      for(int i=0; i<filterString.length(); i++){
          for(int j = 0; j<filterSymbols.length(); j++){
              if(filterString.charAt(i)==filterSymbols.charAt(j)){
                  result.insert(i,filterString.charAt(i));
              }
          }

      }

        return result;
    }
}
