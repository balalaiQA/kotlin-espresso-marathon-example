package com.balalaiqa.testapplication.tests

import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.hasChildCount
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.balalaiqa.testapplication.annotations.TargetOne
import com.balalaiqa.testapplication.annotations.TargetTwo
import com.balalaiqa.testapplication.environment.TestBase
import org.junit.Test


class MainScreenTests: TestBase() {

    @TargetOne
    @TargetTwo
    @Test
    fun addNewLoginTest() {
        mainScreen.loginInput.perform(typeText("login1"))
        mainScreen.addLoginButton.perform(click())
        mainScreen.getLogin("login1").check(matches(isDisplayed()))
    }

    @TargetOne
    @TargetTwo
    @Test
    fun deleteAllLoginsTest() {
        mainScreen.loginInput.perform(typeText("login2"))
        mainScreen.addLoginButton.perform(click())
        mainScreen.selectCheckbox()
        mainScreen.deleteLoginButton.perform(click())
        mainScreen.loginList.check(matches(hasChildCount(0)))
    }

    @TargetOne
    @TargetTwo
    @Test
    fun failedExampleTest() {
        mainScreen.loginInput.perform(typeText("login3"))
        mainScreen.loginList.check(matches(hasChildCount(1)))
    }

    @TargetOne
    @Test
    fun addNewTargetOneLoginTest() {
        mainScreen.loginInput.perform(typeText("login4"))
        mainScreen.addLoginButton.perform(click())
        mainScreen.getLogin("login4").check(matches(isDisplayed()))
    }

    @TargetTwo
    @Test
    fun addNewTargetTwoLoginTest() {
        mainScreen.loginInput.perform(typeText("login5"))
        mainScreen.addLoginButton.perform(click())
        mainScreen.getLogin("login5").check(matches(isDisplayed()))
    }
}
