package com.karumi.magiccounterkataandroid

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MagicCounterTest {

    private lateinit var random: MockRandomNumberGenerator
    private lateinit var storage: MockCounterStorage
    private lateinit var magicCounter: MagicCounter

    @Before
    fun setUp() {
        random = MockRandomNumberGenerator()
        storage = MockCounterStorage()
        magicCounter = MagicCounter(random, storage)
    }

    @Test
    fun returnsTheRandomValueIfTheCounterWasNotSavedPreviouslyAndTheRandomValueIsGreaterThan100() {
        random.value = 101

        val result = magicCounter.increase()

        assertEquals(101, result)
    }

    @Test
    fun returns1IfTheCounterWasNotSavedPreviouslyAndTheRandomValueIsLowerOrEqualTo100() {
        random.value = 100

        val result = magicCounter.increase()

        assertEquals(1, result)
    }

    @Test
    fun savesTheCounterValueIfTheRandomNumberIsGreaterThan100() {
        random.value = 101

        magicCounter.increase()

        assertEquals(101, storage.get())
    }

    @Test
    fun savesTheCounterValueIfTheRandomNumberIsLowerOrEqualTo100() {
        random.value = 100

        magicCounter.increase()

        assertEquals(1, storage.get())
    }

    @Test
    fun twoConsecutiveIncrementsGreaterThan100ReturnsTheExpectedValue() {
        random.value = 101

        magicCounter.increase()
        val result = magicCounter.increase()

        assertEquals(202, result)
    }

    @Test
    fun twoConsecutiveIncrementsLowerOrEqualTo100ReturnsTheExpectedValue() {
        random.value = 99

        magicCounter.increase()
        val result = magicCounter.increase()

        assertEquals(2, result)
    }

    @Test
    fun oneIncrementWithRandomValueLowerThan100AndAnotherOneGreaterThan100ReturnsTheExpectedValue() {
        random.value = 1

        magicCounter.increase()
        random.value = 101
        val result = magicCounter.increase()

        assertEquals(102, result)
    }

    @Test
    fun oneIncrementGreaterThan100AndAnotherOneLowerThan100ReturnsTheExpectedValue() {
        random.value = 101

        magicCounter.increase()
        random.value = 1
        val result = magicCounter.increase()

        assertEquals(102, result)
    }

    @Test
    fun ifThereWasNoPreviouslySavedValuesTheResultWillBeMinusOne() {
        val result = magicCounter.decrease()

        assertEquals(-1, result)
    }

    @Test
    fun ifTheValueIsIncrementedTwiceWithoutAnyPreviouslySavedValueTheResultIsMinusTwo() {
        magicCounter.decrease()
        val result = magicCounter.decrease()

        assertEquals(-2, result)
    }

    @Test
    fun ifTheValueWasPreviouslyIncreasedTheResultIsOneUnitLess() {
        random.value = 101

        magicCounter.increase()
        val result = magicCounter.decrease()

        assertEquals(100, result)
    }
}

private class MockRandomNumberGenerator : RandomNumberGenerator {
    var value: Int = 0
    override fun randomValue(): Int = value
}

private class MockCounterStorage : CounterStorage {
    private var value: Int? = null
    override fun save(value: Int) {
        this.value = value
    }

    override fun get(): Int? = value

    override fun clear() {
        value = null
    }
}
