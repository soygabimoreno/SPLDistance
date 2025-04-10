package com.appacoustic.android.spldistance.domain

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.appacoustic.android.spldistance.framework.isFilled
import kotlin.math.log10
import kotlin.math.round

class CalculateAttenuation {

    object InputNotFilledException : Exception("InputNotFilledException")

    operator fun invoke(input: CharSequence?): Either<Throwable, Float> {
        return if (input.isFilled()) {
            val rawResult = 20 * log10(input.toString().toDouble())
            val formattedResult = (round(rawResult * 10) / 10).toFloat()
            formattedResult.right()
        } else {
            InputNotFilledException.left()
        }
    }
}
