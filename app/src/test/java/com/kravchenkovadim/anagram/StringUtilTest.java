package com.kravchenkovadim.anagram;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringUtilTest {

    private StringUtil stringUtil;

    @Before
    public void setUp() {
        // Инициализируем объект StringUtil перед каждым тестом
        stringUtil = new StringUtil();
    }

    @Test
    public void testMakeAnagramWithoutFilterFoxminded() {
        // Входные данные: текст "Foxminded cool 24/7" без фильтра
        String input = "Foxminded cool 24/7";
        StringBuilder filter = new StringBuilder(); // Пустой фильтр

        // Ожидаемый результат
        String expected = "dednimxoF looc 24/7";

        // Получаем результат
        StringBuilder result = stringUtil.makeAnagram(input, filter);

        // Проверяем результат
        assertEquals(expected, result.toString());
    }

    @Test
    public void testMakeAnagramWithoutFilterAbcdEfgh() {
        // Входные данные: текст "abcd efgh" без фильтра
        String input = "abcd efgh";
        StringBuilder filter = new StringBuilder(); // Пустой фильтр

        // Ожидаемый результат
        String expected = "dcba hgfe";

        // Получаем результат
        StringBuilder result = stringUtil.makeAnagram(input, filter);

        // Проверяем результат
        assertEquals(expected, result.toString());
    }

    @Test
    public void testMakeAnagramWithoutFilterSpecialCharacters() {
        // Входные данные: текст "a1bcd efg!h" без фильтра
        String input = "a1bcd efg!h";
        StringBuilder filter = new StringBuilder(); // Пустой фильтр

        // Ожидаемый результат
        String expected = "d1cba hgf!e";

        // Получаем результат
        StringBuilder result = stringUtil.makeAnagram(input, filter);

        // Проверяем результат
        assertEquals(expected, result.toString());
    }

    @Test
    public void testMakeAnagramWithFilterFoxminded() {
        // Входные данные: текст "Foxminded cool 24/7" с фильтром "xl"
        String input = "Foxminded cool 24/7";
        StringBuilder filter = new StringBuilder("xl");

        // Ожидаемый результат
        String expected = "dexdnimoF oocl 7/42";

        // Получаем результат
        StringBuilder result = stringUtil.makeAnagram(input, filter);

        // Проверяем результат
        assertEquals(expected, result.toString());
    }

    @Test
    public void testMakeAnagramWithFilterAbcdEfgh() {
        // Входные данные: текст "abcd efgh" с фильтром "xl"
        String input = "abcd efgh";
        StringBuilder filter = new StringBuilder("xl");

        // Ожидаемый результат
        String expected = "dcba hgfe";

        // Получаем результат
        StringBuilder result = stringUtil.makeAnagram(input, filter);

        // Проверяем результат
        assertEquals(expected, result.toString());
    }

    @Test
    public void testMakeAnagramWithFilterSpecialCharacters() {
        // Входные данные: текст "a1bcd efglh" с фильтром "xl"
        String input = "a1bcd efglh";
        StringBuilder filter = new StringBuilder("xl");

        // Ожидаемый результат
        String expected = "dcb1a hgfle";

        // Получаем результат
        StringBuilder result = stringUtil.makeAnagram(input, filter);

        // Проверяем результат
        assertEquals(expected, result.toString());
    }
}
