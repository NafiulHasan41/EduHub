package com.nafsoft.aspireacademy.Authentication;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import androidx.test.espresso.intent.Intents;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.nafsoft.aspireacademy.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

@RunWith(AndroidJUnit4.class)
public class SignUpActivityTest {

    @Rule
    public ActivityTestRule<SignUp> activityRule = new ActivityTestRule<>(SignUp.class);

    @Before
    public void setUp() {
        Intents.init();
    }

    @After
    public void tearDown() {
        Intents.release();
    }

    @Test
    public void testEmptyEmail() {
        onView(withId(R.id.signUp)).perform(click());
        onView(withId(R.id.signUpEmail)).check(matches(withText("Enter Email Address")));
    }

    @Test
    public void testInvalidEmail() {
        onView(withId(R.id.signUpEmail)).perform(replaceText("test"));
        onView(withId(R.id.signUp)).perform(click());
        onView(withId(R.id.signUpEmail)).check(matches(withText("Enter Valid Email Address")));
    }

    @Test
    public void testEmptyPassword() {
        onView(withId(R.id.signUpEmail)).perform(replaceText("test@example.com"));
        onView(withId(R.id.signUp)).perform(click());
        onView(withId(R.id.signUpPassword)).check(matches(withText("Enter Password")));
    }

    @Test
    public void testShortPassword() {
        onView(withId(R.id.signUpEmail)).perform(replaceText("test@example.com"));
        onView(withId(R.id.signUpPassword)).perform(replaceText("123"));
        onView(withId(R.id.signUp)).perform(click());
        onView(withId(R.id.signUpPassword)).check(matches(withText("Password is too Short!")));
    }

    @Test
    public void testEmptyUserName() {
        onView(withId(R.id.signUpEmail)).perform(replaceText("test@example.com"));
        onView(withId(R.id.signUpPassword)).perform(replaceText("password"));
        onView(withId(R.id.signUp)).perform(click());
        onView(withId(R.id.signUpUserName)).check(matches(withText("Enter Your userName")));
    }

    @Test
    public void testSuccessfulSignUp() {
        onView(withId(R.id.signUpEmail)).perform(replaceText("test@example.com"));
        onView(withId(R.id.signUpPassword)).perform(replaceText("password"));
        onView(withId(R.id.signUpUserName)).perform(replaceText("username"));
        onView(withId(R.id.signUp)).perform(click());


    }
}
