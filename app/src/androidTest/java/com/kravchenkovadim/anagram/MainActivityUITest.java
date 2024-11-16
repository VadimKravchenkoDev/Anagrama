package com.kravchenkovadim.anagram;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityUITest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testConvertButton_withValidInput_showsAnagram() {
        // Arrange
        String inputSymbols = "abcd";
        String filterString = "b";
        String expectedResult = "dbca";

        // Act
        onView(withId(R.id.inputTextLayout))
                .perform(replaceText(inputSymbols), closeSoftKeyboard());
        onView(withId(R.id.filterTextLayout))
                .perform(replaceText(filterString), closeSoftKeyboard());
        onView(withId(R.id.ConvertButton))
                .perform(click());

        // Assert
        onView(withId(R.id.outputResult))
                .check(matches(withText(expectedResult)));
    }

    @Test
    public void testConvertButton_withEmptyInput_showsError() {
        // Act
        onView(withId(R.id.ConvertButton))
                .perform(click());

        // Assert
        Context context = ApplicationProvider.getApplicationContext();
        String expectedError = context.getString(R.string.enter_your_text);

        onView(withId(R.id.outputResult))
                .check(matches(withText(expectedError)));
    }

    @Test
    public void testConvertButton_withDuplicateFilter_showsError() {
        // Arrange
        String inputSymbols = "abcd";
        String filterString = "bb";

        // Act
        onView(withId(R.id.inputTextLayout))
                .perform(replaceText(inputSymbols), closeSoftKeyboard());
        onView(withId(R.id.filterTextLayout))
                .perform(replaceText(filterString), closeSoftKeyboard());
        onView(withId(R.id.ConvertButton))
                .perform(click());

        // Assert
        Context context = ApplicationProvider.getApplicationContext();
        String expectedError = context.getString(R.string.filter);

        onView(withId(R.id.outputResult))
                .check(matches(withText(expectedError)));
    }
}
