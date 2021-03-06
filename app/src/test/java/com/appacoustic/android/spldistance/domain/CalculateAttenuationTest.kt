package com.appacoustic.android.spldistance.domain

import org.junit.Assert.assertTrue
import org.junit.Assert.fail
import org.junit.Test

class CalculateAttenuationTest {

    @Test
    fun `A distance of 0 meters generates an attenuation of -Infinite`() {
        val distance = "0"
        val calculateAttenuation = CalculateAttenuation()

        calculateAttenuation(distance)
            .fold({
                fail("")
            }, {
                assertTrue(Float.NEGATIVE_INFINITY == it)
            })
    }

    @Test
    fun `A empty distance doesn't generate a valid attenuation`() {
        val distance = ""
        val calculateAttenuation = CalculateAttenuation()

        calculateAttenuation(distance)
            .fold({
                assertTrue(CalculateAttenuation.InputNotFilledException == it)
            }, {
                fail()
            })
    }

    @Test
    fun `A null distance doesn't generate a valid attenuation`() {
        val distance = null
        val calculateAttenuation = CalculateAttenuation()

        calculateAttenuation(distance)
            .fold({
                assertTrue(CalculateAttenuation.InputNotFilledException == it)
            }, {
                fail()
            })
    }

    @Test
    fun `A distance of 1 meter generates an attenuation of 0 dB`() {
        val distance = "1"
        val calculateAttenuation = CalculateAttenuation()

        calculateAttenuation(distance)
            .fold({
                fail("")
            }, {
                assertTrue(0f == it)
            })
    }

    @Test
    fun `A distance of 2 meters generates an attenuation of -3 dB`() {
        val distance = "2"
        val calculateAttenuation = CalculateAttenuation()

        calculateAttenuation(distance)
            .fold({
                fail("")
            }, {
                assertTrue(6f == it)
            })
    }
}
