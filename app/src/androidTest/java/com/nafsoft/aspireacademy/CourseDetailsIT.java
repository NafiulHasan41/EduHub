package com.nafsoft.aspireacademy;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
public class CourseDetailsIT {

    @Rule
    public ActivityTestRule<CourseDetails> activityRule = new ActivityTestRule<>(CourseDetails.class);

    @Test
    public void testVideoCardClick() {
        Espresso.onView(withId(R.id.videoCard)).perform(ViewActions.click());

    }

    @Test
    public void testExamCardClick() {
        Espresso.onView(withId(R.id.examCard)).perform(ViewActions.click());

    }

    @Test
    public void testPdfCardClick() {
        Espresso.onView(withId(R.id.pdfCard)).perform(ViewActions.click());

    }
}