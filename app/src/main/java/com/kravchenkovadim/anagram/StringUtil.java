package com.kravchenkovadim.anagram;

import android.util.Log;

public class StringUtil {

  public StringBuilder  doReverse(String inputSymbols, String filterSymbols){
      StringBuilder result = new StringBuilder();

      // Create a StringBuilder with a length equal to inputSymbols to store filter symbols
      StringBuilder filterString = new StringBuilder();

      for (int i = 0; i < inputSymbols.length(); i++) {
          filterString.append(' ');
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
      Log.d("mylog", filterString.toString());


        return result;
    }
}
