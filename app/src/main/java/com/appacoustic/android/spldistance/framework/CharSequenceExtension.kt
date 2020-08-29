package com.appacoustic.android.spldistance.framework

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
fun CharSequence?.isFilled(): Boolean {
    contract {
        returns(true) implies (this@isFilled != null)
    }
    return !this.isNullOrEmpty()
}
