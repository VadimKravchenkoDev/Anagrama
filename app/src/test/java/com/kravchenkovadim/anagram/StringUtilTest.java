package com.kravchenkovadim.anagram;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringUtilTest {

    private StringUtil stringUtil;

    @Before
    public void setUp() {
        stringUtil = new StringUtil();
    }

    @Test
    public void testMakeAnagramWithoutFilter() {
        StringBuilder input = new StringBuilder("Foxminded cool 24/7");
        StringBuilder filter = new StringBuilder();
        StringBuilder expected = new StringBuilder("dednimxoF looc 24/7");
        assertEquals(expected.toString(), stringUtil.makeAnagram(input.toString(), filter).toString());
    }

    @Test
    public void testMakeAnagramWithAlphabetOnly() {
        StringBuilder input = new StringBuilder("abcd efgh");
        StringBuilder filter = new StringBuilder();
        StringBuilder expected = new StringBuilder("dcba hgfe");
        assertEquals(expected.toString(), stringUtil.makeAnagram(input.toString(), filter).toString());
    }

    @Test
    public void testMakeAnagramWithSpecialCharsAndDigits() {
        StringBuilder input = new StringBuilder("a1bcd efg!h");
        StringBuilder filter = new StringBuilder();
        StringBuilder expected = new StringBuilder("d1cba hgf!e");
        assertEquals(expected.toString(), stringUtil.makeAnagram(input.toString(), filter).toString());
    }

    @Test
    public void testMakeAnagramWithCustomFilter() {
        StringBuilder input = new StringBuilder("Foxminded cool 24/7");
        StringBuilder filter = new StringBuilder("xl");
        StringBuilder expected = new StringBuilder("dexdnimoF oocl 7/42");
        assertEquals(expected.toString(), stringUtil.makeAnagram(input.toString(), filter).toString());
    }

    @Test
    public void testMakeAnagramWithEmptyInput() {
        StringBuilder input = new StringBuilder("");
        StringBuilder filter = new StringBuilder();
        StringBuilder expected = new StringBuilder("");
        assertEquals(expected.toString(), stringUtil.makeAnagram(input.toString(), filter).toString());
    }

    @Test
    public void testMakeAnagramWithSpacesOnly() {
        StringBuilder input = new StringBuilder("    ");
        StringBuilder filter = new StringBuilder();
        StringBuilder expected = new StringBuilder("    ");
        assertEquals(expected.toString(), stringUtil.makeAnagram(input.toString(), filter).toString());
    }

    @Test
    public void testMakeAnagramWithFilterContainingSpecialCharacters() {
        StringBuilder input = new StringBuilder("a!b@c#d e$f%g");
        StringBuilder filter = new StringBuilder("!@#$%");
        StringBuilder expected = new StringBuilder("d!c@b#a g%f$e");
        assertEquals(expected.toString(), stringUtil.makeAnagram(input.toString(), filter).toString());
    }
}
