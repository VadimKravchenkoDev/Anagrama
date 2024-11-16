package com.kravchenkovadim.anagram;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilTest {

    @Test
    public void testMakeAnagram_reversesWords() {
        // Arrange
        StringUtil stringUtil = new StringUtil();
        String inputSymbols = "abcd efgh";
        String filterString = "b";

        // Act
        String result = stringUtil.makeAnagram(inputSymbols, filterString).toString();

        // Assert
        assertEquals("dbca hgfe", result);
    }

    @Test
    public void testMakeAnagram_preservesFilterSymbols() {
        // Arrange
        StringUtil stringUtil = new StringUtil();
        String inputSymbols = "abc def ghi";
        String filterString = "b";

        // Act
        String result = stringUtil.makeAnagram(inputSymbols, filterString).toString();

        // Assert
        assertEquals("cba fed ihg", result);
    }

    @Test
    public void testMakeAnagram_handlesEmptyInput() {
        // Arrange
        StringUtil stringUtil = new StringUtil();
        String inputSymbols = "";
        String filterString = "x";

        // Act
        String result = stringUtil.makeAnagram(inputSymbols, filterString).toString();

        // Assert
        assertEquals("", result);
    }
}
