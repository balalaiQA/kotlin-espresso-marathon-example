package com.balalaiqa.testapplication.environment

import android.util.Log
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import com.balalaiqa.testapplication.MainActivity
import com.balalaiqa.testapplication.environment.SupportBase.Companion.waitForIdle
import com.balalaiqa.testapplication.screens.MainScreen
import org.junit.*

open class TestBase {

    companion object {
        var currentDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())!!
        var mainScreen = MainScreen()

        @JvmStatic
        @BeforeClass
        fun precondition() {
            Log.i("AUTOTESTS_LOG", "[ BEFORE SUITE ]")
        }

        @JvmStatic
        @AfterClass
        fun closeApps() {
            Log.i("AUTOTESTS_LOG", "[ AFTER SUITE ]")
        }
    }

    @get:Rule
    var mainActivity = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
        Log.i("AUTOTESTS_LOG", "[ BEFORE TEST ]")
        currentDevice.wakeUp()
        waitForIdle()
    }

    @After
    fun closeApp() {
        Log.i("AUTOTESTS_LOG", "[ AFTER TEST ]")
    }
}