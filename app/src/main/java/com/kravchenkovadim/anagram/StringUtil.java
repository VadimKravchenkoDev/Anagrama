package com.kravchenkovadim.anagram;

public class StringUtil {

  public StringBuilder makeAnagram(String inputSymbols, String filterSymbols){
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
          if(inputSymbols.charAt(a)==space){
              currentWord.deleteCharAt(a);



              for(int i=0; i<filterString.length(); i++){
                  for(int j = 0; j<filterSymbols.length(); j++){
                      if(filterString.charAt(i)==filterSymbols.charAt(j)){
                          result.insert(i,filterString.charAt(i));
                      }
                  }
              }
          currentWord.setLength(0);
          result.append(space);
          }


      }




        return result;
  }

  public StringBuilder doReverse(StringBuilder word, StringBuilder filterString){
      outerLoop:
      for (int i = currentWord.length()-1; i >= 0; i--) {

          //Find filtering symbols and add them into filterSymbols
          for(int j = 0; j<filterSymbols.length(); j++){
              //find a filter symbol in input
              if(currentWord.charAt(i)==filterSymbols.charAt(j)){
                  filterString.setCharAt(i,currentWord.charAt(i));
                  continue outerLoop;
              }
          }
          result.append(currentWord.charAt(i));
      }
  }
}
