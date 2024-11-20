package com.kravchenkovadim.anagram;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class StringUtilTest {

    private final StringUtil stringUtil = new StringUtil();

    @Test
    public void testMakeAnagramWithoutFilter() {
        String input = "Foxminded cool 24/7";
        String filter = "";

        String result = stringUtil.makeAnagram(input, filter);

        assertEquals("dednimxoF looc 24/7", result);
    }

    @Test
    public void testMakeAnagramWithFilter() {
        String input = "Foxminded cool 24/7";
        String filter = "xl";

        String result = stringUtil.makeAnagram(input, filter);

        assertEquals("dexdnimoF oocl 7/42", result);
    }

    @Test
    public void testMakeAnagramWithSpecialSymbols() {
        String input = "a1bcd efg!h";
        String filter = "!";

        String result = stringUtil.makeAnagram(input, filter);

        assertEquals("dcb1a hgf!e", result);
    }

    @Test
    public void testDoReverseWithoutFilter() {
        String word = "a1bcd";
        String filter = "";

        StringBuilder result = stringUtil.doReverse(word, filter);

        assertEquals("d1cba", result.toString());
    }

    @Test
    public void testDoReverseWithFilter() {
        String word = "a1bcd";
        String filter = "1";

        StringBuilder result = stringUtil.doReverse(word, filter);

        assertEquals("d1cba", result.toString());
    }

    @Test
    public void testDoReverseWithComplexFilter() {
        String word = "a1bcd";
        String filter = "1b";

        StringBuilder result = stringUtil.doReverse(word, filter);

        assertEquals("d1bca", result.toString());
    }

    @Test
    public void testDoReverseWithEmptyWord() {
        String word = "";
        String filter = "1";

        StringBuilder result = stringUtil.doReverse(word, filter);

        assertEquals("", result.toString());
    }

    @Test
    public void testDoReverseWithAllFiltered() {
        String word = "12345";
        String filter = "12345";

        StringBuilder result = stringUtil.doReverse(word, filter);

        assertEquals("12345", result.toString());
    }

    @Test
    public void testDoReverseWithNoFilterMatch() {
        String word = "abcdef";
        String filter = "123";

        StringBuilder result = stringUtil.doReverse(word, filter);

        assertEquals("fedcba", result.toString());
    }

    @Test
    public void testSymbolsConstant() {
        Set<Character> symbolsSet = StringUtil.symbols.chars()
                .mapToObj(c -> (char) c)
                .collect(java.util.stream.Collectors.toSet());

        assertTrue(symbolsSet.contains('!'));
        assertTrue(symbolsSet.contains('@'));
        assertTrue(symbolsSet.contains('9'));
        assertFalse(symbolsSet.contains('a'));
    }
}
