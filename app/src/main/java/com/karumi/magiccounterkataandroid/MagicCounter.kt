package com.karumi.magiccounterkataandroid

class MagicCounter(private val random: RandomNumberGenerator, private val storage: CounterStorage) {
    fun increase(): Int {
        val currentCounter = storage.get() ?: 0
        val randomValue = random.randomValue()
        val updatedCounter = if (randomValue > 100) {
            currentCounter + randomValue
        } else {
            currentCounter + 1
        }
        storage.save(updatedCounter)
        return updatedCounter
    }

    fun decrease(): Int {
        val updatedCounter = (storage.get() ?: 0) - 1
        storage.save(updatedCounter)
        return updatedCounter
    }
}
