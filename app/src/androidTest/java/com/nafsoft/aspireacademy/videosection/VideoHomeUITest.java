package com.nafsoft.aspireacademy.videosection;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import com.nafsoft.aspireacademy.R;

@LargeTest
public class VideoHomeUITest {

    @Rule
    public ActivityScenarioRule<VideoHome> activityRule =
            new ActivityScenarioRule<>(VideoHome.class);

    @Test
    public void testClassOneViewIsDisplayed() {
        Espresso.onView(withId(R.id.videOne)).check(matches(isDisplayed()));
    }

    @Test
    public void testClickOnClassOneOpensShowVideoActivity() {

        Espresso.onView(withId(R.id.videOne)).perform(ViewActions.click());


        Espresso.onView(withId(R.id.showVideoLayout)).check(matches(isDisplayed()));
    }
}
