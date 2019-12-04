package com.karumi.magiccounterkataandroid

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AndroidCounterStorageTest {

    private lateinit var storage: AndroidCounterStorage

    @Before
    fun setUp() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        storage = AndroidCounterStorage(context)
        storage.clear()
    }

    @After
    fun tearDown() {
        storage.clear()
    }

    @Test
    fun returnsNullIfTheCounterValueWasNotSavedBefore() {
        assertNull(storage.get())
    }

    @Test
    fun returnsTheValuePreviouslySaved() {
        val counter = 1

        storage.save(counter)

        assertEquals(counter, storage.get())
    }

    @Test
    fun overridesTheValuePreviouslySavedWithANewOne() {
        val counter = 1

        storage.save(0)
        storage.save(counter)

        assertEquals(counter, storage.get())
    }
}
