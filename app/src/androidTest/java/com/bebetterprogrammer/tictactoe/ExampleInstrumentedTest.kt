package com.bebetterprogrammer.tictactoe

<<<<<<< HEAD

import androidx.test.ext.junit.runners.AndroidJUnit4


import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals


import org.junit.Test
import org.junit.runner.RunWith


=======
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
>>>>>>> d9c21eba2394350ea4c7cf7697e24df7e9a0f3b6
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.bebetterprogrammer.tictactoe", appContext.packageName)
    }
}
