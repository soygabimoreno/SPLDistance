package com.appacoustic.android.spldistance.domain

import org.junit.Assert.assertTrue
import org.junit.Assert.fail
import org.junit.Test

class CalculateAttenuationTest {

    @Test
    fun `A distance of 0 meters generates an attenuation of Infinite`() {
        val distance = "0"
        val calculateAttenuation = CalculateAttenuation()

        calculateAttenuation(distance)
            .fold({
                fail("")
            },
                {
                    assertTrue(Float.POSITIVE_INFINITY == it)
                })
    }
}
