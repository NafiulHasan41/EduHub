package com.nafsoft.aspireacademy.pdfsection;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.nafsoft.aspireacademy.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class pdfSectionUITest {
    @Rule
    public ActivityTestRule<pdfSection> activityRule = new ActivityTestRule<>(pdfSection.class);

    @Before
    public void setUp() {
        Intents.init();
    }
    @Test
    public void testButtonClick() {
        onView(withId(R.id.notebtn)).perform(click());
        intended(hasComponent(recyclerViewActivity.class.getName()));
    }
    @After
    public void tearDown() {
        Intents.release();
    }

}