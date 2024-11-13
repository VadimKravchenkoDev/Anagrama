package com.kravchenkovadim.anagram;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.MediumTest;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@MediumTest
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testConvertButtonClickWithoutFilter() {
        // Вводим текст в поле inputText
        Espresso.onView(withId(R.id.inputText))
                .perform(ViewActions.typeText("hello world"), ViewActions.closeSoftKeyboard());

        // Вводим текст в поле filterText (пустой фильтр)
        Espresso.onView(withId(R.id.filterText))
                .perform(ViewActions.typeText(""), ViewActions.closeSoftKeyboard());

        // Нажимаем на кнопку ConvertButton
        Espresso.onView(withId(R.id.ConvertButton)).perform(ViewActions.click());

        // Проверяем, что поле outputResult отображает результат с перевёрнутыми словами
        Espresso.onView(withId(R.id.outputResult))
                .check(matches(withText("olleh dlrow")));
    }

    @Test
    public void testConvertButtonClickWithFilter() {
        // Вводим текст в поле inputText
        Espresso.onView(withId(R.id.inputText))
                .perform(ViewActions.typeText("Foxminded cool 24/7"), ViewActions.closeSoftKeyboard());

        // Вводим текст в поле filterText (фильтр с буквами, которые не должны изменяться)
        Espresso.onView(withId(R.id.filterText))
                .perform(ViewActions.typeText("xl"), ViewActions.closeSoftKeyboard());

        // Нажимаем на кнопку ConvertButton
        Espresso.onView(withId(R.id.ConvertButton)).perform(ViewActions.click());

        // Проверяем, что поле outputResult отображает результат с перевёрнутыми словами
        Espresso.onView(withId(R.id.outputResult))
                .check(matches(withText("dexdnimoF oocl 7/42")));
    }

    @Test
    public void testAnagramLiveDataUpdatesOutputWithFilter() {
        // Вводим текст в поле inputText
        Espresso.onView(withId(R.id.inputText))
                .perform(ViewActions.typeText("abcd efgh"), ViewActions.closeSoftKeyboard());

        // Вводим текст в поле filterText (фильтр, который сохраняет символы на месте)
        Espresso.onView(withId(R.id.filterText))
                .perform(ViewActions.typeText("fgh"), ViewActions.closeSoftKeyboard());

        // Нажимаем на кнопку ConvertButton
        Espresso.onView(withId(R.id.ConvertButton)).perform(ViewActions.click());

        // Проверяем, что результат отображается в outputResult
        Espresso.onView(withId(R.id.outputResult))
                .check(matches(withText("dcba efgh"))); // Ожидаемый результат: перевёрнутые слова, учитывая фильтр
    }

    @Test
    public void testAnagramWithoutFilter() {
        // Вводим текст в поле inputText
        Espresso.onView(withId(R.id.inputText))
                .perform(ViewActions.typeText("a1bcd efgh"), ViewActions.closeSoftKeyboard());

        // Вводим текст в поле filterText (пустой фильтр)
        Espresso.onView(withId(R.id.filterText))
                .perform(ViewActions.typeText(""), ViewActions.closeSoftKeyboard());

        // Нажимаем на кнопку ConvertButton
        Espresso.onView(withId(R.id.ConvertButton)).perform(ViewActions.click());

        // Проверяем, что результат отображается в outputResult
        Espresso.onView(withId(R.id.outputResult))
                .check(matches(withText("d1cba hgfe"))); // Ожидаемый результат: перевёрнутые слова без фильтра
    }
}
