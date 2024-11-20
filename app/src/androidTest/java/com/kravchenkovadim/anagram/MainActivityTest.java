package com.kravchenkovadim.anagram;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testAnagramWithoutFilter() {
        onView(withId(R.id.inputTextLayout)).perform(typeText("Foxminded cool 24/7"));
        onView(withId(R.id.filterTextLayout)).perform(typeText(""));
        onView(withId(R.id.ConvertButton)).perform(click());
        onView(withId(R.id.outputResult)).check(matches(withText("dednimxoF looc 24/7")));
    }

    @Test
    public void testAnagramWithFilter() {
        onView(withId(R.id.inputTextLayout)).perform(typeText("Foxminded cool 24/7"));
        onView(withId(R.id.filterTextLayout)).perform(typeText("xl"));
        onView(withId(R.id.ConvertButton)).perform(click());
        onView(withId(R.id.outputResult)).check(matches(withText("dexdnimoF oocl 7/42")));
    }

    @Test
    public void testRotationPreservesData() {
        onView(withId(R.id.inputTextLayout)).perform(typeText("abcd efgh"));
        onView(withId(R.id.filterTextLayout)).perform(typeText(""));
        activityRule.getScenario().onActivity(activity -> activity.setRequestedOrientation(android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE));
        onView(withId(R.id.inputTextLayout)).check(matches(withText("abcd efgh")));
        onView(withId(R.id.filterTextLayout)).check(matches(withText("")));
    }
}
