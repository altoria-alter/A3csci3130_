package com.acme.a3csci3130;


import android.support.test.espresso.DataInteraction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction viewGroup = onView(
                allOf(childAtPosition(
                        allOf(withId(android.R.id.content),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                        1)),
                        0),
                        isDisplayed()));
        viewGroup.check(matches(isDisplayed()));

        ViewInteraction button = onView(
                allOf(withId(R.id.submitButton),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        button.check(matches(isDisplayed()));

        ViewInteraction viewGroup2 = onView(
                allOf(childAtPosition(
                        allOf(withId(android.R.id.content),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                        1)),
                        0),
                        isDisplayed()));
        viewGroup2.check(matches(isDisplayed()));

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction button2 = onView(
                allOf(withId(R.id.submitButton), withText("Create Contact"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        button2.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(3481220);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction editText = onView(
                allOf(withId(R.id.name),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        editText.perform(replaceText("Y"), closeSoftKeyboard());

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.name), withText("Y"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        editText2.perform(click());

        ViewInteraction editText3 = onView(
                allOf(withId(R.id.name), withText("Y"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        editText3.perform(replaceText("Yuhao Hu"));

        ViewInteraction editText4 = onView(
                allOf(withId(R.id.name), withText("Yuhao Hu"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        editText4.perform(closeSoftKeyboard());

        ViewInteraction editText5 = onView(
                allOf(withId(R.id.email),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        editText5.perform(replaceText("hhsshh119@gmai.com"), closeSoftKeyboard());

        ViewInteraction editText6 = onView(
                allOf(withId(R.id.businessNO),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        editText6.perform(replaceText("123456789"), closeSoftKeyboard());

        ViewInteraction editText7 = onView(
                allOf(withId(R.id.address),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        editText7.perform(replaceText("asdqwea"), closeSoftKeyboard());

        ViewInteraction spinner = onView(
                allOf(withId(R.id.primaryBusiness),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        spinner.perform(click());

        ViewInteraction spinner2 = onView(
                allOf(withId(R.id.primaryBusiness),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        spinner2.perform(click());

        DataInteraction checkedTextView = onData(anything())
                .inAdapterView(childAtPosition(
                        withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
                        0))
                .atPosition(2);
        checkedTextView.perform(click());

        ViewInteraction spinner3 = onView(
                allOf(withId(R.id.province),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                6),
                        isDisplayed()));
        spinner3.perform(click());

        DataInteraction checkedTextView2 = onData(anything())
                .inAdapterView(childAtPosition(
                        withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
                        0))
                .atPosition(4);
        checkedTextView2.perform(click());

        ViewInteraction editText8 = onView(
                allOf(withId(R.id.address), withText("asdqwea"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        editText8.perform(pressImeActionButton());

        ViewInteraction button3 = onView(
                allOf(withId(R.id.submitButton), withText("Create Contact"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        button3.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(3445252);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction imageButton = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withClassName(is("android.widget.Toolbar")),
                                        childAtPosition(
                                                withClassName(is("com.android.internal.widget.ActionBarContainer")),
                                                0)),
                                0),
                        isDisplayed()));
        imageButton.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(3594905);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        DataInteraction textView = onData(anything())
                .inAdapterView(allOf(withId(R.id.listView),
                        childAtPosition(
                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                1)))
                .atPosition(0);
        textView.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(3596980);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction button4 = onView(
                allOf(withId(R.id.erase), withText("Erase"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        button4.perform(click());

        ViewInteraction button5 = onView(
                allOf(withId(R.id.erase), withText("Erase"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        button5.perform(click());

        ViewInteraction button6 = onView(
                allOf(withId(R.id.erase), withText("Erase"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        button6.perform(click());

        ViewInteraction imageButton2 = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withClassName(is("android.widget.Toolbar")),
                                        childAtPosition(
                                                withClassName(is("com.android.internal.widget.ActionBarContainer")),
                                                0)),
                                0),
                        isDisplayed()));
        imageButton2.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(3576115);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        DataInteraction textView2 = onData(anything())
                .inAdapterView(allOf(withId(R.id.listView),
                        childAtPosition(
                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                1)))
                .atPosition(0);
        textView2.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(3595438);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction imageButton3 = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withClassName(is("android.widget.Toolbar")),
                                        childAtPosition(
                                                withClassName(is("com.android.internal.widget.ActionBarContainer")),
                                                0)),
                                0),
                        isDisplayed()));
        imageButton3.perform(click());

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
