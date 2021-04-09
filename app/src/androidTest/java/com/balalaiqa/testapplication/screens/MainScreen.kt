package com.balalaiqa.testapplication.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.balalaiqa.testapplication.R
import com.balalaiqa.testapplication.environment.SupportBase
import org.hamcrest.CoreMatchers.allOf

class MainScreen : SupportBase() {

    val addLoginButton = onView(withId(R.id.addLoginButton))
    val deleteLoginButton = onView(withId(R.id.deleteSelectedLoginsButton))
    val loginInput = onView(withId(R.id.loginInput))
    val loginCheckbox = onView(withId(R.id.loginCheckBox))
    val loginList = onView(withId(R.id.loginList))


    fun getLogin(loginText: String): ViewInteraction {
        return onView(allOf(withId(R.id.loginTitle), withText(loginText)))
    }

    fun selectCheckbox() {
        loginCheckbox.perform(click())
    }

}