package com.karumi.magiccounterkataandroid

import kotlin.random.Random

interface RandomNumberGenerator {
    fun randomValue(): Int
}

class DefaultRandomNumberGenerator : RandomNumberGenerator {
    override fun randomValue(): Int = Random.nextInt()
}
