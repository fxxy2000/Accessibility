package com.wilsonzhou.accessibility

import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import org.junit.After

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    private var mContext: Context? = null

    @Before
    fun setUp() {
        mContext = InstrumentationRegistry.getTargetContext()
    }

    @After
    fun tearDown() {

    }

    @Test
    @Throws(Exception::class)
    fun useAppContext() {
        // Context of the app under test.
        assertEquals("com.wilsonzhou.accessibility", mContext?.packageName)
    }
}
