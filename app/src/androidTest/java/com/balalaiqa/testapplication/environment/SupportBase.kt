package com.balalaiqa.testapplication.environment

import androidx.test.espresso.AppNotIdleException
import androidx.test.platform.app.InstrumentationRegistry

open class SupportBase {

    companion object {
        fun waitForIdle() {
            try {
                InstrumentationRegistry.getInstrumentation().waitForIdleSync()
            } catch (ignored: AppNotIdleException) {
            }
        }
    }
}